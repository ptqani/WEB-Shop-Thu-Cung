package WebAppController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAppData.DAO;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			// lưu lại bình luận và hiển thị bình luận lên trang detail
			String nameuser = req.getParameter("nameuser");
			String content = req.getParameter("content");
			String idpro = req.getParameter("idpro");
			DAO dao = new DAO();
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   String datetime = String.valueOf(dtf.format(now));
			dao.commentUser(nameuser, content,datetime, idpro);
			req.setAttribute("idp", idpro);
			resp.sendRedirect("detailServlet?fromitem=" + idpro);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
