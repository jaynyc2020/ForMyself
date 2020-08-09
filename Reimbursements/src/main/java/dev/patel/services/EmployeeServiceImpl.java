package dev.patel.services;

import java.util.List;
import java.util.Set;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.entities.Employee;
//import dev.patel.daos.EmployeeDAO;
//import dev.patel.daos.EmployeeDAOhibernate;
//import dev.ranieri.entities.Employee;
//import dev.ranieri.entities.Movie;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeDAO edao = new EmployeeDAOhibernate();
	// public EmployeeDAO ddao = new EmployeeDAOhibenate();

	public EmployeeServiceImpl() {
		super();
	}

	public EmployeeServiceImpl(EmployeeDAO edao) {
		super();
		this.edao = edao;

	}

	
	@Override
	public Employee createEmployee(Employee employee) {
		return this.edao.createEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return this.edao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.edao.getAllEmployees();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.edao.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return this.edao.deleteEmployee(employee);
		
	}




}
