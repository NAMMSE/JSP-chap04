<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>add new emp</title>
</head>
<body>
	<!-- 0726 ����� �ڵ� -->
	<h3># �� ��� �߰��ϱ�</h3>
	
	<!-- /chap04/employee/add_form : �� �������� �����ϴ� ���μ����� ����ִ� ��(uri_mapping)�� Ű ���-->
	<form action="./add" method="POST">
	employee_id : <input type="text" name="employee_id"/><br />
	last_name : <input type="text" name="last_name"/><br />
	email : <input type="text" name="email"/><br />
	hire_date : <input type="date" name="hire_date"/><br />
	job_id : <input type="text" name="job_id"/><br />
	<input type="submit" value="�߰��ϱ�"/>
	</form>

</body>
</html>