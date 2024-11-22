<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO618.HoaDonNhapDAO618" %>
<%@ page import="Model618.HoaDonNhap618" %>
<%@ page import="Model618.HoaDonNhapChiTiet618" %>
<%@ page import="Model618.MatHang618" %>
<%@ page import="java.text.DecimalFormat" %>

<%
    // Lấy tham số từ URL
    String IDHoaDonStr = request.getParameter("IDHoaDon");
    HoaDonNhap618 hoaDonNhap = null;

    if (IDHoaDonStr != null) {
        int IDHoaDon = Integer.parseInt(IDHoaDonStr); // Chuyển đổi ID hóa đơn
        try {
            // Tạo đối tượng DAO và lấy chi tiết hóa đơn nhập
            HoaDonNhapDAO618 hoaDonNhapDAO = new HoaDonNhapDAO618();
            hoaDonNhap = hoaDonNhapDAO.GetChiTietLanNhap(IDHoaDon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Chi Tiết Hóa Đơn Nhập</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: flex-start;
                height: 100%;
                overflow-y: scroll;
            }

            h1 {
                text-align: center;
                color: #333;
                margin-top: 20px;
            }

            .container {
                width: 80%;
                margin-top: 30px;
                padding: 20px;
                background-color: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            .details-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            .details-table th, .details-table td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: center;
            }

            .details-table th {
                background-color: #f2f2f2;
            }

            .total {
                margin-top: 20px;
                font-size: 18px;
                font-weight: bold;
                text-align: right; /* Đặt tổng tiền sang bên phải */
                padding-right: 20px; /* Thêm khoảng cách từ viền phải */
            }

            /* ... other styles ... */

            .back-btn {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 150px;
                height:50px;
                margin: 20px auto;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                border: none;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            /* ... other styles ... */

            .back-btn:hover {
                background-color: #45a049;
            }

        </style>
    </head>
    <body>

        <h1>Chi Tiết Hóa Đơn Nhập</h1>

        <%
            if (hoaDonNhap != null) {
        %>
        <div class="container">
            <h3>Hóa Đơn Nhập ID: <%= hoaDonNhap.getID()%></h3>
            <p><strong>Ngày Nhập:</strong> <%= hoaDonNhap.getNgayNhap()%></p>

            <table class="details-table">
                <thead>
                    <tr>
                        <th>ID Mặt Hàng</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Số Lượng Nhập</th>
                        <th>Giá Nhập</th>
                        <th>Thành Tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<HoaDonNhapChiTiet618> dsHangNhap = hoaDonNhap.getDSHangNhap();
                        DecimalFormat df = new DecimalFormat("#,###");
                        for (HoaDonNhapChiTiet618 chiTiet : dsHangNhap) {
                            for (MatHang618 matHang : chiTiet.getMatHang()) {
                    %>
                    <tr>
                        <td><%= matHang.getID()%></td>
                        <td><%= matHang.getTenSanPham()%></td>
                        <td><%= chiTiet.getSoLuongNhap()%></td>
                        <td><%= df.format(matHang.getDonGiaNhap())%> VND</td>
                        <td><%= df.format(chiTiet.getSoLuongNhap() * matHang.getDonGiaNhap())%> VND</td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>

            <div class="total">
                <p><strong>Tổng Tiền: </strong><%= df.format(hoaDonNhap.getTongTien())%> VND</p>
            </div>

            <button class="back-btn" onclick="window.history.back();">Quay lại</button>
        </div>
        <%
        } else {
        %>
        <div class="container">
            <p>Không tìm thấy thông tin hóa đơn nhập.</p>
            <button class="back-btn" onclick="window.history.back();">Quay lại</button>
        </div>
        <%
            }
        %>

    </body>
</html>
