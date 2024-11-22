/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

/**
 *
 * @author Lenovo
 */
public class KhachHang618 extends ThanhVien618{
    private String MaKhachHang;

    public KhachHang618(String MaKhachHang, int ID, String TenDangNhap, String HoTen, String DiaChi, String SoDienThoai, String Password) {
        super(ID, TenDangNhap, HoTen, DiaChi, SoDienThoai, Password);
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }
    
}
