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
    <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"> --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/jqueryui/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
	    $('#new').on("click", function() {
	        window.location.href = "employeeForm";
	    });
	    
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
</head>


<body>
<div><button id="new">추가</button></div>
<%--
<h2>
<spring:message code="employee" /><spring:message code="list" /></h2>
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
        <td><a href="employees/${employee.empNo}"> ${employee.empName} </a></td>
        <td>${employee.title}</td>
        <td>${employee.manager.empNo}</td>
        <td><fmt:formatNumber value="${employee.salary}"></fmt:formatNumber></td>
        <td>${employee.dept.deptNo}</td>
        </td>
    </tr>
</c:forEach>
</table>

<hr> 
--%>
<h2><spring:message code="employee" /><spring:message code="list" /></h2>
   <table border="1">
       <thead>
        <td><spring:message code="eno" /></td>
        <td><spring:message code="ename" /></td>
        <td><spring:message code="title" /></td>
        <td><spring:message code="manager" /></td>
        <td><spring:message code="salary" /></td>
        <td><spring:message code="dept" /></td>
    </thead>
       <tbody id="load">
       </tbody>
   </table>
</body>
</html>