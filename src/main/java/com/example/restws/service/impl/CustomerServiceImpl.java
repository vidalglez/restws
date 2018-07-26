package com.example.restws.service.impl;

import java.util.List;
import static java.util.Comparator.comparing;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restws.dao.CustomerDAO;
import com.example.restws.entity.Customer;
import com.example.restws.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDao;

	@Override
	public Customer getCustomer(Integer id) {		
		return customerDao.findById(id).get();
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = customerDao.findAll();
		customers.sort(comparing(Customer::getFirstName));
		return customers;
	}

	@Override
	public Response updateCustomer(Customer c) {
		Customer updCustomer = customerDao.save(c);
		return Response.ok(updCustomer).build();
	}

	@Override
	public Response addCustomer(Customer c) {
		Customer newCustomer = customerDao.save(c);
		return Response.ok(newCustomer).build();
	}

	@Override
	public Response deleteCustomer(Integer id) {
		customerDao.deleteById(id);
		return Response.ok().build();
	}

}
