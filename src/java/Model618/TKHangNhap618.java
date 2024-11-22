/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class TKHangNhap618 extends MatHang618 {
    private float GiaTriHangNhap;
    private Date NgayBatDau;
    private Date NgayKetThuc;

    public TKHangNhap618(float GiaTriHangNhap, Date NgayBatDau, Date NgayKetThuc, int ID, String TenSanPham, float DonGiaNhap, float DonGiaXuat) {
        super(ID, TenSanPham, DonGiaNhap, DonGiaXuat);
        this.GiaTriHangNhap = GiaTriHangNhap;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }

    public float getGiaTriHangNhap() {
        return GiaTriHangNhap;
    }

    public void setGiaTriHangNhap(float GiaTriHangNhap) {
        this.GiaTriHangNhap = GiaTriHangNhap;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }
    
}
