package com.blogspot.javabyrajasekhar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogspot.javabyrajasekhar.model.Employee;
import com.blogspot.javabyrajasekhar.model.EmployeeIdentity;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,EmployeeIdentity> {

	List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}
