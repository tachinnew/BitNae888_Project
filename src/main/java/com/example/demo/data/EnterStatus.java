package com.example.demo.data;

public class EnterStatus {
    private static boolean enterStatus = false;
    private static boolean enterAdminStatus = false;

    static public void setEnterStatus(boolean aenterStatus){
        enterStatus = aenterStatus;
    }

    static public boolean getEnterStatus(){
        return enterStatus;
    }

    static public void setEnterAdminStatus(boolean EnterAdminStatus){
        enterAdminStatus = EnterAdminStatus;
    }

    static public boolean getEnterAdminStatus(){
        return enterAdminStatus;
    }
}
