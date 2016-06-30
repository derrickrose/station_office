package station.authentification.controlers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class UserDetailsHandler extends DefaultHandler {

    public static final String FIRST_NAME_FIELD = "firstName";
    public static final String LAST_NAME_FIELD = "lastName";
    public static final String ADRESS_FIELD = "adress";
    public static final String PHONE_NUMBER_FIELD = "phone";
    public static final String EMAIL_FIELD = "email";
    public static final String BIRTH_DAY_FIELD = "birth";

    public static UserDetailsHandler getUserDetailsHandler() {
	return new UserDetailsHandler();
    }

    public void validateUserDetails(HttpServletRequest request) {
	String firstName, lastName, adress, phone, email;
	Date birth;

	try {
	    firstName = validateFirstName(request);
	} catch (Exception e) {
	    putFieldError(FIRST_NAME_FIELD, e);
	}

	try {
	    lastName = validateLastName(request);
	} catch (Exception e) {
	    putFieldError(LAST_NAME_FIELD, e);
	}

	try {
	    adress = validateAdress(request);
	} catch (Exception e) {
	    putFieldError(ADRESS_FIELD, e);
	}

	try {
	    phone = validatePhone(request);
	} catch (Exception e) {
	    putFieldError(PHONE_NUMBER_FIELD, e);
	}

	try {
	    email = validateEmail(request);
	} catch (Exception e) {
	    putFieldError(EMAIL_FIELD, e);
	}

	try {
	    birth = validateBirth(request);
	    // TODO
	} catch (Exception e) {
	    putFieldError(BIRTH_DAY_FIELD, e);
	}

    }

    // private String validateFieldValue(final HttpServletRequest request)
    // throws EmptyValueException, Exception {
    // String value = null;
    // try {
    // value = getFieldValue(request, FIRST_NAME_FIELD, fieldType.REQUIRED);
    // } catch (Exception e) {
    // throw new Exception(e.getMessage());
    // }
    // return value;
    // }

    private String validateFirstName(final HttpServletRequest request) throws Exception {
	String firstName = null;
	try {
	    firstName = getFieldValue(request, FIRST_NAME_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return firstName;
    }

    private String validateLastName(final HttpServletRequest request) throws Exception {
	String lastName = null;
	try {
	    lastName = getFieldValue(request, LAST_NAME_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return lastName;
    }

    private String validateAdress(final HttpServletRequest request) throws Exception {
	String adress = null;
	try {
	    adress = getFieldValue(request, ADRESS_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return adress;
    }

    private String validatePhone(final HttpServletRequest request) throws Exception {
	String phone = null;
	try {
	    phone = getFieldValue(request, PHONE_NUMBER_FIELD, fieldType.REQUIRED);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return phone;
    }

    private String validateEmail(final HttpServletRequest request) throws Exception {
	String email = null;
	try {
	    email = getFieldValue(request, EMAIL_FIELD, fieldType.FREE);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return email;
    }

    private Date validateBirth(final HttpServletRequest request) throws Exception {
	String birth = null;
	// TODO
	try {
	    birth = getFieldValue(request, BIRTH_DAY_FIELD, fieldType.FREE);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return null;
    }

}
