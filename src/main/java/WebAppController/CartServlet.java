package WebAppController;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import WebAppData.DAO;
import WebAppModel.Cart;
import WebAppModel.LineItem;
import WebAppModel.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
            
        // gán action = cart nếu rỗng
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";  
        }

        // thực hiện hành động và đặt URL thành trang thích hợp
        String url = "/home.jsp";
        if (action.equals("shop")) {            
            url = "/home.jsp";    // trang chủ
        } 
        else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
// lấy cart từ ss ss
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }else {
            	 LineItem lineItem = new LineItem();
            	 lineItem.setQuantity(1 +lineItem.getQuantity() );
            }

            //if the user enters a negative or invalid quantity,
            //the quantity is automatically reset to 1.
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
         DAO dao = new DAO();
            Product product;
			try {
				//lấy sản phẩm theo id
				product = dao.getProductID(productCode);
				  LineItem lineItem = new LineItem();
		            lineItem.setProduct(product);
		            lineItem.setQuantity(quantity);
		            if (quantity > 0) {
		                cart.addItem(lineItem);
		            } else if (quantity == 0) {
		                cart.removeItem(lineItem);
		            }
		            
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            session.setAttribute("cart", cart);
            url = "cart.jsp";
        }
        else if (action.equals("checkout")) {
            url = "checkout.jsp";
        }

        request.getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
}