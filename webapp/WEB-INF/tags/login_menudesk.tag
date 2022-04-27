<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type"%>

<c:if test="${udata_s.uuid!=null}">
	<c:choose>
		<c:when test="${type=='mobile'}">
			<ul class="main-menu-m">
				<li><a href="product.do">Product</a></li>
				<li><a href="shopping-cart.do">Cart</a></li>
				<li><a href="artist.do">Artist</a></li>
				<li><a href="commu.do">Community</a></li>
				<li><a href="#">Follow List</a>
					<ul class="sub-menu-m">
						<c:forEach var="v" items="${fdatas_s}">
							<li><a href="artist.do?uuid=${v.followed}&loginuuid=${udata_s.uuid}">${v.follower}</a></li>
						</c:forEach>
					</ul> <span class="arrow-main-menu-m"> <i
						class="fa fa-angle-right" aria-hidden="true"></i>
				</span>
				</li>
			</ul>
		</c:when>
		<c:when test="${type=='web'}">
			<ul class="main-menu">
				<li><a href="product.do">Product</a></li>
				<li><a href="shopping-cart.do">Cart</a></li>
				<li><a href="artist.do">Artist</a></li>
				<li><a href="commu.do">Community</a></li>
				<li class="active-menu"><a href="#">Follow List</a>
					<ul class="sub-menu">
						<c:forEach var="v" items="${fdatas_s}">
							<li><a href="artist.do?uuid=${v.followed}&loginuuid=${udata_s.uuid}">${v.follower}</a></li>
						</c:forEach>

					</ul>
				</li>
			</ul>
		</c:when>
	</c:choose>
</c:if>

<c:if test="${udata_s.uuid==null}">
	<c:choose>
		<c:when test="${type=='mobile'}">
			<ul class="main-menu-m">
				<li><a href="product.do">Product</a></li>
				<li><a href="shopping-cart.do">Cart</a></li>
				<li><a href="artist.do">Artist</a></li>
				<li><a href="commu.do">Community</a></li>
			</ul>
		</c:when>
		<c:when test="${type=='web'}">
			<ul class="main-menu">
				<li><a href="product.do">Product</a></li>
				<li><a href="shopping-cart.do">Cart</a></li>
				<li><a href="artist.do">Artist</a></li>
				<li><a href="commu.do">Community</a></li>
			</ul>
		</c:when>
	</c:choose>
</c:if>
