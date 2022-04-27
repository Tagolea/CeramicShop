<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ham" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Product Detail</title>
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
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/MagnificPopup/magnific-popup.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
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

		<!-- Modal Search -->
		<div
			class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
			<div class="container-search-header">
				<button
					class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
					<img src="images/icons/icon-close2.png" alt="CLOSE">
				</button>

				<form class="wrap-search-header flex-w p-l-15"  action="psearch.do"
				method="post">
					<button class="flex-c-m trans-04">
						<i class="zmdi zmdi-search"></i>
					</button>
					<input class="plh3" type="text" name="search"
						placeholder="Search...">
				</form>
			</div>
		</div>
	</header>







	<!-- Product Detail -->
	<section class="sec-product-detail bg0 p-t-65 p-b-60">
		<div class="container">

			<%-- 커스텀태그 --%>
			<ham:if_seller_product type="detail" />
			<div class="row">
				<div class="col-md-6 col-lg-7 p-b-30">
					<div class="p-l-25 p-r-30 p-lr-0-lg">
						<div class="wrap-slick3 flex-sb flex-w">
							
							<div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

							<div class="slick3 gallery-lb">
									<div class="wrap-pic-w pos-relative">
										<img
											src="product_img/${pdata.pnum}.jpg"
											alt="IMG-PRODUCT">
							</div>
						</div>
					</div>
				</div>
			</div>

				<div class="col-md-6 col-lg-5 p-b-30">
					<div class="p-r-50 p-t-5 p-lr-0-lg">
						<h1 class="mtext-105 cl2 js-name-detail p-b-14">
							${pdata.pname}
						</h1>
						
						<span class="mtext-106 cl2"> ${pdata.pprice} ₩ 
						<c:if test="${pdata.pstock!=0}">
						<span style="font-size:11px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(${pdata.pstock } 개 남음)</span>
						</c:if>
						<c:if test="${pdata.pstock==0}">
						<span style="font-size:11px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(매진)</span>
						</c:if>
						</span>
						<br>
						<p class="stext-102 cl3 p-t-23">${pdata.ptext}</p>
						<hr>						




						<!-- ========= 작업중 / 밸류값 보내주기 ========= -->
		
						<div class="p-b-10">
							<div class="size-315 respon6-next">
								<form action="shopping-cartAdd.do?pnum=${pdata.pnum }" method="post">
								<div style="display:flex">
								
									<div style="flex-item:70%;margin-left:40px;">
									<div class="wrap-num-product flex-w m-r-20 m-tb-10">
										<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
											<i class="fs-16 zmdi zmdi-minus"></i>
										</div>
										
										<input class="mtext-104 cl3 txt-center num-product" type="number" name="cnt" value="1" min="1" max="${pdata.pstock}">
										
										<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
											<i class="fs-16 zmdi zmdi-plus"></i>
										</div>
									</div>
									</div>
									
									<div style="flex-item:30%;margin-left:70px">
									<input type="submit" value="장바구니로 보내기" 
									class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail"
									>
									</div>
									
								</div>	
								</form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ========= 작업범위 ========= -->


		<div class="bor10 m-t-50 p-t-43 p-b-40">
			<!-- Tab -->
			<div class="tab01">
				<!-- 네비게이션 탭 -->
				<ul class="nav nav-tabs" role="tablist">
					<li class="nav-item p-b-10"><a class="nav-link active"
						data-toggle="tab" href="#reviews" role="tab">Reviews</a></li>

					<li class="nav-item p-b-10"><a class="nav-link"
						data-toggle="tab" href="#add_review" role="tab">Add review</a></li>

				</ul>

				<!-- Tab panes -->
				<div class="tab-content p-t-43">
					<!-- - -->
					<div class="tab-pane fade show active" id="reviews" role="tabpanel">
						<div class="how-pos2 p-lr-15-md">


							<div class="size-207">
							
								<c:if test="${fn:length(rdatas)==0 }">
									<p class="txt-center m-t-10 m-b-20 p-l-85">리뷰가 존재하지 않습니다.</p>
								</c:if>
									
								<c:forEach var="v" items="${rdatas}">
									<hr>
									<!-- 리뷰어 아이디 -->
									<span class="flex-w flex-sb-m p-b-17" >
									
										<span class="mtext-107 cl2 p-r-20"> 작성자 : ${v.ruid} </span>
										
										<!-- 삭제버튼 -->
										<c:if test="${udata_s.uuid==v.ruid}">
										<a type="hidden" id="deltebtn"
									
											class="m-b-40 flex-c-m stext-101 cl0 size-104 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer m-r-30"
											 href="reviewdelete.do?rnum=${v.rnum}&rpnum=${v.rpnum}">
												삭제하기 </a>
												</c:if>
									</span>
									
									<!-- 리뷰 내용 -->
																			
									
									<p class="stext-102 cl6">${v.rtext}</p>
									<br>
									<p>작성일:${v.rdate }</p>
									
									<hr>
								</c:forEach>
								<c:if test="${fn:length(rdatas) != 0}">	
								<p class="txt-center m-t-10 m-b-20 p-t-40">마지막 리뷰 입니다.</p>
								</c:if>
							</div>
							
						</div>
					</div>

					<!-- 리뷰 남기기 -->
					<div class="tab-pane fade" id="add_review" role="tabpanel">
						<div class="row">
							<div class="col-sm-10 col-md-8 col-lg-6 m-lr-auto">
								<!-- 리뷰 추가하기 들어갈 칸 -->
								<div class="p-t-40">
						<h5 class="mtext-113 cl2 p-b-12">리뷰를 남겨보세요</h5>

						<p class="stext-107 cl6 p-b-40">★★리뷰는 작가님들에게 큰 힘이 됩니다!!!★★</p>

						<%-- 코멘트 등록정보 컨트롤러로 운반, 게시글번호만 hidden으로 넘겨주기 --%>
						<form action="reviewinsert.do" method="post">
							<input type="hidden" name="rpnum" value="${pdata.pnum}">

							<c:choose>
								<c:when test="${udata_s.uuid != null}">
									<div class="bor19 m-b-20">
										<%-- 로그인상태일때, 댓글작성 가능 --%>
										<textarea class="stext-111 cl2 plh3 size-124 p-lr-18 p-tb-15" style="resize: none;"
											name="rtext" placeholder="리뷰를 작성해보세요" required></textarea>
									</div>

									<div class="bor19 size-218 m-b-20">
										<input class="stext-111 cl2 plh3 size-116 p-lr-18" type="text"
											name="ruid" value="${udata_s.uuid}" readonly>
										<%-- 현재 로그인된 회원의 id, 수정 불가능 --%>
									</div>

									<input type="submit" value="리뷰 등록"
										class="flex-c-m stext-101 cl0 size-125 bg3 bor2 hov-btn3 p-lr-15 trans-04">
								</c:when>
								<c:otherwise>
									<div class="bor19 m-b-20">
										<%-- 비로그인상태일때, 댓글작성 불가능 --%>
										<textarea class="stext-111 cl2 plh3 size-124 p-lr-18 p-tb-15"
											name="ctext" style="resize: none;" placeholder="로그인 후 작성 가능합니다." disabled></textarea>
									</div>
								</c:otherwise>
							</c:choose>


						</form>
					</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	



	</section>


	<!-- Related Products -->



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
	<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="js_1/scroll.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>

</html>