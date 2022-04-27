package controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Action.Action;
import Action.ActionForward;
import dao.Follow_dao;

import vo.Follow_vo;
import vo.User_vo;

public class FollowAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		forward = null;

		Follow_vo fvo = new Follow_vo();
		Follow_dao fdao = new Follow_dao();

		String follower = req.getParameter("follower");
		String followed = req.getParameter("followed");


		fvo.setFollowed(followed);
		fvo.setFollower(follower);

		boolean insert_follow = fdao.insert_follow(fvo);
		System.out.println(fvo + " " + insert_follow);

		if (insert_follow) {
			System.out.println("로그 : 팔로우 성공");

			req.setAttribute("jsmsg", "팔로우 성공");

			User_vo uvo = new User_vo();
			uvo.setUuid(follower);
			controller.MakeSessionUtill.followSession(uvo, req);
		} else {
			System.out.println("로그 : 팔로우 실패");

			req.setAttribute("jsmsg", "팔로우 실패");

		}
		req.setAttribute("jsAction", "location.href=\"artist.do?uuid=" + followed + "&loginuuid=" + follower + "\"");
		return forward;
	}

}