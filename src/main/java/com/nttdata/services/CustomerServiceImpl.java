package com.nttdata.services;

import com.nttdata.persistence.Customer;
import com.nttdata.persistence.CustomerDaoI;
import com.nttdata.persistence.CustomerDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class CustomerServiceImpl implements CustomerServiceI {

	private CustomerDaoI customerDao;
	
	public CustomerServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}
	
	@Override
	public void insertCustomer(Customer customer) {
		
		customerDao.insert(customer);
		
	}

	@Override
	public List<Customer> searchAll() {

		List<Customer> result = new ArrayList<Customer>();
		result = customerDao.searchAll();

		return result;
		
	}

	@Override
	public Customer searchById(Long id) {

		Customer result = new Customer();
		result = customerDao.searchById(id);

		return result;
		
	}

	@Override
	public List<Customer> searchByFullName(String name, String lastname1, String lastname2) {
		
		List<Customer> result = new ArrayList<Customer>();
		result = customerDao.searchByFullName(name, lastname1, lastname2);

		return result;
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		customerDao.update(customer);
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		
		customerDao.delete(customer);
		
	}

}