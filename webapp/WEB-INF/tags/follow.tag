<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${udata_s.uuid!=null}">
	<c:if test="${uuid!=null}">
		<c:choose>
			<c:when test="${res==false}">
				<div class="flex-r-m">
					<a href="follow.do?follower=${udata_s.uuid}&followed=${uuid}"
						class="flex-c-m stext-101 cl0 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer fs-12 m-b-20"
						style="width: 100px; height: 30px;">팔로우</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="flex-r-m">
					<a href="followUn.do?follower=${udata_s.uuid}&followed=${uuid}"
						id="deletebtn"
						class="flex-c-m bor1 hov-btn3 p-lr-15 trans-04 pointer fs-12 m-b-20"
						style="width: 100px; height: 30px;">팔로우 취소</a>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
</c:if>
<c:if test="${udata_s.uuid==null}">
	<c:if test="${uuid!=null}">
		<div class="flex-r-m">
			<a href="#" onclick="follow()"
				class="flex-c-m stext-101 cl0 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer fs-12 m-b-20"
				style="width: 100px; height: 30px;">팔로우</a>
		</div>
	</c:if>
</c:if>
