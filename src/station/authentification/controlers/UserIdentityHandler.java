package station.authentification.controlers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class UserIdentityHandler extends DefaultHandler {

    public static final String IDENTITY_TYPE_FIELD = "identityType";
    public static final String NUMBER_FIELD = "number";
    public static final String ISSUE_DATE_FIELD = "issueDate";
    public static final String TOWN_FIELD = "town";

    public static UserIdentityHandler getUserIdentityHandler() {
	return new UserIdentityHandler();
    }

    public void validateUserIdentity(HttpServletRequest request) {
	int identityType;
	Date issueDate;
	String town, number;

	try {
	    identityType = validateIdentityType(request);
	} catch (Exception e) {
	    putFieldError(IDENTITY_TYPE_FIELD, e);
	}

	try {
	    number = validateNumber(request);
	} catch (Exception e) {
	    putFieldError(NUMBER_FIELD, e);
	}

	try {
	    issueDate = validateIssueDate(request);
	} catch (Exception e) {
	    putFieldError(ISSUE_DATE_FIELD, e);
	}

	try {
	    town = validateTown(request);
	} catch (Exception e) {
	    putFieldError(TOWN_FIELD, e);
	}
    }

    private int validateIdentityType(final HttpServletRequest request) throws EmptyValueException, Exception {
	int identityType = 0;
	try {
	    // TODO
	    getFieldValue(request, IDENTITY_TYPE_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return identityType;
    }

    private String validateNumber(final HttpServletRequest request) throws Exception {
	String number = null;
	try {
	    number = getFieldValue(request, NUMBER_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return number;
    }

    private Date validateIssueDate(final HttpServletRequest request) throws Exception {
	String issueDate = null;
	try {
	    issueDate = getFieldValue(request, ISSUE_DATE_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	// TODO
	return null;
    }

    private String validateTown(final HttpServletRequest request) throws Exception {
	String town = null;
	try {
	    town = getFieldValue(request, TOWN_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return null;
    }

}
