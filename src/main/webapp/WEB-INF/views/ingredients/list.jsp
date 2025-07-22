<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL Formatting (가격 포맷용) -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고 관리 - 원재료</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- FontAwesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="/css/main/main.css">
<style>
	body {
		background-color: #f8f9fa;
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	}
	.navbar {
	    background-color: #003366;
	}
	h2 {
		font-weight: bold;
		color: #003366;
	}
	.table thead {
		background-color: #003366;
		color: white;
	}
	.table tbody tr:hover {
		background-color: #f1f1f1;
	}
</style>
</head>
<body>
	<div class="wrapper">
	    <!-- top -->
	 	<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>

	    <!--content-->
	    <div class="content">
	        <div class="container my-5">
	            <div class="row g-4">
					<h2 class="mb-4">
						<i class="fas fa-boxes"></i> 원재료 재고 목록</h2>
						
						<table class="table table-bordered table-hover shadow-sm">
							<thead>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>재고</th>
									<th>가격</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr>
										<td>${item.ingredientsId}</td>
										<td>${item.ingredientsName}</td>
										<td>${item.ingredientsStock}</td>
										<td><fmt:formatNumber value="${item.ingredientsPrice}" type="number" groupingUsed="true"/> 원</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-12 col-md-4"></div>
								<div class="col-sm-12 col-md-4">
									<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
										<ul class="pagination">
											<li class="paginate_button page-item previous disabled" id="dataTable_previous">
												<a href="./list?nowPage=${pager.start-1 }&search=${pager.search}&kind=${pager.kind}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">
													Previous
												</a>
											</li>
											<c:forEach begin="${pager.start }" end="${pager.end }" var="i">
											<li class="paginate_button page-item ${pager.nowPage == i ? 'active' : '' }">
												<a href="./list?nowPage=${i }&search=${pager.search}&kind=${pager.kind}" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">
												${i}
												</a>
											</li>
											</c:forEach>
											<li class="paginate_button page-item next ${pager.endCheck?'disabled':''}" id="dataTable_next">
												<a href="./list?nowPage=${pager.end+1}&search=${pager.search}&kind=${pager.kind}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">
												Next
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>

						<a href="/" class="btn btn-secondary mt-3"><i class="fas fa-arrow-left"></i> 홈으로</a>
	            </div>
	        </div>
	    </div>

	    <!-- footer -->
	     <c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>