<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ham" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Artist</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images_1/favicon-96x96.png" />
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

			<div class="wrap-menu-desktop how-shadow1">
				<nav class="limiter-menu-desktop container">

					<!-- Logo desktop -->
					<a href="main.do" class="logo"> <img src="images_1/logo.png"
						alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
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
				<!-- login_topbar_mobile -->
				<li><ham:login_topbar type="mobile" /></li>
			</ul>
			<!-- login_menudesk_mobile -->
			<ham:login_menudesk type="mobile" />
		</div>

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

	<!-- Product -->

	<div class="bg0 m-t-23 p-b-140">
		<div class="container">

			<div class="flex-w flex-sb-m p-b-52">

				<%-- uuid 안넘겨주면 전체보기, 넘겨주면 해당 작가 보기 --%>
				<div class="flex-w flex-l-m filter-tope-group m-tb-10">
					<a href="artist.do"
						class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5">전체</a>
					<c:forEach var="v" items="${udatas}">
						<div>
							<%-- 작가명 a태그 누르면, 그 작가의 id에 해당하는 제품 정렬할 수 있도록 --%>
							<%-- 이때 팔로우의 유무를 컨트롤러에서 검색하기 위해 현재 로그인 한 id 전송 필요! --%>
							<a href="artist.do?uuid=${v.uuid}&loginuuid=${udata_s.uuid}"
								class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"> ${v.uname} <!-- 작가의 이름 -->
							</a>
						</div>
					</c:forEach>
				</div>

			</div>
			<!-- ============= -->

			<%--
				! uuid에 들어간 값(선택된 작가)이 없으면 "전체보기" !
				로그인시 : res false면 팔로우 안 된 상태(uuid-선택된 작가와 loginuuid-현재 로그인상태인 유저가 팔로우 관계인지 컨트롤러에서 체크하여 res로 반환)
				비로그인 : 전체보기가 아니라면 "팔로우"버튼을 띄우되, 경로 이동은 없으며, onclick이벤트를 통해 "로그인 후 이용 가능"안내창 출력
			--%>
			<ham:follow />

			<%-- 제품목록 --%>
			<div class="row isotope-grid">
				<c:forEach var="v" items="${pdatas}">
					<div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
						<!-- Block2 -->
						<div class="block2">
							<div class="block2-pic hov-img0">
								<!-- 제품 이미지 확인요망 -->
								<img src="product_img/${v.pnum}.jpg" alt="IMG-PRODUCT"
								onClick="location.href='pdetail.do?pnum=${v.pnum}'">
							</div>

							<div class="block2-txt flex-w flex-t p-t-14">
								<div class="block2-txt-child1 flex-col-l ">
									<%-- pdetail로 이동 --%>
									<a href="pdetail.do?pnum=${v.pnum}"
										class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
										${v.pname} </a> <span class="stext-105 cl3"><hr> ${v.pprice} ₩</span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>


	<!-- Footer -->
	<footer class="bg3 p-t-32 p-b-32" style='width: 100%'>
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
	<script src="js_1/select2.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/slick/slick.min.js"></script>
	<script src="js/slick-custom.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/parallax100/parallax100.js"></script>
	<script src="js_1/pararllax100.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<script src="js_1/gallery-lb"></script>
	<!--===============================================================================================-->
	<script src="vendor/isotope/isotope.pkgd.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/sweetalert/sweetalert.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="js_1/scroll.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>
	<!--=========================================추가====================================================-->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="js_1/api_snsLogin.js"></script>
	<script src="js_1/api_weather.js"></script>
	<script src="js_1/info_msg.js"></script>

</body>
</html>
