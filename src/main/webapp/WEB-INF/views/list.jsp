<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			//获取class为delete的标签的属性href的值
			var href = $(this).attr("href");
			//将form标签的action属性的值设置为href
			$("form").attr("action", href).submit();
			//返回false阻止a标签的默认跳转而使用form标签的action
			return false;
		})
	})
</script>
<body>

<!-- 让delete按钮使用此表单提交 -->
<form action="" method="post">
	<input type="hidden" name="_method" value="DELETE" />
</form>

<c:if test="${empty requestScope.employees }">
	没有任何员工信息
</c:if>
<c:if test="${!empty requestScope.employees }">
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${requestScope.employees }" var="emp"> 
			<tr>
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender == 0 ? 'Female' : 'male' }</td>
				<td>${emp.department.departmentname }</td>
				<td><a href="emp/${emp.id}">Edit</a></td>
				<td><a class="delete" href="emp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<a href="emp">增加员工</a>

</body>
</html>