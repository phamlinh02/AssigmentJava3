/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import models.SVDiem;
import models.SVThongTin;

/**
 *
 * @author Thuy Linh
 */
public interface BaseDAO {
    boolean add(SVDiem x);
    boolean add(SVThongTin x);
    boolean deleteTT(String ma);
        boolean deleteDiem(String ma);

    boolean update(SVDiem x);
    boolean update(SVThongTin x);
    
}
