<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="dacvankc">
<meta name="author" content="Vu Quoc Tuan">
<title>Login</title>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/styles/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/styles/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/styles/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/styles/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/styles/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/styles/dataTables.responsive.css"
	rel="stylesheet" type="text/css">		
</head>
<body>
	<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                
                <a class="navbar-brand" href="">Employee Manage</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                    	<c:set var="name">${pageContext.request.userPrincipal.name}</c:set>
                        <li><a href="${pageContext.request.contextPath}/editUser?id=${name}"><i class="fa fa-user fa-fw"></i> ${name}</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="{{ url('/auth/logout') }}"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-bullseye fa-fw dropdown-toggle" data-toggle="dropdown"></i>Administration</a>
					<ul class="nav dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/listUser">List Admin</a>
                                </li>
						
                                <li>
                                    <a href="${pageContext.request.contextPath}/addUser">Add Admin</a>
                                </li>
						
                            </ul>

                        </li>
                        <li>
                            <a href="#"><i class="fa fa-institution fa-fw"></i> Department</a>
                            <ul class="nav dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/listDepartment">List Department</a>
                                </li>
						
                                <li>
                                    <a href="${pageContext.request.contextPath}/addDepartment">Add Department</a>
                                </li>
						
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> Employee</a>
                            <ul class="nav dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/listEmployee">List Employee</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/addEmployee">Add Employee</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><tiles:insertAttribute name="controller" />
                            <small><tiles:insertAttribute name="action" /></small>
                        </h1>
                    </div>
                    <!-- /.col-lg-12 -->
				<div class="col-lg-12">
					<c:if test="${not empty messageSuccess}">
						<div class="alert alert-success">
							${messageSuccess}
						</div>
					</c:if>
				</div>
				<tiles:insertAttribute name="content" />    
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/js/sb-admin-2.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/myscript.js"></script>
</body>
</html>