package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    HBox scene;

    @FXML
    Pane graphe;

    @FXML
    TextField comp1;
    @FXML
    TextField comp2;
    @FXML
    TextField comp3;
    @FXML
    TextField comp4;
    @FXML
    TextField comp5;
    @FXML
    TextField comp6;

    @FXML
    Button boutonTracer;
    @FXML
    Button boutonVider;

    Circle note1 = new Circle(200,200,5);
    Circle note2 = new Circle(200,200,5);
    Circle note3 = new Circle(200,200,5);
    Circle note4 = new Circle(200,200,5);
    Circle note5 = new Circle(200,200,5);
    Circle note6 = new Circle(200,200,5);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        scene.setBackground(new Background(new BackgroundFill(Color.rgb(145,198,255),null,null)));
        graphe.getChildren().addAll(note1,note2,note3,note4,note5,note6);

        boutonTracer.setOnAction(actionEvent -> {
            int posX = 0;
            int posY = 0;

            // mise à jour du point de la compétence 1
            posX = getXRadarChart(Double.parseDouble(comp1.getText()),1);
            posY = getYRadarChart(Double.parseDouble(comp1.getText()),1);
            note1.setCenterX(posX);
            note1.setCenterY(posY);

            // mise à jour du point de la compétence 2
            posX = getXRadarChart(Double.parseDouble(comp2.getText()),2);
            posY = getYRadarChart(Double.parseDouble(comp2.getText()),2);
            note2.setCenterX(posX);
            note2.setCenterY(posY);

            // mise à jour du point de la compétence 3
            posX = getXRadarChart(Double.parseDouble(comp3.getText()),3);
            posY = getYRadarChart(Double.parseDouble(comp3.getText()),3);
            note3.setCenterX(posX);
            note3.setCenterY(posY);

            // mise à jour du point de la compétence 4
            posX = getXRadarChart(Double.parseDouble(comp4.getText()),4);
            posY = getYRadarChart(Double.parseDouble(comp4.getText()),4);
            note4.setCenterX(posX);
            note4.setCenterY(posY);

            // mise à jour du point de la compétence 5
            posX = getXRadarChart(Double.parseDouble(comp5.getText()),5);
            posY = getYRadarChart(Double.parseDouble(comp5.getText()),5);
            note5.setCenterX(posX);
            note5.setCenterY(posY);

            // mise à jour du point de la compétence 6
            posX = getXRadarChart(Double.parseDouble(comp6.getText()),6);
            posY = getYRadarChart(Double.parseDouble(comp6.getText()),6);
            note6.setCenterX(posX);
            note6.setCenterY(posY);
        });
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

}
