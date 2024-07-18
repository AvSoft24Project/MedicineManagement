package com.Avsoft.Service;

import java.util.List;
import com.Avsoft.Model.MedicineItem;

public interface MedicineItemService {

	MedicineItem createItem(MedicineItem item);

	MedicineItem getItemById(Long id);

	List<MedicineItem> getAllItems();

	MedicineItem updateItem(Long id, MedicineItem item);

	void deleteItem(Long id);
}
