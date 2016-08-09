<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new Garage</title>
</head>
<body>
	<form method="POST" action='GarageController' name="frmAddGarage">
		Garage ID : <input type="text" readonly="readonly" name="id"
			value="<c:out value="${garage.id}" />" /> <br /> 
		Garage Name : <input type="text" name="name" 
			value="<c:out value="${garage.name}" />" /><br />
		Category: <input type="text" name="category"
			value="<c:out value="${garage.category}" />" /> <br />
		 Address: <input type="text" name="address"
			value="<c:out value="${garage.address}" />" /> <br />
		 Owner : <input type="text" name="owner" 
		 	value="<c:out value="${garage.owner}" />" /><br /> 
		 Contact : <input type="text" name="contact"
			value="<c:out value="${garage.contact}" />" /> <br /> <input
			type="submit" value="Submit" />
	</form>
</body>
</html>