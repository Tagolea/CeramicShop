package controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Action.Action;
import Action.ActionForward;
import dao.Product_dao;
import vo.Product_vo;

public class ProductInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		Product_dao pdao = new Product_dao();
		Product_vo pvo = new Product_vo();
		
		//경로지정
		String realPath = req.getServletContext().getRealPath("/product_img");
		String localPath  = realPath.substring(0, realPath.indexOf(".metadata"));
		localPath = localPath + "ceramicShop\\src\\main\\webapp\\product_img";
		
		//디렉토리
		File dir_t = new File(realPath);
		File dir_l = new File(localPath);
		if (!dir_t.exists()) {
			dir_t.mkdir();
		}
		if(!dir_l.exists()) {
			dir_l.mkdir();
		}
		
		//사이즈설정
		int size = 1024 * 1024 * 100;
		String imgName = "";
		
		//이미지 저장
		MultipartRequest multi = new MultipartRequest(req, realPath, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		//세부정보 저장
		String puid = multi.getParameter("puid");
		String pname = multi.getParameter("pname");
		String ptext = multi.getParameter("ptext");
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
		int pstock = Integer.parseInt(multi.getParameter("pstock"));

		pvo.setPname(pname);
		pvo.setPprice(pprice);
		pvo.setPstock(pstock);
		pvo.setPtext(ptext);
		pvo.setPuid(puid);
		

		boolean productInsert = pdao.insert_product(pvo);
		System.out.println(pdao + " " + productInsert);
		if (productInsert) {
			System.out.println("로그 : 제품 등록 성공");

			forward.setPath("/product.do");
			forward.setRedirect(false);

		} else {
			System.out.println("로그 : 제품 등록 실패");

			forward.setPath("/error.jsp");
			forward.setRedirect(false);
		}
		
		
		Enumeration e = multi.getFileNames();
		//파일이 있으면 실행
		while (e.hasMoreElements()) {
			String eleName = (String) e.nextElement();
			String fileName = multi.getFilesystemName(eleName);

			if (fileName != null) {
				File oriFile = new File(realPath + "\\" + fileName);

				pvo = new Product_vo();
				pvo.setPname(multi.getParameter("pname"));
				int name = pdao.selectOne_product(pvo).getPnum();
				
				imgName = name + ".jpg";
				realPath = realPath + "\\" + imgName;
				localPath = localPath + "\\" + imgName;
				
				File tmpFile = new File(realPath);
				if (!oriFile.renameTo(tmpFile)) {
					System.out.println("파일명 변경실패!");
				} else {
					System.out.println("파일명 변경성공!");
				}
				
				File sf = new File(realPath);
				File lf = new File(localPath);
				
				FileInputStream fis = new FileInputStream(sf);
				FileOutputStream fos = new FileOutputStream(lf);
				
				byte[] buff = new byte[3000];
				int len;
				while((len = fis.read(buff))> 0) {
					fos.write(buff,0,len);
				}
				
				fis.close();
				fos.close();
				
			}
		}
		
		
		return forward;
	}

}