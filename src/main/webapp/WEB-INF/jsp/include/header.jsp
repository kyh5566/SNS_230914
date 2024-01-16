<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex justify-content-between align-items-center bg-info">
<h2>Marondalgram</h2>
<div>
	<c:if test="${not empty userId}">
		<span class="font-weight-bold">${userName} 님 안녕하세요!</span>
		<a href="/user/sign-out">로그아웃</a>
	</c:if>
	<c:if test="${empty userId}">
		<a href="/user/sign-in-view">로그인</a>
	</c:if>
</div>
</div>