package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Article_dao;

import vo.Article_vo;

public class CommuUpdatePageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath("/commu-update.jsp");
		forward.setRedirect(false);
		Article_dao adao = new Article_dao();
		Article_vo avo = new Article_vo();

		int anum = Integer.parseInt(req.getParameter("anum"));
		avo.setAnum(anum);
		avo = adao.selectOne_article(avo);

		req.setAttribute("adata", avo);

		return forward;
	}

}
