package com.Avsoft.Service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Avsoft.Exception.ResourceNotFoundException;
import com.Avsoft.Model.Customer;
import com.Avsoft.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Customer existingCustomer = getCustomerById(id);
		existingCustomer.setCustomerName(customer.getCustomerName());
		existingCustomer.setMobileNo(customer.getMobileNo());
		return customerRepository.save(existingCustomer);
	}

	@Override
	public void deleteCustomer(Long id) {
		Customer customer = getCustomerById(id);
		customerRepository.delete(customer);
	}
}
