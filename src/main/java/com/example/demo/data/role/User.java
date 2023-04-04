package com.example.demo.data.role;

import com.example.demo.data.balance.Balance;

public class User extends Balance{

    private static String name;
    public static double balance;

    public static void setNameA(String name){
        User.name = name;
    }

    public static double getUserBalance(){
        return Balance.getBalance();
    }

    public static String getName(){
        return name;
    }

}
