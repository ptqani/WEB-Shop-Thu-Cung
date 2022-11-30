package WebAppData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WebAppModel.Category;
import WebAppModel.Product;
import WebAppModel.User;

public class DAO {

	// Tạo ra phương thức đăng kí lưu thông tin đến cơ sở dữ liệu
	public void registerUser(String username,String pass,String email,String phonenumber ) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "insert into user (username, pass, email, phonenumber, isSell, isAdmin) values (?, ?, ?, ?, 0, 0)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,pass);
			preparedStatement.setString(3,email);
			preparedStatement.setString(4,phonenumber);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}
	public User checkUSer(String username) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from user where username =?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1,username );

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getInt(6),rs.getInt(7));	
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return null;
	}
	// Tạo ra phương thức đăng nhập lấy thông tin từ cơ sở dữ liệu
	public User loginUser(String username,String pass) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from user where username =? and pass =?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1,username );
			preparedStatement.setString(2, pass);

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getInt(6),rs.getInt(7));	
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
						rs.getString(6),rs.getString(7),rs.getInt(8)));
			}

		}
		return list;
	}
	// Tạo ra phương thức lấy thông tin tất cả sản phẩm từ cơ sở dữ liệu xếp thoe chiều từ dưới lên
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
						rs.getString(6),rs.getString(7),rs.getInt(8)));
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
						rs.getString(6),rs.getString(7),rs.getInt(8)));
			}

		}
		return list;
	}

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
						rs.getString(6),rs.getString(7),rs.getInt(8));
			}

		}
		return null;

	}

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
						rs.getString(6),rs.getString(7),rs.getInt(8)));
			}

		}
		return list;
	}
	
	public List<Product> getIdProduct(int iduser) throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "SELECT * FROM product where id_product = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setInt(1,iduser);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getInt(8)));
			}

		}
		return list;
	}
	public void deleteProduct(String id ) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String delete = "delete from product where id = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
			preparedStatement.setString(1,id);
	
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}
	public void addProduct(String name,String image,double price,String sellprice,String title,String description,int cateId,int id) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "INSERT INTO product (name, image, price, sellprice, title, description, cateID, id_product) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,image);
			preparedStatement.setDouble(3,price);
			preparedStatement.setString(4,sellprice);
			preparedStatement.setString(5,title);
			preparedStatement.setString(6, description);
			preparedStatement.setInt(7,cateId);
			preparedStatement.setInt(8,id);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}
	public void editProduct(String name,String image,String price,String sellprice,String title,String description,String cateId,String idpro) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String update = "update product set name = ?, image = ?, price = ?, sellprice = ?, title = ?, description = ?, cateID = ? where id = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(update)) {
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,image);
			preparedStatement.setString(3,price);
			preparedStatement.setString(4,sellprice);
			preparedStatement.setString(5, title);
			preparedStatement.setString(6,description);
			preparedStatement.setString(7,cateId);
			preparedStatement.setString(8,idpro);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}
	public void registerProduct(String isAdmin,int iduser) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String update = "update user set isAdmin = ? where iduser = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webthucung", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(update)) {
			preparedStatement.setString(1,isAdmin);
			preparedStatement.setInt(2, iduser);
		
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	}
}