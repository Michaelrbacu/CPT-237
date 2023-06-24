//Joe Chapman, Michael Bacu, Nick Chapman

//Final Project Sorry!

//CPT-237-W34

//Spring 2023


import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.net.URL;
import javafx.stage.Stage;
import java.util.*;  
import javafx.scene.control.Alert.AlertType;



public class PawnDetector {

      public static boolean alertShown = false;
      
    public static void addPawnDetection(ImageView pawn1, ImageView pawn2, ImageView pawn3, ImageView pawn4, Rectangle detectionArea) {
        ChangeListener<Bounds> boundsListener = new ChangeListener<Bounds>() {
            @Override
            
            
            public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
            
               GameWindow gameWindow = new GameWindow();
            
                if (!alertShown && pawn1.getBoundsInParent().intersects(detectionArea.getBoundsInParent()) &&
                    pawn2.getBoundsInParent().intersects(detectionArea.getBoundsInParent()) &&
                    pawn3.getBoundsInParent().intersects(detectionArea.getBoundsInParent()) &&
                    pawn4.getBoundsInParent().intersects(detectionArea.getBoundsInParent())) {
             
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("WINNER");
                    alert.setHeaderText("All 4 pawns are in the Home area!");
                    alert.setContentText("Return to Main Menu?");
                    Optional<ButtonType> result = alert.showAndWait();
                    alertShown = true;


                     
                    // Restart the game if the user clicked "OK"
                    if (result.get() == ButtonType.OK)
                    {
                        
                       Stage currentStage = (Stage) pawn1.getScene().getWindow();
                       currentStage.close();
                       gameWindow.start(new Stage());
                       
                       
                     
                    } 
                
                }
            
            }
            
        };

        pawn1.boundsInParentProperty().addListener(boundsListener);
        pawn2.boundsInParentProperty().addListener(boundsListener);
        pawn3.boundsInParentProperty().addListener(boundsListener);
        pawn4.boundsInParentProperty().addListener(boundsListener);
    }
}