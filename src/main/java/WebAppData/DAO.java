package WebAppData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import WebAppModel.Billproduct;
import WebAppModel.Category;
import WebAppModel.Comment;
import WebAppModel.Custommer;
import WebAppModel.Product;
import WebAppModel.User;
import WebAppModel.UserShop;

public class DAO {

	// Tạo ra phương thức đăng kí lưu thông tin đến cơ sở dữ liệu
	public void registerUser(String username, String pass, String email, String phonenumber)
			throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "insert into user (username, pass, email, phonenumber, isSell, isAdmin) values (?, ?, ?, ?, 0, 0)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phonenumber);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	// đăng kí bán hàng
	public void registerUserShop(String name, String sdt, String address, String email, int userid)
			throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "insert into usershop (name, sdt, address, email, userid) values (?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, sdt);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, email);
			preparedStatement.setInt(5, userid);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}
// kiểm tra tên người dùng 
	public User checkUSer(String username) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from user where username =?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, username);

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return null;
	}

	// Tạo ra phương thức đăng nhập lấy thông tin từ cơ sở dữ liệu
	public User loginUser(String username, String pass) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from user where username =? and pass =?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return null;
	}

	// Tạo ra phương thức lấy thông tin tất cả sản phẩm từ cơ sở dữ liệu
	public List<Product> getAllProduct() throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		}
		return list;
	}

	// Tạo ra phương thức lấy thông tin tất cả sản phẩm từ cơ sở dữ liệu xếp thoe
	// chiều từ dưới lên
	public List<Product> getAllProductdesc() throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product order by id desc";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		}
		return list;
	}

	// Tạo ra phương thức lấy thông tin bộ lọc từ cơ sở dữ liệu
	public List<Product> getAllProductCategory(String cid) throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product where cateID = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, cid);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		}
		return list;
	}

// lấy ra tất cả danh mục
	public List<Category> getAllCategory() throws ClassNotFoundException, SQLException {
		List<Category> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from category";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}

		}
		return list;
	}
// lấy ra một sản phẩm theo id
	public Product getProductID(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product where id = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, id);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
			}

		}
		return null;

	}
// lấy ra một sản phẩm
	public Product getProduct() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
			}

		}
		return null;

	}

// tìm kiếm theo từ khóa
	public List<Product> getAllProductSearch(String name) throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "SELECT * FROM product where name like ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, "%" + name + "%");
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		}
		return list;
	}
// lấy ra sản phẩm theo id người dùng
	public List<Product> getIdProduct(int iduser) throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "SELECT * FROM product where id_product = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setInt(1, iduser);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		}
		return list;
	}

	public void deleteProduct(String id) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String delete = "delete from product where id = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
			preparedStatement.setString(1, id);

			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

// thêm sp 
	public void addProduct(String name, String image, double price, double sellprice, String title, String description,
			int cateId, int id) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "INSERT INTO product (name, image, price, sellprice, title, description, cateID, id_product) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, image);
			preparedStatement.setDouble(3, price);
			preparedStatement.setDouble(4, sellprice);
			preparedStatement.setString(5, title);
			preparedStatement.setString(6, description);
			preparedStatement.setInt(7, cateId);
			preparedStatement.setInt(8, id);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	public void editProduct(String name, String image, String price, String sellprice, String title, String description,
			String cateId, String idpro) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String update = "update product set name = ?, image = ?, price = ?, sellprice = ?, title = ?, description = ?, cateID = ? where id = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(update)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, image);
			preparedStatement.setString(3, price);
			preparedStatement.setString(4, sellprice);
			preparedStatement.setString(5, title);
			preparedStatement.setString(6, description);
			preparedStatement.setString(7, cateId);
			preparedStatement.setString(8, idpro);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	public void registerProduct(String isAdmin, int iduser) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String update = "update user set isAdmin = ? where iduser = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(update)) {
			preparedStatement.setString(1, isAdmin);
			preparedStatement.setInt(2, iduser);

			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	// tạo bình luận
	public void commentUser(String name, String command, String datetime, String idpro) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "insert into comment (name, command, datetime, idpro) values (?, ?, ? , ?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, command);
			preparedStatement.setString(3, datetime);
			preparedStatement.setString(4, idpro);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	// Tạo ra phương thức lấy thông tin tất cả comment từ cơ sở dữ liệu
	public List<Comment> getAllcommentUser(String idpro) throws ClassNotFoundException, SQLException {
		List<Comment> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from comment where idpro = ? order by id desc";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, idpro);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Comment(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		}
		return list;
	}

	// Đếm số lượng sp có trong csdl
	public int countProduct() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "SELECT COUNT(*) FROM product";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return 0;
	}

// Tra ve danh sach san pham co dinh theo trang
	public List<Product> getProductOffSet(int index) throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "SELECT * FROM product LIMIT 20 OFFSET ?;";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setInt(1, (index - 1) * 20);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}

		}
		return list;
	}

	// lấy ra thông tin userShop
	public UserShop getUserShop(int userid) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from usershop where userid = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			preparedStatement.setInt(1, userid);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new UserShop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			}

		}
		return null;
	}

	// lưu thông tin khách hàng
	public void customer(int iduser, String name, String email, String address, String sdt, double sumallpro,
			int quantity, String datetime) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "insert into custommer (iduser, name, email, address, sdt, sumallpro, quantity, datetime) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setInt(1, iduser);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, sdt);
			preparedStatement.setDouble(6, sumallpro);
			preparedStatement.setInt(7, quantity);
			preparedStatement.setString(8, datetime);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

	// chèn tất cả sản phẩm người mua đã mua vào csdl
	public void setlistProduct(Custommer e) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "insert into billproduct (id_product, idcustom, quantity, datetime) values (?, ?, ?, ?)";
		for (Product i : e.getListPro()) {

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
					"123456");

					// Tạo câu lệnh sử dụng đối tượng kết nối
					PreparedStatement preparedStatement = connection.prepareStatement(select)) {
				preparedStatement.setInt(1, i.getId()); // lay id san pham
				preparedStatement.setInt(2, e.getIduser()); // lay id nguoi dung
				preparedStatement.setInt(3, i.getQuantity()); // lay ra so luong sp
				preparedStatement.setString(4, e.getDatetime()); // lay thoi gian
				// thực hiện chọn truy vấn
				preparedStatement.executeUpdate();

			}

		}
	}

	// lịch sử mua hàng của người dùng (don hang)
	public List<Billproduct> getAllBill() throws ClassNotFoundException, SQLException {
		List<Billproduct> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from billproduct";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			;
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Billproduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}

		}
		return list;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DAO dao = new DAO();
//		int count = dao.countProduct();
//		System.out.println(count);
//		List<Product> list = dao.getProductOffSet(2);
//		for (Product product : list) {
//			System.out.println(product);
//		dao.registerUserShop("1", "1", "1", "1", 1);

//		}
	}
}
