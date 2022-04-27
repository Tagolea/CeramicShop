package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;

import dao.User_dao;

import vo.User_vo;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);

		String uuid = req.getParameter("uuid");
		String upw = req.getParameter("upw");
		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		uvo.setUpw(upw);
		uvo.setUuid(uuid);
		System.out.println(upw + " " + uuid);
		int admin = udao.login_user(uvo);

		if (uvo.getUathu() == 2) {
			admin = 1;
		}

		System.out.println(uvo + " " + admin);
		if (admin == 0) {
			System.out.println("로그 : 로그인 성공");
			uvo = udao.selectOne_user(uvo);
			forward.setPath("main.do");
			controller.MakeSessionUtill.userSession(uvo, req);
			controller.MakeSessionUtill.followSession(uvo, req);
		} else if (admin == 1) {
			System.out.println("로그 : 아이디가 없습니다");
			forward = null;
			req.setAttribute("jsmsg", "아이디가 없습니다");
			req.setAttribute("jsAction", "history.go(-1)");
		} else if (admin == 2) {
			System.out.println("로그 : 비밀번호 틀림");
			forward = null;
			req.setAttribute("jsmsg", "비밀번호가 틀렸습니다");
			req.setAttribute("jsAction", "history.go(-1)");
		} else {
			forward.setPath("/login.jsp");
			System.out.println("알수 없는 에러");
			forward = null;
			req.setAttribute("jsmsg", "알수 없는 에러");
			req.setAttribute("jsAction", "history.go(-1)");
		}

		// 다음 요청까지 유효
		return forward;
	}

}