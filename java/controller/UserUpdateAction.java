package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class UserUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		boolean flag = true;
		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();

		String uuid = req.getParameter("uuid");
		String upw = req.getParameter("upw");
		String uname = req.getParameter("uname");
		String uph = req.getParameter("uph");
		String uem = req.getParameter("uem");
		String uaddr = req.getParameter("uaddr");
		uvo.setUuid(uuid);

		uvo = udao.selectOne_user(uvo);

		uvo.setUem(uem);
		uvo.setUname(uname);
		uvo.setUaddr(uaddr);
		uvo.setUph(uph);
		if (upw != null) {
			if (!upw.equals("")) {
				uvo.setUpw(upw);

				req.setAttribute("jsmsg", "비밀번호가 변경되었습니다! 다시 로그인해주세요!");
				req.setAttribute("jsAction", "location.href=\"logout.do\"");
				flag = false;
			}
		}
		boolean update_user = udao.update_user(uvo);
		System.out.println(uvo + " " + update_user);
		if (flag) {
			if (update_user) {
				System.out.println("로그 : 수정 성공");
				controller.MakeSessionUtill.userSession(uvo, req);

				req.setAttribute("jsmsg", "회원정보 수정 완료!");
				req.setAttribute("jsAction", "location.href=\"myPage.do\"");

			} else {
				forward = new ActionForward();
				System.out.println("로그 : 수정 실패");
				forward.setPath("myPage.do");
				forward.setRedirect(false);
			}
		}
		return forward;
	}

}