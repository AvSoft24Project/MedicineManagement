package com.Avsoft.Model;

import javax.persistence.*;

@Entity
public class MedicineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String medicineName;
	private String batchId;
	private String expiryDate;
	private Integer quantity;
	private Double totalMrp;
	private Integer stripSize;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private MedicineOrder order;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalMrp() {
		return totalMrp;
	}

	public void setTotalMrp(Double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public Integer getStripSize() {
		return stripSize;
	}

	public void setStripSize(Integer stripSize) {
		this.stripSize = stripSize;
	}
/*
	public MedicineOrder getOrder() {
		return order;
	}
*/
	public void setOrder(MedicineOrder order) {
		this.order = order;
	}

}