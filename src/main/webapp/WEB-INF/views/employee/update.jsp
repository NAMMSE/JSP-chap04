<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>update employee</title>
</head>
<body>
<%-- 0727 --%>
<h3># ��� ���� �����ϱ�</h3>
	
	<%-- /chap04/employee/add_form : �� �������� �����ϴ� ���μ����� ����ִ� ��(uri_mapping)�� Ű ��� --%>
	<form action="./update" method="GET">
	employee_id : <input type="number" name="employee_id" value="${employee_id+1 }" min="${employee_id+1 }"/><br />
	first_name : <input type="text" name="first_name" /><br />
	last_name : <input type="text" name="last_name"/><br />
	email : <input type="text" name="email"/><br />
	phone_number : <input type="text" name="phone_number" /><br />
	hire_date : <input type="date" name="hire_date"/><br />
	job_id :
			<select name="job_id">
				<c:forEach items="${jobs }" var="job">
					<option value="${job.job_id }">${job.job_title }(${job.job_id })</option>
				</c:forEach>
			</select><br />
			<input type="hidden" name="emp_id" value="${employee.employee_id }" />
	<input type="submit" value="�����ϱ�"/>
	</form>



</body>
</html>