<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
	<c:if test="${employee.id == null }">
		<!-- path 属性对应 html 表单标签的 name 属性值 -->
		LastName: <s:input path="lastName"/>
		<s:errors path="lastName"></s:errors>
	</c:if>
	<c:if test="${employee.id != null }">
		<s:hidden path="id"/>
		<input type="hidden" name="_method" value="PUT"/>
	</c:if>
	<br/>
	Email: <s:input path="email"/>
	<s:errors path="email" cssStyle="color: red"></s:errors>
	<br/>
	<%
		Map<String, String> genders = new HashMap<String, String>();
		genders.put("1", "Male");
		genders.put("0", "Female");
		request.setAttribute("genders", genders);
	%>
	Gender: <s:radiobuttons path="gender" items="${genders }"/>
	<br/>
	Department: <s:select path="department.id" items="${departments }" itemLabel="departmentname" itemValue="id"></s:select>
	<br/>
	<input type="submit" value="Submit" />
</s:form>

</body>
</html>