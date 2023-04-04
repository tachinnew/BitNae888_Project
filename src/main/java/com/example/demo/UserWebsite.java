package com.example.demo;

import com.example.demo.data.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("userView")
@PageTitle("BitNae888")
public class UserWebsite extends VerticalLayout{

    public UserWebsite() throws Exception{ 
        if(EnterStatus.getEnterStatus()){
            add(new UserView());
            return;
        }
        throw new Exception("You cann't reach webnsite without login!!");
    }

}
