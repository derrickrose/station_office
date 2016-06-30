package station.authentification.controlers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import station.authentification.beans.UserAccount;
import station.authentification.beans.UserDetails;
import station.authentification.beans.UserIdentity;

public class UserHandler {

    private UserDetailsHandler userDetailsHandler;
    private UserIdentityHandler userIdentityHandler;
    private UserAccountHandler userAccountHandler;
    private HashMap<String, String> error = new HashMap<String, String>();
    private String message = "";

    private UserHandler(UserDetailsHandler userDetailsHandler, UserIdentityHandler userIdentityHandler,
	    UserAccountHandler userAccountHandler) {
	this.userDetailsHandler = userDetailsHandler;
	this.userIdentityHandler = userIdentityHandler;
	this.userAccountHandler = userAccountHandler;

    }

    public void validateUser(HttpServletRequest request) {
	UserDetails userDetails;
	UserIdentity userIdentity;
	UserAccount userAccount;
	// TODO userDetails = validateUserDeatils...
	this.userDetailsHandler.validateUserDetails(request);
	this.userIdentityHandler.validateUserIdentity(request);
	this.userAccountHandler.validateUserAccount(request);
    }

    private UserHandler() {

    }

    public HashMap<String, String> getError() {
	if (!this.userDetailsHandler.getError().isEmpty()) {
	    this.error.putAll(this.userDetailsHandler.getError());
	}
	if (!this.userIdentityHandler.getError().isEmpty()) {
	    this.error.putAll(this.userIdentityHandler.getError());
	}
	if (!this.userAccountHandler.getError().isEmpty()) {
	    this.error.putAll(this.userAccountHandler.getError());
	}
	return this.error;
    }

    public String getMessage() {
	return this.message;
    }

    public static UserHandler getUserHandler(UserDetailsHandler userDetailsHandler,
	    UserIdentityHandler userIdentityHandler, UserAccountHandler userAccountHandler) {
	return new UserHandler(userDetailsHandler, userIdentityHandler, userAccountHandler);
    }

    // if field required sending error
    // private enum fieldType {
    // REQUIRED, FREE
    // }

    // public void validateUser(HttpServletRequest request) {
    // String firstName = null;
    // try {
    // firstName = validateFirstName(request, "firstName", fieldType.REQUIRED);
    // } catch (Exception e) {
    // putFieldError("firstName", e);
    // }
    // }

    // private String validateField(final HttpServletRequest request, final
    // String fieldName, final fieldType type) throws Exception {
    // String fieldValue = request.getParameter(fieldName);
    // if (fieldValue == null || "".equals(fieldValue) || fieldValue.length() <=
    // 1) {
    // throw new Exception(fieldName + " must not be empty");
    // }
    // return fieldValue;
    // }

    // private String validateFirstName(final HttpServletRequest request, final
    // String fieldName, final fieldType type) throws Exception {
    // String firstName = null;
    // try {
    // firstName = validateField(request, fieldName, fieldType.REQUIRED);
    // } catch (Exception e) {
    // throw new Exception(e.getMessage());
    // }
    //
    // if (firstName.length() < 6) {
    // throw new Exception("firstName must be more than 6 chars");
    // }
    // return firstName;
    // }

    // private HashMap<String, String> initErrorMap() {
    // return new HashMap<String, String>();
    // }

    // private HashMap<String, String> putFieldError(String fieldName, Exception
    // e) {
    // if (error == null)
    // error = initErrorMap();
    // error.put(fieldName, e.getMessage());
    // return error;
    // }

}
