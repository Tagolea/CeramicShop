package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class FindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;

		String uuid = req.getParameter("uuid");
		String uem = req.getParameter("uem");
		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();
		System.out.println(uuid);
		System.out.println(uem);
		uvo.setUuid(uuid);
		uvo = udao.selectOne_user(uvo);
		if (uvo != null) {
			if (uvo.getUem().equals(uem)) {
				String randNum = api.RandomKey.createKey();
				uvo.setUpw(randNum);
				udao.update_user(uvo);
				api.SendEmail.sendMail(uem, uvo.getUname(), randNum);
				req.setAttribute("jsmsg", uem + "으로 임시 비밀번호가 전송되었습니다");
				req.setAttribute("jsAction", "history.go(-1)");
				return forward;
			}
		}
		req.setAttribute("jsmsg", "일치하는 회원 정보가 없습니다");
		req.setAttribute("jsAction", "history.go(-1)");
		return forward;
	}

}
