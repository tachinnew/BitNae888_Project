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
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("game/CoinFilpGame")
@PageTitle("BitNae888")
public class CoinFilp extends VerticalLayout{
    
    private static Random rand = new Random();
    private static int randomNumber = rand.nextInt(2);

    private boolean isWin = false;
    
    private static int getRand(){
        return CoinFilp.randomNumber;
    }

    private static double getRands = getRand();

    H1 title = new H1("Three Cup Game");
    H2 discribe = new H2("You need to guess the coin which it Head or Tail");
    H2 resultOfCoin = new H2("");
    NumberField betAmount = new NumberField("How much you going to bet this time: ");
    TextField yourGuess = new TextField("Your Guess (H or T): ");
    Button letgo = new Button("Let lose all your money");

    public CoinFilp() throws Exception{
        if(EnterStatus.getEnterStatus()){
            component();
            return;
        }
        throw new Exception("You cann't reach webnsite without login!!");
    }

    private void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        yourGuess.setRequiredIndicatorVisible(true);
        betAmount.setRequiredIndicatorVisible(true);

        mainLayout.addComponentAsFirst(backToLobby());
        mainLayout.addComponentAsFirst(letgo);
        mainLayout.addComponentAsFirst(betAmount);
        mainLayout.addComponentAsFirst(yourGuess);
        mainLayout.addComponentAsFirst(resultOfCoin);
        mainLayout.addComponentAsFirst(title);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);

        letgo.addClickListener(click ->{
            if(enoughMoney()){
                resultOfCoin.setText(sCoin());
                startGame();
                startCalculate();
                sleep(2000);
                UI.getCurrent().getPage().reload();
                return;
            }
            Notification.show("You dont have enough money to bet");
        });
    }

    private String sCoin(){
        double coin = getRands;
        
        if(coin == 0)
        {
            return "Head";
        }

        else if(coin == 1)
        {
            return "Tail";
        }

        else
        {
        return "";
        }
    }

    private String convertAnswer(){
        String user = yourGuess.getValue();

        if(user.equals("H")){
            return "Head";
        }
        else if(user.equals("T")){
            return "Tail";
        }
        else{
            return "Huh";
        }
    }

    private void startGame(){
        String ans = sCoin();
        String user = convertAnswer();

        if(ans.equals(user)){
            isWin = true;
            return;
        }
        isWin = false;
    }

    private void startCalculate(){
        if(isWin){
            Notification.show("Congrat You win");
            printOut(calculateAddBet());
            return;
        }
        Notification.show("Nice try bet more an make your answer must easier to correct :P");
        printOut(calculateDelBet());
    }

    private void printOut(double A){
        Notification.show("Your Balance : " + Double.toString(A));
    }

    private double calculateAddBet(){
        double add = betAmount.getValue()*0.1;
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

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean enoughMoney(){
        double moneyU = User.balance;
        double moneyB = betAmount.getValue();

        if(moneyU >= moneyB){
            return true;
        }
        return false;
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
