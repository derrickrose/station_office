package station.authentification.beans;

import java.util.Date;

public class UserIdentity {

    private int identityType;
    private Date issueDate;
    private String town, number;

    public UserIdentity(int identityType, String number, Date issueDate, String town) {

	this.identityType = identityType;
	this.number = number;
	this.issueDate = issueDate;
	this.town = town;

    }

    public int getIdentityType() {
	return identityType;
    }

    public void setIdentityType(int identityType) {
	this.identityType = identityType;
    }

    public Date getIssueDate() {
	return issueDate;
    }

    public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
    }

    public String getTown() {
	return town;
    }

    public void setTown(String town) {
	this.town = town;
    }

    public String getId() {
	return number;
    }

    public void setId(String number) {
	this.number = number;
    }

}
