//Joe Chapman, Michael Bacu, Nick Chapman

//Final Project Sorry!

//CPT-237-W34

//Spring 2023

import java.awt.*;
import javax.swing.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.util.Optional;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Dialog;


public class GameWindow extends Application
{
   public static int input3;
   
   Stage window;
   static Scene scene1, scene2;
   
   private static int playerNum;    
   private final int PLAYER_MAX = 4;
   private final int PLAYER_MIN = 2;
   
   public Stage stage;

   
   public static void main(String[] args) 
   {
      launch(args);
	}

   public void start(final Stage primaryStage) {
   
      StackPane root = new StackPane();
      root.setStyle("-fx-background-color: #D5d5d5;"); // set background color
      
      // Create button styles
      String buttonStyle = "-fx-background-color: #DC143C; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: Arial;";
      String buttonHoverStyle = "-fx-background-color: #ff5858; -fx-text-fill: white; -fx-font-size: 20px; -fx-font-family: Arial;";
      
      // Create button for starting a new game
      Button button = new Button("Start a new game");
      button.setStyle(buttonStyle);
      button.setOnMouseEntered(e -> button.setStyle(buttonHoverStyle)); // change style on hover
      button.setOnMouseExited(e -> button.setStyle(buttonStyle)); // reset style when mouse exits
      button.setTranslateY(150);
      button.setTranslateX(0);
      
      // Create button for instructions
      Button htpBtn = new Button("How to Play");
      htpBtn.setStyle(buttonStyle);
      htpBtn.setOnMouseEntered(e -> htpBtn.setStyle(buttonHoverStyle));
      htpBtn.setOnMouseExited(e -> htpBtn.setStyle(buttonStyle));
      htpBtn.setTranslateY(200);
      htpBtn.setTranslateX(0);
      
      // Create button for exiting the game
      Button exitBtn = new Button("Exit");
      exitBtn.setStyle(buttonStyle);
      exitBtn.setOnMouseEntered(e -> exitBtn.setStyle(buttonHoverStyle));
      exitBtn.setOnMouseExited(e -> exitBtn.setStyle(buttonStyle));
      exitBtn.setTranslateY(280);
      exitBtn.setTranslateX(0);
      
      // Create button for navigating to the next instruction page
      Button nextBtn = new Button("Next");
      nextBtn.setStyle(buttonStyle);
      nextBtn.setOnMouseEntered(e -> nextBtn.setStyle(buttonHoverStyle));
      nextBtn.setOnMouseExited(e -> nextBtn.setStyle(buttonStyle));
      nextBtn.setTranslateY(80);
      nextBtn.setTranslateX(-480);
      nextBtn.setVisible(false);
      
      //Back button out of the how to play section
      Button backBtn = new Button("Back");
      backBtn.setStyle(buttonStyle);
      backBtn.setOnMouseEntered(e -> backBtn.setStyle(buttonHoverStyle));
      backBtn.setOnMouseExited(e -> backBtn.setStyle(buttonStyle));
      backBtn.setTranslateY(130);
      backBtn.setTranslateX(-480);
      backBtn.setVisible(false);
      
      // Create image of the game board
      Image board = new Image("File:HomeLogo.jpg");
      ImageView B = new ImageView();
      B.setFitWidth(400);
      B.setFitHeight(400);
      B.setImage(board);
      B.setTranslateY(-100);
      
      // Create images of the instructions
      Image rules = new Image("File:rules.png");
      ImageView pic = new ImageView();
      pic.setFitWidth(650);
      pic.setFitHeight(650);
      pic.setImage(rules);
      pic.setVisible(false);
      
      Image rules2 = new Image("File:rules2.png");
      ImageView pic2 = new ImageView();
      pic2.setFitWidth(650);
      pic2.setFitHeight(650);
      pic2.setImage(rules2);
      pic2.setVisible(false);

        
      htpBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
            	nextBtn.setVisible(true);
               
               B.setVisible(false);
               
               pic.setVisible(true);
               
               pic2.setVisible(false);
               
               backBtn.setVisible(true);
               
            }
		});


      nextBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
			public void handle(ActionEvent event) {
         
      if (nextBtn.getText().equals("Next")) {
        nextBtn.setText("Prev");
               pic.setVisible(false);
               pic2.setVisible(true);
               
      } else {
        nextBtn.setText("Next");
               pic.setVisible(true);
               pic2.setVisible(false);
               }
            }
		});
      
      
      backBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
			public void handle(ActionEvent event) {
                  pic.setVisible(false);
                  pic2.setVisible(false);
                  nextBtn.setVisible(false);
                  backBtn.setVisible(false);
                  B.setVisible(true);
          }
		});

      TextInputDialog Dialog = new TextInputDialog("");
      Dialog.setHeaderText("Please enter a valid number of players to play (2-4).");
      
      Dialog<String> dialog2 = new Dialog<String>();
      dialog2.setTitle("Error");
      ButtonType OkBtn = new ButtonType("Ok", ButtonData.OK_DONE);
      dialog2.setContentText("Please input a number between 2-4");
      //Adding buttons to the dialog pane
      dialog2.getDialogPane().getButtonTypes().add(OkBtn);
          
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

         
         
            //playerNum = Integer.parseInt( JOptionPane.showInputDialog( "Please enter a valid number of players to play (2-4)." ) );
            Optional<String> input = Dialog.showAndWait();
            
            String input2 = input.get();
            if (input2.matches("[0-9]+"))
            {
               input3 = Integer.parseInt(input2);
               if(input3 <= 1 || input3 >= 5)
               {
                  dialog2.showAndWait();
               }
               else if (input3 > 1 || input3 < 5)
               {
                  stage.setScene(SorryScreen());
               }
            }
            else
            {
               dialog2.showAndWait();
            }

          }
		});
      
      
      
      exitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();  			
            }
		});
      
      

      
		root.getChildren().addAll(button, exitBtn, htpBtn, nextBtn, pic, pic2, B, backBtn);

   
      
      stage = primaryStage;
      Scene scene1 = new Scene(root, 1080, 705);
      
      primaryStage.setTitle("");
		primaryStage.setScene(scene1);
	   primaryStage.show();
   }
   
   public static Scene SorryScreen()
   {
      SorryGame sorryscreen = new SorryGame();
      scene2 = new Scene(sorryscreen.SorryGameScreen(), 1080, 705);
      return scene2;
      
      
      
   }

}
