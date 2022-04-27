package filterLisener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter({ "*.do", "*.jsp" })
public class EncodingFilter extends HttpFilter implements Filter {  
	//인코딩 설정값 저장할 변수
	private String encoding;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		//response.setContentType("text/html; charset=UTF-8");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//fConfig(서비스하는 웹의 설정값)에서 encoding이라는 name의 value를 필터의 encoding변수에 저장한다.
		this.encoding = fConfig.getServletContext().getInitParameter("encoding");
		System.out.println("필터생성 : 인코딩설정완료 인코딩값:"+encoding);
	}

}
