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
public class SVThongTin {

    private String ma, hoTen, mail, sdt, gt, dchi;

    public SVThongTin() {
    }

    public SVThongTin(String ma, String hoTen, String mail, String sdt, String gt, String dchi) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.mail = mail;
        this.sdt = sdt;
        this.gt = gt;
        this.dchi = dchi;

    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

}
