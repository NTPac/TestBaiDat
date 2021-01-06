/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntppackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class diemdanhAction {
    private String id;
    private List<String> list = new ArrayList<String>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    

    
    
    public diemdanhAction() {
        
    }
    
    public String execute() throws Exception {
        String currentDate = LocalDate.now().toString();
        ConnectDBClass conn = new ConnectDBClass();
        int x = list.size();
        int dem = 0;
        if(x!=0){
        for(int i =0;i<=x;i++){
            if(list.get(i)!=""){
                dem=1;
            }
        }
        if(dem==1){
            conn.thucThiCauLenhSQL("ALTER TABLE `"+id+"` ADD `"+currentDate+"` INT  NULL");
            for(int i =0;i<=x;i++){
            if(list.get(i)!=""){
                conn.thucThiCauLenhSQL("UPDATE `"+id+"` SET `"+currentDate+"`=1 WHERE `stt`="+list.get(i));
            }
        }
        }}
        return "T";
    }
    
}
