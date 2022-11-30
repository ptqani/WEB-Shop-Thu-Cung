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
import WebAppModel.Category;
import WebAppModel.Product;
import WebAppModel.User;

@WebServlet("/manage")
public class ManageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			HttpSession ss = req.getSession();
			User user = (User) ss.getAttribute("sessio");
			int iduser = user.getIduser();
			DAO dao = new DAO();
			List<Product> list = dao.getIdProduct(iduser);
			List<Category> listCategory = dao.getAllCategory();
			req.setAttribute("listCategory", listCategory);
			req.setAttribute("listProduct", list);
			req.getRequestDispatcher("viewproduct.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
