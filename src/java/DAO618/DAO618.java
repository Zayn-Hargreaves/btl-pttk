package DAO618;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO618 {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/shopman618?useSSL=false"; // Đảm bảo tên database đúng
    private static final String USER = "root"; // Tên người dùng MySQL
    private static final String PASSWORD = "12345"; // Mật khẩu MySQL

    protected Connection con;

    public DAO618() throws SQLException, ClassNotFoundException {
        try {
            // Nạp driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Kết nối cơ sở dữ liệu
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối thành công tới cơ sở dữ liệu.");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
            throw e;
        }
    }

    // Đóng kết nối khi không còn sử dụng
    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Kết nối cơ sở dữ liệu đã đóng.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối cơ sở dữ liệu: " + e.getMessage());
            }
        }
    }
   
}
