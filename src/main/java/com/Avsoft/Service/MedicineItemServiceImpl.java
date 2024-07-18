package com.Avsoft.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Avsoft.Exception.ResourceNotFoundException;
import com.Avsoft.Model.MedicineItem;
import com.Avsoft.Repository.MedicineItemRepository;

@Service
public class MedicineItemServiceImpl implements MedicineItemService {
	@Autowired
	private MedicineItemRepository itemRepository;

	@Override
	public MedicineItem createItem(MedicineItem item) {
		return itemRepository.save(item);
	}

	@Override
	public MedicineItem getItemById(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}

	@Override
	public List<MedicineItem> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public MedicineItem updateItem(Long id, MedicineItem item) {
		MedicineItem existingItem = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
		existingItem.setMedicineName(item.getMedicineName());
		existingItem.setBatchId(item.getBatchId());
		existingItem.setExpiryDate(item.getExpiryDate());
		existingItem.setQuantity(item.getQuantity());
		existingItem.setTotalMrp(item.getTotalMrp());
		existingItem.setStripSize(item.getStripSize());
		return itemRepository.save(existingItem);
	}

	@Override
	public void deleteItem(Long id) {
		MedicineItem item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
		itemRepository.delete(item);
	}
}
