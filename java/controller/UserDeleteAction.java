package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class UserDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);

		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		String uuid = req.getParameter("uuid");

		uvo.setUuid(uuid);

		boolean delectUser = udao.delete_user(uvo);
		System.out.println(uvo + " " + delectUser);

		if (delectUser) {
			System.out.println("로그 : 탈퇴 성공");
			forward.setPath("logout.do");
		} else {
			System.out.println("로그 : 탈퇴 실패");
			forward.setPath("myPage.do");
		}
		return forward;
	}

}