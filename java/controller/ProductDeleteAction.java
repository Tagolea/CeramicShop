package controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class ProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();

		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();

		int pnum = Integer.parseInt(req.getParameter("pnum"));
		pvo.setPnum(pnum);

		boolean productDelete = pdao.delete_product(pvo);
		System.out.println(pdao + " " + productDelete);
		if (productDelete) {
			System.out.println("로그 : 제품 삭제 성공");

			forward.setPath("/product.do");
			forward.setRedirect(false);
			
			// 사진삭제
			String realPath = req.getServletContext().getRealPath("/product_img");
			String localPath = realPath.substring(0, realPath.indexOf(".metadata"));
			localPath = localPath + "ceramicShop\\src\\main\\webapp\\product_img";
			
			File oldFile1 = new File(realPath + "\\" + pnum + ".jpg");
			File oldFile2 = new File(localPath + "\\" + pnum + ".jpg");
			if (oldFile1.exists()) {
				if (oldFile1.delete()) {
					System.out.println("파일1삭제 성공");
				} else {
					System.out.println("파일1삭제 실패");
				}
			} else {
				System.out.println("파일1이 존재하지 않습니다.");
			}
			if (oldFile2.exists()) {
				if (oldFile2.delete()) {
					System.out.println("파일2삭제 성공");
				} else {
					System.out.println("파일2삭제 실패");
				}
			} else {
				System.out.println("파일2이 존재하지 않습니다.");
			}
			
			

		} else {
			System.out.println("로그 : 제품 삭제 실패");
			forward.setPath("/error.jsp");
		}
		return forward;
	}

}