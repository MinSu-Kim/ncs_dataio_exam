<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="employee" /><spring:message
		code="info" /> 수정</title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {

	$('#modify').on(
				"click",
				function(e) {
					var newEmp = {
						empNo : $('#empNo').val(),
						empName : $('#empName').val(),
						title : $('#title').val(),
						manager : {
							empNo : $('#manager').val()
						},
						salary : $('#salary').val(),
						dept : {
							deptNo : $('#dept').val()
						}
					};
					alert(newEmp.empNo);

					$.ajax({
						url : "/ncs_dataio_exam/update",
						type : 'POST',
						contentType : "application/json; charset=utf-8",
						dataType : 'json',
						cache : false,
						data : JSON.stringify(newEmp),
						success : function(data) {
							alert(data);
							window.location.href = "/ncs_dataio_exam/emplist";
						},
						error : function(data, status, er) {
							alert("error: " + data + " status: " + status
									+ " er:" + er);
							window.location.href = "/ncs_dataio_exam/emplist";
						}
					});
				});
	});
</script>
</head>
<body>
	<h2>
		<spring:message code="employee" />
		<spring:message code="info" /> 수정
	</h2>
	<form:form modelAttribute="employee">
		<p>
			<label><spring:message code="eno" />: <form:input
					path="empNo" /> <form:errors path="empNo" /> </label>
		</p>
		<p>
			<label> <spring:message code="ename" />: <form:input
					path="empName" /> <form:errors path="empName" />
			</label>
		</p>
		<p>
			<label> <spring:message code="title" />: <form:input
					path="title" /> <form:errors path="title" />
			</label>
		</p>
		<p>
			<label> <spring:message code="manager" />: <form:input
					path="manager.empNo" id="manager" /> <form:errors path="manager" />
			</label>
		</p>
		<p>
			<label> <spring:message code="salary" />: <form:input
					path="salary" /> <form:errors path="salary" />
			</label>
		</p>
		<p>
			<label> <spring:message code="dept" />: <form:input
					path="dept.deptNo" id="dept"/> <form:errors path="dept" />
			</label>
		</p>


	</form:form>
        <button id="modify">
            <spring:message code="modify" />
        </button>

</body>
</html>