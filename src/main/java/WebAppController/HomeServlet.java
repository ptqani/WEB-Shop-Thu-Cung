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

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			// phân trang
			String page = req.getParameter("page");
			if (page == null) {
				page = "1";
			}
			int apage = Integer.parseInt(page);
			DAO dao = new DAO();
			// hiển thị tất cả sản phẩm
			List<Product> listProduct = dao.getProductOffSet(apage);
			// hiển thị sản phẩm từ dưới lên
			List<Product> listProductdesc = dao.getAllProductdesc();
			// hiển thị ra danh mục sản phẩm
			List<Category> listCategory = dao.getAllCategory();
			int count = dao.countProduct(); // Đếm số lượng sp có trong csdl
			int endPage = count / 20; // hiện thị lên 1 trang tối đa 20 sản phẩm
			if (count % 20 != 0) { // nếu mà dư sản phẩm thì tăng biến lên đến khi nào không còn dư
				endPage++;
			}
			req.setAttribute("pageid", page);
			req.setAttribute("endCount", endPage);
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
