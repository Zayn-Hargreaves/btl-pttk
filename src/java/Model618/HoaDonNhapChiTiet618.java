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
public class HoaDonNhapChiTiet618 {
    private int ID;
    private int SoLuongNhap;
    private float GiaNhap;
    private List<MatHang618> MatHang;

    public HoaDonNhapChiTiet618(int ID, int SoLuongNhap, float GiaNhap, List<MatHang618> MatHang) {
        this.ID = ID;
        this.SoLuongNhap = SoLuongNhap;
        this.GiaNhap = GiaNhap;
        this.MatHang = MatHang;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSoLuongNhap() {
        return SoLuongNhap;
    }

    public void setSoLuongNhap(int SoLuongNhap) {
        this.SoLuongNhap = SoLuongNhap;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public List<MatHang618> getMatHang() {
        return MatHang;
    }

    public void setMatHang(List<MatHang618> MatHang) {
        this.MatHang = MatHang;
    }

    
    
}
