<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 0726 ���� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Employee List</title>
</head>
<body>
	<!-- ��ü�� �Ӽ��� Getter�� ������ EL�� ���ϰ� �ش� �Ӽ��� ���� ����� �� �ִ�. -->
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
			<input type="submit" value="�����ϱ�" formaction="./update_form" />
			<input type="submit" value="�����ϱ�" formaction="./delete" />
		</form>
	</ol>
	--%>
	<%-- 0727 ������ڵ� --%>
	<h3># Employees</h3>
	<ol>
			<c:forEach items="${employees }" var="employee">
				<li>${employee.first_name }${employee.last_name }
				(<a href="./modify_form?emp=${employee.employee_id }">����</a>
				/ <a href="./delete?emp=${employee.employee_id }">����</a>)
				</li>
			</c:forEach>
	</ol>


</body>
</html>