package controller;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		String userId = req.getParameter("userId");

		User_vo uvo = new User_vo();
		User_dao udao = new User_dao();
		uvo.setUuid(userId);
		int idChcek = udao.idCheck_user(uvo);
		System.out.println(userId);
		// 성공여부 확인 : 개발자용
		if (idChcek == 0) {
			System.out.println("로그 : 아이디 체크 결과 가입 가능 아이디");
		} else if (idChcek == 1) {
			System.out.println("로그 : 아이디 체크 결과 중복된 아이디");
		}
		PrintWriter out = res.getWriter();
		req.setAttribute("flag", "false");
		out.write(idChcek + ""); // --> ajax 결과값인 result가 됨
		// --> String으로 값을 내보낼 수 있도록 + "" 를 해준다
		return forward;

	}
}