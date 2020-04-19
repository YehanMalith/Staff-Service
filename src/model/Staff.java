package model;

public class Staff {
	
	private int staffID;
    private String staffNic;
    private String staffName;
    private String staffMobileno;
    private String staffEmail;
    private String staffGender;
    private String staffSpecialize;
	
    public Staff() {
		super();
	}
    
	public Staff(int staffID, String staffNic, String staffName, String staffMobileno, String staffEmail,
			String staffGender, String staffSpecialize) {
		super();
		this.staffID = staffID;
		this.staffNic = staffNic;
		this.staffName = staffName;
		this.staffMobileno = staffMobileno;
		this.staffEmail = staffEmail;
		this.staffGender = staffGender;
		this.staffSpecialize = staffSpecialize;
	}

	
	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getStaffNic() {
		return staffNic;
	}

	public void setStaffNic(String staffNic) {
		this.staffNic = staffNic;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffMobileno() {
		return staffMobileno;
	}

	public void setStaffMobileno(String staffMobileno) {
		this.staffMobileno = staffMobileno;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public String getStaffSpecialize() {
		return staffSpecialize;
	}

	public void setStaffSpecialize(String staffSpecialize) {
		this.staffSpecialize = staffSpecialize;
	}

	@Override
	public String toString() {
		return "Staff [staffID=" + staffID + ", staffNic=" + staffNic + ", staffName=" + staffName + ", staffMobileno="
				+ staffMobileno + ", staffEmail=" + staffEmail + ", staffGender=" + staffGender + ", staffSpecialize="
				+ staffSpecialize + "]";
	}
    
	
}	