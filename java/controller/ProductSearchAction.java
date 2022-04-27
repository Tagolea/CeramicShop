package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class ProductSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		String search = req.getParameter("search");
		Product_dao dao = new Product_dao();
		Product_vo pvo = new Product_vo();
		req.setAttribute("jsAction", "history.go(-1)");
		System.out.println(search);
		if (search.equals("")) {
			System.out.println("로그 : 검색어 없음");
			forward = null;
			req.setAttribute("jsmsg", "한글자 이상 입력해야 검색이 가능합니다");
			return forward;
		}
		pvo.setPname(search);
		ArrayList<Product_vo> datas = dao.selectAll_product_search(pvo);
		if (datas.size() != 0) {
			System.out.println("로그 : 제품 검색 성공");
			req.setAttribute("pdatas_a", datas);
			forward.setPath("/product.jsp");
			forward.setRedirect(false);
		} else {
			System.out.println("로그 : 검색 결과 없음");
			forward = null;
			req.setAttribute("jsmsg", "검색 결과가 없습니다");
		}
		return forward;
	}

}