/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

/**
 *
 * @author Lenovo
 */
public class MatHang618 {
    private int ID;
    private String TenSanPham;
    private float DonGiaNhap;
    private float DonGiaXuat;

    public MatHang618(int ID, String TenSanPham, float DonGiaNhap, float DonGiaXuat) {
        this.ID = ID;
        this.TenSanPham = TenSanPham;
        this.DonGiaNhap = DonGiaNhap;
        this.DonGiaXuat = DonGiaXuat;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public float getDonGiaNhap() {
        return DonGiaNhap;
    }

    public void setDonGiaNhap(float DonGiaNhap) {
        this.DonGiaNhap = DonGiaNhap;
    }

    public float getDonGiaXuat() {
        return DonGiaXuat;
    }

    public void setDonGiaXuat(float DonGiaXuat) {
        this.DonGiaXuat = DonGiaXuat;
    }
    
}
