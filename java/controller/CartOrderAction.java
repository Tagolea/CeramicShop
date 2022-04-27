package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import dao.User_dao;
import vo.Product_vo;
import vo.User_vo;

public class CartOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		Cookie[] carts = req.getCookies(); // 모든 쿠키 가져오기
		forward.setRedirect(false);
		Product_vo pvo = null;
		Product_dao pdao = new Product_dao();

		ArrayList<Product_vo> pdatas = new ArrayList<Product_vo>();
		boolean flag = true;
		String uuid = req.getParameter("uuid");
		String uaddr = req.getParameter("uaddr");
		System.out.println(uuid);
		if (uuid.equals("")) {// 로그인 체크
			System.out.println("로그 : 로그인 안됨");
			forward = null;
			req.setAttribute("jsmsg", "로그인 후 구매가 가능합니다");
			req.setAttribute("jsAction", "history.go(-1)");
			return forward;
		}
		if (uaddr.equals("미입력")) {
			System.out.println("로그 : 주소 입력 안됨");
			forward = null;
			req.setAttribute("jsmsg", "저장된 주소가 없습니다!");
			req.setAttribute("jsAction", "location.href=\"myPage.do\"");
			return forward;
		}
			for (int i = 0; i < carts.length; i++) {
				if (!carts[i].getName().equals("JSESSIONID")) {
					pvo = new Product_vo();
					int name = Integer.parseInt(carts[i].getName()); // 쿠키 이름 가져오기
					int value = Integer.parseInt(carts[i].getValue()); // 쿠키 값 가져오기

					pvo.setPnum(name);
					pvo = pdao.selectOne_product(pvo);

					if (value > pvo.getPstock()) {
						flag = false;
						break;
					}
					value = pvo.getPstock() - value;
					pvo.setPstock(value);
					pdatas.add(pvo);
				}
			}

		if (flag) {
			System.out.println("로그 : 재고 이상 없음 구매 시작");
			for (int i = 0; i < pdatas.size(); i++) {
				pdao.update_product(pdatas.get(i));
			}
			System.out.println("로그 : 재고 수정 완료");
			req.setAttribute("jsmsg", "구매 성공!");
			req.setAttribute("jsAction", "location.href=\"shopping-cartDelete.do\"");
			forward = null;
		} else {
			System.out.println("로그 : 재고 부족");

			req.setAttribute("jsmsg", pvo.getPname() + "의 재고가 부족합니다");
			req.setAttribute("jsAction", "history.go(-1)");
			forward = null;
		}

		return forward;
	}

}