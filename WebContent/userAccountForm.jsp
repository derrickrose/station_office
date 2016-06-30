<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<fieldset>
			<legend>User account</legend>
			
			<label for="login">Login :</label> 
			<input type="text" id="login" name="login"
				value="<c:out value="${param.login}"/>" /> 
				${error.login} 
			<br /> 
			
			<label for="pass">Password :</label>
			<input type="password" id="pass" name="pass"
				value="<c:out value="${param.pass}"/>" />
			 	${error.pass} 
			<br /> 
			
			<label for="confirm">Confirm password :</label>
			<input type="password" id="confirm" name="confirm"
				value="<c:out value="${param.confirm}"/>" />
			 	${error.confirm} 
			<br /> 
			
			<label for="created">Created on :</label> 
			<input type="text" id="created" name="created" disabled="disabled" 
				value="<c:out value="${param.created}"/>"  />
			 	${error.created} 
			<br /> 
				 
		</fieldset>

<!------------------------------------------------------------------------------------------------------------------->
</body>
</html>
