<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DAO618.HoaDonXuatDAO618" %>
<%@ page import="Model618.HoaDonXuat618" %>
<%@ page import="Model618.HoaDonXuatChiTiet618" %>
<%@ page import="Model618.MatHang618" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>

<%
    // Lấy ID hóa đơn từ request
    String idHoaDonParam = request.getParameter("IDHoaDon");
    int idHoaDon = (idHoaDonParam != null) ? Integer.parseInt(idHoaDonParam) : -1;

    // Lấy thông tin chi tiết hóa đơn
    HoaDonXuat618 hoaDon = null;
    if (idHoaDon != -1) {
        try {
            HoaDonXuatDAO618 hoaDonDAO = new HoaDonXuatDAO618();
            hoaDon = hoaDonDAO.GetHoaDonXuatChiTiet(idHoaDon);
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
    <title>Chi Tiết Hóa Đơn</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 80%;
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
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
        }

        tr:last-child td {
            border-bottom: none;
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

        .info {
            margin: 10px 0;
            font-size: 18px;
        }

        .info span {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Chi Tiết Hóa Đơn</h1>

        <%
            if (hoaDon == null) {
        %>
            <p>Không tìm thấy chi tiết hóa đơn. Vui lòng thử lại.</p>
        <%
            } else {
        %>
            <div class="info">
                <p><span>ID Hóa Đơn:</span> <%= hoaDon.getID() %></p>
                <p><span>Ngày Tạo:</span> <%= hoaDon.getNgayTao() %></p>
                <p><span>Tổng Tiền:</span> <%= (int)hoaDon.getTongTien() %> VND</p>
                <p><span>Trạng Thái:</span> <%= hoaDon.getTrangThaiHoaDon() %></p>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID Mặt Hàng</th>
                        <th>Tên Mặt Hàng</th>
                        <th>Số Lượng</th>
                        <th>Giá Bán</th>
                        <th>Thành Tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<HoaDonXuatChiTiet618> dsHangXuat = hoaDon.getDSHangXuat();
                        for (HoaDonXuatChiTiet618 chiTiet : dsHangXuat) {
                            MatHang618 matHang = chiTiet.getMatHang().get(0); // Lấy mặt hàng đầu tiên (do danh sách có thể chứa nhiều mặt hàng)
                    %>
                    <tr>
                        <td><%= matHang.getID() %></td>
                        <td><%= matHang.getTenSanPham() %></td>
                        <td><%= chiTiet.getSoLuongXuat() %></td>
                        <td><%= (int)matHang.getDonGiaXuat() %> VND</td>
                        <td><%= chiTiet.getSoLuongXuat() *  (int)matHang.getDonGiaXuat()%> VND</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            }
        %>

        <button onclick="window.location.href='GDTraCuuHoaDonKhachHang618.jsp';">Quay lại</button>
    </div>
</body>
</html>
