//Joe Chapman, Michael Bacu, Nick Chapman

//Final Project Sorry!

//CPT-237-W34

//Spring 2023


import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.text.*; 
import javafx.scene.paint.*; 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.net.URL;
import javafx.stage.Stage;


public class PlayersFour {
    public void changeTurn(Text text, Rectangle rectangle, ImageView Red1, ImageView Red2, ImageView Red3, ImageView Red4, ImageView Blue1, ImageView Blue2, ImageView Blue3, ImageView Blue4, ImageView Yellow1, ImageView Yellow2, ImageView Yellow3, ImageView Yellow4, ImageView Green1, ImageView Green2, ImageView Green3, ImageView Green4) {
        
        
         if(text.getText().equals("It is Red's Turn!\n\n" + "Please choose a card!")) {
        text.setText("It is Blue's Turn!\n\n" + "Please choose a card!");
        rectangle.setFill(Color.BLUE);
        Red1.setDisable(true);
        Red2.setDisable(true);
        Red3.setDisable(true);
        Red4.setDisable(true);
        Blue1.setDisable(false);
        Blue2.setDisable(false);
        Blue3.setDisable(false);
        Blue4.setDisable(false);
        Yellow1.setDisable(true);
        Yellow2.setDisable(true);
        Yellow3.setDisable(true);
        Yellow4.setDisable(true);
        Green1.setDisable(true);
        Green2.setDisable(true);
        Green3.setDisable(true);
        Green4.setDisable(true);
      }
      else if (text.getText().equals("It is Blue's Turn!\n\n" + "Please choose a card!")) {
        text.setText("It is Yellow's Turn!\n\n" + "Please choose a card!");
        rectangle.setFill(Color.YELLOW);
        Red1.setDisable(true);
        Red2.setDisable(true);
        Red3.setDisable(true);
        Red4.setDisable(true);
        Blue1.setDisable(true);
        Blue2.setDisable(true);
        Blue3.setDisable(true);
        Blue4.setDisable(true);
        Yellow1.setDisable(false);
        Yellow2.setDisable(false);
        Yellow3.setDisable(false);
        Yellow4.setDisable(false);
        Green1.setDisable(true);
        Green2.setDisable(true);
        Green3.setDisable(true);
        Green4.setDisable(true);
      }
      else if (text.getText().equals("It is Yellow's Turn!\n\n" + "Please choose a card!")) {
        text.setText("It is Green's Turn!\n\n" + "Please choose a card!");
        rectangle.setFill(Color.GREEN);
        Red1.setDisable(true);
        Red2.setDisable(true);
        Red3.setDisable(true);
        Red4.setDisable(true);
        Blue1.setDisable(true);
        Blue2.setDisable(true);
        Blue3.setDisable(true);
        Blue4.setDisable(true);
        Yellow1.setDisable(true);
        Yellow2.setDisable(true);
        Yellow3.setDisable(true);
        Yellow4.setDisable(true);
        Green1.setDisable(false);
        Green2.setDisable(false);
        Green3.setDisable(false);
        Green4.setDisable(false);
      }
      else if (text.getText().equals("It is Green's Turn!\n\n" + "Please choose a card!")) {
        text.setText("It is Red's Turn!\n\n" + "Please choose a card!");
        rectangle.setFill(Color.RED);
        Red1.setDisable(false);
        Red2.setDisable(false);
        Red3.setDisable(false);
        Red4.setDisable(false);
        Blue1.setDisable(true);
        Blue2.setDisable(true);
        Blue3.setDisable(true);
        Blue4.setDisable(true);
        Yellow1.setDisable(true);
        Yellow2.setDisable(true);
        Yellow3.setDisable(true);
        Yellow4.setDisable(true);
        Green1.setDisable(true);
        Green2.setDisable(true);
        Green3.setDisable(true);
        Green4.setDisable(true);
        }
}
        
    }
