package WebAppController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAppData.DAO;
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	req.setCharacterEncoding("UTF-8");
	try {
		String frormitem = req.getParameter("fromitem");
		DAO dao = new DAO();
		dao.deleteProduct(frormitem);
		resp.sendRedirect("manage");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
