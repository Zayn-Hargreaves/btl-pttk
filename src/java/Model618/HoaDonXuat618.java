/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class HoaDonXuat618 {
    private int ID;
    private Date NgayTao;
    private float TongTien;
    private String TrangThaiHoaDon;
    private List<HoaDonXuatChiTiet618> DSHangXuat ;
    private KhachHang618 KhachHang;
    private NhanVienBanHang618 NhanVienBanHang;

    public HoaDonXuat618(int ID, Date NgayTao, float TongTien, String TrangThaiHoaDon, List<HoaDonXuatChiTiet618> DSHangXuat, KhachHang618 KhachHang, NhanVienBanHang618 NhanVienBanHang) {
        this.ID = ID;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.TrangThaiHoaDon = TrangThaiHoaDon;
        this.DSHangXuat = DSHangXuat;
        this.KhachHang = KhachHang;
        this.NhanVienBanHang = NhanVienBanHang;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThaiHoaDon() {
        return TrangThaiHoaDon;
    }

    public void setTrangThaiHoaDon(String TrangThaiHoaDon) {
        this.TrangThaiHoaDon = TrangThaiHoaDon;
    }

    public List<HoaDonXuatChiTiet618> getDSHangXuat() {
        return DSHangXuat;
    }

    public void setDSHangXuat(List<HoaDonXuatChiTiet618> DSHangXuat) {
        this.DSHangXuat = DSHangXuat;
    }

    

    public KhachHang618 getKhachHang() {
        return KhachHang;
    }

    public void setKhachHang(KhachHang618 KhachHang) {
        this.KhachHang = KhachHang;
    }

    public NhanVienBanHang618 getNhanVienBanHang() {
        return NhanVienBanHang;
    }

    public void setNhanVienBanHang(NhanVienBanHang618 NhanVienBanHang) {
        this.NhanVienBanHang = NhanVienBanHang;
    }

    @Override
    public String toString() {
        return "HoaDonXuat618{" + "ID=" + ID + ", NgayTao=" + NgayTao + ", TongTien=" + TongTien + ", TrangThaiHoaDon=" + TrangThaiHoaDon + ", DSHangXuat=" + DSHangXuat + ", KhachHang=" + KhachHang + ", NhanVienBanHang=" + NhanVienBanHang + '}';
    }
    
}
