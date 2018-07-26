package com.example.restws.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restws.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
