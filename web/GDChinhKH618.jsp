<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chính Khách Hàng</title>
    <style>
        /* Cấu hình cho body để căn giữa nội dung */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Chiếm toàn bộ chiều cao màn hình */
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
        }

        /* Tạo một ô vuông chứa button */
        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 300px;
            height: 200px;
            border: 2px solid #333;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
            text-align: center;
        }

        /* Cấu hình cho button */
        button {
            padding: 15px 30px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        /* Khi hover vào button */
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <%
        // Lấy id khách hàng từ cookie
        String idKhachHang = null;
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie cookie : cookies) {
                if ("idKhachHang".equals(cookie.getName())) {
                    idKhachHang = cookie.getValue();
                    break;
                }
            }
        }

        // Kiểm tra nếu không có cookie thì chuyển hướng
        if (idKhachHang == null) {
            response.sendRedirect("dangnhap.jsp?error=missingCookie");
            return;
        }
    %>
    <div class="button-container">
        <!-- Thêm idKhachHang vào URL -->
        <button onclick="window.location.href='GDTraCuuHoaDonKhachHang618.jsp?idKhachHang=<%=idKhachHang%>';">
            Tra cứu hóa đơn khách hàng
        </button>
    </div>
</body>
</html>
