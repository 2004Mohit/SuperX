package com.pgrental.dataAccess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AboutUs {
    private Pane root;
    private Stage primaryStage;

    public void setAboutPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Pane createAboutScene(Runnable AboutUsBackHandler) {

        root = new Pane();

        // BACKGROUND IMAGE
        Image imageHome = new Image("file:src\\main\\resources\\images\\shashi2.png", 1500, 1000, true, true);

        BackgroundSize backgroundSize = new BackgroundSize(
                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageHome, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        Background background = new Background(backgroundImage);

        // VBOX
        VBox vb1Box = new VBox();
        vb1Box.setPrefHeight(300);
        vb1Box.setPrefWidth(300);
        ;
        vb1Box.setBackground(background);

        // Labels

        Label titleLabel = new Label("Special Thanks For Shashi Sir And Core2Web Team ");
        titleLabel.setFont(Font.font("Harlow Solid Italic", FontWeight.BOLD, 50));
        titleLabel.setTextFill(Color.BLACK);
        titleLabel.setPadding(new Insets(30, 0, 0, 20));
        // titleLabel.setLayoutX(320);
        // titleLabel.setLayoutY(60);

        Label aboutuslabel = new Label("About US :");
        aboutuslabel.setPrefWidth(400);
        aboutuslabel.setFont(Font.font("Wide Latin", FontWeight.BOLD, 45));
        aboutuslabel.setTextFill(Color.BLACK);
        // aboutuslabel.setStyle("-fx-background-color:yellow");

        Label mentorlabel = new Label("Mentor : Subodh Yelgandharwar");
        mentorlabel.setPrefWidth(700);
        mentorlabel.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 50));
        mentorlabel.setTextFill(Color.BLACK);
        // mentorlabel.setStyle("-fx-background-color:yellow");

        // HBOX 1
        HBox hb1Box = new HBox(titleLabel);
        hb1Box.setPrefHeight(300);
        hb1Box.setPrefWidth(1200);
        hb1Box.setLayoutX(300);
        // hb1Box.setStyle("-fx-background-color:aqua");

        // HBOX 2
        HBox hbBox2 = new HBox(15, aboutuslabel);
        hbBox2.setPrefHeight(100);
        hbBox2.setPrefWidth(1500);
        hbBox2.setLayoutY(300);
        // hbBox2.setStyle("-fx-background-color:aqua");

        Label memberLabel = new Label("Member's Name :");
        memberLabel.setPrefWidth(400);
        memberLabel.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 50));
        memberLabel.setTextFill(Color.BLACK);
        // memberLabel.setStyle("-fx-background-color:yellow");

        Label member1 = new Label("Mohit Ingale");
        member1.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 35));
        member1.setTextFill(Color.BLACK);

        Label member2 = new Label("Shravan Desai");
        member2.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 35));
        member2.setTextFill(Color.BLACK);

        Label member3 = new Label("Atharv Mane");
        member3.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 35));
        member3.setTextFill(Color.BLACK);

        Label member4 = new Label("Priya Dhamdhere");
        member4.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 35));
        member4.setTextFill(Color.BLACK);

        Label descrLabel = new Label("Project Description: ");
        descrLabel.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 50));
        descrLabel.setTextFill(Color.BLACK);

        Label descr1Label = new Label(
                "Abodeify is here to simplify your search! Our app connects you with a wide range of verified PGs");
        descr1Label.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 35));
        descr1Label.setPrefHeight(50);
        descr1Label.setTextFill(Color.BLACK);

        Label descr2Label = new Label(" in your city, catering to students and working professionals.");
        descr2Label.setFont(Font.font("Baskerville Old Face", FontWeight.BOLD, 35));
        descr2Label.setPrefHeight(50);
        descr2Label.setTextFill(Color.BLACK);

        // VBOX2
        VBox vb2Box = new VBox(10, mentorlabel, memberLabel, member1, member2, member3, member4, descrLabel,
                descr1Label, descr2Label);
        vb2Box.setPrefHeight(570);
        vb2Box.setPrefWidth(1500);
        // vb.setLayoutX(10);
        vb2Box.setLayoutY(410);

        Image imageHome2 = new Image("file:src\\main\\resources\\images\\aboutbg.png", 1500, 1000, true,
                true);

        BackgroundSize backgroundSize2 = new BackgroundSize(
                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage backgroundImage2 = new BackgroundImage(imageHome2, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize2);
        Background background2 = new Background(backgroundImage2);

        VBox vb = new VBox();
        vb.setPrefWidth(800);
        vb.setPrefHeight(700);
        vb.setLayoutX(700);
        vb.setLayoutY(100);
        vb.setBackground(background2);

        Button bt = new Button("Back");

        bt.setPrefSize(100, 50);
        bt.setLayoutX(715);
        bt.setLayoutY(935);
        bt.setFont(new Font(20));
        bt.setStyle("-fx-background-radius: 2em;");
        bt.setStyle("-fx-background-color:red");
        bt.setTextFill(Color.WHITE);
        bt.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                AboutUsBackHandler.run();
            }
        });

        // Pane Root
        root.getChildren().addAll(vb, vb1Box, hb1Box, hbBox2, vb2Box, bt);
        // System.out.println(root);

        return root;
    }
}