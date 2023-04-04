package com.example.demo.data.game;

import java.util.Random;

import com.example.demo.data.EnterStatus;
import com.example.demo.data.balance.Balance;
import com.example.demo.data.role.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("game/ThreeCupGame")
@PageTitle("BitNae888")
public class ThreeCup extends VerticalLayout{

    private static Random rand = new Random();
    private static int randomNumber = rand.nextInt(3);

    private boolean isWin = false;

    private boolean rClick = false;
    private boolean mClick = false;
    private boolean lClick = false;
    
    private static int getRand(){
        return ThreeCup.randomNumber;
    }

    H1 title = new H1("Three Cup Game");
    H2 discribe = new H2("Chose 1 cup between 3 cup if it has coin in it you win the game");
    H2 select = new H2("You didnt choose yet");
    NumberField betAmount = new NumberField("How much you going to bet this time: ");
    Button letgo = new Button("Let lose all your money");

    public ThreeCup() throws Exception{
        if(EnterStatus.getEnterStatus()){
            component();
            return;
        }
        throw new Exception("You cann't reach webnsite without login!!");
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

    private boolean enoughMoney(){
        double moneyU = User.balance;
        double moneyB = betAmount.getValue();

        if(moneyU >= moneyB){
            return true;
        }
        return false;
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Component cup(){
        HorizontalLayout cupLayout = new HorizontalLayout();

        cupLayout.addComponentAsFirst(cupR());
        cupLayout.addComponentAsFirst(cupM());
        cupLayout.addComponentAsFirst(cupL());

        cupLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        return cupLayout;
    }

    private Component cupL(){
        Image image = new Image("img/lCUP.png", "lCupPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        image.addClickListener(click -> {

            select.setText("You choose Left cup");

            lClick = true;

            if(mClick || rClick){
                mClick = false;
                rClick = false;
            }
        });

        return image;
    }

    private Component cupM(){
        Image image = new Image("img/mCUP.png", "mCupPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        image.addClickListener(click -> {

            select.setText("You choose Middle cup");

            mClick = true;

            if(lClick || rClick){
                lClick = false;
                rClick = false;
            }
        });

        return image;
    }

    private Component cupR(){
        Image image = new Image("img/rCUP.png", "rCupPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        image.addClickListener(click -> {

            select.setText("You choose Right cup");

            rClick = true;

            if(mClick || lClick){
                mClick = false;
                lClick = false;
            }
        });

        return image;
    }

    private void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        betAmount.setRequiredIndicatorVisible(true);

        mainLayout.addComponentAsFirst(backToLobby());
        mainLayout.addComponentAsFirst(letgo);
        mainLayout.addComponentAsFirst(betAmount);
        mainLayout.addComponentAsFirst(select);
        mainLayout.addComponentAsFirst(cup()); 
        mainLayout.addComponentAsFirst(discribe);
        mainLayout.addComponentAsFirst(title);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);

        letgo.addClickListener(click ->{
            if(enoughMoney()){
                startGame();
                whoWin();
                sleep(1000);
                UI.getCurrent().getPage().reload();
                return;
            }
            Notification.show("You dont have enough money to bet");
        });
    }

    private void startGame(){
        cupBotCheck();
        cupUserCheck();
    }

    private void whoWin(){
        if(isWin){
            Notification.show("You choose the Right one you won");
            printOut(calculateAddBet());
            return;
        }
        printOut(calculateDelBet());
        Notification.show("You choose the Wrong one you lose hahaha");
    }

    private void cupUserCheck(){
        if(rClick){
            if(cupBotCheck().equals("R")){
                isWin = true;
            }
        }
        else if(mClick){
            if(cupBotCheck().equals("M")){
                isWin = true;
            }
        }
        else if(lClick){
            if(cupBotCheck().equals("L")){
                isWin = true;
            }
        }
        else{
            isWin = false;
            Notification.show("You choose the Wrong one you lose hahaha");
        }
    }

    private String cupBotCheck(){
        if(getRand() == 0){
            return "L";
        }
        else if(getRand() == 1){
            return "M";
        }
        else if(getRand() == 2){
            return "R";
        }
        else{
            return "Huh";
        }
    }

    private void printOut(double A){
        Notification.show("Your Balance : " + Double.toString(A));
    }

    private double calculateAddBet(){
        double add = betAmount.getValue()*0.3;
        double result = User.balance + add;
        Balance.addBalance(add);
        return result;
    }

    private double calculateDelBet(){
        double del = betAmount.getValue();
        double result = User.balance - del;
        Balance.delBalance(del);
        return result;
    }
}
