package dev.patel.daos;

import java.util.List;
import java.util.Set;

import dev.patel.entities.Employee;

@SuppressWarnings("unused")
public interface EmployeeDAO {

	// Create
	Employee createEmployee(Employee employee);

	// read
	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	//Set<Employee> getEmployeesBySchoolId(int id);

	// update
	Employee updateEmployee(Employee employee);

	// delete
	boolean deleteEmployee(Employee employee);
}
