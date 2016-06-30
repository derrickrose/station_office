<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		
		
		<fieldset> 
			<legend>User identity</legend>
			
			<label for="identityType">Identity type :</label> 
			<input type="text" id="identityType" name="identityType"
				value="<c:out value="${param.identityType}"/>" />
				${error.identityType}
			<br /> 
			
			<label for="number">Number :</label> 
			<input type="text" id="number" name="number"
				value="<c:out value="${param.number}"/>" />
				${error.number}
			<br />
			
			<label for="issueDate">Issue date :</label> 
			<input type="text" id="issueDate" disabled="disabled" 
				value="<c:out value="${param.issueDate}"/>" />
				${error.issueDate}
			<br /> 
			 
			<label for="town">Delivering town :</label>
			<input type="text" id="town" name="town"
				value="<c:out value="${param.town}"/>" />
				${error.town}
			<br/>
		</fieldset>
		
		
			${message}
		
