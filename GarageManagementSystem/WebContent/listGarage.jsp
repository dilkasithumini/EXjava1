<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Garage Id</th>
				<th>Garage Name</th>
				<th>Category</th>
				<th>Address</th>
				<th>Owner</th>
				<th>Contact</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${garage}" var="gr">
				<tr>
					<td><c:out value="${gr.id}" /></td>
					<td><c:out value="${gr.name}" /></td>
					<td><c:out value="${gr.category}" /></td>
					<td><c:out value="${gr.address}" /></td>
					<td><c:out value="${gr.owner}" /></td>
					<td><c:out value="${gr.contact}" /></td>
					<td><a
						href="GarageController?action=edit&userId=<c:out value="${gr.id}"/>">Update</a></td>
					<td><a
						href="GarageController?action=delete&userId=<c:out value="${gr.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="GarageController?action=insert">Add Garage</a>
	</p>
</body>
</html>