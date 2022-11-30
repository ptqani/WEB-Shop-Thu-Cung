package WebAppController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebAppData.DAO;
import WebAppModel.User;

@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		String email = req.getParameter("email");
		String number = req.getParameter("phonenumber");
		if (!pass.equals(repass)) {
			req.setAttribute("errore", "Mật khẩu không khớp");
			req.setAttribute("usname", username);
			req.setAttribute("pas", pass);
			req.setAttribute("rpas", repass);
			req.setAttribute("el", email);
			req.setAttribute("nb", number);
			req.getRequestDispatcher("/errorRegister.jsp").forward(req, resp);
		} else {
			try {
				DAO dao = new DAO();
				User usercheck = dao.checkUSer(username);
				req.setAttribute("exit", "Tài khoản đã tồn tại");

				if (usercheck == null) {
					dao.registerUser(username, pass, email, number);
					resp.sendRedirect("login.jsp");
				} else {
					req.setAttribute("usname", username);
					req.setAttribute("pas", pass);
					req.setAttribute("rpas", repass);
					req.setAttribute("el", email);
					req.setAttribute("nb", number);
					req.getRequestDispatcher("/errorRegister.jsp").forward(req, resp);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
