<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/loginmvc/registry"
		method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="login.username" value="user1"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="login.password" value="pwd1"></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input type="text" name="detail.realname" value="realname1"></td>
			</tr>
			<tr>
			<tr>
				<td>余额</td>
				<td><input type="text" name="detail.balance" value="9999.88"></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>

	</form>
</body>
</html>