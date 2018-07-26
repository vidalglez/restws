package com.example.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.example.restws.entity.Customer;

@Path("/customerservice")
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
public interface CustomerService {

	@Path("/customer/{id}")
	@GET
	Customer getCustomer(@PathParam(value = "id") Integer id);

	@Path("/customers")
	@GET
	List<Customer> getCustomers();

	@Path("/customer")
	@PUT
	Response updateCustomer(Customer c);

	@Path("/customer")
	@POST
	Response addCustomer(Customer c);

	@Path("/customer/{id}")
	@DELETE
	Response deleteCustomer(@PathParam(value = "id") Integer id);
}
