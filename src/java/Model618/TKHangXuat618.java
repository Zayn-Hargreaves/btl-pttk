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
public class TKHangXuat618 extends MatHang618 {
    private float TongDoanhThu;
    private Date NgayBatDau;
    private Date NgayKetThuc;

    public TKHangXuat618(float TongDoanhThu, Date NgayBatDau, Date NgayKetThuc, int ID, String TenSanPham, float DonGiaNhap, float DonGiaXuat) {
        super(ID, TenSanPham, DonGiaNhap, DonGiaXuat);
        this.TongDoanhThu = TongDoanhThu;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }

    public float getTongDoanhThu() {
        return TongDoanhThu;
    }

    public void setTongDoanhThu(float TongDoanhThu) {
        this.TongDoanhThu = TongDoanhThu;
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
