package station.authentification.beans;

import java.util.Date;

public class UserAccount {

    private String login, pass;
    private Date created;

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPass() {
	return pass;
    }

    public void setPass(String pass) {
	this.pass = pass;
    }

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

}
