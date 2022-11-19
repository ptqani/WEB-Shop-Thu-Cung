package WebAppController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAppData.DAO;
import WebAppModel.User;

@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String, String> mess = new HashMap<String, String>();
		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		String email = req.getParameter("email");
		String number = req.getParameter("phonenumber");
		if ((username == null) || (username == "")) {
			username = req.getParameter("username");
			mess.put("errorUs", "(*)");
		}
		if ((pass == null) || (pass == "")) {
			pass = req.getParameter("pass");
			mess.put("errorPas", "(*)");

		}
		if ((repass == null) || (repass == "")) {
			repass = req.getParameter("pass");
			mess.put("passRE", "(*)");

		}
		if ((email == null) || (email == "")) {
			email = req.getParameter("pass");
			mess.put("errorEm", "(*)");

		}
		if ((number == null) || (number == "")) {
			number = req.getParameter("pass");
			mess.put("errorNum", "(*)");

		}
		if (!pass.equals(repass)) {
			req.setAttribute("usname", username);
			req.setAttribute("pas", pass);
			req.setAttribute("rpas", repass);
			req.setAttribute("el", email);
			req.setAttribute("nb", number);
			req.setAttribute("errore", "Mật khẩu không khớp");
			req.getRequestDispatcher("/errorRegister.jsp").forward(req, resp);
		} else {
			try {
				DAO dao = new DAO();
				User usercheck = dao.checkUSer(username);
				req.setAttribute("exit", "Tài khoản đã tồn tại");

				if (usercheck == null) {
					dao.registerUser(username, pass, email, number);
					resp.sendRedirect("home");
				} else {

					req.setAttribute("usname", username);
					req.setAttribute("pas", pass);
					req.setAttribute("rpas", repass);
					req.setAttribute("el", email);
					req.setAttribute("nb", number);
					req.setAttribute("error", mess);
					req.getRequestDispatcher("/errorRegister.jsp").forward(req, resp);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
