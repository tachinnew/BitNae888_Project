package com.example.demo;

import com.example.demo.data.EnterStatus;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("TopUpAndWithDraw")
@PageTitle("BitNae888")
public class TopWith extends VerticalLayout{
    H1 name = new H1("Topup and Withdraw");
    H5 text = new H5("Scan this QR Code then text the HQ for topup or withdraw the money");

    H1 space = new H1("");
    
    public TopWith()throws Exception{
        if(EnterStatus.getEnterStatus()){
            component();
            return;
        }
        throw new Exception("You cann't reach webnsite without login!!");
    }
    
    public Component image(){
        VerticalLayout imageLayout = new VerticalLayout();

        Image image = new Image("img/BitNaeQR.png", "QR_Code");

        image.setWidth(200, Unit.PIXELS);              
        image.setHeight(200, Unit.PIXELS);    

        imageLayout.addComponentAsFirst(image);

        imageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
                   
        return imageLayout;
    }

    public void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(backToLobby());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(image());
        mainLayout.addComponentAsFirst(text);
        mainLayout.addComponentAsFirst(name);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);
    }

    public Component backToLobby(){
        VerticalLayout imageLayout = new VerticalLayout();

        Image image = new Image("img/b2lobby.png", "B2Lobby");

        image.setWidth(200, Unit.PIXELS);              
        image.setHeight(200, Unit.PIXELS);    

        imageLayout.addComponentAsFirst(image);

        imageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        image.addClickListener(click ->{
            Notification.show("User go back to Lobby");
            UI.getCurrent().navigate("userView");
        });
                   
        return imageLayout;
    }
}
