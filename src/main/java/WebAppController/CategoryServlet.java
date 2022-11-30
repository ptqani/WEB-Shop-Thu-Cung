package WebAppController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAppData.DAO;
import WebAppModel.Category;
import WebAppModel.Product;
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	req.setCharacterEncoding("UTF-8");
	try {
	String cateID = req.getParameter("fromid");
	DAO dao = new DAO();
		List<Product> listproduct = dao.getAllProductCategory(cateID);
		List<Category> listCategory = dao.getAllCategory();
		List<Product> listProductdesc = dao.getAllProductdesc();
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("listProductdesc", listProductdesc);
		req.setAttribute("listProduct", listproduct);
		req.setAttribute("cate", cateID);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
