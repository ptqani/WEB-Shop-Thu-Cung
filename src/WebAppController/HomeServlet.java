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
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	req.setCharacterEncoding("UTF-8");
	try {
		
	DAO dao = new DAO();
		List<Product> listProduct = dao.getAllProduct();
		List<Product> listProductdesc = dao.getAllProductdesc();
		List<Category> listCategory = dao.getAllCategory();
		req.setAttribute("listProduct", listProduct);
		req.setAttribute("listProductdesc", listProductdesc);
		req.setAttribute("listCategory", listCategory);
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void main(String[] args) {

}
}
