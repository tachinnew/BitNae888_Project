package com.example.demo;

import com.example.demo.data.EnterStatus;
import com.example.demo.data.Password;
import com.example.demo.data.balance.Balance;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("admin")
@PageTitle("BitNae888")
public class AdminView extends VerticalLayout{

    H1 title = new H1("BitNae888");
    H2 welcome = new H2("Welcome Admin!");
    H1 space = new H1("");

    H2 text1 = new H2("Check Password for User that forget it here");
    TextField forgetPass = new TextField("For Forget Password");
    Button check = new Button("Check!");

    H2 text2 = new H2("Add new ID Password for new User here");
    TextField idAsk = new TextField("Enter new ID");
    TextField passAsk = new TextField("Enter new Password");
    Button add = new Button("Add!");

    H2 text3 = new H2("Add balance for user here");
    TextField idAdd = new TextField("Enter ID");
    NumberField balance = new NumberField("Enter the amoung of money");
    Button addBal = new Button("Add!");

    public AdminView()throws Exception{ 
        if(EnterStatus.getEnterAdminStatus()){
            component();
            return;
        }
        throw new Exception("You cann't reach webnsite if u r not admin!!");
    }

    private Component forgetP(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(check);
        mainLayout.addComponentAsFirst(forgetPass);
        mainLayout.addComponentAsFirst(text1);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        
        check.addClickListener(click -> {
            Password.forgetPass(forgetPass.getValue());
        });

        return mainLayout;
    }

    private Component addP(){
        VerticalLayout layout = new VerticalLayout();

        layout.addComponentAsFirst(add);
        layout.addComponentAsFirst(passAsk);
        layout.addComponentAsFirst(idAsk);
        layout.addComponentAsFirst(text2);

        layout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        
        add.addClickListener(click -> {
            Password.addPassword(idAsk.getValue(), passAsk.getValue());
        });

        return layout;
    }

    private Component addBalance(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(addBal);
        mainLayout.addComponentAsFirst(balance);
        mainLayout.addComponentAsFirst(idAdd);
        mainLayout.addComponentAsFirst(text3);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        
        addBal.addClickListener(click -> {
            Balance.addBalance(balance.getValue());
        });

        return mainLayout;
    }

    protected void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(backToLogin());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(forgetP());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(addP());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(addBalance());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(welcome);
        mainLayout.addComponentAsFirst(logo());
        mainLayout.addComponentAsFirst(title);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);
    }

    private Component backToLogin(){
        VerticalLayout imageLayout = new VerticalLayout();

        Image image = new Image("img/b2login.png", "B2Login");

        image.setWidth(200, Unit.PIXELS);              
        image.setHeight(200, Unit.PIXELS);    

        imageLayout.addComponentAsFirst(image);

        imageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        image.addClickListener(click ->{
            Password.setIsAd(false);
            Notification.show("User go back to Login Page");
            UI.getCurrent().navigate("");
        });
                   
        return imageLayout;
    }

    private Component logo(){
        VerticalLayout imageLayout = new VerticalLayout();

        Image image = new Image("img/BitNae_Logo.png", "logo");

        image.setWidth(200, Unit.PIXELS);              
        image.setHeight(200, Unit.PIXELS);    

        imageLayout.addComponentAsFirst(image);

        imageLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
                   
        return imageLayout;
    }
}
