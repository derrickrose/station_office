package station.authentification.controlers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public abstract class DefaultHandler {

    protected HashMap<String, String> error = null;
    protected String message = null;

    public static final String ERROR_MAP_FIELD = "error";
    public static final String MESSAGE_FIELD = "message";

    public HashMap<String, String> getError() {
	return error;
    }

    public String getMessage() {
	return message;
    }

    protected enum fieldType {
	REQUIRED, FREE
    }

    protected String getFieldValue(final HttpServletRequest request, final String fieldName, final fieldType type)
	    throws Exception {
	String fieldValue = request.getParameter(fieldName);
	if (fieldValue != null)
	    fieldValue = fieldValue.trim();
	if (fieldValue == null || "".equals(fieldValue)) {
	    if (type == fieldType.REQUIRED)
		// throw new EmptyValueException(fieldName + "must not be
		// empty");
		throw new EmptyValueException("must not be empty");
	}
	return fieldValue;
    }

    protected HashMap<String, String> initErrorMap() {
	return new HashMap<String, String>();
    }

    protected void putFieldError(String fieldName, Exception e) {
	if (error == null)
	    error = initErrorMap();
	error.put(fieldName, e.getMessage());
    }

    protected void putFieldError(String fieldName, String str) {
	if (error == null)
	    error = initErrorMap();
	error.put(fieldName, str);
    }

    protected class EmptyValueException extends Exception {
	private EmptyValueException(String message) {
	    super(message);
	}

    }
}
