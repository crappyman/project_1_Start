package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.DBUtil;
import models.Reimbursement;
import models.User;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getListOfOwnReimbursement(User user) {
		Connection conn = DBUtil.obtainConnection();
		 List<Reimbursement> reimbursements = new ArrayList<>();
		 String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ? ";

         // adding any filters or sorting orders.
         PreparedStatement ps;
         try {
         ps= conn.prepareStatement(sql);
         ps.setInt(1, user.getUserId());

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             reimbursements.add(
                     new Reimbursement(
                             rs.getInt("reimbursementid"),
                             rs.getInt("author"),
                             rs.getInt("amount"),
                             rs.getDate("datesubmitted"),
                             rs.getDate("dateresolved"),
                             rs.getString("description"),
                             rs.getInt("resolver"),
                             rs.getInt("status"),
                             rs.getInt("type")
                     ));
         }
         ps.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     }
     return reimbursements;
	}


	@Override
	public Reimbursement getASpecificReimbursementTicket(Reimbursement reimb) {
		Reimbursement reimbursement = new Reimbursement();
		Connection conn = DBUtil.obtainConnection();
		 String sql = "SELECT * FROM reimbursement WHERE reimbursementid = ? ";

         PreparedStatement ps ;
         try {
         ps= conn.prepareStatement(sql);
         ps.setInt(1, reimb.getReimbId());

         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
             reimbursement = new Reimbursement(
            		 rs.getInt("reimbursementid"),
                     rs.getInt("author"),
                     rs.getInt("amount"),
                     rs.getDate("datesubmitted"),
                     rs.getDate("dateresolved"),
                     rs.getString("description"),
                     rs.getInt("resolver"),
                     rs.getInt("status"),
                     rs.getInt("type")
             );
         }
         ps.close();
     } catch (Exception ex) {
         ex.printStackTrace();
     }
     return reimbursement;
	}

	@Override
	public boolean addNewReimbursement(Reimbursement reimbursement) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
		String sql = "INSERT INTO reimbursement VALUES (DEFAULT, ?, DEFAULT, NULL, ?, NULL, ?, NULL, 1, ?);";
         ps = conn.prepareStatement(sql);

        ps.setInt(1, reimbursement.getAmount());
        ps.setString(2, reimbursement.getDescription());
        ps.setInt(3, reimbursement.getAuthor());
        ps.setInt(4, reimbursement.getTypeId());

        return ps.executeUpdate() != 0;
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
	}

	@Override
	public boolean editAReimbursement(Reimbursement reimbursement) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
			 String sql = "UPDATE reimbursement " +
	                    "SET amount = ?, description = ?, " +
	                    "typeid = ? WHERE reimbursementid = ?";

	             ps = conn.prepareStatement(sql);

	            ps.setInt(1, reimbursement.getAmount());
	            ps.setString(2, reimbursement.getDescription());
	            ps.setInt(3, reimbursement.getTypeId());
	            ps.setInt(4, reimbursement.getReimbId());

	            return ps.executeUpdate() != 0;
	        } catch (Exception ex) {
	            ex.printStackTrace();
		 }
		 return false;
	}

	@Override
	public boolean deleteAReimbursement(Reimbursement reimbursement, User user) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
			 String sql = "DELETE FROM reimbursement  WHERE reimbursementid = ? AND author = ? ";

	             ps = conn.prepareStatement(sql);
	            ps.setInt(1, reimbursement.getReimbId());
	            ps.setInt(2, user.getUserId());

	            return ps.executeUpdate() != 0;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return false;
		 }
		
	}

	@Override
	public boolean resolveAReimbursement(Reimbursement reimbursement) {
		Connection conn = DBUtil.obtainConnection();
		 PreparedStatement ps;
		 try {
			 String sql = "UPDATE reimbursement " +
	                    "SET dateresolved = DEFAULT, dateresolved = ?, statusid = ?" +
	                    "WHERE reimbursementid = ?";

	             ps = conn.prepareStatement(sql);

	            ps.setInt(1, reimbursement.getResolver());
	            ps.setInt(2, reimbursement.getStatusId());
	            ps.setInt(3, reimbursement.getReimbId());

	            return ps.executeUpdate() != 0;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return false;
	}
	}

	@Override
	public List<Reimbursement> getListOfAllPendingReimbursement() {
		Connection conn = DBUtil.obtainConnection();
		  List<Reimbursement> reimbursements = new ArrayList<>();
		 PreparedStatement ps;
		 try {
			 String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = 1 ";

	            // adding any filters or sorting orders.
	             ps = conn.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                reimbursements.add(
	                        new Reimbursement(
	                        		rs.getInt("reimbursementid"),
	                                rs.getInt("author"),
	                                rs.getInt("amount"),
	                                rs.getDate("datesubmitted"),
	                                rs.getDate("dateresolved"),
	                                rs.getString("description"),
	                                rs.getInt("resolver"),
	                                rs.getInt("status"),
	                                rs.getInt("type")
	                        ));
	            }
	            ps.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return reimbursements;
	}

	@Override
	public List<Reimbursement> getListOfAllResolvedReimbursement(User user) {
		Connection conn = DBUtil.obtainConnection();
		  List<Reimbursement> reimbursements = new ArrayList<>();
		 PreparedStatement ps;
		 try {
			 String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ? ";

	            // adding any filters or sorting orders.
	             ps = conn.prepareStatement(sql);
	            ps.setInt(1, user.getUserId() );
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                reimbursements.add(
	                        new Reimbursement(
	                        		rs.getInt("reimbursementid"),
	                                rs.getInt("author"),
	                                rs.getInt("amount"),
	                                rs.getDate("datesubmitted"),
	                                rs.getDate("dateresolved"),
	                                rs.getString("description"),
	                                rs.getInt("resolver"),
	                                rs.getInt("status"),
	                                rs.getInt("type")
	                        ));
	            }
	            ps.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return reimbursements;
	    }
		 
	

}
