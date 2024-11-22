/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

/**
 *
 * @author Lenovo
 */
public class DonHang618 {
    private int ID;
    private String TrangThaiGiaoHang;
    private HoaDonXuat618 HoaDonXuat;
    private NhanVienGiaoHang618 NhanVienGiaoHang618;

    public DonHang618(int ID, String TrangThaiGiaoHang, HoaDonXuat618 HoaDonXuat, NhanVienGiaoHang618 NhanVienGiaoHang618) {
        this.ID = ID;
        this.TrangThaiGiaoHang = TrangThaiGiaoHang;
        this.HoaDonXuat = HoaDonXuat;
        this.NhanVienGiaoHang618 = NhanVienGiaoHang618;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTrangThaiGiaoHang() {
        return TrangThaiGiaoHang;
    }

    public void setTrangThaiGiaoHang(String TrangThaiGiaoHang) {
        this.TrangThaiGiaoHang = TrangThaiGiaoHang;
    }

    public HoaDonXuat618 getHoaDonXuat() {
        return HoaDonXuat;
    }

    public void setHoaDonXuat(HoaDonXuat618 HoaDonXuat) {
        this.HoaDonXuat = HoaDonXuat;
    }

    public NhanVienGiaoHang618 getNhanVienGiaoHang618() {
        return NhanVienGiaoHang618;
    }

    public void setNhanVienGiaoHang618(NhanVienGiaoHang618 NhanVienGiaoHang618) {
        this.NhanVienGiaoHang618 = NhanVienGiaoHang618;
    }
    
}
