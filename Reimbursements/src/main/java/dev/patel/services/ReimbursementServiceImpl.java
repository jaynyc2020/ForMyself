package dev.patel.services;

import java.util.List;
import java.util.Set;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.daos.ReimbursementDAO;
import dev.patel.daos.ReimbursementDAOhibernate;
import dev.patel.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	public ReimbursementDAO rdao = new ReimbursementDAOhibernate();
	
	public ReimbursementServiceImpl() {
		super();
	}
	
	public ReimbursementServiceImpl(ReimbursementDAO rdao) {
		super();
		this.rdao = rdao;

	}

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		return this.rdao.createReimbursement(reimbursement);
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		return this.rdao.getReimbursementById(id);
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		return this.rdao.getAllReimbursements();
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		return this.rdao.updateReimbursement(reimbursement);
	}

	@Override
	public boolean deleteReimbursement(Reimbursement reimbursement) {
		return this.rdao.deleteReimbursement(reimbursement);

	}

}
