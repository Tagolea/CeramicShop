<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ham" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>My Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" sizes="96x96"
	href="images_1/favicon-96x96.png">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/linearicons-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<link rel="stylesheet" href="css_1/NewFile.css">

</head>
<body class="animsition">

	<!-- Header -->
	<header class="header-v4">
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				<div class="content-topbar flex-sb-m h-full container">
					<div class="left-top-bar"></div>

					<%-- ! 커스텀태그 활용 ! --%>
					<ham:login_topbar type="web" />

				</div>
			</div>
			<div class="wrap-menu-desktop">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="main.do" class="logo"> <img src="images_1/logo.png"
						alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">

						<%-- ! 커스텀태그 활용 ! --%>
						<ham:login_menudesk type="web" />

					</div>

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<div
							class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
							<i class="zmdi zmdi-search"></i>
						</div>
					</div>
				</nav>
			</div>
		</div>

		<!-- Header Mobile -->
		<div class="wrap-header-mobile">
			<!-- Logo moblie -->
			<div class="logo-mobile">
				<a href="main.do"><img src="images_1/logo.png" alt="IMG-LOGO"></a>
			</div>

			<!-- Icon header -->
			<div class="wrap-icon-header flex-w flex-r-m m-r-15">
				<div
					class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
					<i class="zmdi zmdi-search"></i>
				</div>
			</div>

			<!-- Button show menu -->
			<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
			</div>
		</div>


		<!-- Menu Mobile -->
		<div class="menu-mobile">
			<ul class="topbar-mobile">
				<li>
					<%-- ! 커스텀태그 사용할 부분 ! --%> <ham:login_topbar type="mobile" />
				</li>
			</ul>

			<%-- ! 커스텀태그 사용할 부분 ! --%>
			<ham:login_menudesk type="mobile" />

		</div>

		<%--
		부트스트랩의 한 종류! 버튼클릭시 팝업창이 아래로 떨어지도록 한다.
		설명링크 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=ksh81850&logNo=220421356848
		--%>

		<!-- Modal Search -->
		<div
			class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button
					class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15" action="psearch.do"
					method="post">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search"
						placeholder="제품을 검색해보세요">
				</form>
			</div>
		</div>
	</header>

	<%-- ////////////////////////////////////작업/////////////////////////// --%>
	<!-- Title page -->
	<section class="bg-img1 txt-center p-lr-15 p-tb-92"
		style="background-image: url('http://www.busan.com/nas/wcms/wcms_data/photos/2019/11/04/2019110417141390550_l.jpg');">
		<h2 class="ltext-105 cl0 txt-center">My Page</h2>
	</section>


	<!-- Content page -->
	<section class="bg0 p-t-104 p-b-116">
		<div class="container" id="contentWrap">
			<div class="bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg">

				<%-- 입력내용 contoller에 전달, 이후 반환받은 화면 출력 --%>

				<form action="uupdate.do" method="post">
					<h4 class="mtext-105 cl2 txt-center p-b-60">가입 정보</h4>

					<table class="bor8 m-b-40">
						<tr>
							<th class="bor8">아이디</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="uuid" value="${udata_s.uuid}" readonly></td>
						</tr>
						
						<%-- 소셜로그인 이용자가 아닐때만 내부 로직 수행 --%>
						<c:if test="${udata_s.uathu != 2}">
						<tr>
							<th class="bor8">비밀번호</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="upw"></td>
						</tr>
						</c:if>
						
						<tr>
							<th class="bor8">이름</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="uname" value="${udata_s.uname}"></td>
						</tr>
						<tr>
							<th class="bor8">주소</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="uaddr" value="${udata_s.uaddr}"></td>
						</tr>
						<tr>
							<th class="bor8">전화번호</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="uph" value="${udata_s.uph}"
								title="형식에 맞게 입력해주세요" pattern="\d{3}-\d{4}-\d{4}"></td>
						</tr>
						<tr>
							<th class="bor8">이메일</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="email" name="uem" value="${udata_s.uem}"></td>
						</tr>
					</table>
					<input type="submit"
						class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer m-b-30"
						value="수정하기"> <a onclick="kakaoLogout()" href="udelete.do?uuid=${udata_s.uuid}" 
						class="flex-c-m stext-101 size-121 bor1 hov-btn3 p-lr-15 trans-04 pointer"
						id="deletebtn">계정 탈퇴</a>
				</form>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="bg3 p-t-32 p-b-32">
		<div class="container">
			<p class="stext-107 cl6 txt-center">
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				Copyright &copy;
				<script>
					document.write(new Date().getFullYear());
				</script>
				All rights reserved | Made with <i class="fa fa-heart-o"
					aria-hidden="true"></i> by <a href="https://colorlib.com"
					target="_blank">Colorlib</a> &amp; distributed by <a
					href="https://themewagon.com" target="_blank">ThemeWagon</a>
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			</p>
		</div>
	</footer>


	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top"> <i
			class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="js/main.js"></script>
	<!--=========================================추가====================================================-->
	<script src="js_1/select2.js"></script>
	<script src="js_1/scroll.js"></script>

	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="js_1/api_snsLogin.js"></script>
	<script src="js_1/api_weather.js"></script>

</body>
</html>
