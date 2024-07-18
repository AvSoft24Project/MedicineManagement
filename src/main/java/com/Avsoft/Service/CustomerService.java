package com.Avsoft.Service;

import java.util.List;
import com.Avsoft.Model.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	Customer getCustomerById(Long id);

	List<Customer> getAllCustomers();

	Customer updateCustomer(Long id, Customer customer);

	void deleteCustomer(Long id);
}
