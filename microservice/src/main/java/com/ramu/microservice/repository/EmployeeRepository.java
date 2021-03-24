package com.ramu.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramu.microservice.entity.Employee;

/**
 * @author PRAMESWA
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
