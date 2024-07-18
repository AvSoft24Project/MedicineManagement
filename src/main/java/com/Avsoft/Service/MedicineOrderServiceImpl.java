package com.Avsoft.Service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Avsoft.Exception.InsufficientStockException;
import com.Avsoft.Exception.ResourceNotFoundException;
import com.Avsoft.Model.Customer;
import com.Avsoft.Model.Inventory;
import com.Avsoft.Model.MedicineItem;
import com.Avsoft.Model.MedicineOrder;
import com.Avsoft.Repository.MedicineOrderRepository;

@Service
public class MedicineOrderServiceImpl implements MedicineOrderService {

	@Autowired
	private MedicineOrderRepository orderRepository;

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private MedicineItemService itemService;

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private CustomerService customerService;

	@Override
	@Transactional
	public MedicineOrder createOrder(MedicineOrder order) {
		double totalMrp = 0.0;
		for (MedicineItem item : order.getItems()) {
			Inventory inventory = inventoryService.findByBatchId(item.getBatchId());
			if (inventory == null) {
				throw new ResourceNotFoundException("Inventory item not found for batch ID: " + item.getBatchId());
			}

			double perUnitMrp = inventory.getMrp() / inventory.getStripSize();
			item.setTotalMrp(perUnitMrp * item.getQuantity());
			item.setMedicineName(inventory.getName());
			totalMrp += item.getTotalMrp();

			// Update inventory quantity
			if ("Sell".equalsIgnoreCase(order.getType())) {
				if (inventory.getQuantity() < item.getQuantity()) {
					throw new InsufficientStockException("Not enough stock for " + inventory.getName());
				}
				inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
			} else if ("Purchase".equalsIgnoreCase(order.getType())) {
				inventory.setQuantity(inventory.getQuantity() + item.getQuantity());
			}
			inventoryService.saveInventory(inventory);
		}
		order.setTotalMrp(totalMrp);
		MedicineOrder savedOrder = orderRepository.save(order); // Save the order first to generate the order ID

		// Now set the order reference in each item and save them
		for (MedicineItem item : order.getItems()) {
			item.setOrder(savedOrder); // Set the order reference
			itemService.createItem(item); // Save the item using MedicineItemService
		}

		return savedOrder;
	}

	@Override
	public MedicineOrder getOrderById(Long id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
	}

	@Override
	public List<MedicineOrder> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	@Transactional
	public MedicineOrder updateOrder(Long id, MedicineOrder order) {
		MedicineOrder existingOrder = getOrderById(id);
		existingOrder.setStatus(order.getStatus());
		existingOrder.setType(order.getType());
		// Update other fields as needed
		return orderRepository.save(existingOrder);
	}

	@Override
	@Transactional
	public void deleteOrder(Long id) {
		MedicineOrder order = getOrderById(id);
		orderRepository.delete(order);
	}

	@Override
	@Transactional
	public void generateInvoiceAndUpdateInventory(MedicineOrder order, String customerId, String customerName,
			String mobileNo) throws IOException {
		Customer customer = customerService.getCustomerById(Long.parseLong(customerId));
		generateInvoice(order, customer.getCustomerId(), customer.getCustomerName(), customer.getMobileNo());
		updateInventoryAfterSell(order);
	}

	private void generateInvoice(MedicineOrder order, String customerId, String customerName, String mobileNo)
			throws IOException {
		invoiceService.generateInvoicePdf(order, customerId, customerName, mobileNo);
	}

	private void updateInventoryAfterSell(MedicineOrder order) {
		for (MedicineItem item : order.getItems()) {
			Inventory inventory = inventoryService.findByBatchId(item.getBatchId());
			if (inventory != null) {
				inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
				inventoryService.saveInventory(inventory);
			}
		}
	}
}
