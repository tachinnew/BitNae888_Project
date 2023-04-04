package com.example.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("UserForgotPassword")
@PageTitle("BitNae888")
public class FogetPassword extends VerticalLayout{

    H1 name = new H1("You forgot the password?");
    H2 text = new H2("Scan this QR Code then text the HQ for your password");

    H1 space = new H1("");
    
    public FogetPassword(){
        component();
        image();
        space();
        backToLogin();
    }

    public void space(){
        add(space);
        add(space);
    }

    public void image (){
        VerticalLayout imageLayout = new VerticalLayout();

        Image image = new Image("img/BitNaeQR.png", "QR_Code");

        image.setWidth(200, Unit.PIXELS);              
        image.setHeight(200, Unit.PIXELS);    

        imageLayout.addComponentAsFirst(image);

        imageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
                   
        add(imageLayout);
    }

    public void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(name);
        mainLayout.addComponentAsFirst(text);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);
    }

    public void backToLogin(){
        VerticalLayout imageLayout = new VerticalLayout();

        Image image = new Image("img/b2login.png", "B2Login");

        image.setWidth(200, Unit.PIXELS);              
        image.setHeight(200, Unit.PIXELS);    

        imageLayout.addComponentAsFirst(image);

        imageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        image.addClickListener(click ->{
            Notification.show("User go back to Login Page");
            UI.getCurrent().navigate("");
            // UI.getCurrent().getPage().reload();
        });
                   
        add(imageLayout);
    }
}
