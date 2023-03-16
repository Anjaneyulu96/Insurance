package com.vtalent.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtalent.insurance.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
