package dev.patel.daos;

import java.util.Set;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;

import dev.patel.entities.Reimbursement;
import dev.patel.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class ReimbursementDAOhibernate implements ReimbursementDAO {

	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(reimbursement);
		sess.getTransaction().commit();
		sess.close();
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Reimbursement.class);
		List<Reimbursement> reimbursement = crit.list();
			
		return reimbursement;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Session sess = sf.openSession();		
		Reimbursement reimbursement = sess.get(Reimbursement.class, id);		
		sess.close();
		
		return reimbursement;
		
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		sess.update(reimbursement);
		
		sess.getTransaction().commit();
		sess.close();
		
		return reimbursement;
	}

	@Override
	public boolean deleteReimbursement(Reimbursement reimbursement) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		
		sess.delete(reimbursement);
		
		sess.getTransaction().commit();
		sess.close();
		
		return true;
	}

}
