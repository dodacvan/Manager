<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-lg-7" style="padding-bottom: 120px">
	<form:form action="" method="POST" commandName="department">
		<div class="form-group">
			<label>Department Name</label> 
			<form:input type="text" class="form-control" path="name"
				placeholder="Please Enter Department Name" />
		</div>
		<c:set var="domainNameErrors"><form:errors path="name"/></c:set>
		<c:if test="${not empty domainNameErrors}">
			<div class="alert alert-danger">${domainNameErrors}</div>
		</c:if>

		<div class="form-group">
			<label>Office Phone</label> <form:input type="text" class="form-control" path="officephone" placeholder="Please Enter Office Phone" />
		</div>
		<c:set var="domainOfficephoneErrors"><form:errors path="officephone"/></c:set>
		<c:if test="${not empty domainOfficephoneErrors}">
			<div class="alert alert-danger">${domainOfficephoneErrors}</div>
		</c:if>
		
		<div class="form-group">
			<label>Manager</label> 
			<form:select class="form-control" path="manager.id">
				<c:forEach items="${listEmp}" var="emp">
				<option value="${emp.id}">${emp.name}</option>
			</c:forEach>
			</form:select>
		</div>
		<button type="submit" class="btn btn-default">Add Department
		</button>
		<button type="reset" class="btn btn-default">Reset</button>
		</form:form>
</div>