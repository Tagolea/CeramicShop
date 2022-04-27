package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.User_dao;
import vo.User_vo;

public class FindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		boolean flag = false;
		String uname = req.getParameter("uname");
		String uph = req.getParameter("uph");
		User_dao udao = new User_dao();
		User_vo uvo = new User_vo();
		ArrayList<User_vo> udatas = new ArrayList<User_vo>();
		uvo.setUname(uname);
		uvo.setUph(uph);
		udatas = udao.selectAll_user(uvo);

		for (int i = 0; i < udatas.size(); i++) {
			if (udatas.get(i).getUname().equals(uname)) {
				if (udatas.get(i).getUph().equals(uph)) {
					flag = true;
					System.out.println("로그 : 회원 정보 있음");
					uvo.setUuid(udatas.get(i).getUuid());
					break;
				}
			}
		}

		if (flag) {

			api.SendSms.sendSms(uph, uvo.getUuid());
			req.setAttribute("jsmsg", uph + "으로 아이디가 전송되었습니다");
			req.setAttribute("jsAction", "history.go(-1)");
		} else {

			req.setAttribute("jsmsg", "일치하는 회원 정보가 없습니다");
			req.setAttribute("jsAction", "history.go(-1)");
		}

		return forward;
	}

}
