package dev.patel.app;

import dev.patel.controllers.EmployeeController;
//import dev.patel.controllers.ReimbursementController;
import io.javalin.Javalin;

public class App {

	public static void main(String[] args) {

		Javalin app = Javalin.create(config -> { // pass in a lambda that describes HOW to create the app

			config.enableCorsForAllOrigins();
			// config.addStaticFiles("/frontend");

		}).start(7000);

		// create operation
		app.post("/employees", EmployeeController.createEmployee);
		// read
		app.get("/employees", EmployeeController.getAllEmployees);
		app.get("/schools/:eid", EmployeeController.getEmployeeById);

		// update operation
		app.put("/employees", EmployeeController.updateEmployee);

		// delete operation
		app.delete("/employees/:eid", EmployeeController.deleteEmployee);

	}// end main

}
