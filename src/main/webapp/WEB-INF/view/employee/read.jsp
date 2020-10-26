<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="employee" /> <spring:message code="info" /></title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
    $('#list').on("click", function(){
    	 window.location.href = "/ncs_dataio_exam/emplist";
    });
    
    $('#modify').on("click", function() {
    	window.location.href = "/ncs_dataio_exam/update";
    });
    
    $('#remove').on("click", function(){
        var data = {empNo :  $('#empNo').val()};
        alert("data > " + data);
        $.post("/ncs_dataio_exam/delete", data, function(){
            window.location.href = "/ncs_dataio_exam/emplist";
        });
   });

});
</script>
</head>
<body>
	<h2>
		<spring:message code="employee" />
		<spring:message code="info" />
	</h2>
	<p>
		<label><spring:message code="eno" /></label>:
		<input type="number" id="empNo" name="empNo" value="${employee.empNo }" readonly="readonly">
	</p>
	<p>
		<label> <spring:message code="ename" />: </label>
		 <input type="text" name="empName" value="${employee.empName }" readonly="readonly">
	</p>
	<p>
		<label> <spring:message code="title" />: </label>
        <input type="text" name="title" value="${employee.title }" readonly="readonly">
	</p>
	<p>
		<label> <spring:message code="manager" />: </label> 
		<input type="number" name="manager" value="${employee.manager.empNo }" readonly="readonly">
	</p>
	<p>
		<label> <spring:message code="salary" />: </label>
		<input type="number" name="salary" value="${employee.salary }" readonly="readonly">
	</p>
	<p>
		<label> <spring:message code="dept" />: </label> 
		<input type="number" name="dept" value="${employee.dept.deptNo }" readonly="readonly">
	</p>

	<button id="modify">
		<spring:message code="modify" />
	</button>
	<button id="list">
		<spring:message code="list" />
	</button>
    <button id="remove">
        <spring:message code="remove" />
    </button>
</body>
</html>