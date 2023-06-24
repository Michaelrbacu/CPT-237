/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package javafxapplication1;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
*
* 
*/
public class FileDump extends Application {

@Override
public void start(Stage primaryStage) {

/*
use a GridPane layout because it enables you to
create a flexible grid of rows and columns in which to lay out controls.
You can place controls in any cell in the grid,
and you can make controls span cells as needed.

*/

GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25, 25, 25, 25));
Text scenetitle = new Text("No File Currently Open :");
//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
grid.add(scenetitle, 0, 0, 2, 1);
FileChooser fil_chooser = new FileChooser();

//filechooser for the file to open
Button button = new Button("Open File:");
grid.add(button,0,0,8,1);
button.setOnAction(new EventHandler<ActionEvent>() {
private Window stage;

@Override
public void handle(ActionEvent t) {
// get the file selected
File file = fil_chooser.showOpenDialog(stage);

if (file != null) {

scenetitle.setText(file.getAbsolutePath()
+ " selected");

}
}
});



/*
The grid.add() method adds the scenetitle variable to the layout grid.
The numbering for columns and rows in the grid starts at zero, and scenetitle is added in column 0, row 0.
The last two arguments of the grid.add() method set the column span to 2 and the row span to 1.
Label userName = new Label("Enter Quantity:");
grid.add(userName, 0, 1);

The Label is added to the grid pane at column 0, row 1

TextField userTextField = new TextField();
grid.add(userTextField, 1, 1);

The text field is added to the grid pane at column 1, row 1

Button add1=new Button("Add to Cart ");
grid.add(add1,2,1);
/*
The button is added to the grid pane at column 2, row 1*/

//TextArea with the 20 column and 8 rows
TextArea textArea = new TextArea();
textArea.setPrefColumnCount(20);
textArea.setPrefRowCount(8);

grid.add(textArea, 0, 1);
GridPane grid1 = new GridPane();
grid1.setAlignment(Pos.CENTER);
grid1.setHgap(10);
grid1.setVgap(10);
grid1.setPadding(new Insets(25, 25, 25, 25));
grid.add(grid1,1,1);

Button Up=new Button("Up");
grid1.add(Up,0,1);
Button Down=new Button("Down");
grid1.add(Down,0,2);


/*
When working with a grid pane, you can display the grid lines, which is useful for debugging purposes.
In this case, you can add grid.setGridLinesVisible(true) after the line that adds the password field.
Then, when you run the application, you see the lines for the grid columns and rows as well as the gap properties
*/
GridPane grid2 = new GridPane();
grid2.setAlignment(Pos.CENTER);
grid2.setHgap(10);
grid2.setVgap(10);
grid2.setPadding(new Insets(25, 25, 25, 25));



BorderPane root=new BorderPane();
root.setBottom(grid2);
Button Reset=new Button("Reset");
grid2.add(Reset,0,1);
Button Exit=new Button("Exit");
grid2.add(Exit,1,1);



MenuBar menuBar = new MenuBar();

// --- Menu File
Menu menuFile = new Menu("File");
MenuItem add = new MenuItem("Open");
add.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent t) {
//your code here
//vbox.setVisible(true);
}
});
MenuItem exit = new MenuItem("Exit");
exit.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent t) {
//your code here
//vbox.setVisible(true);
}
});
menuFile.getItems().addAll(add,exit);


// --- Menu Edit
Menu menuEdit = new Menu("Help");
MenuItem about = new MenuItem("About");
about.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent t) {
//your code here
//vbox.setVisible(true);
}
});
menuEdit.getItems().addAll(about);

// --- Menu View
//Menu menuView = new Menu("View");

menuBar.getMenus().addAll(menuFile, menuEdit);
root.setTop(menuBar);
root.setCenter(grid);
FileChooser file = new FileChooser();
file.setTitle("Open File");
//file.showOpenDialog(primaryStage);

HBox root1 = new HBox();

root1.setSpacing(20);

root.setLeft(root1);

Scene scene;
scene = new Scene(root, 500, 500);
// scene=new Scene(grid);


//((VBox) scene.getRoot()).getChildren().addAll(menuBar);





primaryStage.setScene(scene);
primaryStage.setTitle("Hello JavaFX");
primaryStage.show();
}

/**
* The main() method is ignored in correctly deployed JavaFX application.
* main() serves only as fallback in case the application can not be
* launched through deployment artifacts, e.g., in IDEs with limited FX
* support. NetBeans ignores main().
*
* @param args the command line arguments
*/
public static void main(String[] args) {
launch(args);
}

}