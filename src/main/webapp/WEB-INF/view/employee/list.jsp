<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="employee" /><spring:message code="list" /></title>
<!-- <link rel="stylesheet" type="text/css" href="css/style.css"> -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<script>
$(function(){
     $.get("employees", function(json){
         var dataLength = json.length;
         if ( dataLength >=1 ){
             var sCont = "";
             for ( i=0 ; i < dataLength ; i++){
                sCont += "<tr>";
                sCont += "<td>" + json[i].empNo + "</td>";
                sCont += "<td><a href='employees/"+json[i].empNo+"'>" + json[i].empName + "</a></td>";
                sCont += "<td>" + json[i].title + "</td>";
                if (json[i].manager != null){
                    sCont += "<td>" + json[i].manager.empNo + "</td>";
                }else{
                    sCont += "<td></td>"; 
                }
                sCont += "<td>" + json[i].salary.toLocaleString("ko") + "</td>";
                sCont += "<td>" + json[i].dept.deptNo + "</td>";
                sCont += "</tr>";
            }
            $("#load:last-child").append(sCont);   
        } 
     });
});
</script>

<body>

<h2><spring:message code="employee" /><spring:message code="list" /></h2>
<table border=1>
	<thead>
	    <td><spring:message code="eno" /></td>
	    <td><spring:message code="ename" /></td>
	    <td><spring:message code="title" /></td>
	    <td><spring:message code="manager" /></td>
	    <td><spring:message code="salary" /></td>
	    <td><spring:message code="dept" /></td>
	</thead>
<c:forEach var="employee" items="${emplist}">
    <tr>
        <td>${employee.empNo}</td>
        <td>${employee.empName}</td>
        <td>${employee.title}</td>
        <td>${employee.manager.empNo}</td>
        <td><fmt:formatNumber value="${employee.salary}"></fmt:formatNumber></td>
        <td>${employee.dept.deptNo}</td>
        </td>
    </tr>
</c:forEach>
</table>

<hr>
<h2>사원목록</h2>
   <table>
       <thead>
           <td>사원번호</td>
           <td>사원명</td>
           <td>직책</td>
           <td>직속상사</td>
           <td>급여</td>
           <td>부서</td>
       </thead>
       <tbody id="load">
       </tbody>
   </table>
</body>
</html>