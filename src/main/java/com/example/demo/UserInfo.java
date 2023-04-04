package com.example.demo;

import com.example.demo.data.EnterStatus;
import com.example.demo.data.role.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("UserInfo")
@PageTitle("BitNae888")
public class UserInfo extends VerticalLayout {

    H1 userName = new H1("Your name : " + User.getName());
    H1 userBalance = new H1("Your Balance : " + User.getUserBalance());

    H1 space = new H1("");
    
    public UserInfo() throws Exception{
        if(EnterStatus.getEnterStatus()){
            component();
            return;
        }
        throw new Exception("You cann't reach webnsite without login!!");
    }

    private void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(backToLobby());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(userBalance);
        mainLayout.addComponentAsFirst(userName);

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
