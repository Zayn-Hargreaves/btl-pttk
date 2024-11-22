/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model618;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class HoaDonXuatChiTiet618 {
    private int ID;
    private int SoLuongXuat;
    private float GiaBan;
    private List<MatHang618> MatHang;

    public HoaDonXuatChiTiet618(int ID, int SoLuongXuat, float GiaBan, List<MatHang618> MatHang) {
        this.ID = ID;
        this.SoLuongXuat = SoLuongXuat;
        this.GiaBan = GiaBan;
        this.MatHang = MatHang;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSoLuongXuat() {
        return SoLuongXuat;
    }

    public void setSoLuongXuat(int SoLuongXuat) {
        this.SoLuongXuat = SoLuongXuat;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public List<MatHang618> getMatHang() {
        return MatHang;
    }

    public void setMatHang(List<MatHang618> MatHang) {
        this.MatHang = MatHang;
    }

    
      
}
