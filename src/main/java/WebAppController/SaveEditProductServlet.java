package WebAppController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import WebAppData.DAO;

@MultipartConfig
@WebServlet("/editsave")
public class SaveEditProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// lưu lại thông tin sản phẩm
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {

			String id = req.getParameter("id");
			String name = req.getParameter("name");
			Part part = req.getPart("image");
			String realpath = req.getServletContext().getRealPath("/images");
			String fileimage = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realpath))) {
				Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath + "/" + fileimage);
			String image ="images/"+fileimage;
			
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
