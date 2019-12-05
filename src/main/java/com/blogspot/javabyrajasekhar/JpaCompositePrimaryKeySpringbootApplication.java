package com.blogspot.javabyrajasekhar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blogspot.javabyrajasekhar.model.Employee;
import com.blogspot.javabyrajasekhar.model.EmployeeIdentity;
import com.blogspot.javabyrajasekhar.repository.EmployeeRepository;

@SpringBootApplication
public class JpaCompositePrimaryKeySpringbootApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaCompositePrimaryKeySpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup employees table
		employeeRepository.deleteAllInBatch();

		// Insert a new Employee in the database
		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"), "Narender g", "narender@gmail.com",
				"+91-9999999999");

		Employee employee1 = new Employee(new EmployeeIdentity("E-123", "D-451"), "Rajasekhar reddy", "abc@gmail.com",
				"+91-9996666666");

		employeeRepository.save(employee);
		employeeRepository.save(employee1);
	}

}
