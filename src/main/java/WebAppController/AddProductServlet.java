package WebAppController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebAppData.DAO;
import WebAppModel.LineItem;
import WebAppModel.User;
import WebAppModel.UserShop;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			
			String name = req.getParameter("name");
			String image = req.getParameter("image");
			double price  = Double.parseDouble(req.getParameter("price"));
			double percent = Double.parseDouble(req.getParameter("percent"));
			double sellprice = Double.parseDouble(req.getParameter("sellprice")); 
			double percentprice = (price * percent)/100;
			sellprice = price - percentprice;
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			int category = Integer.parseInt(req.getParameter("category"));
			HttpSession ss = req.getSession();
			User user = (User) ss.getAttribute("sessio");
			int idpro = user.getIduser();
			DAO dao = new DAO();
			// thêm add product
			dao.addProduct(name, image, price, sellprice, title, description, category, idpro);
			
	
			resp.sendRedirect("manage");
		} catch (ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
