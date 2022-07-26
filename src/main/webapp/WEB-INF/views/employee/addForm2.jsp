<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>add new emp</title>
</head>
<body>
	<!-- 0726 강사님 코드 -->
	<h3># 새 사원 추가하기</h3>
	
	<!-- /chap04/employee/add_form : 이 페이지를 리턴하는 프로세스가 들어있는 맵(uri_mapping)의 키 경로-->
	<form action="./add" method="POST">
	employee_id : <input type="text" name="employee_id"/><br />
	last_name : <input type="text" name="last_name"/><br />
	email : <input type="text" name="email"/><br />
	hire_date : <input type="date" name="hire_date"/><br />
	job_id : <input type="text" name="job_id"/><br />
	<input type="submit" value="추가하기"/>
	</form>

</body>
</html>