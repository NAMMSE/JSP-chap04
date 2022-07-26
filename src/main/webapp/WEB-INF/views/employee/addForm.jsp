<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Add New Employee</title>
</head>
<body>

	<h3># 새 사원 추가하기</h3>
	
	<ul>
	<form action="/chap04/servlet/addemp" method="POST">
		<li><input type="number" name="info" id="employee_id" /> - 사원번호</li>
		<li><input type="text" name="info" id="first_name"/> - 성</li>
		<li><input type="text" name="info" id="last_name"/> - 이름</li>
		<li><input type="text" name="info" id="eamil"/> - 이메일</li>
		<li><input type="text" name="info" id="job_id"/> - 직업번호</li>
		<li><input type="submit" value="추가하기"/></li>
	</form>
	</ul>
	
	<p>
	<form action="">
	<input type="submit" value="직원 명단 보기"/>
	</form>
	</p>
	<!-- 여기까지 내 코드 -->
</body>
</html>