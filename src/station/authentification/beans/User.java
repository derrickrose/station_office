package station.authentification.beans;

public class User {

    private UserDetails userDetails;
    private UserIdentity userIdentity;
    private UserAccount userAccount;

    public UserDetails getUserDetails() {
	return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
	this.userDetails = userDetails;
    }

    public UserIdentity getUserIdentity() {
	return userIdentity;
    }

    public void setUserIdentity(UserIdentity userIdentity) {
	this.userIdentity = userIdentity;
    }

    public UserAccount getUserAccount() {
	return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
	this.userAccount = userAccount;
    }

}
