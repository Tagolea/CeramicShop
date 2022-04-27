package controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class ProductUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();


		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();

		// 경로지정
		String realPath = req.getServletContext().getRealPath("/product_img");
		String localPath = realPath.substring(0, realPath.indexOf(".metadata"));
		localPath = localPath + "ceramicShop\\src\\main\\webapp\\product_img";

		// 사이즈설정
		int size = 1024 * 1024 * 100;
		String imgName = "";

		// 이미지 저장
		MultipartRequest multi = new MultipartRequest(req, realPath, size, "UTF-8", new DefaultFileRenamePolicy());

		if (multi.getFile("image") != null) {
			Enumeration e = multi.getFileNames();
			System.out.println(e);

			System.out.println(e.hasMoreElements());
			// 파일이 있으면 실행
			while (e.hasMoreElements()) {

				File oldFile1 = new File(realPath + "\\" + multi.getParameter("pnum") + ".jpg");
				File oldFile2 = new File(localPath + "\\" + multi.getParameter("pnum") + ".jpg");
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
				String element = (String) e.nextElement();
				String fileName = multi.getFilesystemName(element);
				File updateFile = new File(realPath + "\\" + fileName);
				//String updateFileName = updateFile.getName();
				//String ex = updateFileName.substring(updateFileName.lastIndexOf("."));
				imgName = multi.getParameter("pnum") + ".jpg";
				realPath = realPath + "\\" + imgName;
				localPath = localPath + "\\" + imgName;

				File tmpFile = new File(realPath);
				if (!updateFile.renameTo(tmpFile)) {
					System.out.println("상품 업데이트 중 파일명 변경 실패!");
				} else {
					System.out.println("상품 업데이트 중 파일명 변경 성공!");
				}

				File sf = new File(realPath);
				File lf = new File(localPath);

				FileInputStream fis = new FileInputStream(sf);
				FileOutputStream fos = new FileOutputStream(lf);

				byte[] buff = new byte[3000];
				int len;
				while ((len = fis.read(buff)) > 0) {
					fos.write(buff, 0, len);
				}

				fis.close();
				fos.close();
			}
		}

		String puid = multi.getParameter("puid");
		String pname = multi.getParameter("pname");
		String ptext = multi.getParameter("ptext");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		int pstock = Integer.parseInt(multi.getParameter("pstock"));
		int pnum = Integer.parseInt(multi.getParameter("pnum"));

		pvo.setPname(pname);
		pvo.setPprice(pprice);
		pvo.setPstock(pstock);
		pvo.setPtext(ptext);
		pvo.setPuid(puid);
		pvo.setPnum(pnum);

		boolean productUpdate = pdao.update_product(pvo);
		if (productUpdate) {
			System.out.println("로그 : 제품 수정 성공");
			forward.setPath("/product.do");
			forward.setRedirect(false);

		} else {
			System.out.println("로그 : 제품 수정 실패");
			forward.setPath("/error.jsp");
		}
		return forward;
	}

}