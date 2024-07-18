package com.Avsoft.Service;

import java.io.IOException;
import java.util.List;
import com.Avsoft.Model.MedicineOrder;

public interface MedicineOrderService {

	MedicineOrder createOrder(MedicineOrder order);

	MedicineOrder getOrderById(Long id);

	List<MedicineOrder> getAllOrders();

	MedicineOrder updateOrder(Long id, MedicineOrder order);

	void deleteOrder(Long id);

	void generateInvoiceAndUpdateInventory(MedicineOrder order, String customerId, String customerName, String mobileNo)
			throws IOException;

}
