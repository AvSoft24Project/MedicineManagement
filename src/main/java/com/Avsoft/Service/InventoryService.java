package com.Avsoft.Service;

import java.util.List;

import com.Avsoft.Model.Inventory;

public interface InventoryService {

	Inventory addMedicine(Inventory inventory);

	Inventory getMedicineById(Long id);

	List<Inventory> getAllMedicines();

	Inventory updateMedicine(Long id, Inventory inventory);

	void deleteMedicine(Long id);

	Inventory findByBatchId(String batchId);

	Inventory saveInventory(Inventory inventory); // Add this method

	List<Inventory> findMedicineByInitials(String initials);
}