package com.Avsoft.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Avsoft.Exception.ResourceNotFoundException;
import com.Avsoft.Model.Inventory;
import com.Avsoft.Repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public Inventory addMedicine(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory getMedicineById(Long id) {
		return inventoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id " + id));
	}

	@Override
	public List<Inventory> getAllMedicines() {
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory updateMedicine(Long id, Inventory updatedInventory) {
		Inventory existingInventory = inventoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory item not found with id " + id));

		// Update properties based on your needs
		existingInventory.setBatchId(updatedInventory.getBatchId());
		existingInventory.setName(updatedInventory.getName());
		existingInventory.setExpiryDate(updatedInventory.getExpiryDate());
		// Update other properties as needed

		return inventoryRepository.save(existingInventory);
	}

	@Override
	public void deleteMedicine(Long id) {
		if (!inventoryRepository.existsById(id)) {
			throw new ResourceNotFoundException("Inventory item not found with id " + id);
		}
		inventoryRepository.deleteById(id);
	}

	@Override
	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory findByBatchId(String batchId) {
		List<Inventory> inventories = inventoryRepository.findByBatchId(batchId);
		if (inventories.isEmpty()) {
			throw new ResourceNotFoundException("Inventory item not found with batchId " + batchId);
		}
		return inventories.get(0); // Assuming you want the first item if there are multiple
	}

	@Override
	public List<Inventory> findMedicineByInitials(String initials) {
		return inventoryRepository.findByInitials(initials);
	}

}