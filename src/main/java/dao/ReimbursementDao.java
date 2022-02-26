package dao;

import java.util.List;

import models.Reimbursement;
import models.User;

public interface ReimbursementDao {
	List<Reimbursement> getListOfOwnReimbursement(User user);

    Reimbursement getASpecificReimbursementTicket(Reimbursement reimbursement);

    boolean addNewReimbursement(Reimbursement reimbursement);

    boolean editAReimbursement(Reimbursement reimbursement);

    boolean deleteAReimbursement(Reimbursement reimbursement, User user);

    boolean resolveAReimbursement(Reimbursement reimbursement);

    List<Reimbursement> getListOfAllPendingReimbursement();

    List<Reimbursement> getListOfAllResolvedReimbursement(User user);
}
