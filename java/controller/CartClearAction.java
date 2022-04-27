package controller;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;

public class CartClearAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath("product.do");
		forward.setRedirect(false);

		Cookie[] carts = req.getCookies(); // 모든 쿠키의 정보를 cookies에 저장
		if (carts != null) { // 쿠키가 한개라도 있으면 실행

			for (Cookie c : carts) {
				c.setMaxAge(0); // 유효시간을 0으로 설정
				c.setPath("/");
				res.addCookie(c); // 응답에 추가하여 만료시키기.

			}

		}

		return forward;
	}

}