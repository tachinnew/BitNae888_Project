package com.vaadin.demo.component.login;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.example.demo.data.*;
import com.example.demo.data.balance.Balance;
import com.example.demo.data.role.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("BitNae888")
public class LoginPage extends Div {    

    private LoginOverlay loginOverlay = new LoginOverlay();

    public String userName;

    public LoginPage() {
        loginOverlay.setTitle("BitNae888");
        loginOverlay.setDescription("This is not actualy an gambling website");
        loginOverlay.setOpened(true);
        loginOverlay.getElement().setAttribute("no-autofocus", "");

        add(loginOverlay);

        loginOverlay.addLoginListener(event ->{
            Password.checkUserIDP(event.getUsername(), event.getPassword());
            if(Password.getIA()){
                if(Password.getPA()){
                    Password.checkRole(event.getUsername());
                    if(Password.getIAD()){
                        Notification.show("Welcome Admin of BitNae888");
                        EnterStatus.setEnterAdminStatus(true);
                        EnterStatus.setEnterStatus(true);
                        UI.getCurrent().navigate("admin");
                        return;
                    }
                    User.setNameA(event.getUsername());
                    if(Balance.getBalance() == 0){
                        Balance.setBalance(100);
                    }
                    Notification.show("Welcome to BitNae888");
                    EnterStatus.setEnterStatus(true);
                    UI.getCurrent().navigate("userView"); 
                    return;
                }
                Notification.show("Wrong Id or Password boi!");
                return;
            }
            Notification.show("Wrong Id or Password boi!");

        });

        loginOverlay.addForgotPasswordListener(event ->{
            Notification.show("User Forgot The Password?");
            UI.getCurrent().navigate("UserForgotPassword");
        });
    }

}