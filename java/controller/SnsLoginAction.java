package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class SnsLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;

		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		String uuid = req.getParameter("uuid");
		String uem = req.getParameter("uem");

		String upw = "미입력";
		String uname = "미입력";
		String uph = "미입력";

		String uaddr = "미입력";

		int uathu = 2;

		uvo.setUaddr(uaddr);
		uvo.setUathu(uathu);
		uvo.setUem(uem);
		uvo.setUname(uname);
		uvo.setUph(uph);
		uvo.setUpw(upw);
		uvo.setUuid(uuid);

		int insertUser = udao.insert_user(uvo);
		System.out.println(uvo + " " + insertUser);
		req.setAttribute("jsmsg", "sns로그인시 일부 기능이 제한됩니다! 마이페이지에서 주소 및 전화번호를 등록해주세요!");
		req.setAttribute("jsAction", "location.href=\"myPage.do\"");
		if (insertUser == 0) {
			System.out.println("로그 : 가입 성공");
			controller.MakeSessionUtill.userSession(uvo, req);
			controller.MakeSessionUtill.followSession(uvo, req);
		} else if (insertUser == 1) {
			// 이미 생성된적 있는 아이디
			System.out.println("로그 : 이미 가입된 sns로그인");
			uvo = udao.selectOne_user(uvo);
			// 기존 계정 불러오기
			if (!uvo.getUaddr().equals("미입력")) {
				// 주소가 미입력 상태가 아니라면
				forward = new ActionForward();
				forward.setPath("main.do");
				System.out.println("로그 : 기존의 아이디 로딩 - 회원정보 변경한 유저");
				// 그냥 로그인
			}
			// 아니라면 수정페이지로
			controller.MakeSessionUtill.userSession(uvo, req);
			controller.MakeSessionUtill.followSession(uvo, req);
		} else if (insertUser == 2) {
			System.out.println("로그 : sns로그인 에러");
			req.setAttribute("jsmsg", "sns로그인 에러");
			req.setAttribute("jsAction", "history.go(-1)");

		} else {
			System.out.println("로그 : sns로그인 알수 없는 에러");
			req.setAttribute("jsmsg", "sns로그인 알수 없는 가입 에러");
			req.setAttribute("jsAction", "history.go(-1)");
		}

		return forward;
	}

}