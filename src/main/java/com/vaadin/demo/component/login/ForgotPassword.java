package com.vaadin.demo.component.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ForgotPassword extends VerticalLayout{
    H1 title = new H1("BitNae888");
    H2 h2 = new H2("Welcome to forgot your password page");

    public ForgotPassword(){
        UI.getCurrent().getPage().reload();
        add(title);
        add(h2);
    }
}
