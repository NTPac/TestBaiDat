/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntppackage;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class NewAction {
    String currentDate = LocalDate.now().toString();
    String id ;
    public NewAction() {
    }
    
    public String execute() throws Exception {
            
            ConnectDBClass conn = new ConnectDBClass();
            ResultSet rs = conn.chonDuLieuTuDTB("SELECT * FROM `"+id+"`");
            ResultSetMetaData rsmd = rs.getMetaData();
            int i = rsmd.getColumnCount();
        return null;
    }
    
}
