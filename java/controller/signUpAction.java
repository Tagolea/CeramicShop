package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class signUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;

		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		String uuid = req.getParameter("uuid");
		String upw = req.getParameter("upw");
		String pwCheck = req.getParameter("pwCheck");
		String uname = req.getParameter("uname");
		String uph = req.getParameter("uph");
		String uem = req.getParameter("uem");
		String uaddr = req.getParameter("uaddr");
		String uaddrDetail = req.getParameter("uaddrDetail");

		int uathu = Integer.parseInt(req.getParameter("uathu"));

		uvo.setUaddr(uaddr + " " + uaddrDetail);
		uvo.setUathu(uathu);
		uvo.setUem(uem);
		uvo.setUname(uname);
		uvo.setUph(uph);
		uvo.setUpw(upw);
		uvo.setUuid(uuid);

		int insertUser = 3;
		// 디퐅트를 3으로 잡고
		if (upw.equals(pwCheck)) {
			insertUser = udao.insert_user(uvo);
			// 인서트를 수행한다면 0~2로 변경됨
		}
		System.out.println(uvo + " 비밀번호확인 : " + pwCheck + " "+ insertUser);
		req.setAttribute("jsAction", "history.go(-1)");
		if (insertUser == 0) {
			System.out.println("로그 : 가입 성공");
			req.setAttribute("jsmsg", "가입 성공!");
			req.setAttribute("jsAction", "location.href=\"main.do\"");
		} else if (insertUser == 1) {
			System.out.println("로그 : 아이디 중복");
			req.setAttribute("jsmsg", "중복된 아이디입니다");
		} else if (insertUser == 2) {
			System.out.println("로그 : 가입에러");
			req.setAttribute("jsmsg", "가입 에러");
		} else if (insertUser == 3) {
			// 비밀번호가 달라서 인서트를 수행하지 못했다면
			System.out.println("로그 : 비밀번호 체크 실패");
			req.setAttribute("jsmsg", "비밀번호가 일치하지 않습니다!");
		} else {
			System.out.println("로그 : 가입 알수 없는 에러");
			req.setAttribute("jsmsg", "알수 없는 가입 에러");
		}

		return forward;
	}

}