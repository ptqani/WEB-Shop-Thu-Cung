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

import WebAppData.DAO;
import WebAppModel.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// Kiểm tra tính hợp lệ
		
		HashMap<String, String> mess = new HashMap<String, String>();
		mess.put("error", "Sai thông tin tài khoản hoặc mật khẩu");
		String username = req.getParameter("usernamet");
		String pass = req.getParameter("passt");
//		// Lấy dữ liệu người dùng nhập vào
//		
//		// Tạo ra một người dùng mới
//		// Gọi lớp DAO , cơ sở dữ liệu
//	
//		// kiểm tra tính hợp lệ
		if ((username == null) || (username == "")) {
			username = req.getParameter("username");
			mess.put("usernameError", "(*)");
		}
		if ((pass == null) || (pass == "")) {
			pass = req.getParameter("pass");
			mess.put("passError", "(*)");
			
		}
		req.setAttribute("username", username);
		try {
			
			DAO dao = new DAO();
			User user = dao.loginUser(username, pass);
			if (user == null) {
				req.setAttribute("mess", mess);
				getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(req, resp);
			} else  {
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
