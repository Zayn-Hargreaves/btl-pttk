<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="DAO618.HoaDonNhapDAO618" %>
<%@ page import="Model618.HoaDonNhap618" %>

<%
    // Lấy tham số từ URL
    String IDNCCStr = request.getParameter("IDNCC");
    String startDateStr = request.getParameter("startDate");
    String endDateStr = request.getParameter("endDate");

    List<HoaDonNhap618> chiTietLanNhap = null;

    if (IDNCCStr != null && startDateStr != null && endDateStr != null) {
        int IDNCC = Integer.parseInt(IDNCCStr); // Chuyển đổi ID nhà cung cấp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Chuyển chuỗi ngày thành đối tượng Date
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            // Tạo đối tượng DAO và lấy danh sách các hóa đơn nhập
            HoaDonNhapDAO618 hoaDonNhapDAO = new HoaDonNhapDAO618();
            chiTietLanNhap = hoaDonNhapDAO.GetListChiTietLanNhap618(IDNCC, startDate, endDate);
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
        <title>Chi Tiết Lần Nhập</title>
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

            .form-container {
                background-color: #ffffff;
                border-radius: 8px;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 300px;
                margin-top: 20px;
                text-align: center;
            }
            a {
                display: inline-block; /* Đảm bảo thẻ a có thể chỉnh kiểu giống như button */
                background-color: #4CAF50; /* Màu nền của button */
                color: white; /* Màu chữ */
                padding: 10px 20px; /* Khoảng cách xung quanh chữ */
                text-decoration: none; /* Bỏ gạch chân của link */
                font-size: 16px; /* Kích thước chữ */
                border-radius: 5px; /* Bo góc */
                text-align: center; /* Canh giữa chữ */
                transition: background-color 0.3s; /* Hiệu ứng chuyển màu khi hover */
            }

            a:hover {
                background-color: #45a049; /* Màu nền khi hover */
            }

            .form-container input, .form-container button {
                padding: 10px;
                font-size: 16px;
                margin: 10px 0;
                width: 100%;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            button {
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            button:hover {
                background-color: #45a049;
            }

            .container-table {
                width: 80%;
                margin-top: 30px;
                overflow-x: auto;
                display: flex;
                justify-content: center;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                text-align: center;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
            }

            th {
                background-color: #f2f2f2;
            }

        </style>
    </head>
    <body>

        <h1>Chi Tiết Lần Nhập</h1>

        <div class="container-table">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Ngày Nhập</th>
                        <th>Tổng Tiền</th>
                        <th>Chi Tiết</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Kiểm tra nếu có dữ liệu
                        if (chiTietLanNhap != null && !chiTietLanNhap.isEmpty()) {
                            for (HoaDonNhap618 hoaDonNhap : chiTietLanNhap) {
                    %>
                    <tr>
                        <td><%= hoaDonNhap.getID()%></td>
                        <td><%= hoaDonNhap.getNgayNhap()%></td>
                        <td><%= (int) hoaDonNhap.getTongTien()%> VND</td>
                        <td><a href="GDChiTietHoaDonNhap618.jsp?IDHoaDon=<%= hoaDonNhap.getID() %>">Xem Chi Tiết</a></td>

                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="4">Không có hóa đơn nhập trong khoảng thời gian này.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

    </body>
</html>
