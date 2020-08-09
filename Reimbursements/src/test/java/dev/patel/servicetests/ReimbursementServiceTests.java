package dev.patel.servicetests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.ReimbursementDAOhibernate;
import dev.patel.entities.Employee;
import dev.patel.entities.Reimbursement;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import dev.patel.services.ReimbursementService;
import dev.patel.services.ReimbursementServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ReimbursementServiceTests {
	
	public static ReimbursementService rserv = new ReimbursementServiceImpl();
	public static EmployeeService eserv = new EmployeeServiceImpl();

	@Test
	@Order(1)
	void createReimbursement() {
		Employee employee = eserv.getEmployeeById(2);
		Reimbursement reimbursement = new Reimbursement(0,1.0,"Pending", "na", employee );
		rserv.createReimbursement(reimbursement);
	}
	
	@Test
	@Order(2)
	void getReimbursementById() {
		Reimbursement reimbursement = rserv.getReimbursementById(1);
		Assertions.assertEquals(1, reimbursement.getrId());
	}
	
	@Test
	@Order(3)
	void updateReimbursement() {
		Reimbursement reimbursement = rserv.getReimbursementById(1);
		reimbursement.setAmount(2);
		rserv.updateReimbursement(reimbursement);	
		Assertions.assertEquals(2,reimbursement.getAmount());
	}
	
	@Test
	@Order(4)
	void getAllReimbursements() {
		
		List<Reimbursement> reimbursement = rserv.getAllReimbursements();
		Assertions.assertEquals(1,reimbursement.size());
	}
	
	
	
	@Test
	@Order(5)
	void deletereimbursement() {
		Reimbursement reimbursement = rserv.getReimbursementById(1);	
		boolean result = rserv.deleteReimbursement(reimbursement);
		Assertions.assertEquals(true,result);

	}
	

}
