package com.example.demo.data;

import java.util.ArrayList;

import com.vaadin.flow.component.notification.Notification;

public class Password {
    private static ArrayList<String> pCollecter = new ArrayList<String>();
    private static ArrayList<String> iCollecter = new ArrayList<String>();
    private static ArrayList<String> adminICollecter = new ArrayList<String>();

    private static boolean iAlreadyCheck = false;
    private static boolean pAlreadyCheck = false;
    private static boolean isAdmin = false;
    private static boolean isUser = false;

    private static String userName;

    public static void startPassword(){
        addPassword("TachinTheAdmin1","qazwsxedc123");
        addPassword("TachinTheAdmin2","1234");
        addPassword("User","1234");
        addPassword("Admin","1234");
        addAdmin("TachinTheAdmin1");
        addAdmin("Admin");
    }

    public static void forgetPass(String ID){
        int locate = indexPassword(ID);
        if(locate == 99999){
            Notification.show("The ID that you put in didnt have in data");
        }
        else{
            Notification.show("The Password for "+ iCollecter.get(locate) + " is " + pCollecter.get(locate));
        }
    }

    private static int indexPassword(String ID){
        checkUserID(ID);
        if(Password.isUser){
            return iCollecter.indexOf(ID); 
        }
        return 99999;
    }

    private static void checkUserID(String ID){
        for(int i = 0 ; i < iCollecter.size() ;i++){
            if(ID.equals(iCollecter.get(i))){
                Password.isUser = true;
                return;
            }
        }
        Password.isUser = false;
    }

    private static void setUserName(String name){
        userName = name;
    }

    public static String getUserName(){
        return userName;
    }

    private static void setIA(boolean status){
        iAlreadyCheck = status;
    }

    private static void setPA(boolean status){
        pAlreadyCheck = status;
    }

    public static boolean getIA(){
        return iAlreadyCheck;
    }

    public static boolean getPA(){
        return pAlreadyCheck;
    }

    public static boolean getIAD(){
        return isAdmin;
    }

    public static void addPassword(String ID,String Password){
        iCollecter.add(ID);
        pCollecter.add(Password);
    }

    protected static void addAdmin(String IDa){
        adminICollecter.add(IDa);
    }

    public static void checkRole(String IDw){
        for(int i = 0 ; i < adminICollecter.size() ; i++){
            if(IDw.equals(adminICollecter.get(i))){
                isAdmin = true;
            }
        }
    }

    public static void setIsAd(boolean status){
        Password.isAdmin = status;
    }

    public static void checkUserIDP(String IDw,String Passwordw){
        for(int i = 0 ; i < iCollecter.size() ;i++){
            if(IDw.equals(iCollecter.get(i))){
                setIA(true);
                if(Passwordw.equals(pCollecter.get(i))){
                    setUserName(IDw);
                    setPA(true);
                    return;
                }
                setIA(false);
            }
        }
    }

    protected static void getPassword(){
        return ;
    }


}
