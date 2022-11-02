package WebAppController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAppData.DAO;
import WebAppModel.User;
@WebServlet("/Views/signup")
public class SignUpServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//Lấy dữ liệu người dùng nhập vào
	String username = req.getParameter("username");
	String pass = req.getParameter("pass");
	String email = req.getParameter("email");
	String number = req.getParameter("number");
	//Tạo ra một người dùng mới
	User user = new User();
	//Đọc giá trị cho User
	user.setUsername(username);
	user.setPass(pass);
	user.setEmail(email);
	user.setNumber(0);
	//Gọi lớp DAO , cơ sở dữ liệu
	DAO dao = new DAO();
	try {
		dao.registerUser(user);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	RequestDispatcher rd = req.getRequestDispatcher("/Views/success.jsp");
	rd.forward(req, resp);
	}
}
