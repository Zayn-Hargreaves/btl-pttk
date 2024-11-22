<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DAO618.HoaDonXuatDAO618" %>
<%@ page import="Model618.HoaDonXuat618" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>

<%
    // Lấy ID khách hàng từ cookie
    int idKhachHang = -1;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("idKhachHang".equals(cookie.getName())) {
                idKhachHang = Integer.parseInt(cookie.getValue());
                break;
            }
        }
    }

    // Danh sách hóa đơn
    List<HoaDonXuat618> danhSachHoaDon = null;

    if (idKhachHang != -1) {
        try {
            // Gọi DAO để lấy danh sách hóa đơn
            HoaDonXuatDAO618 hoaDonDAO = new HoaDonXuatDAO618();
            danhSachHoaDon = hoaDonDAO.GetListHoaDonKH(idKhachHang);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tra Cứu Hóa Đơn Khách Hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
            background: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
            cursor: pointer;
        }

        tr:last-child td {
            border-bottom: none;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        p {
            text-align: center;
            color: #888;
        }

        button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        // Hàm để chuyển đến giao diện chi tiết hóa đơn
        function goToDetail(idHoaDon) {
            window.location.href = 'GDChiTietHoaDon618.jsp?IDHoaDon=' + idHoaDon;
        }
    </script>
</head>
<body>
    <div>
        <h1>Danh Sách Hóa Đơn Khách Hàng</h1>
        <%
            // Hiển thị thông báo nếu không tìm thấy ID khách hàng
            if (idKhachHang == -1) {
        %>
            <p>Không tìm thấy thông tin khách hàng. Vui lòng đăng nhập lại.</p>
        <%
            } else if (danhSachHoaDon == null || danhSachHoaDon.isEmpty()) {
        %>
            <p>Không tìm thấy hóa đơn nào cho khách hàng này.</p>
        <%
            } else {
        %>
            <table>
                <thead>
                    <tr>
                        <th>ID Hóa Đơn</th>
                        <th>Ngày Tạo</th>
                        <th>Tổng Tiền</th>
                        <th>Trạng Thái</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (HoaDonXuat618 hoaDon : danhSachHoaDon) {
                    %>
                    <tr onclick="goToDetail(<%= hoaDon.getID() %>)">
                        <td><%= hoaDon.getID() %></td>
                        <td><%= hoaDon.getNgayTao() %></td>
                        <td><%= (int)hoaDon.getTongTien() %> VND</td>
                        <td><%= hoaDon.getTrangThaiHoaDon() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            }
        %>
        <button onclick="window.location.href='GDChinhKH618.jsp';">Quay lại</button>
    </div>
</body>
</html>
