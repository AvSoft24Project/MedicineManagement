package com.Avsoft.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Avsoft.Model.MedicineOrder;
import com.Avsoft.Service.InvoiceService;
import com.Avsoft.Service.MedicineOrderService;

@RestController
public class InvoiceController {

	@Autowired
	private MedicineOrderService orderService;

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/api/orders/{id}/invoice")
	public String generateInvoice(@PathVariable("id") Long id, @RequestParam String customerId,
			@RequestParam String customerName, @RequestParam String mobileNo) throws IOException {
		MedicineOrder order = orderService.getOrderById(id);
		String pdfPath = invoiceService.generateInvoicePdf(order, customerId, customerName, mobileNo);
		return "Invoice generated at: " + pdfPath;
	}
}
