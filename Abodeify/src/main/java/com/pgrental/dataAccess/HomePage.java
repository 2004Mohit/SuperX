package com.pgrental.dataAccess;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomePage extends Application {

        private Group group;
        private Stage primaryStage;
        private Scene homeScene;
        private Scene OptionPageScene;

        public void getHomePage(Stage primaryStage) {
                this.primaryStage = primaryStage;
                initHomeScene();
        }

        public void initHomeScene() {

                // BACKGROUND IMAGE
                Image imageHome = new Image("file:src\\main\\resources\\images\\smallhome.jpg", 1500, 1000, false,
                                false);

                BackgroundSize backgroundSize = new BackgroundSize(
                                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                BackgroundImage backgroundImage = new BackgroundImage(
                                imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                backgroundSize);
                Background background = new Background(backgroundImage);

                // LOGO
                Image logo = new Image("file:src\\main\\resources\\images\\icon3.png", 1500, 1000, true, false);
                ImageView logoImageView = new ImageView(logo);
                logoImageView.setPreserveRatio(true);
                logoImageView.setFitHeight(300);
                logoImageView.setFitWidth(300);

                // TITLE
                Label titleLabel = new Label("Abodeify");
                titleLabel.setFont(Font.font("Harlow Solid Italic", FontWeight.BOLD, 70));
                titleLabel.setTextFill(Color.BLACK);
                titleLabel.setLayoutX(320);
                titleLabel.setLayoutY(60);

                // TITLE CAPTION
                Label captionLabel = new Label("Home in Clicks");
                captionLabel.setLayoutX(600);
                captionLabel.setLayoutY(150);
                captionLabel.setFont(Font.font("Brush Script MT", FontWeight.BOLD, 50));
                captionLabel.setTextFill(Color.BLACK);

                // Signup Label
                Button start = new Button("Get Started -> ");
                start.setFont(new Font(40));
                start.setLayoutX(950);
                start.setLayoutY(820);
                start.setAlignment(Pos.CENTER);
                start.setStyle(
                                "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 320px; " +
                                                "-fx-min-height: 90px; " +
                                                "-fx-max-width: 320px; " +
                                                "-fx-max-height: 90px;" +
                                                "-fx-background-color: YELLOW");
                
                
                start.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                                start.setStyle(
                                                "-fx-background-radius: 5em; " +
                                                                "-fx-min-width: 320px; " +
                                                                "-fx-min-height: 90px; " +
                                                                "-fx-max-width: 320px; " +
                                                                "-fx-max-height: 90px;" +
                                                                "-Fx-Background-Color:AQUA");
                                initOptionScene();
                                primaryStage.setScene(OptionPageScene);
                        }
                });

                // VBOX
                VBox verticallogBox = new VBox(50);
                // verticallogBox.setAlignment(Pos.CENTER_RIGHT);
                verticallogBox.setPrefHeight(1000);
                verticallogBox.setPrefWidth(1500);
                verticallogBox.setBackground(background);

                group = new Group(verticallogBox, start, logoImageView, titleLabel, captionLabel);

                homeScene = new Scene(group, 1500, 1000);
        }

        //Method To Home Page Scene
        public void showHomeScene() {
                primaryStage.setScene(homeScene);
                primaryStage.show();
        }

        //Method to get HomePage Scene
        public Scene getHomeScene() {
                return homeScene;
        }

        //Method To show option Page Scene
        private void initOptionScene() {
                OptionPage OptionPage = new OptionPage();
                OptionPage.setOptionPage(primaryStage);
                OptionPageScene = new Scene(OptionPage.createOptionScene(this::handleBack), 1500, 1000);
                OptionPage.setOptionScene(OptionPageScene);
                primaryStage.show();
        }

        public void start(Stage primaryStage) throws Exception {
                Class.forName("com.pgrental.configuration.FirebaseInitialization");
                HomePage HomeController = new HomePage();

                HomeController.getHomePage(primaryStage);

                primaryStage.setScene(HomeController.getHomeScene());

                primaryStage.setTitle("Abodeify");

                primaryStage.getIcons().add(new Image("file:src\\main\\resources\\images\\icon3.png"));

                primaryStage.show();
        }

        private void handleBack() {

                primaryStage.setScene(OptionPageScene);
        }
}