<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Building user detailsr</title>
</head>
<body>
		<form method="post" action="BuildUserDetails">
			<c:import url="/userDetailsForm.jsp"></c:import>
			<input type="reset" value="Cancel" /> 
			<input type="submit" value="Create"/>  ${message}
		</form> 
		<br />
<!------------------------------------------------------------------------------------------------------------------->
</body>
</html>
