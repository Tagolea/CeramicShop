<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ham" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Shoping Cart</title>
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
					<a href=main.do " class="logo"> <img src="images_1/logo.png"
						alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<!-- 커스텀 태그 활용 -->
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

				<!-- Button show menu -->
				<div class="btn-show-menu-mobile hamburger hamburger--squeeze">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
				</div>
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

		<!-- Modal Search -->
		<div
			class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button
					class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15" action="psearch.do" method="post">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search"
						placeholder="제품을 검색해보세요">
				</form>
			</div>
		</div>
	</header>

	<!-- Shoping Cart -->
	<%-- ///////////////////////////////////////////작업 ///////////////////////////////////////////--%>
	<%-- 제품의 상세정보 조회 가능, 주문 가능, 일괄 비우기 가능 --%>
	<form class="bg0 p-t-75 p-b-85" action="order.do" method="post">
		<input type="hidden" name=uuid value="${udata_s.uuid}"> <input
			type="hidden" name=uaddr value="${udata_s.uaddr}">
		<%-- 카카오가입자는 주소 없으므로, 주소 확인차 값 전송 --%>

		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
							<table class="table-shopping-cart">
								<%-- 쿠키에 저장된 제품 목록에 접근 --%>
								<c:forEach var="v" items="${pdatas}">
									<tr class="table_head">
										<th class="column-1">PODUCT</th>
										<th class="column-2"></th>
										<th class="column-3">PRICE</th>
										<th class="column-4">QUANTTITY</th>
										<th class="column-5">TOTAL</th>
									</tr>

									<tr class="table_row">
										<%-- 제품이미지--%>
										<td class="column-1">
											<div class="how-itemcart1">
												<img src="product_img/${v.pnum}.jpg" alt="IMG-PRODUCT">
											</div>
										</td>
										<%-- =================================--%>
										<td class="column-2">${v.pname}</td>
										<td class="column-3">${v.pprice}</td>
										<td class="column-4">
											<div class="wrap-num-product flex-w m-l-auto m-r-0 m-t-35"
												style="width: 70px;">

												<%-- 제품 수량 --%>
												<input type="text" class="txt-center m-l-10"
													value="${v.pstock}" style="width: 50px;" readonly>
												<%-- ========= --%>

											</div>
										</td>
										<td class="column-5">${v.pprice*v.pstock}</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<div class="flex-r bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<%-- 장바구니 일괄 비우기 --%>
							<div id="deletebtn"
								class="flex-c-m stext-101 cl2 size-119 bor13 p-lr-15 trans-04 pointer m-tb-10">
								<a href="shopping-cartDelete.do" style="color: white;">Delete
									Cart</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
					<div
						class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
						<h4 class="mtext-109 cl2 p-b-30">Cart Totals</h4>

						<div class="flex-w flex-t bor12 p-b-13">
							<div class="size-208">
								<span class="stext-110 cl2"> Subtotal: </span>
							</div>

							<%-- 제품 총 개수 --%>
							<div class="size-209">
								<span class="mtext-110 cl2"> ${Subtotal} </span>
							</div>
						</div>

						<!-- 주소지 입력받을 칸 -->
						<!-- 
						<div class="flex-w flex-t bor12 p-t-15 p-b-30">
						<%-- ================================주소 API 검색창================================== --%>
						<div id="wrap" style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
							<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
								id="btnFoldWrap"
								style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
								onclick="foldDaumPostcode()" alt="접기 버튼">
						</div>
						<%-- ============================================================================== --%>
						
						<tr>
							<th class="bor8" style="width: 30%; padding-left: 20px;">주소</th>
							<td><input
								class="bor8  stext-111 cl2 plh3 size-116 p-l-62 p-r-30"
								type="text" name="uaddr" placeholder="주소 입력" required></td>
						</tr>

						<%-- ========================================================================================================== --%>
						</div>
 						-->
						<div class="flex-w flex-t p-t-27 p-b-33">
							<div class="size-208">
								<span class="mtext-101 cl2"> Total: </span>
							</div>
							<%-- 제품 총 가격 --%>
							<div class="size-209 p-t-1">
								<span class="mtext-110 cl2"> ${Total} </span>
							</div>
						</div>

						<input type="submit" value="주문"
							class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">
					</div>
				</div>
			</div>
		</div>

	</form>



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
	<script src="js_1/add-cart.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="js_1/scroll.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>
	<!--=======================================추가====================================================-->
	<script src="js_1/api_address.js"></script>

	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="js_1/api_snsLogin.js"></script>
	<script src="js_1/api_weather.js"></script>
</body>
</html>
