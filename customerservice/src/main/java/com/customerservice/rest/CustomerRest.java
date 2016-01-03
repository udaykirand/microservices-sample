package com.customerservice.rest;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class CustomerRest {
	private static List<Customer> CUSTOMERS = new ArrayList<Customer>();
	static {
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setNome("Customer 1");
		customer1.setEmail("customer1@gmail.com");
		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setNome("Customer 2");
		customer2.setEmail("Customer2@gmail.com");
		Customer customer3 = new Customer();
		customer3.setId(3);
		customer3.setNome("Customer 3");
		customer3.setEmail("Customer3@gmail.com");
		Customer customer4 = new Customer();
		customer4.setId(4);
		customer4.setNome("Customer 4");
		customer4.setEmail("Customer4@gmail.com");
		Customer customer5 = new Customer();
		customer5.setId(5);
		customer5.setNome("Customer 5");
		customer5.setEmail("Customer5@gmail.com");
		CUSTOMERS.add(customer1);
		CUSTOMERS.add(customer2);
		CUSTOMERS.add(customer3);
		CUSTOMERS.add(customer4);
		CUSTOMERS.add(customer5);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers() {
		return CUSTOMERS;
	}

	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@QueryParam("id") long id) {
		Customer cli = null;
		for (Customer c : CUSTOMERS) {
			if (c.getId() == id)
				cli = c;
		}
		return cli;
	}
}