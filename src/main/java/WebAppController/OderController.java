package WebAppController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebAppData.DAO;
import WebAppModel.Billproduct;
import WebAppModel.User;

@WebServlet("/oder")
public class OderController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	DAO dao = new DAO();
	req.setCharacterEncoding("UTF-8");
	try {
		List<Billproduct> bill = dao.getAllBill();
		HttpSession ss = req.getSession();
		User user = (User) ss.getAttribute("sessio");
		int iduser = user.getIduser();
		req.setAttribute("keyu", iduser);
		req.setAttribute("billoder", bill);
		req.getRequestDispatcher("oder.jsp").forward(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
