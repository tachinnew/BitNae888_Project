package com.example.demo;

import com.example.demo.data.EnterStatus;
import com.example.demo.data.Password;
import com.vaadin.demo.component.login.LoginPage;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("")
@PageTitle("BitNae888")
public class MainView extends VerticalLayout{
    
    public MainView(){ 
        EnterStatus.setEnterAdminStatus(false);
        Password.startPassword();
        add(new LoginPage());
    }

}
