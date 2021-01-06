package com.ntppackage;


import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class DiemDanhClass {
    @SuppressWarnings("empty-statement")
    public int taoBang(String tenBang) throws Exception
    {
        ConnectDBClass conn = new ConnectDBClass();
        String sql = "SELECT * FROM `danhsachdiemdanh` WHERE `TenBang`='diemdanh"+tenBang+"'";
        ResultSet rs = conn.chonDuLieuTuDTB(sql);
        if (rs.next()) {
            return 0;
        }
        sql = "CREATE TABLE `testbaidat`.`diemdanh"+tenBang+"` ( `stt` INT NOT NULL AUTO_INCREMENT , `msv` TEXT NOT NULL , `HoTen` TEXT NOT NULL , `NgaySinh` TEXT NOT NULL , PRIMARY KEY (`stt`)) ENGINE = InnoDB;";
        if(conn.thucThiCauLenhSQL(sql)){
            sql = "INSERT INTO `danhsachdiemdanh` (`id`, `TenBang`) VALUES (NULL, 'diemdanh"+tenBang+"')";
            if (conn.thucThiCauLenhSQL(sql)) {
                return 1;
            } else{
                sql="DROP TABLE `testbaidat`.`diemdanh"+tenBang+"`";
                conn.thucThiCauLenhSQL(sql);
                return 2;
            }     
        };
        
        return 0;
        
    }
}
