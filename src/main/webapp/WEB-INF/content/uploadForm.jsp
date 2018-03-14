<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
</head>
<body>
	<h2>文件上传</h2>
	<form action="upload" enctype="Multipart/form-data" method="post">
		<table>
			<tr>
				<td>文件描述：</td>
				<td><input type="text" name="description"> </td>
			</tr>
			<tr>
				<td>请选择文件：</td>
				<td><input type="file" name="file"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="上传"> </td>
			</tr>
		</table>
	</form>
	<form action="testpojo" method="post">
		username: <input type="text" name="username" />
		<br/>
		password: <input type="password" name="password" />
		<br/>
		email: <input type="text" name="email" />
		<br/>
		age: <input type="text" name="age" />
		<br/>
		province: <input type="text" name="address.province" />
		<br/>
		city: <input type="text" name="address.city" />
		<br/>
		<input type="submit" value="submit" />
	</form>
</body>
</html>