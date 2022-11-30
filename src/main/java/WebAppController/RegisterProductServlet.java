package WebAppController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebAppData.DAO;
import WebAppModel.User;
@WebServlet("/registerproduct")
public class RegisterProductServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	req.setCharacterEncoding("UTF-8");
	String regis = req.getParameter("regis");
	DAO dao = new DAO();
	 try {
		 	HttpSession ss = req.getSession();
			User user = (User) ss.getAttribute("sessio");
			int iduser = user.getIduser();
		dao.registerProduct(regis,iduser);
resp.sendRedirect("home");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
