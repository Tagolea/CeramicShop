package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Article_dao;

import vo.Article_vo;

public class CommuUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Article_dao adao = new Article_dao();
		Article_vo avo = new Article_vo();

		int anum = Integer.parseInt(req.getParameter("anum"));
		String atitle = req.getParameter("atitle");
		String auid = req.getParameter("auid");
		String atext = req.getParameter("atext");

		avo.setAtext(atext);
		avo.setAtitle(atitle);
		avo.setAuid(auid);
		avo.setAnum(anum);
		boolean update_article = adao.update_article(avo);

		if (update_article) {
			forward.setPath("/cdetail.do?anum="+anum);
			System.out.println("로그 : 게시글 수정 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 게시글 수정 실패");
		}

		return forward;
	}

}
