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


public class playersTwo {
    public void changeTurn( Text text, Rectangle rectangle, ImageView Red1, ImageView Red2, ImageView Red3, ImageView Red4, ImageView Blue1, ImageView Blue2, ImageView Blue3, ImageView Blue4) {
        
        
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

      }
      else if (text.getText().equals("It is Blue's Turn!\n\n" + "Please choose a card!")) {
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

      }      
}
        
    }
