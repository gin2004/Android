package com.example.myapplication.model;

public class Phong {
    private String maPhong, tenPhong, tenNguoi, sdt, tinhTrang;
    private double giaThue;

    public Phong() {
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTenNguoi() {
        return tenNguoi;
    }

    public void setTenNguoi(String tenNguoi) {
        this.tenNguoi = tenNguoi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public Phong(String maPhong, String tenPhong, String tenNguoi, String sdt, String tinhTrang, double giaThue) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.tenNguoi = tenNguoi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
        this.giaThue = giaThue;
    }
}
