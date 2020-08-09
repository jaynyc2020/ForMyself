package dev.patel.controllers;

import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import dev.patel.entities.Employee;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import io.javalin.http.Handler;

public class EmployeeController {

	public static EmployeeService eserv = new EmployeeServiceImpl();
	private static Gson gson = new Gson();
	
	public static Handler createEmployee= (ctx) ->{
		//context object ctx is an object that contains the http request and response objects
		// it contains a whole bunch of method for dealing with getting information from the request
		// and sending information in the http response
		
		String employeeJson = ctx.body();
		Employee employee = gson.fromJson(employeeJson, Employee.class); // transform the json into a Shcool object
		eserv.createEmployee(employee);
		ctx.status(201); // 201 is the status code to return if you successfully add something
		
		//usually you want to return the created object
		ctx.result(gson.toJson(employee));
	};
	
	public static Handler getEmployeeById = (ctx)->{
		String id = ctx.pathParam("eid");
		Employee employee = eserv.getEmployeeById(Integer.parseInt(id));
		//school object but I want it sent back as a JSON		
		if(employee ==null) {
			ctx.status(404);
		}else {
			String json = gson.toJson(employee);		
			ctx.result(json);	
		}
	
	};

	public static Handler getAllEmployees = (ctx) -> {
		List<Employee> employees = eserv.getAllEmployees();
		String json = gson.toJson(employees);
		ctx.result(json);

	};
	
	public static Handler updateEmployee = (ctx)->{
		String employeeJson = ctx.body();
		Employee employee = gson.fromJson(employeeJson, Employee.class);
		eserv.updateEmployee(employee);	
		ctx.result(gson.toJson(employee));
	};
	
	public static Handler deleteEmployee = (ctx) ->{
		String id = ctx.pathParam("eid");
		Employee employee = eserv.getEmployeeById(Integer.parseInt(id));
		boolean result = eserv.deleteEmployee(employee);
		
	};
	
	

}
