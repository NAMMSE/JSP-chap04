<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Add New Employee</title>
</head>
<body>

	<h3># �� ��� �߰��ϱ�</h3>
	
	<ul>
	<form action="/chap04/servlet/addemp" method="POST">
		<li><input type="number" name="info" id="employee_id" /> - �����ȣ</li>
		<li><input type="text" name="info" id="first_name"/> - ��</li>
		<li><input type="text" name="info" id="last_name"/> - �̸�</li>
		<li><input type="text" name="info" id="eamil"/> - �̸���</li>
		<li><input type="text" name="info" id="job_id"/> - ������ȣ</li>
		<li><input type="submit" value="�߰��ϱ�"/></li>
	</form>
	</ul>
	
	<p>
	<form action="">
	<input type="submit" value="���� ��� ����"/>
	</form>
	</p>
	<!-- ������� �� �ڵ� -->
</body>
</html>