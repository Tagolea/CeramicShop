package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Article_dao;
import vo.Article_vo;

public class CommuAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath("/commu.jsp");
		forward.setRedirect(false);
		Article_dao adao = new Article_dao();
		Article_vo avo = new Article_vo();

		ArrayList<Article_vo> adatas = new ArrayList<Article_vo>();
		adatas = adao.selectAll_article(avo);
		req.setAttribute("adatas", adatas);
		System.out.println("로그 : 게시글 목록 로드");

		return forward;
	}

}
