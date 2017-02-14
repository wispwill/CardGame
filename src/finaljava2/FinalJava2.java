

package finaljava2;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author lj38697, Laura Josuweit
 */
public class FinalJava2 extends Application
{
    
        int losses = 0;//counts for wins, losses, etc.
        int wins = 0;
        int draws = 0; 
        
        int yourval = 0;//current card value of players
        int theirval = 0;
        
        boolean roundover = false;//is the round over?
        boolean scored = false;//has the round been scored yet?
       
        
               
    @Override
    public void start(Stage stage)
    {
        
        Random rand = new Random();
        
        BorderPane pane = new BorderPane();
        HBox cards = new HBox();//cards pane
        HBox nodes = new HBox();//pane for buttons ad textfield to hold wins
        
        //line things up nice
        cards.setAlignment(Pos.CENTER);
        cards.setSpacing(10);
        cards.setPadding(new Insets(10,10,10,10));
        
        nodes.setAlignment(Pos.CENTER);
        nodes.setSpacing(10);
        nodes.setPadding(new Insets(10,10,10,10));
        

        
        TextField tbox = new TextField("Wins: 0 Draws: 0 Losses: 0");
        
       ArrayList<Image> images = new ArrayList<>();
       
       for (int i = 1; i <= 52; i++) 
       {
           images.add(new Image(i+".png"));
       }
        
       
        //if we were going to display many cards, we would just use an array
        //since there is only 4, I just typed them out.
        //same thing for their mouse event handlers, we could just do a loop
        //using array indexs.
        ImageView imv1 = new ImageView("backCard.png");
        ImageView imv2 = new ImageView("backCard.png");
        ImageView imv3 = new ImageView("backCard.png");
        ImageView imv4 = new ImageView("backCard.png");
        
        
        Button chkwinner = new Button("Check Winner");
        Button next = new Button("New Round");
        
        //image view 1 clicking event handler
        imv1.setOnMouseClicked(e ->
        {
           if(yourval == 0)
           {
              int cardval = (rand.nextInt(52)+1);//random card for them
              
              imv1.setImage(images.get(cardval -1));
              
              yourval = (cardval - 1) % 13;
               //to get integer value, not just
              //the count of what card it is
              //14.png is an ace, it should be beaten by a 2, like 2.png.
              //We need to subtract one so that kings
              //(which are 13, 26, etc, all divisible by 13) come out bigger
              //than everything else instead of smaller (13 % 13 = 0)
           }
           else if(yourval > 0 && theirval == 0)
           {
              int cardval = (rand.nextInt(53)+1);//random card for opponent
              
              imv1.setImage(images.get(cardval - 1));
              //carval -1 for its index
              
              theirval = (cardval - 1) % 13;
              
              roundover = true;
              //round is now over, second car has been drawn.
           }
        });
        //image view 2
        imv2.setOnMouseClicked(e ->
        {
           if(yourval == 0)
           {
              int cardval = (rand.nextInt(52)+1);//random card for them
              
              imv2.setImage(images.get(cardval- 1));
              
              yourval = (cardval - 1) % 13;
           }
           else if(yourval > 0 && theirval == 0)
           {
              int cardval = (rand.nextInt(53)+1);//random card for opponent
              
              imv2.setImage(images.get(cardval- 1));
              
              theirval = (cardval - 1) % 13;
              
              roundover = true;
           }
        });
        //image view 3
        imv3.setOnMouseClicked(e ->
        {
           if(yourval == 0)
           {
              int cardval = (rand.nextInt(52)+1);//random card for them
              
              imv3.setImage(images.get(cardval- 1));
              
              yourval = (cardval - 1) % 13;
           }
           else if(yourval > 0 && theirval == 0)
           {
              int cardval = (rand.nextInt(53)+1);//random card for opponent
              
              imv3.setImage(images.get(cardval- 1));
              
              theirval = (cardval - 1) % 13;
              
              roundover = true;
           }
        });
        //image view 4
        imv4.setOnMouseClicked(e ->
        {
           if(yourval == 0)
           {
              int cardval = (rand.nextInt(52)+1);//random card for them
              
              imv4.setImage(images.get(cardval- 1));
              
              yourval = (cardval - 1) % 13;
           }
           else if(yourval > 0 && theirval == 0)
           {
              int cardval = (rand.nextInt(53)+1);//random card for opponent
              
              imv4.setImage(images.get(cardval- 1));
              
              theirval = (cardval - 1) % 13;
              
              roundover = true;
              
           }
        });
        
       
        
        
        //check for wins and losses button event handler stuff
        chkwinner.setOnAction(e -> 
        {
            //make sure the round is over and has not been scored yet
            if(yourval > theirval && roundover && !scored)//win
            {
                wins += 1;
                tbox.setText("Wins: "+wins+" Draws: "+draws+
                        " Losses: "+losses);
                scored = true;
            }
            else if(theirval > yourval && roundover && !scored)//loss
            {
                losses += 1;
                
                tbox.setText("Wins: "+wins+" Draws: "+draws+
                        " Losses: "+losses);
                scored = true;
            }
            else if (roundover && !scored)//draw
            {
                draws += 1;
                
                tbox.setText("Wins: "+wins+" Draws: "+draws+
                        " Losses: "+losses);
                scored = true;
            }
            
        });
        
        //reset game button event handler stuff
        next.setOnAction(e -> 
        {
            //reset cards
            
            imv1.setImage(new Image("backCard.png"));
            imv2.setImage(new Image("backCard.png"));
            imv3.setImage(new Image("backCard.png"));
            imv4.setImage(new Image("backCard.png"));
            
            //reset scores
            yourval = 0;
            theirval = 0;
            //play again
            roundover = false; 
            scored = false;
            
        });
        
    
        
        cards.getChildren().addAll(imv1, imv2, imv3, imv4);
        nodes.getChildren().addAll(chkwinner, next, tbox);
        pane.setTop(cards);
        pane.setBottom(nodes);
        
        
        Scene scene = new Scene(pane, 400, 200);
        stage.setTitle("Laura's Card Game");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }

   
}
