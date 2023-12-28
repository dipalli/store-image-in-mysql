package newp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;

public class image {
	public static void main(String [] args) {
		String url = "jdbc:mysql://localhost:3306/d2";
		String user = "root";
		String password = "Root";
		
		String filePath = "C:\\dipa\\image.jpg";
		
		try {
			Connection conn = DriverManager.getConnection(url,user, password);
			
			String sql = "INSERT INTO t3 (name,image) value (?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,"ravina dipa");
			
			InputStream inputStream = new FileInputStream(new File(filePath));
			statement.setBlob(2,inputStream);
			
			int row = statement.executeUpdate();
			if(row > 0) {
				System.out.println("A contact was inserted with photo image.");
			}
			conn.close();
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
			
		}
}
