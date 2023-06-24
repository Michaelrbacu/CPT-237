//Joe Chapman, Michael Bacu, Nick Chapman

//Final Project Sorry!

//CPT-237-W34

//Spring 2023


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MusicPlayer {
    private Stage stage;
    private MediaPlayer mediaPlayer;

    public MusicPlayer() {
        stage = new Stage();
        stage.setTitle("Music Player");

        // Load image
       Image image = new Image(getClass().getResourceAsStream("board.png"));

        // Create image view
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        // Create label and slider
        Label label = new Label("Volume:");
        Slider volumeSlider = new Slider(0, 1, 0.5);

        // Create play and stop buttons
        Button playButton = new Button("Play", imageView);
        Button stopButton = new Button("Stop");
        stopButton.setDisable(true);

        // Create hbox for buttons
        HBox buttonBox = new HBox(playButton, stopButton);
        buttonBox.setSpacing(10);

        // Create vbox for layout
        VBox root = new VBox(label, volumeSlider, buttonBox);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10px");

        // Create stack pane for image view and vbox
        StackPane stackPane = new StackPane(root, imageView);
        stackPane.setStyle("-fx-background-color: #ECECEC");

        // Create scene
        Scene scene = new Scene(stackPane, 300, 200);

        // Set scene to stage
        stage.setScene(scene);

        // Set event handlers
        playButton.setOnAction(event -> {
            Media media = new Media(getClass().getResource("music.mp3").toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            playButton.setDisable(true);
            stopButton.setDisable(false);
        });

        stopButton.setOnAction(event -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                playButton.setDisable(false);
                stopButton.setDisable(true);
            }
        });

        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(newValue.doubleValue());
            }
        });

        // Set stage properties
        stage.setResizable(false);
    }

    public void show() {
        stage.show();
    }
}