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
		code="info" /></title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
	$('#new').on("click", function(e) {
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
		    url: "/ncs_dataio_exam/create",
		    type: 'POST',
		    contentType:"application/json; charset=utf-8",
		    dataType: 'json',
		    cache : false,
            data : JSON.stringify(newEmp),
		    success: function(data) {
		        alert(data);
		        window.location.href = "/ncs_dataio_exam/emplist";
		    },
		    error:function(data, status, er) {
		        alert("error: "+data+" status: "+status+" er:"+er);
		        window.location.href = "/ncs_dataio_exam/emplist";
		    }
		}); 
	});

	$('#modify').on("click", function() {
		window.location.href = "/ncs_dataio_exam/update";
	});

});
</script>
</head>
<body>
	<h2>
		<spring:message code="employee" />
		<spring:message code="info" />
	</h2>
	<form:form>
		<p>
			<label><spring:message code="eno" />: 
			<input type="text" id="empNo" value="1004"> </label>
		</p>
		<p>
			<label> <spring:message code="ename" />:
			</label>
			<input type="text" id="empName" value="박규영"/>
		</p>
		<p>
			<label> <spring:message code="title" />:
			</label>
			<input type="text" id="title" value="대리"/>
		</p>
		<p>
			<label> <spring:message code="manager" />:
			</label>
			<input type="text" id="manager" value="4377"/>
		</p>
		<p>
			<label> <spring:message code="salary" />:
			</label>
			<input type="text" id="salary" value="1500000"/>
		</p>
		<p>
			<label> <spring:message code="dept" />:
			</label>
			<input type="text" id="dept"  value="1" />
		</p>


	</form:form>

	<button id="new">
		<spring:message code="new" />
	</button>
</body>
</html>