/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

/**
 *
 * @author Lenovo
 */
public class ThanhVien618 {
    public int ID;
    private String TenDangNhap;
    private String HoTen;
    private String DiaChi;
    private String SoDienThoai;
    private String Password;

    public ThanhVien618(int ID,String TenDangNhap, String HoTen, String DiaChi, String SoDienThoai, String Password) {
        this.ID = ID;
        this.TenDangNhap = TenDangNhap;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Password = Password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "ThanhVien618{" + "TenDangNhap=" + TenDangNhap + ", HoTen=" + HoTen + ", DiaChi=" + DiaChi + ", SoDienThoai=" + SoDienThoai + ", Password=" + Password + '}';
    }
    
    
}
