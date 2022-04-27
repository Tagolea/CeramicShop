package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Follow_dao;
import dao.User_dao;
import vo.Follow_vo;
import vo.User_vo;

public class MakeSessionUtill {
	public static HttpServletResponse userSession(User_vo uvo, HttpServletRequest req) {
		HttpServletResponse res = null;

		uvo.setUpw("");
		HttpSession session = req.getSession();
		session.setAttribute("udata_s", uvo);

		return res;
	}

	public static HttpServletResponse followSession(User_vo uvo, HttpServletRequest req) {
		HttpServletResponse res = null;
		Follow_vo fvo = new Follow_vo();
		Follow_dao fdao = new Follow_dao();
		User_dao udao = new User_dao();
		fvo.setFollower(uvo.getUuid());
		ArrayList<Follow_vo> fdatas_s = new ArrayList<Follow_vo>();
		ArrayList<User_vo> udatas = new ArrayList<User_vo>();
		udatas = udao.selectAll_user(uvo);
		fdatas_s = fdao.selectAll_follow(fvo);
		if (fdatas_s.size() != 0) {
			for (int i = 0; i < fdatas_s.size(); i++) {
				for (int j = 0; j < udatas.size(); j++) {
					if (fdatas_s.get(i).getFollowed().equals(udatas.get(j).getUuid())) {
						fdatas_s.get(i).setFollower(udatas.get(j).getUname());

					}

				}
			}
		} else {
			fvo = new Follow_vo();
			fvo.setFollower("팔로우 하러 가기");
			fvo.setFollowed(null);
			fdatas_s.add(fvo);
		}
		HttpSession session = req.getSession();

		session.setAttribute("fdatas_s", fdatas_s);

		return res;
	}
}
