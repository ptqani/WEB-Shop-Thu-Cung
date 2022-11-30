package WebAppController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebAppData.DAO;
import WebAppModel.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			HashMap<String, String> mess = new HashMap<String, String>();
			mess.put("error", "Sai thông tin tài khoản hoặc mật khẩu");
			String username = req.getParameter("usernamet");
			String pass = req.getParameter("passt");

			req.setAttribute("username", username);
			DAO dao = new DAO();
			User user = dao.loginUser(username, pass);
			if (user == null) {
				req.setAttribute("mess", mess);
				getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(req, resp);
			} else {
				HttpSession ss = req.getSession(true);
				ss.setAttribute("sessio", user);
				ss.setMaxInactiveInterval(2000);
				resp.sendRedirect("home");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
