package com.Avsoft.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Avsoft.Model.MedicineItem;

import com.Avsoft.Service.MedicineItemService;

@RestController
@RequestMapping("/api/items")
public class MedicineItemController {

	@Autowired
	private MedicineItemService itemService;

	@PostMapping
	public ResponseEntity<MedicineItem> createItem(@RequestBody MedicineItem item) {
		return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(item));
	}

	@GetMapping("/{id}")
	public ResponseEntity<MedicineItem> getItemById(@PathVariable Long id) {
		return ResponseEntity.ok(itemService.getItemById(id));
	}

	@GetMapping
	public ResponseEntity<List<MedicineItem>> getAllItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}

	@PutMapping("/{id}")
	public ResponseEntity<MedicineItem> updateItem(@PathVariable Long id, @RequestBody MedicineItem item) {
		return ResponseEntity.ok(itemService.updateItem(id, item));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}
}