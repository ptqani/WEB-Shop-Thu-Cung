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

@WebServlet("/editsave")
public class SaveEditProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String image = req.getParameter("image");
		String price = req.getParameter("price");
		String sellprice = req.getParameter("sellprice");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String cate = req.getParameter("category");
		DAO dao = new DAO();
		dao.editProduct(name, image, price, sellprice, title, description, cate, id);
		resp.sendRedirect("manage");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
