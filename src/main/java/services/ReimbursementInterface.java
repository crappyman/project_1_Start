package services;

import java.util.List;

import models.Reimbursement;
import models.User;

public interface ReimbursementInterface {
	List<Reimbursement> getListOfOwnReimbursement(User user);

	Reimbursement getASpecificReimbursementTicket(Reimbursement reimbursement);

	Reimbursement addNewReimbursement(Reimbursement reimbursement);

	List<Reimbursement> getListOfAllResolvedReimbursement(User user);

	List<Reimbursement> getListOfAllPendingReimbursement();

	Reimbursement resolveAReimbursement(Reimbursement reimbursement);

	void deleteAReimbursement(Reimbursement reimbursement, User user);
}
