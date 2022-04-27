<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="type"%>

<c:if test="${type=='product'}">
	<c:if test="${udata_s.uathu==1}">
		<div class="flex-r">
			<a href="product-insert.jsp"
				class="m-b-40 flex-c-m stext-101 cl0 size-104 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer">제품등록</a>
		</div>
	</c:if>
</c:if>

<c:if test="${type=='detail'}">
	<c:if test="${udata_s.uuid==pdata.puid}">
		<div class="flex-r">
			<a href="product-update.do?pnum=${pdata.pnum}"
				class="m-b-40 flex-c-m stext-101 cl0 size-104 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer m-r-20">수정</a>
			<a id="deletebtn" href="pdelete.do?pnum=${pdata.pnum}"
				class="m-b-40 flex-c-m stext-101 cl0 size-104 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer m-r-30">삭제</a>
		</div>
	</c:if>
</c:if>
