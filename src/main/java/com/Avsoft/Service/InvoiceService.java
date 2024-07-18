package com.Avsoft.Service;

import java.io.IOException;
import com.Avsoft.Model.MedicineOrder;

public interface InvoiceService {
	String generateInvoicePdf(MedicineOrder order, String customerId, String customerName, String mobileNo)
			throws IOException;
}
