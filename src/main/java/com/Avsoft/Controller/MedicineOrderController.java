package com.Avsoft.Controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Avsoft.Model.MedicineOrder;
import com.Avsoft.Service.MedicineOrderService;
import com.Avsoft.Service.InvoiceService;

@RestController
@RequestMapping("/api/orders")
public class MedicineOrderController {

	@Autowired
	private MedicineOrderService orderService;

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping
	public ResponseEntity<MedicineOrder> createOrder(@RequestBody MedicineOrder order) {
		MedicineOrder createdOrder = orderService.createOrder(order);
		return ResponseEntity.ok(createdOrder);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicineOrder> getOrderById(@PathVariable Long id) {
		MedicineOrder order = orderService.getOrderById(id);
		return ResponseEntity.ok(order);
	}

	@GetMapping
	public ResponseEntity<List<MedicineOrder>> getAllOrders() {
		List<MedicineOrder> orders = orderService.getAllOrders();
		return ResponseEntity.ok(orders);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MedicineOrder> updateOrder(@PathVariable Long id, @RequestBody MedicineOrder order) {
		MedicineOrder updatedOrder = orderService.updateOrder(id, order);
		return ResponseEntity.ok(updatedOrder);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/invoice")
	public ResponseEntity<Void> generateInvoiceAndUpdateInventory(@PathVariable Long id,
			@RequestParam String customerId, @RequestParam String customerName, @RequestParam String mobileNo)
			throws IOException {
		MedicineOrder order = orderService.getOrderById(id);
		invoiceService.generateInvoicePdf(order, customerId, customerName, mobileNo);
		return ResponseEntity.ok().build();
	}
}
