package com.Avsoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Avsoft.Model.MedicineItem;

public interface MedicineItemRepository extends JpaRepository<MedicineItem, Long> {
}
