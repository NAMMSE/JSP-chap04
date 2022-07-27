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
	<%-- 
	<h3># Employees</h3>
	<ol>
		<form method="GET">
			<c:forEach items="${employees }" var="employee">
				<li>${employee.first_name }${employee.last_name }--%>
				<%-- <c:set var="emp_id" value="${employee.employee_id }" scope="session"></c:set>--%><%-- 
				<input	type="radio" name="employee" value="${employee.employee_id }" />
				</li>
			</c:forEach>
			<input type="submit" value="수정하기" formaction="./update_form" />
			<input type="submit" value="삭제하기" formaction="./delete" />
		</form>
	</ol>
	--%>
	<%-- 0727 강사님코드 --%>
	<h3># Employees</h3>
	<ol>
			<c:forEach items="${employees }" var="employee">
				<li>${employee.first_name }${employee.last_name }
				(<a href="./modify_form?emp=${employee.employee_id }">수정</a>
				/ <a href="./delete?emp=${employee.employee_id }">삭제</a>)
				</li>
			</c:forEach>
	</ol>


</body>
</html>