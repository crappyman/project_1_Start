package models;

import java.util.Date;
//import java.awt.*;

public class Reimbursement {
	  private int reimbId;
	    private int amount;
	    private Date dateSubmitted;
	    private Date dateResolved;
	    private String description;
	    //private FileAttachment receipt;
	    private int author;
	    private int resolver;
	    private int statusId;
	    private int typeId;
	    private String status;
	    private String type;

		public Reimbursement(int reimbId, int author,int amount, Date dateSubmitted, Date dateResolved, String description,
				 int resolver, int statusId, int typeId) {
			super();
			this.reimbId = reimbId;
			this.amount = amount;
			this.dateSubmitted = dateSubmitted;
			this.dateResolved = dateResolved;
			this.description = description;
			this.author = author;
			this.resolver = resolver;
			this.statusId = statusId;
			this.typeId = typeId;
		}


		public int getReimbId() {
			return reimbId;
		}


		public void setReimbId(int reimbId) {
			this.reimbId = reimbId;
		}


		public int getAmount() {
			return amount;
		}


		public void setAmount(int amount) {
			this.amount = amount;
		}


		public Date getDateSubmitted() {
			return dateSubmitted;
		}


		public void setDateSubmitted(Date dateSubmitted) {
			this.dateSubmitted = dateSubmitted;
		}


		public Date getDateResolved() {
			return dateResolved;
		}


		public void setDateResolved(Date dateResolved) {
			this.dateResolved = dateResolved;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public int getAuthor() {
			return author;
		}


		public void setAuthor(int author) {
			this.author = author;
		}


		public int getResolver() {
			return resolver;
		}


		public void setResolver(int resolver) {
			this.resolver = resolver;
		}


		public int getStatusId() {
			return statusId;
		}


		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}


		public int getTypeId() {
			return typeId;
		}


		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}
		  public String getStatus() {
				return status;
			}


			public void setStatus(String status) {
				this.status = status;
			}


			public String getType() {
				return type;
			}


			public void setType(String type) {
				this.type = type;
			}


			
		    public Reimbursement() {
		    }

	    
}
