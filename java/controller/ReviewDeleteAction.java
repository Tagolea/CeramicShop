package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Comment_dao;
import dao.Review_dao;
import vo.Comment_vo;
import vo.Review_vo;

public class ReviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Review_dao rdao = new Review_dao();
		Review_vo rvo = new Review_vo();

		int rnum = Integer.parseInt(req.getParameter("rnum"));
		int rpnum = Integer.parseInt(req.getParameter("rpnum"));
		rvo.setRnum(rnum);

		boolean delete_review = rdao.delete_review(rvo);

		if (delete_review) {
			forward.setPath("/pdetail.do?pnum=" + rpnum);
			System.out.println("로그 : 리뷰 삭제 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 리뷰 삭제 실패");
		}

		return forward;
	}

}
