package com.nttdata.persistence;

import java.util.List;

import org.hibernate.Session;

public class CustomerDaoImpl implements CustomerDaoI {

	private Session session;
	
	public CustomerDaoImpl(Session session) {
		this.session = session;
	}
	
	@Override
	public void insert(Customer customer) {
		
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();

		session.save(customer);
		session.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchAll() {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<Customer> result = session.createQuery("FROM Customer").list();
		return result;
		
	}

	@Override
	public Customer searchById(Long id) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		Customer result = session.get(Customer.class, id);
		return result;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByFullName(String name, String lastname1, String lastname2) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<Customer> result = session
		        .createQuery("FROM Customer WHERE name='" + name + "' AND lastname1='" + lastname1 + "' AND lastname2='" + lastname2 + "'").list();
		return result;
		
	}

	@Override
	public void update(Customer customer) {
		
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();

		session.saveOrUpdate(customer);
		session.getTransaction().commit();
		
	}

	@Override
	public void delete(Customer customer) {

		if (!session.getTransaction().isActive())
			session.getTransaction().begin();

		session.delete(customer);
		session.getTransaction().commit();
		
	}

}