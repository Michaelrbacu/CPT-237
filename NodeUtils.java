//Joe Chapman, Michael Bacu, Nick Chapman

//Final Project Sorry!

//CPT-237-W34

//Spring 2023


import javafx.scene.Node;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.GridPane;

public class NodeUtils {
    private double mouseAnchorX = 0;
    private double mouseAnchorY = 0;
     
    public void makeDraggable(Node node) {
        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getSceneX() - node.getTranslateX();
            mouseAnchorY = mouseEvent.getSceneY() - node.getTranslateY();
            mouseEvent.consume();
        });

        node.setOnMouseDragged(mouseEvent -> {
                    
            double newX = mouseEvent.getSceneX() - mouseAnchorX;
            double newY = mouseEvent.getSceneY() - mouseAnchorY;
            node.setTranslateX(newX);
            node.setTranslateY(newY);
            mouseEvent.consume();
            
        });
    }
}