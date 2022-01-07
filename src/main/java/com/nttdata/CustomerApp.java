package com.nttdata;

import com.nttdata.persistence.Customer;
import com.nttdata.services.CustomerServiceI;
import com.nttdata.services.CustomerServiceImpl;

import java.util.List;
import java.util.Date;
import org.hibernate.Session;

public class CustomerApp{

	
	
	public static void main(String[] args) {
		
		final Session session = Util.getSessionFactory().openSession();
		
		final CustomerServiceI customerServiceI = new CustomerServiceImpl(session);
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		
		c1.setName("Marco");
		c1.setLastName1("Palmero");
		c1.setLastName2("Monroy");
		c1.setIdn("01223333E");
		c1.setUpdatedUser("APOZGAM");
		c1.setUpdatedDate(new Date());
		
		c2.setName("Jorge");
		c2.setLastName1("Dayoub");
		c2.setLastName2("Dayoub");
		c2.setIdn("21122012F");
		c2.setUpdatedUser("APOZGAM");
		c2.setUpdatedDate(new Date());
		
		c3.setName("Bruno");
		c3.setLastName1("Cruz");
		c3.setLastName2("Luque");
		c3.setIdn("55555558L");
		c3.setUpdatedUser("APOZGAM");
		c3.setUpdatedDate(new Date());
		
		
		
		customerServiceI.insertCustomer(c1);
		customerServiceI.insertCustomer(c2);
		customerServiceI.insertCustomer(c3);

		c2.setID(19L);
		customerServiceI.deleteCustomer(c2);
		
		c3.setName("Juan Antonio");
		customerServiceI.updateCustomer(c3);
		
		
		
		System.out.println("-- BÚSQUEDA DE CLIENTE POR ID --");

		final Long searchId = 1L;
		final Customer customer = customerServiceI.searchById(searchId);

		if (customer != null) {
			System.out.println("Se ha localizado el cliente con ID " + searchId + ":");
			System.out.println(customer.toString());
		}

		System.out.println("-- BÚSQUEDA DE TODOS LOS CLIENTES --");

		List<Customer> customersList = customerServiceI.searchAll();
		printCustomerList(customersList);

		System.out.println("-- BÚSQUEDA DE CLIENTES POR NOMBRE Y APELLIDOS --");

		final List<Customer> customersByNameList = customerServiceI.searchByFullName("Juan Antonio", "Cruz", "Luque");
		printCustomerList(customersByNameList);

		session.close();
		
	}
	
	private static void printCustomerList(final List<Customer> list) {

		if (list != null && list.size() > 0) {
			System.out.println("Total de clientes registrados: " + list.size());
			for (Customer customer : list) {
				System.out.println(customer.toString());
			}
		}

	}

}
