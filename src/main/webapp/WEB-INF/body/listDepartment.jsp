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
			<th>Office Number</th>
			<th>Manager</th>
			<th>Employee</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="depart" items="${listDepart}" varStatus="i">
		<tr id="${i.index +1}" class="odd gradeX" align="center">
			<td>${i.index +1}</td>
			<td><a
				href="${pageContext.request.contextPath}/Departmentinfo?id=${depart.id}">${depart.name }</a></td>
			<td>${depart.officephone }</td>
			<td>${depart.manager.name }</td>
			<td class="center"><i class="btn btn-info"><a href="${pageContext.request.contextPath}/employeeDepart?id=${depart.id}">
						Employee</i></a></td>
			<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
				onclick="return xacnhanxoa('are you sure delete this')"
				href="${pageContext.request.contextPath}/deleteDepart?id=${depart.id}">
					Delete</a></td>
			<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
				href="${pageContext.request.contextPath}/editDepartment?Department_id=${depart.id}">Edit</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>