package controller;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class CartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		req.setAttribute("jsAction", "history.go(-1)");
	
		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();
		String pnum = req.getParameter("pnum");
		String cnt = req.getParameter("cnt");
		pvo.setPnum(Integer.parseInt(pnum));
		pvo = pdao.selectOne_product(pvo);
		if (Integer.parseInt(cnt) > pvo.getPstock()) {
			//테이블에 있는 재고보다 많이 요청하면
			System.out.println("로그 : 수량 초과");
			forward = null;
			req.setAttribute("jsmsg", "재고가 부족합니다!");
		
			return forward;
		}
		req.setAttribute("jsmsg", pvo.getPname()+ " " + cnt+"개 장바구니 등록 완료!");
	
		Cookie[] carts = req.getCookies(); // 모든 쿠키 가져오기
		if (carts != null) {
			for (Cookie c : carts) {
				String name = c.getName(); // 쿠키 이름 가져오기
				String value = c.getValue(); // 쿠키 값 가져오기
				System.out.println("로그 - 쿠키 이름 : " + name);
				System.out.println("로그 - 쿠키 값 : " + value);
				if (name.equals(pnum)) {//같은 이름의 쿠키가 있으면
					int resultStock = Integer.parseInt(cnt) + Integer.parseInt(value);
					
					c = new Cookie(name, null);
					c.setMaxAge(0);
					c.setPath("/");
					res.addCookie(c);
					//기존 쿠키 지우고
					
					c = new Cookie(name, Integer.toString(resultStock));
					c.setMaxAge(60 * 60 * 24);
					c.setPath("/");
					res.addCookie(c);
					//수량 +해준 새로운 쿠키 생성
					return forward;
				}
			}
		}
		//if문에 한번도 안걸렸으면
		Cookie cart = new Cookie(pnum, cnt); // 쿠키 이름 지정하여 생성( name, value 개념)

		cart.setMaxAge(60 * 60 * 24); // 쿠키 유효 기간: 하루로 설정(60초 * 60분 * 24시간)
		cart.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
		res.addCookie(cart); // response에 Cookie 추가

		return forward;
	}

}