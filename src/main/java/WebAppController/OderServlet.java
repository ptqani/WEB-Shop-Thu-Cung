package WebAppController;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WebAppData.DAO;
import WebAppModel.Custommer;
import WebAppModel.Product;
import WebAppModel.User;

@WebServlet("/oderproducts")
public class OderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String byUser = req.getParameter("byUser");
			String byemail = req.getParameter("byemail");
			String byaddress = req.getParameter("byaddress");
			String bynum = req.getParameter("bynum");
			String[] idpro = req.getParameterValues("idpro"); // lấy ra id sản phẩm
			String[] itemquantity = req.getParameterValues("quantiitem"); // lấy số lượng sản phẩm
			// lấy thời gian hiện tại
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String datetime = String.valueOf(dtf.format(now));
			//gọi ss
			HttpSession ss = req.getSession();
			User user = (User) ss.getAttribute("sessio");
			int iduser = user.getIduser();
			DAO dao = new DAO();
			int[] idprod = new int[idpro.length];
			int[] idquan = new int[itemquantity.length];
			List<Product> list = new ArrayList<>();
			for (int i = 0; i < idpro.length; i++) {
				idprod[i] = Integer.parseInt(idpro[i]);
				for (int j = 0; j < idquan.length; j++) {
					idquan[i] = Integer.parseInt(itemquantity[i]);
				}
				Product p = new Product(idprod[i], idquan[i]);
				list.add(p);
			}

			double sum = Double.parseDouble(req.getParameter("sum"));
			int count = Integer.parseInt(req.getParameter("count"));

			Custommer cus = new Custommer();
			cus.setIduser(iduser);
			cus.setDatetime(datetime);
			cus.setListPro(list);
			// lưu thông tin sản phẩm
			dao.setlistProduct(cus);
			//lưu thông tin khách hàng
			dao.customer(iduser, byUser, byemail, byaddress, bynum, sum, count, datetime);
			req.getRequestDispatcher("ordering.jsp").forward(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
