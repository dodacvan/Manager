<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  	
<table class="table table-striped table-bordered table-hover"
	id="dataTables-example">
	<thead>
		<tr align="center">
			<th>Numerical Order</th>
			<th>Name</th>
			<th>Department</th>
			<th>Jobtitle</th>
			<th>Email</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="test" items="${tests}" varStatus="i">

		<tr id="${i.index +1}" class="odd gradeX" align="center">
			<td>${i.index +1}</td>
			<td><a
				href="${pageContext.request.contextPath}/employeeinfo?Employee_id=${test.id}">${test.name }</a></td>
			<td>		
				${test.department.name }
			</td>
			<td>${test.jobtitle }</td>
			<td>${test.email }</td>
			<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
				onclick="return xacnhanxoa('are you sure delete this')"
				href="${pageContext.request.contextPath}/deleteEmployee?id=${test.id}">
					Delete</a></td>
			<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
				href="${pageContext.request.contextPath}/editEmployee?Employee_id=${test.id}">Edit</a></td>
		</tr>

		</c:forEach>

	</tbody>
</table>
