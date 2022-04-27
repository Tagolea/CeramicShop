package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Article_dao;

import vo.Article_vo;

public class CommuInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Article_dao adao = new Article_dao();
		Article_vo avo = new Article_vo();

		String atitle = req.getParameter("atitle");
		String auid = req.getParameter("auid");
		String atext = req.getParameter("atext");

		avo.setAtext(atext);
		avo.setAtitle(atitle);
		avo.setAuid(auid);

		boolean insert_article = adao.insert_article(avo);

		if (insert_article) {
			forward.setPath("commu.do");
			System.out.println("로그 : 게시글 작성 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 게시글 작성 실패");
		}

		return forward;
	}

}
