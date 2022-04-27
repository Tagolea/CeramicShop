package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Review_dao;
import vo.Review_vo;

public class ReviewInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Review_dao rdao = new Review_dao();
		Review_vo rvo = new Review_vo();

		int rpnum = Integer.parseInt(req.getParameter("rpnum"));
		String ruid = req.getParameter("ruid");
		String rtext = req.getParameter("rtext");

		rvo.setRpnum(rpnum);
		rvo.setRtext(rtext);
		rvo.setRuid(ruid);
		System.out.println(rvo);
		boolean insert_review = rdao.insert_review(rvo);

		if (insert_review) {

			forward.setPath("pdetail.do?pnum=" + rpnum);
			System.out.println("로그 : 리뷰 작성 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 리뷰 작성 실패");
		}

		return forward;
	}

}
