<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-lg-7" style="padding-bottom: 120px">
	<form:form action="" method="POST" commandName="user">
	<div class="form-group">
			<label>Username</label>
			<form:input class="form-control" path="username"
				placeholder="Please Enter Username" />
		</div>
		<c:set var="domainUsernameErrors">
			<form:errors path="username" />
		</c:set>
		<c:if test="${not empty domainUsernameErrors}">
			<div class="alert alert-danger">${domainUsernameErrors}</div>
		</c:if>
	
	
		<div class="form-group">
			<label>Password</label>
			<form:input type="password" class="form-control" path="password"/>
		</div>
		<c:set var="domainPasswordErrors">
			<form:errors path="password" />
		</c:set>
		<c:if test="${not empty domainPasswordErrors}">
			<div class="alert alert-danger">${domainPasswordErrors}</div>
		</c:if>

		<div class="form-group">
			<label>RePassword</label>
			<form:input type="password" class="form-control"
				path="confirmPassword" placeholder="Please Enter RePassword" />
		</div>
		<c:set var="domainConfirmPasswordErrors">
			<form:errors path="confirmPassword" />
		</c:set>
		<c:if test="${not empty domainConfirmPasswordErrors}">
			<div class="alert alert-danger">${domainConfirmPasswordErrors}</div>
		</c:if>

		<div class="form-group">
			<label>Email</label>
			<form:input type="email" class="form-control" path="email"
				placeholder="Please Enter Email" />
		</div>
		<c:set var="domainEmailErrors">
			<form:errors path="email" />
		</c:set>
		<c:if test="${not empty domainEmailErrors}">
			<div class="alert alert-danger">${domainEmailErrors}</div>
		</c:if>

		<button type="submit" class="btn btn-default">Edit</button>
		<button type="reset" class="btn btn-default">Reset</button>
		</form:form>
</div>