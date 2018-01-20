<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>  

<div id="container" class="container">
    <div class="row">
    	<div class="col-xs-12">
        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <td>${department.name }</td>
            </tr>
            <tr>
                <th>Office Phone</th>
                <td>${department.officephone }</td>
            </tr>
            <tr>
                <th>Manager</th>
                <td>${department.manager.name }</td>
            </tr>
        </table>
        <a href="{!! URL::previous() !!}" class="btn btn-default">Back</a>   
	 </div>
     </div>
</div>