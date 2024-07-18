package com.Avsoft.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Avsoft.Model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	List<Inventory> findByBatchId(String batchId);

	@Query("SELECT m FROM Inventory m WHERE LOWER(m.name) LIKE LOWER(CONCAT(?1, '%'))")
	List<Inventory> findByInitials(String initials);
}