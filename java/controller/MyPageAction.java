package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;

import vo.User_vo;

public class MyPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);

		//String uuid = req.getParameter("uuid");

		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		//uvo.setUuid(uuid);

		//uvo = udao.selectOne_user(uvo);

		//System.out.println(uvo);

		System.out.println("로그 : 마이페이지 진입");
		forward.setPath("/myPage.jsp");
		//req.setAttribute("udata", uvo);

		return forward;
	}

}