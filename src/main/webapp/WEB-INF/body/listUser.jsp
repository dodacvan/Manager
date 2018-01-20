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
			<th>Email</th>
			<th>Level</th>
			<th>Delete</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}" varStatus="i">
		<tr id="${i.index +1}" class="odd gradeX" align="center">
			<td>${i.index +1}</td>
			<td>${user.username}</a></td>
			<td>${user.email}</td>
			<td><c:forEach var="role" items="${user.roles}">
				${role.userRole }
			</c:forEach></td>
			<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
				onclick="return xacnhanxoa('are you sure delete this')"
				href="{!! URL::route('admin.user.getdelete',$item['id']) !!}">
					Delete</a></td>

		</tr>
		</c:forEach>
	</tbody>
</table>
