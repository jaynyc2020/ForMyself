package dev.patel.services;

import dev.patel.entities.Employee;

import java.util.Set;
import dev.patel.entities.Reimbursement;
import java.util.List;

public interface ReimbursementService {
	
	// create 
	Reimbursement createReimbursement(Reimbursement reimbursement);
	// read
	Reimbursement getReimbursementById(int id);
	List<Reimbursement> getAllReimbursements();
	
	//update
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	//Delete
	boolean deleteReimbursement(Reimbursement reimbursement);
}
