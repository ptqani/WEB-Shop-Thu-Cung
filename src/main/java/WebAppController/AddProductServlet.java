package WebAppController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import WebAppData.DAO;
import WebAppModel.User;
@MultipartConfig
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {

			String name = req.getParameter("name");
//			String image =req.getParameter("image");
			Part part = req.getPart("image");
			String realpath = req.getServletContext().getRealPath("/images");
			String fileimage = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+"/"+fileimage);
			String image ="images/"+fileimage;
					
			double price = Double.parseDouble(req.getParameter("price"));
			double percent = Double.parseDouble(req.getParameter("percent"));
			double sellprice = Double.parseDouble(req.getParameter("sellprice"));
			// tính goảm giá theo %
			double percentprice = (price * percent) / 100;
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
