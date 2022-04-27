package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Article_dao;

import vo.Article_vo;

public class CommuDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Article_dao adao = new Article_dao();
		Article_vo avo = new Article_vo();
		int anum = Integer.parseInt(req.getParameter("anum"));

		avo.setAnum(anum);
		boolean delete_article = adao.delete_article(avo);

		if (delete_article) {
			forward.setPath("commu.do");
			System.out.println("로그 : 게시글 삭제 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 게시글 삭제 실패");
		}

		return forward;
	}

}
