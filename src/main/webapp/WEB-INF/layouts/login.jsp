<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   	
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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Log In</h3>
					</div>
					<div class="panel-body">

						<div class="alert alert-danger"></div>

						<form role="form" action="${pageContext.request.contextPath}/j_spring_security_check" method="POST">
							<fieldset>
								<div class="form-group">
									<label>username</label> <input class="form-control"
										placeholder="Username" name="username" type="text">
								</div>

								<div class="alert alert-danger"></div>


								<div class="form-group">
									<label>password</label> <input class="form-control"
										placeholder="Password" name="password" type="password"
										value="">
								</div>
								<div class="alert alert-danger"></div>

								<button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
							</fieldset>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/js/sb-admin-2.js"></script>
	<script src="{{url('public/admin/dist/js/myscript.js')}}"></script>
</body>
</html>