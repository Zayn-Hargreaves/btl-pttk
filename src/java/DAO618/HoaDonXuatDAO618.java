/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO618;

import Model618.HoaDonXuat618;
import Model618.HoaDonXuatChiTiet618;
import Model618.KhachHang618;
import Model618.MatHang618;
import Model618.NhanVienBanHang618;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class HoaDonXuatDAO618 extends DAO618 {

    public HoaDonXuatDAO618() throws SQLException, ClassNotFoundException {
    }

    public List<HoaDonXuat618> GetListHoaDonKH(int IDKhachHang) throws SQLException {
        List<HoaDonXuat618> ListHoaDonXuat618 = new ArrayList<>();
        String sqlHoaDonXuat618 = "SELECT * FROM tblHoaDonXuat618 hdx WHERE hdx.tblKhachHang618tblThanhVien618ID = ? AND hdx.TrangThaiDonHang = 'Đang xử lý';";

        PreparedStatement ps = con.prepareStatement(sqlHoaDonXuat618);
        ps.setInt(1, IDKhachHang);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ID = rs.getInt("ID");
            Date NgayTao = rs.getDate("NgayTao");
            float TongTien = rs.getFloat("TongTien");
            String TrangThaiDonHang = rs.getString("TrangThaiDonHang");
            HoaDonXuat618 HoaDonXuat = new HoaDonXuat618(ID, NgayTao, TongTien, TrangThaiDonHang, null, null, null);
            ListHoaDonXuat618.add(HoaDonXuat);
        }
        return ListHoaDonXuat618;
    }

    public HoaDonXuat618 GetHoaDonXuatChiTiet(int IDHoaDonXuat) throws SQLException {
        HoaDonXuat618 hoaDonXuat = null;
        List<HoaDonXuatChiTiet618> dsHangXuat = new ArrayList<>();

            String sql = "SELECT hdxct.ID, hdxct.SoLuongXuat, hdxct.GiaBan, mh.TenSanPham, mh.DonGiaXuat, hdx.ID, hdx.NgayTao, hdx.TongTien, hdx.TrangThaiDonHang From tblHoaDonXuat618 hdx Join tblHoaDonXuatChiTiet618 hdxct on hdx.ID = hdxct.tblHoaDonXuat618ID JOIN tblMatHang618 mh ON hdxct.tblMatHang618ID = mh.ID WHERE hdx.ID = ?;";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IDHoaDonXuat);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) { 
            // Khởi tạo hóa đơn nhập nếu chưa được tạo
            if (hoaDonXuat == null) {
                int id = rs.getInt("ID");
                Date ngayNhap = rs.getDate("NgayTao");
                float tongTien = rs.getFloat("TongTien");
                String TrangThaiDonHang = rs.getString("TrangThaiDonHang");
               
                hoaDonXuat = new HoaDonXuat618(id, ngayNhap, tongTien,TrangThaiDonHang ,dsHangXuat,null,null);
            }

            // Tạo danh sách mặt hàng
            MatHang618 matHang = new MatHang618(0,"",0,0);
            matHang.setID(rs.getInt("ID"));
            matHang.setTenSanPham(rs.getString("TenSanPham"));
            matHang.setDonGiaXuat(rs.getFloat("DonGiaXuat"));

            // Tạo chi tiết hóa đơn nhập
            int chiTietID = rs.getInt("ID");
            int soLuongNhap = rs.getInt("SoLuongXuat");
            float giaBan= rs.getFloat("GiaBan");

            // Tạo chi tiết hóa đơn nhập
            HoaDonXuatChiTiet618 chiTietHoaDon = new HoaDonXuatChiTiet618(0, 0, 0, null);
            chiTietHoaDon.setID(chiTietID);
            chiTietHoaDon.setSoLuongXuat(soLuongNhap);
            chiTietHoaDon.setGiaBan(giaBan);
            chiTietHoaDon.setMatHang(List.of(matHang)); // Thêm mặt hàng vào chi tiết

            // Thêm chi tiết vào danh sách
            dsHangXuat.add(chiTietHoaDon);
        }

        // Gắn danh sách chi tiết hóa đơn vào hóa đơn nhập
        if (hoaDonXuat != null) {
            hoaDonXuat.setDSHangXuat(dsHangXuat);
        }

        return hoaDonXuat;
    }
}
