package WebAppController;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class LangServlet implements Filter {
// lưu ngôn ngữ vào ss
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	      throws IOException, ServletException {
	response.setContentType("text/html;charset=UTF-8");
	request.setCharacterEncoding("UTF-8");
	        HttpServletRequest req = (HttpServletRequest) request;
	        // nếu có thì đã cập nhật ss đã chọn
	        if (req.getParameter("sessionLocale") != null) {
	            req.getSession().setAttribute("lang", req.getParameter("sessionLocale"));
	        }
	        chain.doFilter(request, response);
	    }
	    public void destroy() {}
	    public void init(FilterConfig arg0) throws ServletException {}

}
