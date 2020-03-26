package com.example.ontapcustomlistview;

public class NhanVien {
    int Gt;
    String maNV;
    String name;

    public NhanVien(int gt, String maNV, String name) {
        Gt = gt;
        this.maNV = maNV;
        this.name = name;
    }

    public int getGt() {
        return Gt;
    }

    public void setGt(int gt) {
        Gt = gt;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
