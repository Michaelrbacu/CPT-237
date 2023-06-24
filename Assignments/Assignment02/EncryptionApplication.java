
//Michael Bacu
//Adv Java Programming



import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class EncryptionApplication extends Application {

   public void start(Stage primaryStage) {
   
      // Create addressable controls
      // Reachable from the event handlers
      TextArea taInput = new TextArea("Input text here");
      TextArea taOutput = new TextArea("Output Text:");
      
      // Create the GridPane pane
      GridPane pane = new GridPane();
      pane.setPadding(new Insets(10, 10, 10, 10));
      pane.setVgap(5);
      
      // Place nodes in the GridPane pane
      pane.add(new Label("Input Text:"), 0, 0);
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
      // Encrypt Button
      Button btnEncrypt = new Button("Encrypt");
      btnEncrypt.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            try {
               // Get input field and create EncryptString object
               EncryptString eObj = new EncryptString(taInput.getText());
               
               // Output the encrypted text
               taOutput.setText(eObj.encryptString());
            } catch (IllegalArgumentException ex) {
               // Display error dialog
               Alert alert = new Alert(Alert.AlertType.ERROR, "Input can only contain a-z and spaces!");
               alert.showAndWait();
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
      
      // Decrypt Button
      Button btnDecrypt = new Button("Decrypt");
      btnDecrypt.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e) {
            try {
               // Get the encrypted string from input field
               String eString = taInput.getText();
               
               // Output the encrypted text
               taOutput.setText(EncryptString.decryptString(eString));
            } catch (IllegalArgumentException ex) {
               // Display error dialog
               Alert alert = new Alert(Alert.AlertType.ERROR, "Input can only contain a-z and spaces!");
               alert.showAndWait();
            }
         }
      });
      
      // Place Buttons on the FlowPane and place FlowPane on GridPane
      btnPane.getChildren().addAll(btnEncrypt, btnClear, btnDecrypt);
      pane.add(btnPane, 0, 2);
                                                                                                                            
      // Place nodes in the GridPane pane
      pane.add(new Label("Output Text:"), 0, 3);
      pane.add(taOutput, 0, 4);
      
      //Create scene and place it on the stage
      Scene scene = new Scene(pane);
      primaryStage.setTitle("CPT 236 Encryption Application");
      primaryStage.setScene(scene);
      primaryStage.show();
      
   }

   /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
   public static
 void main(String[] args) { 
    launch(args);
   }

}                                                                                                                                                                                                             