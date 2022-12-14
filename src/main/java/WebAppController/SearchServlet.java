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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tìm kiếm sp theo từ khóa
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String text = req.getParameter("txtsearch");
			DAO dao = new DAO();
			//Tìm kiếm theo từ khóa
			List<Product> listSearch = dao.getAllProductSearch(text);
			//hiển thị lại thông tin sản phẩm
			List<Product> listProductdesc = dao.getAllProductdesc();
			List<Category> listCategory = dao.getAllCategory();
			req.setAttribute("listProduct", listSearch);
			req.setAttribute("listProductdesc", listProductdesc);
			req.setAttribute("listCategory", listCategory);
			req.setAttribute("textvalue", text);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
