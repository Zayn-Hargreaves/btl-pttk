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
public class HoaDonNhap618 {
    private int ID;
    private Date NgayNhap;
    private float TongTien;
    private NhaCungCap618 NhaCungCap;
    private List<HoaDonNhapChiTiet618> DSHangNhap;

    public HoaDonNhap618(int ID, Date NgayNhap, float TongTien, NhaCungCap618 NhaCungCap, List<HoaDonNhapChiTiet618> DSHangNhap) {
        this.ID = ID;
        this.NgayNhap = NgayNhap;
        this.TongTien = TongTien;
        this.NhaCungCap = NhaCungCap;
        this.DSHangNhap = DSHangNhap;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public NhaCungCap618 getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap618 NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }

    public List<HoaDonNhapChiTiet618> getDSHangNhap() {
        return DSHangNhap;
    }

    public void setDSHangNhap(List<HoaDonNhapChiTiet618> DSHangNhap) {
        this.DSHangNhap = DSHangNhap;
    }

    
    
    
}
