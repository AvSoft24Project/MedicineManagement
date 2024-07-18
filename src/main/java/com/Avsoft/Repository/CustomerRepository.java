package com.Avsoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Avsoft.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerId(String customerId);
}
