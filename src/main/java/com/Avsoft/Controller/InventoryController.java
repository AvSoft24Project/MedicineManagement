package com.Avsoft.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Avsoft.Model.Inventory;
import com.Avsoft.Service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	  @Autowired
	    private InventoryService inventoryService;

	    @PostMapping
	    public ResponseEntity<Inventory> addMedicine(@RequestBody Inventory inventory) {
	        return ResponseEntity.ok(inventoryService.addMedicine(inventory));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Inventory> getMedicineById(@PathVariable Long id) {
	        return ResponseEntity.ok(inventoryService.getMedicineById(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<Inventory>> getAllMedicines() {
	        List<Inventory> inventories = inventoryService.getAllMedicines();
	        return ResponseEntity.ok(inventories);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Inventory> updateMedicine(@PathVariable Long id, @RequestBody Inventory inventory) {
	        return ResponseEntity.ok(inventoryService.updateMedicine(id, inventory));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
	        inventoryService.deleteMedicine(id);
	        return ResponseEntity.noContent().build();
	    }
	}