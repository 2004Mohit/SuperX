package com.pgrental.dataAccess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Announce {

        private Pane root;
        private Stage primaryStage;
        LoginPage OwnerLogin = new LoginPage();
        private Label label1 , label2, label3, label4;
        public String OwnerName = LoginPage.statusOwner;

        public Announce() {

        }

        //Method To set primary stage
        public void setAnnouncePage(Stage primaryStage) {
                this.primaryStage = primaryStage;
        }

        public Pane createAnnounceScene(Runnable AnnounceBackHandler) {

        // Create a background image
        Image imageTenant = new Image("file:src\\main\\resources\\images\\ownerbg.jpg", 1600, 1200,true,false);
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO,
                BackgroundSize.AUTO, false,
                false,
                false, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageTenant,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        
        root = new Pane();

        // WELCOME LABEL
        Label welcome = new Label("WELCOME,\n               " + OwnerName);
        welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 35));
        welcome.setLayoutX(230);
        welcome.setLayoutY(60);

        // OWNER IMAGE
        Image ownerLogo = new Image("file:src\\main\\resources\\images\\owner1.png", 200, 200, true, false);

        // IMAGEVIEW OF OWNER'S IMAGE
        ImageView ownerLogoView = new ImageView(ownerLogo);
        ownerLogoView.setFitHeight(200);
        ownerLogoView.setFitWidth(200);

        // HBOX FOR OWNER'S LOGO
        VBox ownerLogoViewvBox = new VBox(ownerLogoView);
        ownerLogoViewvBox.setLayoutX(500);
        ownerLogoViewvBox.setLayoutY(500);
        ownerLogoViewvBox.setPrefSize(200, 300);

        //MAIN HBOX
        HBox mainBox = new HBox(ownerLogoViewvBox);
        mainBox.setPrefSize(1500, 1000);
        mainBox.setBackground(background);
        
        //Announcement & Line 
        Label Announcement = new Label("Announcements");
        Announcement.setFont(Font.font(null, FontWeight.BOLD, 100));
        Announcement.setLayoutX(650);
        Announcement.setLayoutY(60);

        Line line = new Line(1500, 220, 0, 220);

        //HBox
        label1 = new Label("Welcome to your new home! We are delighted to\nhave you as our tenant. If you have any questions or need assistance,\nplease do not hesitate to contact us.");
        label1.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 30));
        label1.setWrapText(true);
        
        HBox hb1 = new HBox(label1);
        hb1.setStyle("-fx-background-radius: 2em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: linear-gradient(to top right, #9DBFFD, #C4ECFB);");
        hb1.setPadding(new Insets(10));
        hb1.setPrefWidth(1100);
        
        label2 = new Label("Dear Tenants, please be reminded to adhere to the house rules,\nincluding no loud noises after 10 PM," +"keeping common areas clean, and disposing of garbage properly.");
        label2.setWrapText(true);
        label2.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 30));

        HBox hb2 = new HBox(label2);
        hb2.setStyle("-fx-background-radius: 2em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: linear-gradient(to top right, #9DBFFD, #C4ECFB);");
        hb2.setPadding(new Insets(10));
        hb2.setPrefWidth(1100);
        
        label3 = new Label("Dear tenants, we will be holding a community meeting on 27/07/2024 at Office. We encourage all residents to attend and share their feedback and suggestions.\nLight refreshments will be provided.");
        label3.setWrapText(true);
        label3.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 30));

        HBox hb3 = new HBox(label3);
        hb3.setStyle("-fx-background-radius: 2em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: linear-gradient(to top right, #9DBFFD, #C4ECFB);");
        hb3.setPrefWidth(1100);
        hb3.setPadding(new Insets(10));
        
        label4 = new Label("Dear tenants, we have scheduled a pest control service\non 20/07/2024. Please ensure that all food items\nare stored properly and pets are secured during this time.");
        label4.setWrapText(true);
        label4.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 30));

        HBox hb4 = new HBox(label4);
        hb4.setStyle("-fx-background-radius: 2em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: linear-gradient(to top right, #9DBFFD, #C4ECFB);");
        hb4.setPadding(new Insets(10));
        hb4.setPrefWidth(1100);

        VBox vb = new VBox(20, hb1, hb2, hb3, hb4);
        vb.setLayoutX(150);
        vb.setLayoutY(240);

        // Back Button To Back Page
        Button Back = new Button("Back");
                Back.setFont(new Font(30));
                Back.setLayoutX(150);
                Back.setLayoutY(850);
                Back.setStyle("-fx-background-radius: 2em;");
                Back.setAlignment(Pos.CENTER);

                Back.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                AnnounceBackHandler.run();
                        }
                });
 
        root.getChildren().addAll(mainBox, welcome, Announcement, line, vb, Back);
        return root;
    }

}
