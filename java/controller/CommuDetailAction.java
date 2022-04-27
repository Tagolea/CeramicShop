package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Article_dao;
import dao.Comment_dao;
import dao.User_dao;
import vo.Article_vo;
import vo.Comment_vo;
import vo.User_vo;

public class CommuDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath("/commu-detail.jsp");
		forward.setRedirect(false);
		Article_dao adao = new Article_dao();
		Article_vo avo = new Article_vo();
		Comment_dao cdao = new Comment_dao();
		Comment_vo cvo = new Comment_vo();
		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		int anum = Integer.parseInt(req.getParameter("anum"));
		avo.setAnum(anum);
		avo = adao.selectOne_article(avo);

		ArrayList<Comment_vo> cdatas = new ArrayList<Comment_vo>();
		cvo.setCanum(anum);
		cdatas = cdao.selectAll_comment(cvo);

		uvo.setUuid(avo.getAuid());
		uvo.setUname(udao.selectOne_user(uvo).getUname());

		req.setAttribute("adata", avo);
		req.setAttribute("cdatas", cdatas);
		req.setAttribute("udata", uvo);
		return forward;
	}

}
