package com.Avsoft.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import com.Avsoft.Model.MedicineItem;
import com.Avsoft.Model.MedicineOrder;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public String generateInvoicePdf(MedicineOrder order, String customerId, String customerName, String mobileNo)
			throws IOException {
		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage();
			document.addPage(page);
			float margin = 50;
			float yStart = 750;

			try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
				// Invoice Title
				contentStream.beginText();
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
				contentStream.newLineAtOffset(50, yStart);
				contentStream.showText("Invoice");
				contentStream.endText();
			}

			float yPosition = yStart - 50;

			try (PDPageContentStream contentStream = new PDPageContentStream(document, page,
					PDPageContentStream.AppendMode.APPEND, true)) {
				// Customer Details
				contentStream.beginText();
				contentStream.setFont(PDType1Font.HELVETICA, 12);
				contentStream.newLineAtOffset(margin, yPosition);
				contentStream.showText("Customer ID: " + customerId);
				contentStream.newLineAtOffset(0, -15);
				contentStream.showText("Customer Name: " + customerName);
				contentStream.newLineAtOffset(0, -15);
				contentStream.showText("Mobile No.: " + mobileNo);
				contentStream.newLineAtOffset(0, -15);
				contentStream.showText("Date: " + LocalDate.now().toString());
				contentStream.endText();

				yPosition -= 80;

				// Table Headers
				contentStream.beginText();
				contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
				contentStream.newLineAtOffset(margin, yPosition);
				contentStream.showText("Medicine Name");
				contentStream.newLineAtOffset(100, 0);
				contentStream.showText("Batch ID");
				contentStream.newLineAtOffset(70, 0);
				contentStream.showText("Expiry Date");
				contentStream.newLineAtOffset(70, 0);
				contentStream.showText("Quantity");
				contentStream.newLineAtOffset(50, 0);
				contentStream.showText("Per Unit MRP");
				contentStream.newLineAtOffset(70, 0);
				contentStream.showText("Total MRP");
				contentStream.endText();
			}

			yPosition -= 20;

			for (MedicineItem item : order.getItems()) {
				if (yPosition < 100) {
					page = new PDPage();
					document.addPage(page);
					yPosition = 750;
				}

				try (PDPageContentStream contentStream = new PDPageContentStream(document, page,
						PDPageContentStream.AppendMode.APPEND, true)) {
					contentStream.beginText();
					contentStream.setFont(PDType1Font.HELVETICA, 12);
					contentStream.newLineAtOffset(margin, yPosition);
					contentStream.showText(item.getMedicineName());
					contentStream.newLineAtOffset(100, 0);
					contentStream.showText(item.getBatchId());
					contentStream.newLineAtOffset(70, 0);
					contentStream.showText(item.getExpiryDate().toString());
					contentStream.newLineAtOffset(70, 0);
					contentStream.showText(String.valueOf(item.getQuantity()));
					contentStream.newLineAtOffset(50, 0);
					contentStream.showText(String.format("%.2f", item.getTotalMrp() / item.getQuantity()));
					contentStream.newLineAtOffset(70, 0);
					contentStream.showText(String.format("%.2f", item.getTotalMrp()));
					contentStream.endText();
				}

				yPosition -= 20;
			}

			String uniqueFileName = "invoice-" + UUID.randomUUID() + ".pdf";
			document.save(uniqueFileName);
			return uniqueFileName;
		}
	}
}
