package services;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import models.Reimbursement;
import models.User;
import java.util.List;

public class ReimbursementService implements ReimbursementInterface {

	private ReimbursementDao reimbursementDao;

	public ReimbursementService() {
		this.reimbursementDao = new ReimbursementDaoImpl();
	}

	@Override
	public List<Reimbursement> getListOfOwnReimbursement(User user) {
		return this.reimbursementDao.getListOfOwnReimbursement(user);
	}

	@Override
	public Reimbursement getASpecificReimbursementTicket(Reimbursement reimbursement) {
		return this.reimbursementDao.getASpecificReimbursementTicket(reimbursement);
	}

	@Override
	public Reimbursement addNewReimbursement(Reimbursement reimbursement) {
		if (this.reimbursementDao.addNewReimbursement(reimbursement)) {
			return this.reimbursementDao.getASpecificReimbursementTicket(reimbursement);
		} else {
			return null;
		}
	}

	@Override
	public void deleteAReimbursement(Reimbursement reimbursement, User user) {
		this.reimbursementDao.deleteAReimbursement(reimbursement, user);
	}

	@Override
	public Reimbursement resolveAReimbursement(Reimbursement reimbursement) {
		if (this.reimbursementDao.resolveAReimbursement(reimbursement)) {
			return this.reimbursementDao.getASpecificReimbursementTicket(reimbursement);
		} else {
			return null;
		}
	}

	@Override
	public List<Reimbursement> getListOfAllPendingReimbursement() {
		return this.reimbursementDao.getListOfAllPendingReimbursement();
	}

	@Override
	public List<Reimbursement> getListOfAllResolvedReimbursement(User user) {
		return this.reimbursementDao.getListOfAllResolvedReimbursement(user);
	}
}
