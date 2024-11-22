/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO618;

import Model618.TKNhaCungCap618;
import java.sql.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class TKNhaCungCap618DA0 extends DAO618 {

    public TKNhaCungCap618DA0() throws SQLException, ClassNotFoundException {
    }

    public List<TKNhaCungCap618> TKNhaCungCap(Date ngayBatDau, Date ngayKetThuc) throws SQLException {
        List<TKNhaCungCap618> ThongKeNCC = new ArrayList<>();
        String sqlNhaCungCap618 = "SELECT nc.id AS ID_NhaCungCap, nc.tennhacungcap AS TenNhaCungCap, nc.diachi AS DiaChi, SUM(hdct.Soluongnhap) AS TongLuongHang, SUM(hdct.gianhap) AS TongTienNhap FROM tblHoaDonnhapChitiet618 hdct INNER JOIN tblHoaDonNhap618 hdn ON hdct.tblhoadonnhap618ID = hdn.id INNER JOIN tblNhaCungCap618 nc ON hdn.tblNhaCungcap618ID = nc.id WHERE hdn.NgayNhapHang BETWEEN ? AND ? GROUP BY nc.id, nc.tennhacungcap, nc.diachi;";
        PreparedStatement ps = con.prepareStatement(sqlNhaCungCap618);
        ps.setDate(1, new java.sql.Date(ngayBatDau.getTime()));
        ps.setDate(2, new java.sql.Date(ngayKetThuc.getTime()));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ID = rs.getInt("ID_NhaCungCap");
            String TenNhaCungCap = rs.getString("TenNhaCungCap");
            float TongGiaTriNhap = rs.getFloat("TongTienNhap");
            int TongSoLuongNhap = rs.getInt("TongLuongHang");
            String DiaChi = rs.getString("DiaChi");
            TKNhaCungCap618 Thongke = new TKNhaCungCap618(TongGiaTriNhap, TongSoLuongNhap, ID, TenNhaCungCap, DiaChi);
            ThongKeNCC.add(Thongke);
        }
        return ThongKeNCC;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // Tạo đối tượng của TKNhaCungCap618DA0
            TKNhaCungCap618DA0 dao = new TKNhaCungCap618DA0();

            // Chọn ngày bắt đầu và ngày kết thúc để test
            String startDateStr = "2024-01-01";  // Ngày bắt đầu
            String endDateStr = "2024-12-31";    // Ngày kết thúc

            // Đổi chuỗi ngày sang đối tượng Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            // Gọi hàm TKNhaCungCap để lấy thống kê
            List<TKNhaCungCap618> thongKeNCC = dao.TKNhaCungCap(startDate, endDate);

            // In kết quả ra màn hình
            if (thongKeNCC != null && !thongKeNCC.isEmpty()) {
                for (TKNhaCungCap618 ncc : thongKeNCC) {
                    System.out.println("ID: " + ncc.getID());
                    System.out.println("Tên Nhà Cung Cấp: " + ncc.getTenNhaCungCap());
                    System.out.println("Địa Chỉ: " + ncc.getDiaChi());
                    System.out.println("Tổng Giá Trị Nhập: " + (ncc.getTongGiaTriNhap()) + " VND");
                    System.out.println("Tổng Số Lượng Nhập: " + ncc.getSoLuongNhap());
                    System.out.println("-----------------------------------------------------");
                }
            } else {
                System.out.println("Không có dữ liệu thống kê cho khoảng thời gian này.");
            }
        } catch (SQLException | java.text.ParseException e) {
        }
    }
}
