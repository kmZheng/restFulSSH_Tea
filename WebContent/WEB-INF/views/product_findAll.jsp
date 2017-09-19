<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>显示所有商品</title>
</head>
<body>
	<h3>Welcome ${sessionScope.username }!</h3>

	<h3>商品列表如下：</h3>

	<table border="1">
		<tr>
			<td>商品ID</td>
			<td>商品名称</td>
			<td>国际编码</td>
			<td>商品价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${productListFromServer}" var="product">
			<tr>
				<td>${product.pid }</td>
				<td>${product.pname }</td>
				<td>${product.ean }</td>
				<td>${product.price }</td>
				<td>
					<form
						action="${pageContext.request.contextPath }/productmvc/product/${product.pid}"
						method="POST">
						<input type="hidden" name="_method" value="DELETE"> <input
							type="submit" value="delete" onclick="return confirm('是否删除')">
					</form>
					
					<form action="${pageContext.request.contextPath }/productmvc/product/${product.pid}"
						method="POST">
						<input type="hidden" name="_method" value="DELETE"> 
						<a	class="mya" href="javascript:void(0);">delete</a>
					</form> 
					
					<a href="${pageContext.request.contextPath }/productmvc/product/${product.pid}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/productmvc/saveinit">增加新商品</a>
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/productmvc/product" method="post" onsubmit="false">
		PID:<input type="number" name="pid" id="pid">
		 
		<a id="findbyid" href="javascript:void(0);">精确查询</a>	
	</form>
	<br />
	<br />
	<form method="post"
		action="${pageContext.request.contextPath }/productmvc/findbyname">
		商品名称:<input type="text" name="pname" value="F"> <input
			type="submit" value="模糊查询">
	</form>
	<script type="text/javascript">
		var myas = document.getElementsByClassName("mya");
		for (var i = 0; i < myas.length; i++) {
			myas[i].onclick = function() {
				var flag = confirm("是否确认删除？");
				if (flag) {
					this.parentNode.submit();
				}
			}
		}
		var findbyidNode = document.getElementById("findbyid");
		findbyidNode.onclick = function(){
			var queryNum = document.getElementById("pid").value;
			var formNode = this.parentNode;
			formNode.action = formNode.action+"/"+queryNum;
			formNode.submit();
		}
	</script>
</body>
</html>