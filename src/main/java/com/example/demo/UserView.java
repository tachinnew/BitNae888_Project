package com.example.demo;

import com.example.demo.data.EnterStatus;
/* import com.example.demo.data.Video; */
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
/* import com.vaadin.flow.component.dependency.StyleSheet; */
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
/* import com.vaadin.flow.component.page.BodySize; */
import com.vaadin.flow.router.PageTitle;
/* import com.vaadin.flow.theme.Theme; */

/* @BodySize(height = "100%", width = "100%") */
@PageTitle("BitNae888")
/* @Theme("mytheme") */
/* @StyleSheet("styles/styles.css") */
public class UserView extends VerticalLayout{
    H1 title = new H1("BitNae888");

    H5 discrib = new H5("This is BitNae888 MV");
    H5 wd = new H5("Click Picture to Topup or Withdraw the money");
    H5 un = new H5("Click Picture to see User Info");
    H5 rn = new H5("Click Picture to play Guess Number Game");
    H5 rps = new H5("Click Picture to play Rock Paper Scissor Game");
    H5 thc = new H5("Click Picture to play Three Cup Game");
    H5 cf = new H5("Click Picture to play Coin Filp Game");

    H2 space = new H2("");

    public UserView(){
        component();
    }

    /* public static void bg(){
        
    } */

    public void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponentAsFirst(imageLogo());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(logout());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(cf);
        mainLayout.addComponentAsFirst(imageCF());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(thc);
        mainLayout.addComponentAsFirst(imageThC());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(rps);
        mainLayout.addComponentAsFirst(imageRPS());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(rn);
        mainLayout.addComponentAsFirst(imageRN());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(wd);
        mainLayout.addComponentAsFirst(withdraw());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(un);
        mainLayout.addComponentAsFirst(imageUN());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(discrib);
        mainLayout.addComponentAsFirst(video());
        mainLayout.addComponentAsFirst(space);
        mainLayout.addComponentAsFirst(imageLogo());
        mainLayout.addComponentAsFirst(title);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);
    }

    public void imageLog(){
        Image image = new Image("img/BitNae_logo.png", "WebLogo");
        image.setWidth(600, Unit.PIXELS);                           
        image.setHeight(600, Unit.PIXELS);                          
        
        add(image);
    }

    /* private Component video(){
        Video video = new Video("vid/BitNae888.mp4");
        video.setMaxWidth("500px");
        
        return video;
    } */

    public Component imageLogo(){
        Image image = new Image("img/BitNae_logo.png", "WebLogo");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        return image;
    }

    public Component imageRPS(){
        Image image = new Image("img/RPS_logo.png", "RPSPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        image.addClickListener(click -> {
            UI.getCurrent().navigate("game/RockPaperScissorGame");
        });

        return image;
    }

    public Component imageRN(){
        Image image = new Image("img/RN_logo.png", "RNPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          

        image.addClickListener(click -> {
            UI.getCurrent().navigate("game/RandomNumberGame");
        });

        return image;
    }

    public Component imageUN(){
        Image image = new Image("img/UN_logo.png", "UNPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          

        image.addClickListener(click -> {
            UI.getCurrent().navigate("UserInfo");
        });

        return image;
    }

    public Component imageThC(){
        Image image = new Image("img/ThC_logo.png", "ThCPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        image.addClickListener(click -> {
            UI.getCurrent().navigate("game/ThreeCupGame");
        });

        return image;
    }

    public Component imageCF(){
        Image image = new Image("img/CF_logo.png", "CFPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          

        image.addClickListener(click -> {
            UI.getCurrent().navigate("game/CoinFilpGame");
        });

        return image;
    }

    private static final String VIDEO_URL = "https://www.youtube.com/embed/";

    // <iframe width="853" height="480" src="https://www.youtube.com/embed/ryIacCgrjn4" title="BitNae888 [Really Truly Rarely Tilly Strawberry Blueberry Cranberry Official MV]" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

    private Component video(){
        // Replace {VIDEO_ID} with the ID of the YouTube video you want to embed
        String videoId = "ryIacCgrjn4";
        String videoEmbedCode = "<iframe width=\"560\" height=\"315\" src=\"" + VIDEO_URL + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>";
        Html videoHtml = new Html(videoEmbedCode);
        return videoHtml;
    }

    private Component logout(){
        Image image = new Image("img/logoutpic.png", "logoutPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          

        image.addClickListener(click -> {
            EnterStatus.setEnterStatus(false); 
            UI.getCurrent().navigate("");
        });

        return image;
    }

    public Component withdraw(){
        Image image = new Image("img/withdraw.png", "TopPic");
        image.setWidth(200, Unit.PIXELS);                           
        image.setHeight(200, Unit.PIXELS);                          
        
        image.addClickListener(click -> {
            UI.getCurrent().navigate("TopUpAndWithDraw");
        });

        return image;
    }
}
