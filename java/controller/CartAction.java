package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class CartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		Cookie[] carts = req.getCookies(); // 모든 쿠키 가져오기
		forward.setRedirect(false);
		Product_vo pvo;
		Product_dao pdao = new Product_dao();
		ArrayList<Product_vo> pdatas = new ArrayList<Product_vo>();
		int Subtotal = 0;
		int Total = 0;

		/*
		 * Cookie kc = new Cookie("sdsd", "2222"); kc.setHttpOnly(false);
		 * kc.setMaxAge(0); kc.setPath("/"); res.addCookie(kc);
		 */

		for (int i = 0; i < carts.length; i++) {
			if (!carts[i].getName().equals("JSESSIONID")) {
				pvo = new Product_vo();
				int name = Integer.parseInt(carts[i].getName()); // 쿠키 이름 가져오기
				int value = Integer.parseInt(carts[i].getValue()); // 쿠키 값 가져오기
				System.out.println(name);
				System.out.println(value);
				System.out.println("--------------------------");
				pvo.setPnum(name);
				pvo = pdao.selectOne_product(pvo);
				pvo.setPstock(value);
				pdatas.add(pvo);
				Subtotal += pvo.getPstock();
				Total = Total + (pvo.getPstock() * pvo.getPprice());
			}
		}

		forward.setPath("/shopping-cart.jsp");
		if (pdatas.size() == 0) {
			System.out.println("로그 : 장바구니에 상품이 없습니다");

			req.setAttribute("jsmsg", "장바구니에 담겨있는 상품이 없습니다");
			req.setAttribute("jsAction", "history.go(-1)");
			forward = null;
		}
		req.setAttribute("pdatas", pdatas);
		req.setAttribute("Subtotal", Subtotal);
		req.setAttribute("Total", Total);
		return forward;
	}

}