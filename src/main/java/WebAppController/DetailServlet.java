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
import WebAppModel.Comment;
import WebAppModel.Product;
import WebAppModel.User;
import WebAppModel.UserShop;

@WebServlet("/detailServlet")
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String frormitem = req.getParameter("fromitem");
			String useridshop = req.getParameter("useridshop");
			String idproductshop = req.getParameter("idproductshop");
			DAO dao = new DAO();
			Product product = dao.getProductID(frormitem);
			List<Comment> listComment = dao.getAllcommentUser(frormitem);
			List<Product> listProductdesc = dao.getAllProductdesc();
			HttpSession ss = req.getSession();
			User user = (User) ss.getAttribute("sessio");
			int idpro = product.getId_product();
			UserShop usser = dao.getUserShop(idpro);
			req.setAttribute("listProductdesc", listProductdesc);
			req.setAttribute("useridshops", useridshop);
			req.setAttribute("idproductshop", idproductshop);
			req.setAttribute("userID", usser);
			req.setAttribute("productDetail", product);
			req.setAttribute("listComment", listComment);
			req.getRequestDispatcher("details.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
