package com.ntppackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class ConnectDBClass {
    private String userName = "root";
    private String passWord = "";
    private String URL = "jdbc:mysql://localhost:3306/testbaidat";
    

    public ConnectDBClass() {
        
    }
    
    public Connection connect(){
        Connection conn = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(this.URL, this.userName, this.passWord);}
        catch(Exception e){}
        return conn;
    }
    public boolean thucThiCauLenhSQL(String sql) throws Exception{
            try{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
                return true;
            }
            catch(Exception ex){}
            return false;
	}
    public ResultSet chonDuLieuTuDTB(String sql) throws Exception{
		Connection connect = connect();
		Statement stmt = connect.createStatement();
		ResultSet rs =stmt.executeQuery(sql);
		return rs;
	}
    
    
}
