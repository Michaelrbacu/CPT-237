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

public class SorryGame {

   int counter = 0;
   
   
   int numPlayers = GameWindow.input3;
   
   
   public GridPane SorryGameScreen()
   {      
      GridPane main = new GridPane();
      main.setHgap(5);
      
      GridPane spaces = new GridPane();
      
      int size = 32;
      int spots = 16;
      int squareSize = size / spots;
      
      Random rand = new Random();
      Color[] colors = {Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT};
      
      for (int row = 0; row < size; row += squareSize) {
         for (int col = 0; col < size; col += squareSize) {
            int n = rand.nextInt(4);
            Rectangle rec = new Rectangle(row, col);
            rec.setWidth(41);
            rec.setHeight(41);
            rec.setFill(Color.TRANSPARENT);
            GridPane.setRowIndex(rec, row);
            GridPane.setColumnIndex(rec, col);
            spaces.getChildren().addAll(rec);
         }
      }
      
      
      GridPane controls = new GridPane();
      controls.setVgap(10);
      StackPane board = new StackPane();
      
      AnchorPane Ap = new AnchorPane();
      Ap.setMinSize(700, 700);
      Ap.setMaxSize(700, 700);

      Image image = new Image("File:board.png");
      ImageView pic = new ImageView();
      pic.setFitWidth(700);
      pic.setFitHeight(700);
      pic.setImage(image);
      
      
      board.getChildren().add(spaces);
      board.getChildren().add(pic);
      board.getChildren().add(Ap);
      
      int gridmoveX = 16;
      spaces.translateXProperty().set(gridmoveX);
      
      int gridmoveY = 17;
      spaces.translateYProperty().set(gridmoveY);

      Image CardBack = new Image("File:SorryCardBack.png");
      ImageView CardBack2 = new ImageView();
      CardBack2.setFitWidth(184.75);
      CardBack2.setFitHeight(270);
      CardBack2.setImage(CardBack);
      controls.add(CardBack2, 0, 0);

      
         Alert alert = new Alert(AlertType.CONFIRMATION);

      ///////////////////////////////////////////////////////////////
      Image Red = new Image("File:Red.png");
      ImageView Red1 = new ImageView();
      Red1.setFitWidth(35);
      Red1.setFitHeight(35);
      Red1.setImage(Red);
      Red1.setTranslateX(574);
      Red1.setTranslateY(155);
      
      ImageView Red2 = new ImageView();
      Red2.setFitWidth(35);
      Red2.setFitHeight(35);
      Red2.setImage(Red);
      Red2.setTranslateX(600);
      Red2.setTranslateY(175);
      
      ImageView Red3 = new ImageView();
      Red3.setFitWidth(35);
      Red3.setFitHeight(35);
      Red3.setImage(Red);
      Red3.setTranslateX(574);
      Red3.setTranslateY(195);
      
      ImageView Red4 = new ImageView();
      Red4.setFitWidth(35);
      Red4.setFitHeight(35);
      Red4.setImage(Red);
      Red4.setTranslateX(548);
      Red4.setTranslateY(175);
      
      ///////////////////////////////////////////////////////////////
      
      Rectangle detectionArea = new Rectangle(350, 80, 80, 80);
detectionArea.setFill(Color.TRANSPARENT);
detectionArea.setStroke(Color.TRANSPARENT);
detectionArea.setStrokeWidth(2);
Ap.getChildren().add(detectionArea);

ChangeListener<Bounds> boundsListener = new ChangeListener<Bounds>() {
    @Override
    public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
               
               PawnDetector.addPawnDetection(Red1, Red2, Red3, Red4, detectionArea);
        
            }         
};

Red1.boundsInParentProperty().addListener(boundsListener);
Red2.boundsInParentProperty().addListener(boundsListener);
Red3.boundsInParentProperty().addListener(boundsListener);
Red4.boundsInParentProperty().addListener(boundsListener);

      
      Image Blue = new Image("File:Blue.png");
      ImageView Blue1 = new ImageView();
      Blue1.setFitWidth(35);
      Blue1.setFitHeight(35);
      Blue1.setImage(Blue);
      Blue1.setTranslateX(477);
      Blue1.setTranslateY(530);

      ImageView Blue2 = new ImageView();
      Blue2.setFitWidth(35);
      Blue2.setFitHeight(35);
      Blue2.setImage(Blue);
      Blue2.setTranslateX(503);
      Blue2.setTranslateY(550);
      
      ImageView Blue3 = new ImageView();
      Blue3.setFitWidth(35);
      Blue3.setFitHeight(35);
      Blue3.setImage(Blue);
      Blue3.setTranslateX(477);
      Blue3.setTranslateY(570);
      
      ImageView Blue4 = new ImageView();
      Blue4.setFitWidth(35);
      Blue4.setFitHeight(35);
      Blue4.setImage(Blue);
      Blue4.setTranslateX(451);
      Blue4.setTranslateY(550);
 
      Rectangle detectionAreaBlue = new Rectangle(537, 350, 80, 80);
detectionAreaBlue.setFill(Color.TRANSPARENT);
detectionAreaBlue.setStroke(Color.TRANSPARENT);
detectionAreaBlue.setStrokeWidth(2);
Ap.getChildren().add(detectionAreaBlue);

ChangeListener<Bounds> boundsListenerBlue = new ChangeListener<Bounds>() {
    @Override
    public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
               
               PawnDetector.addPawnDetection(Blue1, Blue2, Blue3, Blue4, detectionAreaBlue);
        
            }         
};

Blue1.boundsInParentProperty().addListener(boundsListenerBlue);
Blue2.boundsInParentProperty().addListener(boundsListenerBlue);
Blue3.boundsInParentProperty().addListener(boundsListenerBlue);
Blue4.boundsInParentProperty().addListener(boundsListenerBlue);

      Image Yellow = new Image("File:Yellow.png");
      ImageView Yellow1 = new ImageView();
      Yellow1.setFitWidth(35);
      Yellow1.setFitHeight(35);
      Yellow1.setImage(Yellow);
      Yellow1.setTranslateX(95);
      Yellow1.setTranslateY(444);
      

      ImageView Yellow2 = new ImageView();
      Yellow2.setFitWidth(35);
      Yellow2.setFitHeight(35);
      Yellow2.setImage(Yellow);
      Yellow2.setTranslateX(121);
      Yellow2.setTranslateY(464);
      
      ImageView Yellow3 = new ImageView();
      Yellow3.setFitWidth(35);
      Yellow3.setFitHeight(35);
      Yellow3.setImage(Yellow);
      Yellow3.setTranslateX(95);
      Yellow3.setTranslateY(484);
      
      ImageView Yellow4 = new ImageView();
      Yellow4.setFitWidth(35);
      Yellow4.setFitHeight(35);
      Yellow4.setImage(Yellow);
      Yellow4.setTranslateX(69);
      Yellow4.setTranslateY(464);
      
       if(3 > numPlayers){
      
      Yellow1.setVisible(false);
      Yellow2.setVisible(false);
      Yellow3.setVisible(false);
      Yellow4.setVisible(false);

      
      }
      
      Rectangle detectionAreaYellow = new Rectangle(270, 538, 80, 80);
detectionAreaYellow.setFill(Color.TRANSPARENT);
detectionAreaYellow.setStroke(Color.TRANSPARENT);
detectionAreaYellow.setStrokeWidth(2);
Ap.getChildren().add(detectionAreaYellow);

ChangeListener<Bounds> boundsListenerYellow = new ChangeListener<Bounds>() {
    @Override
    public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
               
               PawnDetector.addPawnDetection(Yellow1, Yellow2, Yellow3, Yellow4, detectionAreaYellow);
        
            }         
};

Yellow1.boundsInParentProperty().addListener(boundsListenerYellow);
Yellow2.boundsInParentProperty().addListener(boundsListenerYellow);
Yellow3.boundsInParentProperty().addListener(boundsListenerYellow);
Yellow4.boundsInParentProperty().addListener(boundsListenerYellow);

      Image Green = new Image("File:Green.png");
      ImageView Green1 = new ImageView();
      Green1.setFitWidth(35);
      Green1.setFitHeight(35);
      Green1.setImage(Green);
      Green1.setTranslateX(185);
      Green1.setTranslateY(65);

      ImageView Green2 = new ImageView();
      Green2.setFitWidth(35);
      Green2.setFitHeight(35);
      Green2.setImage(Green);
      Green2.setTranslateX(211);
      Green2.setTranslateY(85);
      
      ImageView Green3 = new ImageView();
      Green3.setFitWidth(35);
      Green3.setFitHeight(35);
      Green3.setImage(Green);
      Green3.setTranslateX(185);
      Green3.setTranslateY(105);
      
      ImageView Green4 = new ImageView();
      Green4.setFitWidth(35);
      Green4.setFitHeight(35);
      Green4.setImage(Green);
      Green4.setTranslateX(159);
      Green4.setTranslateY(85);
      
      
      Ap.getChildren().addAll(Red1, Red2, Red3, Red4,
                              Blue1, Blue2, Blue3, Blue4,
                              Yellow1, Yellow2, Yellow3, Yellow4,
                              Green1, Green2, Green3, Green4);
      
      

      if(4 > numPlayers){
      
            Green1.setVisible(false);
            Green2.setVisible(false);
            Green3.setVisible(false);
            Green4.setVisible(false);

      
      }
      
      Rectangle detectionAreaGreen = new Rectangle(81, 270, 80, 80);
detectionAreaGreen.setFill(Color.TRANSPARENT);
detectionAreaGreen.setStroke(Color.TRANSPARENT);
detectionAreaGreen.setStrokeWidth(2);
Ap.getChildren().add(detectionAreaGreen);

ChangeListener<Bounds> boundsListenerGreen = new ChangeListener<Bounds>() {
    @Override
    public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
               
               PawnDetector.addPawnDetection(Green1, Green2, Green3, Green4, detectionAreaGreen);
        
            }         
};


Green1.boundsInParentProperty().addListener(boundsListenerGreen);
Green2.boundsInParentProperty().addListener(boundsListenerGreen);
Green3.boundsInParentProperty().addListener(boundsListenerGreen);
Green4.boundsInParentProperty().addListener(boundsListenerGreen);


      Button btnDeck = new Button("Draw Card");
      btnDeck.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      Font font = Font.font("Courier New", FontWeight.BOLD, 36);
      btnDeck.setFont(font);
      
      controls.add(btnDeck, 0, 6, 2, 10);

              
      Button exitBtn = new Button("Exit");
      exitBtn.setText("Exit");

      
      exitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();  			
            }
		});
         controls.add(exitBtn, 0, 12, 10, 14);
         
         
         
         

      Text text = new Text();
      text.setText("It is Red's Turn!\n\n" + "Please choose a card!");
      text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
      text.setTextAlignment(TextAlignment.CENTER);
      
      Rectangle rectangle = new Rectangle(0, 2, 370, 150);
      rectangle.setFill(Color.RED);
      
      Rectangle rectangle2 = new Rectangle(0, 2, 296, 120);
      rectangle2.setFill(Color.WHITE);
      
      StackPane rect = new StackPane();
      rect.getChildren().addAll(rectangle, rectangle2, text);
      controls.add(rect, 0, 2, 2, 2);

      ImageView DrawnCard = new ImageView();
            
            DrawnCard.setFitWidth(184.75);
            DrawnCard.setFitHeight(270);
            
            DrawnCard.setImage(new Image("File:SorryCard.png"));
      List<Integer> CardDeck = new ArrayList<Integer>(10); 
            for (int i = 1; i <= 11; i++) 
               if(i != 1)
               {
                  CardDeck.add(i);
                  CardDeck.add(i);
                  CardDeck.add(i);
                  CardDeck.add(i);
               }
               else
               {
                  CardDeck.add(i);
                  CardDeck.add(i);
                  CardDeck.add(i);
                  CardDeck.add(i);
                  CardDeck.add(i);
               }
               
            Collections.shuffle(CardDeck);

            Button mediaBtn = new Button(">");
            mediaBtn.setText("Music");
            MusicPlayer musicPlayer = new MusicPlayer();
            mediaBtn.setOnAction(e -> {
            musicPlayer.show();
      });
      
      
      
    controls.add(mediaBtn, 0, 15, 10, 14);   

            PlayersFour playersFour = new PlayersFour();
            
            playersThree playersThree = new playersThree();
            
            playersTwo playersTwo = new playersTwo();
            
            
            
      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            
            if(counter == 41) {
            counter = 0;
            }
            
            if(numPlayers == 4){
            playersFour.changeTurn(text, rectangle,  Red1,  Red2,  Red3,  Red4,  Blue1,  Blue2,  Blue3,  Blue4,  Yellow1,  Yellow2,  Yellow3,  Yellow4,  Green1,  Green2,  Green3,  Green4);            
              
            }else if(numPlayers == 3){
            playersThree.changeTurn(text, rectangle,  Red1,  Red2,  Red3,  Red4,  Blue1,  Blue2,  Blue3,  Blue4,  Yellow1,  Yellow2,  Yellow3,  Yellow4);            
              

            }else if(numPlayers == 2){
            playersTwo.changeTurn(text, rectangle,  Red1,  Red2,  Red3,  Red4,  Blue1,  Blue2,  Blue3,  Blue4);            
              

            }

                DrawnCard.setImage(new Image("File:SorryCard" + CardDeck.get(counter) +".png"));
                
        if (CardDeck.get(counter) == 11 || CardDeck.get(counter) == 9){
                     
        Red1.setDisable(false);
        Red2.setDisable(false);
        Red3.setDisable(false);
        Red4.setDisable(false);
        Blue1.setDisable(false);
        Blue2.setDisable(false);
        Blue3.setDisable(false);
        Blue4.setDisable(false);
        Yellow1.setDisable(false);
        Yellow2.setDisable(false);
        Yellow3.setDisable(false);
        Yellow4.setDisable(false);
        Green1.setDisable(false);
        Green2.setDisable(false);
        Green3.setDisable(false);
        Green4.setDisable(false);
                  
            }
            
                  
            
            
               counter++;  
               
               }
        };
        
      
      


      btnDeck.setOnAction(event);
      
      controls.add(DrawnCard, 1, 0);
      
      main.add(controls, 0, 1);
      main.add(board, 1, 1);
      
        NodeUtils nodeUtils = new NodeUtils();
        
        nodeUtils.makeDraggable(Red1);
        nodeUtils.makeDraggable(Red2);
        nodeUtils.makeDraggable(Red3);
        nodeUtils.makeDraggable(Red4);
        nodeUtils.makeDraggable(Yellow1);
        nodeUtils.makeDraggable(Yellow2);
        nodeUtils.makeDraggable(Yellow3);
        nodeUtils.makeDraggable(Yellow4);
        nodeUtils.makeDraggable(Blue1);
        nodeUtils.makeDraggable(Blue2);
        nodeUtils.makeDraggable(Blue3);
        nodeUtils.makeDraggable(Blue4);
        nodeUtils.makeDraggable(Green1);
        nodeUtils.makeDraggable(Green2);
        nodeUtils.makeDraggable(Green3);
        nodeUtils.makeDraggable(Green4);
        

      
      
      
      
      
      
      return main;
      
      }
     

   }
                                                                          