package com.Avsoft.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class MedicineOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	private Double totalMrp;
	private String status;
	private String type; // Sell or Purchase

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MedicineItem> items = new ArrayList<>();

	// Getters and Setters

	public void addItem(MedicineItem item) {
		items.add(item);
		item.setOrder(this);
	}

	public void removeItem(MedicineItem item) {
		items.remove(item);
		item.setOrder(null);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getTotalMrp() {
		return totalMrp;
	}

	public void setTotalMrp(Double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<MedicineItem> getItems() {
		return items;
	}

	public void setItems(List<MedicineItem> items) {
		this.items = items;
	}

}