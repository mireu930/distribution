<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물류</title>
</head>
<body id="page-top">
	<div id="wrapper">
		<div id="content-wrapper">
			<div id="content">
				
				<div class="container-fluid">
					<h2>ingredients</h2>
					<ul>
					  <c:forEach var="item" items="${list}">
					 	<li>
						  번호: ${item.ingredientsId} <br>
						  이름: ${item.ingredientsName} <br>
						  재고: ${item.ingredientsStock}<br>
						  가격: ${item.ingredientsPrice}
						</li>
					  </c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End Wrapper -->
</body>

</html>