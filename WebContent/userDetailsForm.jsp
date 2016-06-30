<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
			<legend>User details</legend>
			
			<label for="firstName">First name :</label> 
			<input type="text" id="firstName" name="firstName"
				value="<c:out value="${param.firstName}"/>" /> 
				${error.firstName} 
			<br /> 
			
			<label for="lastName">Last Name :</label>
			<input type="text" id="lastName" name="lastName"
				value="<c:out value="${param.lastName}"/>" />
			 	${error.lastName} 
			<br /> 
			
			<label for="birth">Date of birth</label> 
			<input type="text" id="birth" name="birth" disabled="disabled" 
				value="<c:out value="${param.birth}"/>"  />
			 	${error.birth} 
			<br /> 
				 
			<label for="adress">Adress :</label> 
			<textarea id="adress" name="adress"><c:out value="${param.adress}"/></textarea>
				${error.adress} 
			<br /> 
			
			<label for="phone">Phone :</label> 
			<input type="text" id="phone" name="phone"
				value="<c:out value="${param.phone}"/>" />
				${error.phone}
			<br /> 
			
			<label for="email">Email :</label> 
			<input type="text" id="email" name="email" 
				value="<c:out value="${param.email}"/>" />
				${error.email}
			<br />
		</fieldset>
    