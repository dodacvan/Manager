<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="col-lg-7" style="padding-bottom: 120px">
	<form:form action="" method="POST" commandName="employee">
		<div class="form-group">
			<label>Name</label>
			<form:input class="form-control" path="name"
				placeholder="Please Enter Name Of New Employee" />
		</div>
		<c:set var="domainNameErrors"><form:errors path="name"/></c:set>
		<c:if test="${not empty domainNameErrors}">
			<div class="alert alert-danger">${domainNameErrors}</div>
		</c:if>
		
		<div class="form-group">
			<label>Email</label>
			<form:input class="form-control" path="email"
				placeholder="Please Enter email " />
		</div>
		
		<c:set var="domainEmailErrors"><form:errors path="email"/></c:set>
		<c:if test="${not empty domainEmailErrors}">
			<div class="alert alert-danger">${domainEmailErrors}</div>
		</c:if>
		
		<div class="form-group">
			<label>JobTitle</label> 
			<form:input class="form-control" path="jobtitle" placeholder="Please Enter Jobtitle" />
		</div>
		<c:set var="domainJobtitleErrors"><form:errors path="jobtitle"/></c:set>
		<c:if test="${not empty domainJobtitleErrors}">			
        	<div class="alert alert-danger">${domainJobtitleErrors}</div>
		</c:if>
					
        <div class="form-group">
			<label>Cellphone</label> 
			<form:input class="form-control" path="cellphone" placeholder="Please Enter Cellphone"/>
		</div>
		<c:set var="domainCellphoneErrors"><form:errors path="cellphone"/></c:set>
		<c:if test="${not empty domainCellphoneErrors}">				
        	<div class="alert alert-danger">${domainCellphoneErrors}</div>
		</c:if>	

        <div class="form-group">
		</div>
		
		<div class="form-group">
			<label>Department</label> 
			<form:select class="form-control" path="department.id"> 
			<c:forEach items="${listDepart}" var="depart">
				<option value="${depart.id}">${depart.name}</option>
			</c:forEach>
			</form:select>
		</div>	
			<button type="submit" class="btn btn-default">Employee Add</button>
			<button type="reset" class="btn btn-default">Reset</button>
	</form:form>
</div>