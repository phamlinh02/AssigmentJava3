/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import models.SVDiem;
import models.SVThongTin;
import utils.JBDCUtilts;

/**
 *
 * @author Thuy Linh
 */
public class StudentDAO implements BaseDAO {

    private  Connection conn;

    public StudentDAO() {
        this.conn = JBDCUtilts.getConnection();
    }

    public ArrayList<SVDiem> getListDiem() {
        ArrayList<SVDiem> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblDIEM";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SVDiem x = new SVDiem();
                x.setMaSV(rs.getString(2));
                x.setTenSV(rs.getString(3));
                x.setMarkTA(rs.getFloat(4));
                x.setMarkTin(rs.getFloat(5));
                x.setMarkTC(rs.getFloat(6));
                lst.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public ArrayList<SVThongTin> getListTT() {
        ArrayList<SVThongTin> lst = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tblSV";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SVThongTin x = new SVThongTin();
                x.setMa(rs.getString(1));
                x.setHoTen(rs.getString(2));
                x.setMail(rs.getString(3));
                x.setSdt(rs.getString(4));
                x.setGt(rs.getString(5));
                x.setDchi(rs.getString(6));
                lst.add(x);
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public static void main(String[] args) {

    }

    @Override
    public boolean add(SVDiem x) {
        try {
            String sql = "INSERT INTO tblDIEM (MASV,HOTEN,MARKTA,MARKTIN,MARKTC) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, x.getMaSV());
            ps.setString(2, x.getTenSV());
            ps.setFloat(3, x.getMarkTA());
            ps.setFloat(4, x.getMarkTin());
            ps.setFloat(5, x.getMarkTC());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean add(SVThongTin x) {
        try {
            String sql = "INSERT INTO tblSV VALUES(?,?,?,?,?,?)";
            String luu = "INSERT INTO tblDIEM (MASV,HOTEN) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps1 = conn.prepareStatement(luu);
            ps.setString(1, x.getMa());
            ps.setString(2, x.getHoTen());
            ps.setString(3, x.getMail());
            ps.setString(4, x.getSdt());
            ps.setString(5, x.getGt());
            ps.setString(6, x.getDchi());
            ps1.setString(1, x.getMa());
            ps1.setString(2, x.getHoTen());
            if (ps.executeUpdate() > 0 && ps1.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTT(String ma) {
        try {
            String xoa = "delete from tblDIEM where MASV=?";
            String sql = "DELETE FROM tblSV WHERE MASV=?";
            PreparedStatement ps1 = conn.prepareStatement(xoa);
            ps1.setString(1, ma);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            if (ps1.executeUpdate() > 0 && ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDiem(String ma) {
        try {
            String sql = "DELETE FROM tblDIEM WHERE MASV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(SVDiem x) {
        try {
            String sql = "UPDATE tblDIEM SET MARKTA=?, MARKTIN=? , MARKTC =? WHERE MASV=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, x.getMarkTA());
            ps.setFloat(2, x.getMarkTin());
            ps.setFloat(3, x.getMarkTC());
            ps.setString(4, x.getMaSV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(SVThongTin x) {
        try {
            String sql = "UPDATE tblSV set  HOTEN= ? , EMAIL=?,DT=?,GT=?,DCHI=? where MASV=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, x.getHoTen());
            ps.setString(2, x.getMail());
            ps.setString(3, x.getSdt());
            ps.setString(4, x.getGt());
            ps.setString(5, x.getDchi());
            ps.setString(6, x.getMa());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean ktraMa(String ma) {
        int ktra = 0;
        try {
            String sql = "Select MASV FROM tblSV";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (ma.equals(rs.getString(1))) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;

    }
    public String hoTen(String ma) {
        String ten = "";
        try {
            if (ktraMa(ma)) {
                String sql = "SELECT HOTEN FROM tblSV WHERE MASV =?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ma);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ten = rs.getString(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ten;
    }

}
