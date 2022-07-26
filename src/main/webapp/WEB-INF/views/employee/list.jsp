<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 0726 수업 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Employee List</title>
</head>
<body>
	<!-- 객체의 속성에 Getter가 있으면 EL로 편리하게 해당 속성을 꺼내 사용할 수 있다. -->
	<h3># Employees</h3>
	<ul>
	<c:forEach items="${employees }" var="employee">
		<li>${employee.first_name }${employee.last_name }</li>
	</c:forEach>
	</ul>


</body>
</html>