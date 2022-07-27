<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
th{
	text-align:justify;
}
</style>
</head>
<body>

	<%-- EL에서 .property를 하기 위해서는 해당 속성의 GETTER가 구현되어있어야 한다 
		역으로 이걸 이용해서 Employee 모델 클래스 안에 get함수를 커스텀해서 사용할 수도 있다
		${employee.form }--%>
	<form>
		<table>
			<tr>
				<th>employee_id</th>
				<td><input type="text" name="employee_id" value="${employee.employee_id }" readonly/></td>
			</tr>
			<%-- (tr>(th+td))*7 --%>
			<tr>
				<th>first_name</th>
				<td><input type="text" name="first_name" value="${employee.first_name }"/></td>
			</tr>
			<tr>
				<th>last_name</th>
				<td><input type="text" name="last_name" value="${employee.last_name }"/></td>
			</tr>
			<tr>
				<th>hire_date</th>
				<td><input type="date" name="hire_date" value="${employee.hire_date }" readonly/></td>
			</tr>
			<tr>
				<th>salary</th>
				<td><input type="text" name="salary" value="${employee.salary }"/></td>
			</tr>
			<tr>
				<th>commission_pct</th>
				<td><input type="text" name="commission_pct" value="${employee.commission_pct }"/></td>
			</tr>
			<tr>
				<th>job_id</th>
				<td>
					<select name="job_id">
						<c:forEach items="${jobs }" var="job">
							<c:choose>
								<c:when test="${job.job_id==employee.job_id }">
								<option value="${job.job_id }" selected>${job.job_title }(${job.job_id })</option>
								</c:when>
								<c:otherwise>
									<option value="${job.job_id }">${job.job_title }(${job.job_id })</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>department_id</th>
				<td>
					<select name="department_id" >
						<c:forEach items="${departments }" var="department">
							<c:choose>
								<c:when test="${department.department_id == employee.department_id }">
									<option value="${department.department_id }">${department.department_name }(${department.department_id })</option>	
								</c:when>
								<c:otherwise>
									<option value="${department.department_id }">${department.department_name }(${department.department_id })</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>