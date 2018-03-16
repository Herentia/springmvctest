<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.11.3.js"></script>
</head>
<body>

<p>测试json</p>
<button id="ceshi" name="dianjiwo" onclick="getjson()">点我</button>

<script type="text/javascript">
	function getjson() {
		$.ajax({
			url: "testrequestbody",
			data: '{"name" : "zhangsan", "age" : 12}',
			contentType: "application/json;charset=utf-8",
			type: "post",
			headers: {
				Accept: "application/json"
			},
			success: function(data, textStatus) {
				console.log(data);
			},
			error: function(data, textStatus, errorThrown) {
				console.log(data);
			}
		})
	}
</script>

</body>
</html>