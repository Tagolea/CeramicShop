<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type"%>

<c:if test="${udata_s.uuid!=null}">
	<c:choose>
		<c:when test="${type=='mobile'}">
			<div class="right-top-bar flex-w h-full">
				<a href="myPage.do?uuid=${udata_s.uuid}"
					class="flex-c-m p-lr-10 trans-04">마이페이지</a> <a onclick="kakaoLogout()" href="logout.do"
					class="flex-c-m p-lr-10 trans-04">로그아웃</a>
			</div>
		</c:when>
		<c:when test="${type=='web'}">
			<div class="right-top-bar flex-w h-full">
				<div class="flex-c-m trans-04 p-lr-25" style="magin-right : 50px;">
					<img id="wicon" style="height:35px;">
					<h5 style="display:inline"><span id="tempr"></span></h5>
					<span id="city"></span>
				</div>
				<a href="myPage.do?uuid=${udata_s.uuid}"
					class="flex-c-m trans-04 p-lr-25">마이페이지</a>
					<a onclick="kakaoLogout()" href="logout.do"
					class="flex-c-m trans-04 p-lr-25">로그아웃</a>
			</div>
		</c:when>
	</c:choose>
</c:if>

<c:if test="${udata_s.uuid==null}">
	<c:choose>
		<c:when test="${type=='mobile'}">
			<div class="right-top-bar flex-w h-full">
				<a href="login.jsp" class="flex-c-m p-lr-10 trans-04">로그인</a>
				<a href="signUp.jsp" class="flex-c-m p-lr-10 trans-04">회원가입</a>
			</div>
		</c:when>
		<c:when test="${type=='web'}">
			<div class="right-top-bar flex-w h-full">
				<div class="flex-c-m trans-04 p-lr-25" style="magin-right : 50px;">
					<img id="wicon" style="height:35px;">
					<h5 style="display:inline"><span id="tempr"></span></h5>
					<span id="city"></span>
				</div>
				<a href="login.jsp" class="flex-c-m trans-04 p-lr-25">로그인</a>
				<a href="signUp.jsp" class="flex-c-m trans-04 p-lr-25">회원가입</a>
			</div>
		</c:when>
	</c:choose>
</c:if>
