package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Follow_dao;
import dao.Product_dao;
import dao.User_dao;
import vo.Follow_vo;
import vo.Product_vo;
import vo.User_vo;

public class ArtistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		boolean result = false;
		forward.setPath("/artist.jsp");
		forward.setRedirect(false);
		ArrayList<Product_vo> pdatas = new ArrayList<Product_vo>();
		String uuid = req.getParameter("uuid");
		String loginuser = req.getParameter("loginuuid");

		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();
		User_vo uvo = new User_vo();
		User_dao udao = new User_dao();
		Follow_dao fdao = new Follow_dao();
		Follow_vo fvo = new Follow_vo();
		ArrayList<User_vo> udatas = new ArrayList<User_vo>();
		ArrayList<Follow_vo> fdatas = new ArrayList<Follow_vo>();
		udatas = udao.selectAll_user_seller(uvo);

		fvo.setFollower(loginuser);
		System.out.println(loginuser);
		fdatas = fdao.selectAll_follow(fvo);

		for (Follow_vo v : fdatas) {
			System.out.println(v.getFollowed());
			if (v.getFollowed().equals(uuid)) {
				result = true;
				System.out.println(result);
			}
		}

		System.out.println(result);
		System.out.println(uuid);
		if (uuid == null || uuid.equals("")) {
			pdatas = pdao.selectAll_product(pvo);
			uuid = null;
			//해당 항목이 null이여야 뷰에서 팔로우 버튼이 없어진다
		} else {
			pvo.setPuid(uuid);
			pdatas = pdao.selectAll_product_seller(pvo);
		}

		if (pdatas.size() == 0) {
			System.out.println("로그 : 작품 없음");
			forward = null;
			req.setAttribute("jsmsg", "해당 작가의 작품은 존재하지 않습니다");
			req.setAttribute("jsAction", "history.go(-1)");
			return forward;
		}

		req.setAttribute("pdatas", pdatas);
		req.setAttribute("udatas", udatas);
		req.setAttribute("uuid", uuid);
		req.setAttribute("res", result);

		return forward;
	}

}