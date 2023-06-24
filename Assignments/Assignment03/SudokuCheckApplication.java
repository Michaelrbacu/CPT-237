//*********************************************
//
// Assignment 12 
//
// Author: Kim Cannon
// Date: 3/22/16
// Edited by: Michael Bacu
// 2/3/2023
//
// This program is a JavaFX program that will 
// be used as the GUI for further assignments.
//
//
//
//*********************************************

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class SudokuCheckApplication extends Application {
     SudokoBoard sb=new  SudokoBoard();
   public void start(Stage primaryStage) {
   
      // Create addressable controls
      // Reachable from the event handlers
      TextArea taInput = new TextArea("Input your Sudoku answer here:");
      TextArea taOutput = new TextArea("The results will display here:");
      
      // Create the GridPane pane
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(10, 10, 10, 10));
      pane.setVgap(5);
      
      // Place nodes in the GridPane pane
      pane.add(new Label("Input Sudoku:"), 0, 0);
      pane.add(taInput, 0, 1);

      // Create FlowPane pane
      FlowPane btnPane = new FlowPane();
      btnPane.setAlignment(Pos.CENTER);
      pane.setHgap(5);

      // Place nodes in the FlowPane pane and place
      // pane in the GridPane pane
      btnPane.setPadding(new Insets(10, 10, 10, 10));
      btnPane.setHgap(10);
      
      // Create buttons and event handlers
      // Check Button
      Button btnCheck = new Button("Check");
      btnCheck.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
                // take the text from taInput.getText() and use a multidimentional array to process the data
                try{
                String s[]=taInput.getText().split("\n");
                int k=0;
                for(int i=0;i<9;i++){
                    k=0;
                    String s1[]=s[i].split(" ");
                    for(int j=0;j<9;j++){
                        sb.setXY(i, j, Integer.parseInt(s1[j]));
                    }
                }
                sb.checkValidBoard();
                if(sb.isValid())
                    taOutput.setText("The Entered Solution is Correct");
                else
                    taOutput.setText("The Entered Solution is Incorrect");
                
                }catch(Exception ex){
                    taOutput.setText("Exception : Invalid Board"+ex);
                }
            }
      });
      
      // Clear Button
      Button btnClear = new Button("Clear");
      btnClear.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            taInput.setText("");
            taOutput.setText("");
         }
      });
     
      
      // Place Buttons on the FlowPane and place FlowPane on GridPane
      btnPane.getChildren().addAll(btnCheck, btnClear);
      pane.add(btnPane, 0, 2);
                                                                                                                            
      // Place nodes in the GridPane pane
      pane.add(new Label("Check result:"), 0, 3);
      pane.add(taOutput, 0, 4);
      
      //Create scene and place it on the stage
      Scene scene = new Scene(pane);
      primaryStage.setTitle("CPT 237 Sudoku Checker");
      primaryStage.setScene(scene);
      primaryStage.show();
      
   }


   public static void main(String[] args) { 
    launch(args);
   }
}                                                                                                   