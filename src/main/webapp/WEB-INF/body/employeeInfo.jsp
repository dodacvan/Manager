<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>    
    
<div id="container" class="container">
    <div class="row">
    	<div class="col-sm-offset-2 col-sm-2">
        <img src="{!! asset('public/admin/images/'.$data['photo']) !!}" class="img-responsive center-block" alt="Employee Photo"/>    
	</div>
    	<div class="col-sm-6">
        <table id="employee-list" class="table table-striped">
            <tr>
                <th>Name</th>
                <td>${employee.name }</td>
            </tr>
            <tr>
                <th>Department</th>
                <td>${employee.department.name }</td>
            </tr>
            <tr>
                <th>Job Title</th>
                <td>${employee.jobtitle }</td>
            </tr>
            <tr>
                <th>Cellphone</th>
                <td>${employee.cellphone }</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${employee.email }</td>
            </tr>
        </table>
        <a href="{!! URL::previous() !!}" class="btn btn-default">Back</a>    
	</div>
    </div>
</div>