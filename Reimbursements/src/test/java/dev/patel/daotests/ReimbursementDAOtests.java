package dev.patel.daotests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ReimbursementDAO;
import dev.patel.daos.ReimbursementDAOhibernate;
import dev.patel.entities.Employee;
import dev.patel.entities.Reimbursement;
import dev.patel.daos.EmployeeDAOhibernate;

@TestMethodOrder(OrderAnnotation.class) 
public class ReimbursementDAOtests {
	
	private static ReimbursementDAO rdao = new ReimbursementDAOhibernate();
	private static EmployeeDAO edao = new EmployeeDAOhibernate();
	// Execute once
	

	
	
	@Test
	@Order(1)
	void createReimbursement() { 
		// an object with an ID of 0 is understood to not be a record in the database
		Employee employee = edao.getEmployeeById(2);
		Reimbursement reimbursement = new Reimbursement(0,1.0,"Pending", "na", employee );
		rdao.createReimbursement(reimbursement);
		Assertions.assertNotEquals(0, reimbursement.getrId());
	}
	
	
	@Test
	@Order(2)
	void getReimbursementById() {
		Reimbursement reimbursement = rdao.getReimbursementById(1);
		Assertions.assertEquals(1, reimbursement.getrId());
	}
	
	@Test
	@Order(3)
	void updateReimbursement() {
		Reimbursement reimbursement = rdao.getReimbursementById(1);
		reimbursement.setAmount(2);
		rdao.updateReimbursement(reimbursement);	
		Assertions.assertEquals(2,reimbursement.getAmount());
	}
	
	@Test
	@Order(4)
	void getAllReimbursements() {
		
		
		List<Reimbursement> remimbursement = rdao.getAllReimbursements();
		Assertions.assertEquals(1,remimbursement.size());
	}
	
	
	@Test
	@Order(5)
	void deleteReimbursement() {
		Reimbursement reimbursement = rdao.getReimbursementById(1);	
		boolean result = rdao.deleteReimbursement(reimbursement);
		Assertions.assertEquals(true,result);
		
		Employee employee = edao.getEmployeeById(2);	
		boolean res = edao.deleteEmployee(employee);

	}
	

}
