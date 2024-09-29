package com.pgrental.dataAccess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class OptionPage {
        private ToggleButton tenantButton;
        private ToggleButton ownerButton;
        private Pane root;
        private Stage primaryStage;
        private Scene OptionPageScene;
        private Scene loginScene;
        private String Text;

    public OptionPage() {

    }

    //Method To set primary stage
    public void setOptionPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    //Method To set option Page Scene
    public void setOptionScene(Scene optionScene) {
        this.OptionPageScene = optionScene;
    }

    public Pane createOptionScene(Runnable logoutHandler) {

                Image imageTenant = new Image("file:src\\main\\resources\\images\\wallpaper5.jpg", 1500, 1000,
                                false, false);
                BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                                false,
                                false, false);
                BackgroundImage backgroundImage = new BackgroundImage(imageTenant, BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
                Background background = new Background(backgroundImage);

                // IMAGES

                Image imageOwner = new Image("file:src\\main\\resources\\images\\owner1.png");
                ImageView ivOwner = new ImageView(imageOwner);
                ivOwner.setFitHeight(383);
                ivOwner.setFitWidth(383);
                ivOwner.setPreserveRatio(true);

                Image imageTenet = new Image("file:src\\main\\resources\\images\\tenet3.png");
                ImageView ivTenet = new ImageView(imageTenet);

                // OWNER BUTTON FUNCTIONALITY
                ownerButton = new ToggleButton("OWNER");
                ownerButton.setStyle("-Fx-Background-Color:YELLOW");
                ownerButton.setAlignment(Pos.CENTER);
                ownerButton.setFont(Font.font(null, FontWeight.BOLD, 20));
                ownerButton.setStyle(
                                "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 100px; " +
                                                "-fx-min-height: 90px; " +
                                                "-fx-max-width: 200px; " +
                                                "-fx-max-height: 90px;" + "-Fx-Background-Color:YELLOW");
                ownerButton.setLayoutY(500);
                ownerButton.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                Text = "Owner";
                                try {
                                        initLoginPage();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                                primaryStage.setScene(loginScene);
                        }
                });

                // TENET BUTTON
                tenantButton = new ToggleButton("TENANT");
                tenantButton.setAlignment(Pos.CENTER);
                tenantButton.setFont(Font.font(null, FontWeight.BOLD, 20));
                tenantButton.setStyle(
                                "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 100px; " +
                                                "-fx-min-height: 90px; " +
                                                "-fx-max-width: 200px; " +
                                                "-fx-max-height: 90px;" + "-Fx-Background-Color:YELLOW");

                tenantButton.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                Text = "Tenant";
                                try {
                                        initLoginPage();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                                primaryStage.setScene(loginScene);
                        }
                });

                // OWNER VBOX
                VBox verticalownerBox = new VBox(40,ivOwner, ownerButton);
                verticalownerBox.setAlignment(Pos.CENTER);
                verticalownerBox.setLayoutY(600);
                verticalownerBox.setPrefHeight(200);
                verticalownerBox.setPrefWidth(200);
                verticalownerBox.setLayoutY(800);

                // TENET VBOX
                VBox verticaltenetBox = new VBox(50, ivTenet, tenantButton);
                verticaltenetBox.setPrefHeight(200);
                verticaltenetBox.setPrefWidth(200);
                verticaltenetBox.setAlignment(Pos.CENTER);
                verticaltenetBox.setLayoutY(540);


                // MAIN HBOX
                HBox horizontalBox = new HBox(70, verticalownerBox, verticaltenetBox);
                // horizontalBox.setPrefSize(1500, 1000);
                horizontalBox.setLayoutX(350);
                horizontalBox.setLayoutY(180);

                // Create a Pane and set the background
                root = new Pane();
                root.setBackground(background);

                // Add nodes to the root Pane
                root.getChildren().addAll(horizontalBox);
                return root;
        }

        private void initLoginPage() throws Exception {
                LoginPage loginPage = new LoginPage();
                loginPage.setLoginPage(primaryStage);
                loginScene = new Scene(loginPage.createLoginScene(this::handleBack), 1500, 1000);
                loginPage.setLoginScene(loginScene);
                loginPage.setText(Text);
                primaryStage.show();
        }

        // private void initUserController() throws Exception {
        //         UserController UserController = new UserController();
        //         UserController.setText(Text);
        // }
        
        private void handleBack() {
                primaryStage.setScene(OptionPageScene);
        }
}