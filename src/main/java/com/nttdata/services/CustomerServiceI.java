package com.nttdata.services;

import com.nttdata.persistence.Customer;
import java.util.List;

public interface CustomerServiceI {

	public void insertCustomer(Customer customer);

	public List<Customer> searchAll();

	public Customer searchById(Long id);

	public List<Customer> searchByFullName(String name, String lastname1, String lastname2);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(Customer customer);
}