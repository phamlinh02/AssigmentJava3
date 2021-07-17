/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Thuy Linh
 */
public class SVDiem {
     private String maSV, tenSV;
    private float markTA, markTin, markTC;

    public SVDiem() {
    }

    public SVDiem(String maSV, String tenSV, float markTA, float markTin, float markTC) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.markTA = markTA;
        this.markTin = markTin;
        this.markTC = markTC;

    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public float getMarkTA() {
        return markTA;
    }

    public void setMarkTA(float markTA) {
        this.markTA = markTA;
    }

    public float getMarkTin() {
        return markTin;
    }

    public void setMarkTin(float markTin) {
        this.markTin = markTin;
    }

    public float getMarkTC() {
        return markTC;
    }

    public void setMarkTC(float markTC) {
        this.markTC = markTC;
    }

    public float getMarkTB() {

        return (markTA + markTC + markTin) / 3;
    }
    
}
