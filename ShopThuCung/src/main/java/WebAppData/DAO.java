package WebAppData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import WebAppModel.User;

public class DAO {
	// truy vấn đến cơ sở dữ liệu
	public int registerUser(User user) throws ClassNotFoundException  {
		   Class.forName("com.mysql.jdbc.Driver");
		   String insert = "INSERT INTO user" +
		            "  (username, pass, email, number) VALUES " +
		            " (?, ?, ?, ?);";
		   int result = 0;
		   try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/webthucung", "root", "123456");
				  
	// Tạo câu lệnh sử dụng đối tượng kết nối
		            PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
		            preparedStatement.setString(1, user.getUsername());
		            preparedStatement.setString(2, user.getPass());
		            preparedStatement.setString(3, user.getEmail());
		            preparedStatement.setInt(4, user.getNumber());
	//thực hiện cập nhật truy vấn	            
		            result = preparedStatement.executeUpdate();

		        } catch (SQLException e) {
		            // process sql exception
		        e.getStackTrace();
		        }
		return result;
		 
	 }
}
