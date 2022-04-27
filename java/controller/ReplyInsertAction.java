package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Comment_dao;
import vo.Comment_vo;

public class ReplyInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Comment_vo cvo = new Comment_vo();
		Comment_dao cdao = new Comment_dao();

		int canum = Integer.parseInt(req.getParameter("canum"));
		String cuid = req.getParameter("cuid");
		String ctext = req.getParameter("ctext");

		cvo.setCanum(canum);
		cvo.setCtext(ctext);
		cvo.setCuid(cuid);

		boolean insert_comments = cdao.insert_comments(cvo);

		if (insert_comments) {
			
			forward.setPath("cdetail.do?anum="+canum);
			System.out.println("로그 : 댓글 작성 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 댓글 작성 실패");
		}

		return forward;
	}

}
