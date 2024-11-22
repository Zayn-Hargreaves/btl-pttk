/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO618;

import Model618.HoaDonNhap618;
import Model618.HoaDonNhapChiTiet618;
import Model618.HoaDonXuat618;
import Model618.MatHang618;
import Model618.NhaCungCap618;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class HoaDonNhapDAO618 extends DAO618{

    public HoaDonNhapDAO618() throws SQLException, ClassNotFoundException {
    }
    
    public List<HoaDonNhap618> GetListChiTietLanNhap618(int IDNhaCungCap, Date NgayBatDau, Date NgayKetThuc) throws SQLException{
        List<HoaDonNhap618> ListHoaDonNhap = new ArrayList<>();
        String sql = "select * from tblHoaDonNhap618 where tblNhaCungCap618ID = ? AND NgayNhapHang Between ? AND ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IDNhaCungCap);
        ps.setDate(2, new java.sql.Date(NgayBatDau.getTime()));
        ps.setDate(3, new java.sql.Date(NgayKetThuc.getTime()));
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int ID = rs.getInt("ID");
            Date NgayTao = rs.getDate("NgayNhapHang");
            float TongTien = rs.getFloat("TongTien");
            HoaDonNhap618 HoaDonNhap = new HoaDonNhap618(ID, NgayTao, TongTien, null, null);
            ListHoaDonNhap.add(HoaDonNhap);
        }
        return ListHoaDonNhap;
    }
    public HoaDonNhap618 GetChiTietLanNhap(int IDHoaDonNhap) throws SQLException{
        HoaDonNhap618 HoaDonNhap = null;
        List<HoaDonNhapChiTiet618> dsHangNhap = new ArrayList<>();
        String sql = "select hdn.ID, hdn.NgayNhapHang, hdn.TongTien, hdnct.ID as hdnct_ID,hdnct.GiaNhap,hdnct.SoLuongnhap,mh.ID as mh_ID,mh.tensanPham, mh.dongianhap from tblHoaDonNhap618 hdn Join tblHoaDonNhapChiTiet618 hdnct on hdn.ID = hdnct.tblHoaDonNhap618ID join tblMatHang618 mh on mh.id = hdnct.tblMatHang618ID where hdn.ID = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IDHoaDonNhap);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) { 
            // Khởi tạo hóa đơn nhập nếu chưa được tạo
            if (HoaDonNhap == null) {
                int id = rs.getInt("ID");
                Date ngayNhap = rs.getDate("NgayNhapHang");
                float tongTien = rs.getFloat("TongTien");

               
                HoaDonNhap= new HoaDonNhap618(id, ngayNhap, tongTien,null,null);
            }

            // Tạo danh sách mặt hàng
            MatHang618 matHang = new MatHang618(0,"",0,0);
            matHang.setID(rs.getInt("mh_ID"));
            matHang.setTenSanPham(rs.getString("TenSanPham"));
            matHang.setDonGiaNhap(rs.getFloat("DonGiaNhap"));

            // Tạo chi tiết hóa đơn nhập
            int chiTietID = rs.getInt("hdnct_ID");
            int soLuongNhap = rs.getInt("SoLuongNhap");
            float giaNhap= rs.getFloat("GiaNhap");

            // Tạo chi tiết hóa đơn nhập
            HoaDonNhapChiTiet618 chiTietHoaDon = new HoaDonNhapChiTiet618(0, 0, 0, null);
            chiTietHoaDon.setID(chiTietID);
            chiTietHoaDon.setSoLuongNhap(soLuongNhap);
            chiTietHoaDon.setGiaNhap(giaNhap);
            chiTietHoaDon.setMatHang(List.of(matHang)); // Thêm mặt hàng vào chi tiết

            // Thêm chi tiết vào danh sách
            dsHangNhap.add(chiTietHoaDon);
        }

        // Gắn danh sách chi tiết hóa đơn vào hóa đơn nhập
        if (HoaDonNhap != null) {
            HoaDonNhap.setDSHangNhap(dsHangNhap);
        }
        return HoaDonNhap;
    }
}
