package com.Avsoft.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Avsoft.Model.Inventory;
import com.Avsoft.Service.InventoryService;

@RestController
@RequestMapping("/api/medicines")
public class SearchAPI {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/search")
	public List<Inventory> searchMedicineByInitials(@RequestParam String initials) {
		return inventoryService.findMedicineByInitials(initials);
	}
}