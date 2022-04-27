package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Comment_dao;
import vo.Comment_vo;

public class ReplyDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		Comment_vo cvo = new Comment_vo();
		Comment_dao cdao = new Comment_dao();

		int cnum = Integer.parseInt(req.getParameter("cnum"));
		int canum = Integer.parseInt(req.getParameter("anum"));

		cvo.setCnum(cnum);

		boolean delete_comment = cdao.delete_comment(cvo);

		if (delete_comment) {
			forward.setPath("/cdetail.do?anum=" + canum);
			System.out.println("로그 : 댓글 삭제 성공");
		} else {
			forward.setPath("/error.jsp");
			System.out.println("로그 : 댓글 삭제 실패");
		}

		return forward;
	}

}
