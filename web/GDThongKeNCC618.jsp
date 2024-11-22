<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model618.TKNhaCungCap618" %>
<%@ page import="DAO618.TKNhaCungCap618DA0" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    // Khi người dùng submit form, lấy ngày bắt đầu và ngày kết thúc
    String startDateStr = request.getParameter("startDate");
    String endDateStr = request.getParameter("endDate");
    List<TKNhaCungCap618> thongKeNCC = null;

    if (startDateStr != null && endDateStr != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            TKNhaCungCap618DA0 dao = new TKNhaCungCap618DA0();
            thongKeNCC = dao.TKNhaCungCap(startDate, endDate);
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
        <title>Thống Kê Nhà Cung Cấp</title>
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
                text-align: center;
                width: 300px;

                margin-top: 20px;
            }

            .form-container input, .form-container button {
                padding: 10px;
                font-size: 16px;
                margin: 10px 0;
                width: 80%;
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
                width: 80%; /* Đảm bảo bảng có chiều rộng thích hợp */
                margin-top: 30px;
                overflow-x: auto;
                display: flex;
                justify-content: center; /* Căn giữa bảng trong container */
            }

            table {
                width: 100%; /* Đảm bảo bảng chiếm hết không gian của container */
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

        <h1>Thống Kê Nhà Cung Cấp</h1>

        <div class="form-container">
            <form method="get">
                <label for="startDate">Ngày Bắt Đầu:</label>
                <input type="date" id="startDate" name="startDate" required><br>

                <label for="endDate">Ngày Kết Thúc:</label>
                <input type="date" id="endDate" name="endDate" required><br>

                <button type="submit">Xem Thống Kê</button>
            </form>
        </div>

        <%
            if (thongKeNCC != null && !thongKeNCC.isEmpty()) {
        %>
        <div class="container-table">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên Nhà Cung Cấp</th>
                        <th>Địa Chỉ</th>
                        <th>Tổng Giá Trị Nhập</th>
                        <th>Tổng Số Lượng Nhập</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (TKNhaCungCap618 ncc : thongKeNCC) {
                    %>
                    <tr onclick="window.location.href = 'GDChiTietLanNhap618.jsp?IDNCC=<%=ncc.getID()%>&startDate=<%=startDateStr%>&endDate=<%=endDateStr%>'">
                        <td><%= ncc.getID()%></td>
                        <td><%= ncc.getTenNhaCungCap()%></td>
                        <td><%= ncc.getDiaChi()%></td>
                        <td><%= (int)ncc.getTongGiaTriNhap()%> VND</td>
                        <td><%= (int) ncc.getSoLuongNhap()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <% } else { %>
        <p>Không có dữ liệu thống kê cho khoảng thời gian này.</p>
        <% }%>

    </body>
</html>
