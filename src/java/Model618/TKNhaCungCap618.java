/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

/**
 *
 * @author Lenovo
 */
public class TKNhaCungCap618 extends NhaCungCap618 {
    private float TongGiaTriNhap;
    private float SoLuongNhap;

    public float getTongGiaTriNhap() {
        return TongGiaTriNhap;
    }

    public void setTongGiaTriNhap(float TongGiaTriNhap) {
        this.TongGiaTriNhap = TongGiaTriNhap;
    }

    public float getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(float SoLuongNhap) {
        this.SoLuongNhap = SoLuongNhap;
    }

    public TKNhaCungCap618(float TongGiaTriNhap, float SoLuongNhap, int ID, String TenNhaCungCap, String DiaChi) {
        super(ID, TenNhaCungCap, DiaChi);
        this.TongGiaTriNhap = TongGiaTriNhap;
        this.SoLuongNhap = SoLuongNhap;
    }
    
}
