package com.example.demo.data.balance;

import com.example.demo.data.role.User;

public class Balance {

    public static void setBalance(double balance){
        User.balance = balance;
    }

    public static double getBalance(){
        return User.balance;
    }

    public static void withDraw(double money){
        User.balance -= money;
    }

    public static void addBalance(double money){
        User.balance += money;
    }

    public static void delBalance(double money){
        User.balance -= money;
    }

}
