package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class ProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		int page = 1;
		if (req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int pageCut = 12;
		Product_dao dao = new Product_dao();
		ArrayList<Product_vo> datas = dao.selectAll_product(null);
		ArrayList<Product_vo> pdatas = new ArrayList<Product_vo>();
		ArrayList<String> pages = new ArrayList<String>();

		if (((page - 1) * pageCut) > datas.size()) {
			page = 1;
		}

		int page2 = (page - 1) * pageCut;

		for (int i = page2; i <= (page2 + pageCut -1); i++) {
			if (i <= (datas.size() - 1)) {
				pdatas.add(datas.get(i));
			}
		}
		int cnt = 1;
		int cnt2 = datas.size();
		do {
			pages.add(Integer.toString(cnt));
			cnt++;
			cnt2 = cnt2-pageCut;
		} while (cnt2 > 0);
		forward.setRedirect(false);
		forward.setPath("/product.jsp");
		req.setAttribute("pdatas_a", pdatas);
		req.setAttribute("pages", pages);
		req.setAttribute("page", page);
		System.out.println(pages);
		return forward;
	}

}