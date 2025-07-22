<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물류창고 관리 시스템</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- FontAwesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="/css/main/main.css">
</head>
<body>

<div class="wrapper">
    <!-- top -->
 	<c:import url="/WEB-INF/views/template/topbar.jsp"></c:import>

    <!--content-->
    <div class="content">
        <div class="container my-5">
            <div class="text-center mb-4">
                <h2 class="fw-bold">📦 대시보드 Home</h2>
                <p class="text-muted">물류 현황을 빠르게 확인하고 이동하세요</p>
            </div>

            <div class="row g-4">
                <!-- 재고 관리 카드 -->
                <div class="col-md-4">
                    <div class="card shadow dashboard-card">
                        <div class="card-body text-center">
                            <div class="card-icon mb-2"><i class="fas fa-boxes"></i></div>
                            <div class="card-title">원재료 재고 관리</div>
                            <a href="/ingredients/list" class="btn btn-primary mt-3">이동하기</a>
                        </div>
                    </div>
                </div>

                <!-- 입고 처리 카드 -->
                <div class="col-md-4">
                    <div class="card shadow dashboard-card">
                        <div class="card-body text-center">
                            <div class="card-icon mb-2"><i class="fas fa-truck-loading"></i></div>
                            <div class="card-title">입고 처리</div>
                            <a href="/inbound/list" class="btn btn-secondary mt-3">이동하기</a>
                        </div>
                    </div>
                </div>

                <!-- 출고 처리 카드 -->
                <div class="col-md-4">
                    <div class="card shadow dashboard-card">
                        <div class="card-body text-center">
                            <div class="card-icon mb-2"><i class="fas fa-dolly"></i></div>
                            <div class="card-title">출고 처리</div>
                            <a href="/outbound/list" class="btn btn-secondary mt-3">이동하기</a>
                        </div>
                    </div>
                </div>
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