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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    Label messageErreur;

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

    Line comp1_2 = new Line(200,200,200,200); //coordonnée 200 = centre du graphe
    Line comp2_3 = new Line(200,200,200,200);
    Line comp3_4 = new Line(200,200,200,200);
    Line comp4_5 = new Line(200,200,200,200);
    Line comp5_6 = new Line(200,200,200,200);
    Line comp6_1 = new Line(200,200,200,200);
    Circle note1 = new Circle(200,200,0);
    Circle note2 = new Circle(200,200,0);
    Circle note3 = new Circle(200,200,0);
    Circle note4 = new Circle(200,200,0);
    Circle note5 = new Circle(200,200,0);
    Circle note6 = new Circle(200,200,0);

    ArrayList<Integer> lesPosX = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
    ArrayList<Integer> lesPosY = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
    ArrayList<Line> lesLignes = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // couleur de fond
        scene.setBackground(new Background(new BackgroundFill(Color.rgb(145,198,255),null,null)));

        // ajout les points et les lignes au graphes parents
        graphe.getChildren().addAll(note1,note2,note3,note4,note5,note6,comp1_2,comp2_3,comp3_4,comp4_5,comp5_6,comp6_1);

        // initialisation lignes
        comp1_2.setStrokeWidth(0);
        comp2_3.setStrokeWidth(0);
        comp3_4.setStrokeWidth(0);
        comp4_5.setStrokeWidth(0);
        comp5_6.setStrokeWidth(0);
        comp6_1.setStrokeWidth(0);

        // permettre au message d'être sur plusieurs ligne + couleur rouge
        messageErreur.setWrapText(true);
        messageErreur.setStyle("-fx-text-fill: #FF0000 ;");

        boutonTracer.setOnAction(actionEvent -> {
            int posX = 0;
            int posY = 0;
            messageErreur.setText("");
            // mise à jour du point de la compétence 1
            if (!comp1.getText().isEmpty()) {
                if ((Double.parseDouble(comp1.getText()) <= 20.0 && Double.parseDouble(comp1.getText()) >= 0.0)) {
                    posX = getXRadarChart(Double.parseDouble(comp1.getText()), 1);
                    posY = getYRadarChart(Double.parseDouble(comp1.getText()), 1);
                    note1.setCenterX(posX);
                    note1.setCenterY(posY);
                    note1.setRadius(5);
                    lesPosX.set(0,posX);
                    lesPosY.set(0,posY);
                }
                // si au dessus de 20 ou en dessous de 0
                else {
                    messageErreur.setText("Erreur de saisi: Les valeurs doivent êtres comprises entre 0 et 20");
                }
            }

            // mise à jour du point de la compétence 2
            if (!comp2.getText().isEmpty()) {
                if ((Double.parseDouble(comp2.getText()) <= 20 && Double.parseDouble(comp2.getText()) >= 0)) {
                    posX = getXRadarChart(Double.parseDouble(comp2.getText()), 2);
                    posY = getYRadarChart(Double.parseDouble(comp2.getText()), 2);
                    note2.setCenterX(posX);
                    note2.setCenterY(posY);
                    note2.setRadius(5);
                    lesPosX.set(1,posX);
                    lesPosY.set(1,posY);
                }
                // si au dessus de 20 ou en dessous de 0
                else {
                    messageErreur.setText("Erreur de saisi: Les valeurs doivent êtres comprises entre 0 et 20");
                }
            }

            // mise à jour du point de la compétence 3
            if (!comp3.getText().isEmpty()) {
                if ((Double.parseDouble(comp3.getText()) <= 20 && Double.parseDouble(comp3.getText()) >= 0)) {
                    posX = getXRadarChart(Double.parseDouble(comp3.getText()), 3);
                    posY = getYRadarChart(Double.parseDouble(comp3.getText()), 3);
                    note3.setCenterX(posX);
                    note3.setCenterY(posY);
                    note3.setRadius(5);
                    lesPosX.set(2,posX);
                    lesPosY.set(2,posY);
                }
                // si au dessus de 20 ou en dessous de 0
                else {
                    messageErreur.setText("Erreur de saisi: Les valeurs doivent êtres comprises entre 0 et 20");
                }
            }

            // mise à jour du point de la compétence 4
            if (!comp4.getText().isEmpty()) {
                if ((Double.parseDouble(comp4.getText()) <= 20 && Double.parseDouble(comp4.getText()) >= 0)) {
                    posX = getXRadarChart(Double.parseDouble(comp4.getText()), 4);
                    posY = getYRadarChart(Double.parseDouble(comp4.getText()), 4);
                    note4.setCenterX(posX);
                    note4.setCenterY(posY);
                    note4.setRadius(5);
                    lesPosX.set(3,posX);
                    lesPosY.set(3,posY);
                }
                // si au dessus de 20 ou en dessous de 0
                else {
                    messageErreur.setText("Erreur de saisi: Les valeurs doivent êtres comprises entre 0 et 20");
                }
            }

            // mise à jour du point de la compétence 5
            if (!comp5.getText().isEmpty()) {
                if ((Double.parseDouble(comp5.getText()) <= 20 && Double.parseDouble(comp5.getText()) >= 0)) {
                    posX = getXRadarChart(Double.parseDouble(comp5.getText()), 5);
                    posY = getYRadarChart(Double.parseDouble(comp5.getText()), 5);
                    note5.setCenterX(posX);
                    note5.setCenterY(posY);
                    note5.setRadius(5);
                    lesPosX.set(4,posX);
                    lesPosY.set(4,posY);
                }
                // si au dessus de 20 ou en dessous de 0
                else {
                    messageErreur.setText("Erreur de saisi: Les valeurs doivent êtres comprises entre 0 et 20");
                }
            }

            // mise à jour du point de la compétence 6
            if (!comp6.getText().isEmpty()) {
                if ((Double.parseDouble(comp6.getText()) <= 20 && Double.parseDouble(comp6.getText()) >= 0)) {
                    posX = getXRadarChart(Double.parseDouble(comp6.getText()), 6);
                    posY = getYRadarChart(Double.parseDouble(comp6.getText()), 6);
                    note6.setCenterX(posX);
                    note6.setCenterY(posY);
                    note6.setRadius(5);
                    lesPosX.set(5,posX);
                    lesPosY.set(5,posY);
                }
                // si au dessus de 20 ou en dessous de 0
                else  {
                    messageErreur.setText("Erreur de saisi: Les valeurs doivent êtres comprises entre 0 et 20");
                }
            }
            lesLignes.set(0,comp1_2);
            lesLignes.set(1,comp2_3);
            lesLignes.set(2,comp3_4);
            lesLignes.set(3,comp4_5);
            lesLignes.set(4,comp5_6);
            lesLignes.set(5,comp6_1);
        });

        boutonVider.setOnAction(actionEvent -> {
            // mettre la taille des points à 0 ne les rends plus visibles
            note1.setRadius(0);
            note2.setRadius(0);
            note3.setRadius(0);
            note4.setRadius(0);
            note5.setRadius(0);
            note6.setRadius(0);

            // initialisation lignes
            comp1_2.setStrokeWidth(0);
            comp2_3.setStrokeWidth(0);
            comp3_4.setStrokeWidth(0);
            comp4_5.setStrokeWidth(0);
            comp5_6.setStrokeWidth(0);
            comp6_1.setStrokeWidth(0);

            comp1.setText("");
            comp2.setText("");
            comp3.setText("");
            comp4.setText("");
            comp5.setText("");
            comp6.setText("");
        });

    }

    private void ajusterLesLignes() {
        for (int i = 1; i < lesPosY.size() ; i++) {
            if (lesPosY.get(i) != 200 && lesPosY.get(i-1) != 200) {
//                lesLignes.get(i-1)
            }
        }
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
