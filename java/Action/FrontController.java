package Action;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ArtistAction;
import controller.CartAction;
import controller.CartAddAction;
import controller.CartClearAction;
import controller.CartOrderAction;
import controller.CommuAction;
import controller.CommuDeleteAction;
import controller.CommuDetailAction;
import controller.CommuInsertAction;
import controller.CommuUpdateAction;
import controller.CommuUpdatePageAction;
import controller.FindIdAction;
import controller.FindPwAction;
import controller.FollowAction;
import controller.FollowUnAction;
import controller.IdCheckAction;
import controller.LoginAction;
import controller.LogoutAction;
import controller.MainAction;
import controller.MyPageAction;
import controller.ProductAction;
import controller.ProductDeleteAction;
import controller.ProductDetailAction;
import controller.ProductInsertAction;
import controller.ProductSearchAction;
import controller.ProductSelectOneAction;
import controller.ProductUpdateAction;
import controller.ReplyDeleteAction;
import controller.ReplyInsertAction;
import controller.ReviewDeleteAction;
import controller.ReviewInsertAction;
import controller.SnsLoginAction;
import controller.UserDeleteAction;
import controller.UserUpdateAction;
import controller.signUpAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	public void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());
		System.out.println(command);
		request.setAttribute("flag", "true");
		ActionForward forward = null;
		System.out.println("로그 : 프론트 컨트롤러 진입");
		//// 시작
		if (command.equals("/main.do")) {
			System.out.println("메인페이지 이동");
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/main.do 에러!");
			}
		}

		//// User
		// 로그인
		else if (command.equals("/login.do")) {
			System.out.println("로그인페이지 이동");
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/login.do 에러!");
			}
		}
		// 로그아웃
		else if (command.equals("/logout.do")) {
			System.out.println("로그아웃");
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("/logout.do 에러!");
			}
		}
		// 회원가입페이지
		else if (command.equals("/signUp.do")) {
			System.out.println("회원가입페이지 이동");
			try {
				forward = new signUpAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/signUp.do 에러!");
			}
		}
		// sns로그인
		else if (command.equals("/snslogin.do")) {
			System.out.println("sns 로그인");
			try {
				forward = new SnsLoginAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/snslogin.do 에러!");
			}
		}
		// 마이페이지 수정 및 탈퇴
		// 마이페이지 지워도 됩니다 수용님 정희님이랑 상의하시고 지우는 방향으로 ㄱㄱ
		else if (command.equals("/myPage.do")) {
			System.out.println("마이페이지");
			try {
				forward = new MyPageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/myPage.do 에러!");
			}
		} else if (command.equals("/uupdate.do")) {
			System.out.println("유저 수정");
			try {
				forward = new UserUpdateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("/uupdate.do 에러!");
			}
		} else if (command.equals("/udelete.do")) {
			System.out.println("탈퇴");
			try {
				forward = new UserDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/udelet.do 에러!");
			}
		} else if (command.equals("/findPw.do")) {
			System.out.println("비밀번호 이메일전송");
			try {
				forward = new FindPwAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/findPw.do 에러!");
			}
		} else if (command.equals("/findId.do")) {
			System.out.println("아이디 문자 전송");
			try {
				forward = new FindIdAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/findId.do 에러!");
			}
		} else if (command.equals("/idCheck.do")) {
			System.out.println("아이디 체크 진입");
			try {
				forward = new IdCheckAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/idCheck.do 에러!");
			}
		}

		//// Artist
		else if (command.equals("/artist.do")) {
			System.out.println("작가페이지");
			try {
				forward = new ArtistAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/artist.do 에러!");
			}
		}

		//// Product
		// 목록페이지이동
		else if (command.equals("/product.do")) {
			System.out.println("제품목록페이지 이동");
			try {
				forward = new ProductAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/pdetail.do 에러!");
			}
		}
		// 상세페이지
		else if (command.equals("/pdetail.do")) {
			System.out.println("제품 상세 페이지 이동");
			try {
				forward = new ProductDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/pdetail.do 에러!");
			}
		}
		// 제품등록
		else if (command.equals("/pinsert.do")) {
			// 제품 등록 페이지 이동은 VIEW에서 자체적으로 해결
			System.out.println("제품 등록 페이지 기능");
			try {
				forward = new ProductInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/pinsert 에러!");
			}
		}
		// 제품수정
		else if (command.equals("/product-update.do")) {
			System.out.println("제품 수정 페이지 이동");
			try {
				forward = new ProductSelectOneAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/product-update.do 에러!");
			}
		} else if (command.equals("/pupdate.do")) {
			System.out.println("제품 수정 기능");
			try {
				forward = new ProductUpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/pupdate.do 에러!");
			}
		}
		// 제품삭제
		else if (command.equals("/pdelete.do")) {
			System.out.println("제품 삭제");
			try {
				forward = new ProductDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/pdelete.do 에러!");
			}
		}
		// 제품검색
		else if (command.equals("/psearch.do")) {
			System.out.println("제품 검색");
			try {
				forward = new ProductSearchAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/psearch.do 에러!");
			}
		}
		// 리뷰 입력 및 삭제
		else if (command.equals("/reviewinsert.do")) {
			System.out.println("리뷰 입력");
			try {
				forward = new ReviewInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/reviewinsert.do 에러!");
			}
		} else if (command.equals("/reviewdelete.do")) {
			System.out.println("리뷰 삭제");
			try {
				forward = new ReviewDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/reviewdelete.do 에러!");
			}
		}

		//// Community
		// 게시판이동
		else if (command.equals("/commu.do")) {
			System.out.println("게시판");
			try {
				forward = new CommuAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/commu.do 에러!");
			}
		}
		// 상세페이지
		else if (command.equals("/cdetail.do")) {
			System.out.println("게시판 상세페이지");
			try {
				forward = new CommuDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/cdetail.do 에러!");
			}
		}
		// 게시글등록
		else if (command.equals("/cinsert.do")) {
			System.out.println("게시글 등록");
			try {
				forward = new CommuInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/cinsert.do 에러!");
			}
		}
		// 게시글삭제
		else if (command.equals("/cdelete.do")) {
			System.out.println("게시글 삭제");
			try {
				forward = new CommuDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/cdelete.do 에러!");
			}
		}
		// 게시글수정
		else if (command.equals("/commu-update.do")) {
			System.out.println("게시글 수정 페이지 이동");
			try {
				forward = new CommuUpdatePageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/commu-update.do 에러!");
			}
		} else if (command.equals("/cupdate.do")) {
			System.out.println("게시글 수정");
			try {
				forward = new CommuUpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/cupdate.do 에러!");
			}
		}
		// 댓글 입력 및 삭제
		else if (command.equals("/rinsert.do")) {
			System.out.println("댓글추가");
			try {
				forward = new ReplyInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/rinsert.do 에러!");
			}
		} else if (command.equals("/rdelete.do")) {
			System.out.println("댓글삭제");
			try {
				forward = new ReplyDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/rdelete.do 에러!");
			}
		}
		//// Shopping-Cart
		else if (command.equals("/shopping-cartAdd.do")) {
			System.out.println("장바구니 추가");
			try {
				forward = new CartAddAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/shopping-cartAdd.do 에러!");
			}
		} else if (command.equals("/shopping-cart.do")) {
			System.out.println("장바구니페이지로 이동");
			try {
				forward = new CartAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("/shopping-cart.do 에러!");
			}
		} else if (command.equals("/order.do")) {
			System.out.println("주문하기");
			try {
				forward = new CartOrderAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("/order.do 에러!");
			}
		} else if (command.equals("/shopping-cartDelete.do")) {
			System.out.println("장바구니 비우기");
			try {
				forward = new CartClearAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("/shopping-cartDelete.do 에러!");
			}
		}
		//// Follow
		else if (command.equals("/follow.do")) {
			System.out.println("팔로우");
			try {
				forward = new FollowAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("/follow.do 에러!");
			}
		} else if (command.equals("/followUn.do")) {
			System.out.println("언팔로우");
			try {
				forward = new FollowUnAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException("/followUn.do 에러!");
			}
		} else {
			System.out.println("잘못된 요청!");
		}

		if (forward != null) {

			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
		String flag = (String) request.getAttribute("flag");
		if (flag.equals("true")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert(\'" + (String) request.getAttribute("jsmsg") + "!\');"
					+ (String) request.getAttribute("jsAction") + ";</script>");
		}

	}

}