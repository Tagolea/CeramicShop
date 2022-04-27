package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;

import vo.Product_vo;

public class ProductSelectOneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();


		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();
		int pnum = Integer.parseInt(req.getParameter("pnum"));
		pvo.setPnum(pnum);
		
		pvo = pdao.selectOne_product(pvo);
		req.setAttribute("pdata", pvo);

		forward.setPath("/product-update.jsp");
		forward.setRedirect(false);
		
		System.out.println("로그 : 제품 서치 성공");

		return forward;
	}

}