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
		// đăng kí bán hàng
		try {
			String regis = req.getParameter("regis");
			String name = req.getParameter("name");
			String sdt = req.getParameter("sdt");
			String address = req.getParameter("address");
			String email = req.getParameter("email");
			DAO dao = new DAO();
			HttpSession ss = req.getSession();
			User user = (User) ss.getAttribute("sessio");
			int iduser = user.getIduser();
			dao.registerProduct(regis, iduser);
			dao.registerUserShop(name, sdt, address, email, iduser);
			resp.sendRedirect("regisProductSuccess.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
