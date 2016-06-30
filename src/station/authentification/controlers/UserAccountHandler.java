package station.authentification.controlers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class UserAccountHandler extends DefaultHandler {

    public static final String LOGIN_FIELD = "login";
    public static final String PASS_FIELD = "pass";
    public static final String CREATED_FIELD = "created";

    public static UserAccountHandler getUserAccountHandler() {
	return new UserAccountHandler();
    }

    public void validateUserAccount(HttpServletRequest request) {
	String login, pass;
	Date created;

	try {
	    login = validateLogin(request);
	} catch (Exception e) {
	    putFieldError(LOGIN_FIELD, e);
	}

	try {
	    pass = validatePass(request);
	} catch (Exception e) {
	    putFieldError(PASS_FIELD, e);
	}

	try {
	    created = validateCreated(request);
	} catch (Exception e) {
	    // TODO
	    putFieldError(CREATED_FIELD, e);
	}
    }

    private String validateLogin(final HttpServletRequest request) throws Exception {
	String login = null;
	try {
	    login = getFieldValue(request, LOGIN_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return login;
    }

    private String validatePass(final HttpServletRequest request) throws Exception {
	String pass = null;
	try {
	    pass = getFieldValue(request, PASS_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return pass;
    }

    private Date validateCreated(final HttpServletRequest request) throws Exception {
	Date created = null;
	try {
	    getFieldValue(request, CREATED_FIELD, fieldType.FREE);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return null;
    }

}
