package com.nttdata.persistence;

import java.util.List;

public interface CustomerDaoI {
	
	public void insert(Customer customer);
	
	public List<Customer> searchAll();
	
	public Customer searchById(Long id);
	
	public List<Customer> searchByFullName(String name, String lastname1, String lastname2);
	
	public void update(Customer customer);
	
	public void delete(Customer customer);
}
