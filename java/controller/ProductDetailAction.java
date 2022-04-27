package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import dao.Review_dao;
import vo.Product_vo;
import vo.Review_vo;

public class ProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;


		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();
		Review_dao rdao = new Review_dao();
		Review_vo rvo = new Review_vo();
		
		
		ArrayList<Review_vo> rdatas = new ArrayList<Review_vo>();
		int pnum = Integer.parseInt(req.getParameter("pnum"));
		pvo.setPnum(pnum);
		rvo.setRpnum(pnum);
		pvo = pdao.selectOne_product(pvo);

		if(pvo != null) {
			System.out.println("로그 : 제품 + 리뷰 서치 성공");
			rdatas = rdao.selectAll_review(rvo);

			req.setAttribute("pdata", pvo);
			req.setAttribute("rdatas", rdatas);

			forward = new ActionForward();
			forward.setPath("/product-detail.jsp");
			forward.setRedirect(false);
		}else {
			System.out.println("로그 : 해당 상품 존재x");
			
			req.setAttribute("jsmsg", "해당상품은 존재하지않습니다!");
			req.setAttribute("jsAction", "history.go(-1)");
		}
		
		return forward;
	}

}