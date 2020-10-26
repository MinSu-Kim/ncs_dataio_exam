<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="employee" /><spring:message
		code="info" /></title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
    
    $('#modify').on("click", function() {
/*         if ($('#passwd').val() != $('#repasswd').val()){
            alert("비밀번호가 틀립니다.");
            $('#passwd').val('');
            $('#repasswd').val('');
            $('#passwd').focus();
            return;
        }
        if (!isEmpNoCheck){
            alert("중복체크 하세요");
            return;
        } 
        
        //validCheck() 추가하기
        
        var newEmp = {
            empNo : $('#empNo').val(),
            empName : $('#empName').val(),
            title:{titleNo:$('#title').val()},
            manager:{empNo:$('#manager').val()},
            salary:$('#salary').val(),
            dept:{deptNo:$('#dept').val()},
            regDate:$('#regDate').val(),
            email:$('#email').val(),
            tel:$('#tel').val(),
            passwd:$('#passwd').val()
        };

        $.ajax({
            type : "post",
            url : "/employees",
            cache : false,
            data : JSON.stringify(newEmp),
            complete : function(data) {
                alert("추가되었습니다." + data);
                window.location.href = "emplist";
            }
        */
        });
    	
    });
</script>
</head>
<body>
${employee }
	<h2>
		<spring:message code="employee" />
		<spring:message code="info" />
	</h2>
	<form:form>
    <p>
        <label><spring:message code="eno" /></label>:
        <input type="number" name="empNo" value="${employee.empNo }" readonly="readonly">
    </p>
    <p>
        <label> <spring:message code="ename" />: </label>
         <input type="text" name="empName" value="${employee.empName }" >
    </p>
    <p>
        <label> <spring:message code="title" />: </label>
        <input type="text" name="title" value="${employee.title }">
    </p>
    <p>
        <label> <spring:message code="manager" />: </label> 
        <input type="number" name="manager" value="${employee.manager.empNo }" >
    </p>
    <p>
        <label> <spring:message code="salary" />: </label>
        <input type="number" name="salary" value="${employee.salary }" >
    </p>
    <p>
        <label> <spring:message code="dept" />: </label> 
        <input type="number" name="dept" value="${employee.dept.deptNo }" >
    </p>


	</form:form>
	<button id="modify">
		<spring:message code="modify" />
	</button>
</body>
</html>