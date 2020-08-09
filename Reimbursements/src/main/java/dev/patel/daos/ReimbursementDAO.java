package dev.patel.daos;

import java.util.Set;
import java.util.List;

import dev.patel.entities.Reimbursement;

public interface ReimbursementDAO {

	// Create
	Reimbursement createReimbursement(Reimbursement reimbursement);

	// read
	List<Reimbursement> getAllReimbursements();

	Reimbursement getReimbursementById(int id);

	//Set<Employee> getEmployeesBySchoolId(int id);

	// update
	Reimbursement updateReimbursement(Reimbursement reimbursement);

	// delete
	boolean deleteReimbursement(Reimbursement reimbursement);
}
