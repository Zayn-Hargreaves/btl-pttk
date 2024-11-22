/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

/**
 *
 * @author Lenovo
 */
public class NhanVien618 extends ThanhVien618{
    private String MaNhanVien;
    private String ChucVu;

    public NhanVien618(String MaNhanVien, String ChucVu, int ID, String TenDangNhap, String HoTen, String DiaChi, String SoDienThoai, String Password) {
        super(ID, TenDangNhap, HoTen, DiaChi, SoDienThoai, Password);
        this.MaNhanVien = MaNhanVien;
        this.ChucVu = ChucVu;
    }

    

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
    
}
