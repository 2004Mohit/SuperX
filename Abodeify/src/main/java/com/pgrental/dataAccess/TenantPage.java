package com.pgrental.dataAccess;

import com.pgrental.dataAccess.NotificationView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TenantPage {
        private Pane root;
        private String TenantName = LoginPage.statusTenet;
        private Stage primaryStage;
        private Scene NotifyViewScene, TenantScene, HostelViewScene, FlatViewScene, PGViewScene, OptionPageScene, ReviewScene, AboutUsScene;

        public TenantPage() {

        }

        // Method To set primary stage
        public void setTenantPage(Stage primaryStage) {
                this.primaryStage = primaryStage;
        }

        // Method To set option Page Scene
        public void setTenantPageScene(Scene TenantScene) {
                this.TenantScene = TenantScene;
        }

        public void setTenantName(String TenantName) {
                System.out.println(TenantName);
                this.TenantName = TenantName;
        }

        // public void start(Stage primaryStage) throws Exception {
        public Pane createTenantPageScene(Runnable TenantPageBackHandler) {

                Image imageHome = new Image("file:src\\main\\resources\\images\\Tenantbg.jpg",
                                1500, 1000, false, false);
                BackgroundSize backgroundSize = new BackgroundSize(
                                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                BackgroundImage backgroundImage = new BackgroundImage(
                                imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                backgroundSize);
                Background background = new Background(backgroundImage);

                root = new Pane();
                root.setBackground(background);
                root.setPrefSize(1500, 1000);

                // Create ImageView for tenant
                Image imageOfTenant = new Image(getClass().getResourceAsStream("/images/tenet3.png"));

                ImageView imageOfTenantView = new ImageView(imageOfTenant);
                imageOfTenantView.setFitHeight(200);
                imageOfTenantView.setFitWidth(200);
                imageOfTenantView.setLayoutX(20);
                imageOfTenantView.setLayoutY(25);

                // Create welcome label
                Label welcome = new Label("WELCOME,\n               " + TenantName);
                welcome.setTextFill(Color.BLANCHEDALMOND);
                welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 45));
                welcome.setLayoutX(230);
                welcome.setLayoutY(60);

                // Logout Button
                Image imagelogout = new Image(getClass().getResourceAsStream("/images/Logoutbg.png"), 1500, 1000, true,
                                false);

                BackgroundSize logoutbg = new BackgroundSize(
                                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
                BackgroundImage logoutbgImage = new BackgroundImage(
                                imagelogout, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                logoutbg);
                Background logoutBackground = new Background(logoutbgImage);

                // CUSTOMER CARE
                String customer[] = { "9856253625 ", "9856659825" };
                @SuppressWarnings("rawtypes")
                ComboBox care_box = new ComboBox<>(FXCollections.observableArrayList(customer));
                care_box.setPromptText("Customer Care");
                care_box.setLayoutX(1225);
                care_box.setLayoutY(65);

                // Notification
                Image imageNotify = new Image("file:src\\main\\resources\\images\\notification.png",
                                1500, 1000, true, false);
                ImageView NotifyView = new ImageView(imageNotify);
                NotifyView.setFitHeight(40);
                NotifyView.setFitWidth(40);

                Button notify = new Button();
                notify.setStyle(
                                "-fx-background-radius: 5em; " +
                                                "-fx-min-height: 50px; " +
                                                "-fx-max-width: 30px;");
                notify.setGraphic(NotifyView);
                notify.setLayoutX(1400);
                notify.setLayoutY(50);
                notify.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                initNotifyScene();
                                primaryStage.setScene(NotifyViewScene);
                        }
                });

                // LOGOUT BUTTON
                Button logoutButton = new Button();
                logoutButton.setFont(new Font(40));
                logoutButton.setStyle("-fx-backgound-Color : #795695");
                logoutButton.setLayoutX(1150);
                logoutButton.setLayoutY(35);
                logoutButton.setBackground(logoutBackground);
                logoutButton.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                initOptionScene();
                                primaryStage.setScene(OptionPageScene);
                        }
                });

                //Hbox for Logout, careBox & Notify Button
                HBox TopButton = new HBox(20, logoutButton, care_box, notify);
                TopButton.setAlignment(Pos.CENTER);
                TopButton.setLayoutX(1130);
                TopButton.setLayoutY(35);

                // Hostel Button
                Button Hostel = new Button("Hostel");
                Hostel.setPrefSize(300, 250);
                Hostel.setFont(Font.font(null, FontWeight.BOLD, 40));
                Hostel.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                initHostelView();
                        }
                });

                // Flat Button
                Button Flat = new Button("Flat");
                Flat.setPrefSize(300, 250);
                Flat.setFont(Font.font(null, FontWeight.BOLD, 40));
                Flat.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                initflatView();
                        }
                });

                // PG Button
                Button PG = new Button("PG");
                PG.setPrefSize(300, 250);
                PG.setFont(Font.font(null, FontWeight.BOLD, 40));
                PG.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                initPGView();
                        }
                });

                HBox buttonBox = new HBox(70, Hostel, Flat, PG);
                buttonBox.setPadding(new Insets(20));
                buttonBox.setStyle("-fx-background-radius: 1em; "
                                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);" +
                                "-fx-background-color: linear-gradient(to right, #808991, #5C6366);");

                // COMPLAINT FORM
                Label fullnameLabel = new Label("NAME");
                fullnameLabel.setAlignment(Pos.CENTER_LEFT);
                fullnameLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
                fullnameLabel.setTextFill(Color.BLACK);

                TextField fullnameTextField = new TextField();
                fullnameTextField.setPromptText("ENTER YOUR FULL NAME");

                Label emailnameLabel = new Label("EMAIL ID");
                emailnameLabel.setAlignment(Pos.CENTER_LEFT);
                emailnameLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
                emailnameLabel.setTextFill(Color.BLACK);

                TextField emailnameTextField = new TextField();
                emailnameTextField.setPromptText("ENTER YOUR EMAIL ID");

                Label phoneNoLabel = new Label("PHONE NUMBER");
                phoneNoLabel.setAlignment(Pos.CENTER_LEFT);
                phoneNoLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
                phoneNoLabel.setTextFill(Color.BLACK);

                TextField phoneNumberField = new TextField();
                phoneNumberField.setPromptText("ENTER YOUR PHONE NUMBER");

                Label complaintLabel = new Label("COMPLAINT");
                complaintLabel.setAlignment(Pos.CENTER_LEFT);
                complaintLabel.setFont(Font.font(null, FontWeight.BOLD, 15));
                complaintLabel.setTextFill(Color.BLACK);

                TextField complaintField = new TextField();
                complaintField.setPromptText("ENTER YOUR COMPLAINT HERE");
                complaintField.setPrefHeight(200);

                Button submitButton = new Button("SUBMIT");
                submitButton.setTextFill(Color.WHITE);
                submitButton.setFont(Font.font(null, FontWeight.BOLD, 15));
                submitButton.setStyle(
                                "-fx-background-radius: 5em; ;-fx-background-radius: 5em; -fx-border-color: black; -fx-border-width: 0; -fx-background-color:#008000;");
                submitButton.setPrefSize(200, 50);

                Button closeButton = new Button("CLOSE");
                closeButton.setFont(Font.font(null, FontWeight.BOLD, 15));
                closeButton.setTextFill(Color.WHITE);
                closeButton.setStyle(
                                "-fx-background-radius: 5em; ;-fx-background-radius: 5em; -fx-border-color: black; -fx-border-width: 0; -fx-background-color:#FF7F7F;");
                closeButton.setPrefSize(200, 50);

                VBox complaintFormVbox = new VBox(10, fullnameLabel, fullnameTextField, emailnameLabel,
                                emailnameTextField,
                                phoneNoLabel, phoneNumberField, complaintLabel, complaintField, submitButton,
                                closeButton);
                complaintFormVbox.setLayoutX(200);
                complaintFormVbox.setLayoutY(250);
                complaintFormVbox.setVisible(false);
                // complaintFormVbox.setStyle("-fx-background-color:#FFFFFF;");
                complaintFormVbox.setPrefSize(500, 700);
                complaintFormVbox.setAlignment(Pos.CENTER);
                complaintFormVbox.setPadding(new Insets(20));
                complaintFormVbox.setStyle(
                                "-fx-background-radius: 5em; ;-fx-background-radius: 4em; -fx-border-color: black; -fx-border-width: 0; -fx-background-color:#FFFFFF;");

                Button Complaint = new Button("Complaint");
                Complaint.setPrefSize(800, 100);
                Complaint.setFont(Font.font(null, FontWeight.BOLD, 25));
                Complaint.setStyle(
                                "-fx-background-radius: 5em; ;-fx-background-radius: 5em; -fx-border-color: black; -fx-border-width: 0; -fx-background-color:#87CEFA;");
                Complaint.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                complaintFormVbox.setVisible(true);
                                // backgroundImage.setEffect(blur);
                                complaintFormVbox.setEffect(null);
                                // root.setEffect(b);

                        }

                });

                closeButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                complaintFormVbox.setVisible(false);
                                root.setEffect(null);
                                // complaintFormVbox.setEffect(null);
                        }
                });

                submitButton.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                Alert alert = new Alert(AlertType.CONFIRMATION);
                                alert.setContentText("COMPLAINT SUBMITTED");
                                alert.show();
                                emailnameTextField.clear();
                                phoneNumberField.clear();
                                fullnameTextField.clear();
                                complaintField.clear();
                        }
                });

                Button Review = new Button("Review");
                Review.setPrefSize(600, 100);
                Review.setFont(Font.font(null, FontWeight.BOLD, 30));
                Review.setStyle(
                        "-fx-background-radius: 5em; ;-fx-background-radius: 5em; -fx-border-color: black; -fx-border-width: 0; -fx-background-color:#87CEFA;");
                Review.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                System.out.println("In Review");
                                initReviewView();
                                primaryStage.setScene(ReviewScene);
                        }
                });

                Button AboutUs = new Button("AboutUs");
                AboutUs.setPrefSize(400, 100);
                AboutUs.setFont(Font.font(null, FontWeight.BOLD, 30));
                AboutUs.setStyle(
                        "-fx-background-radius: 5em; ;-fx-background-radius: 5em; -fx-border-color: black; -fx-border-width: 0; -fx-background-color:#87CEFA;");
                AboutUs.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                System.out.println("In AboutUs");
                                initAboutUsView();
                                primaryStage.setScene(AboutUsScene);
                        }
                });

                VBox Button_Review = new VBox(30, buttonBox, Complaint, Review, AboutUs);
                Button_Review.setAlignment(Pos.CENTER);
                Button_Review.setLayoutX(200);
                Button_Review.setLayoutY(250);

                root.getChildren().addAll(imageOfTenantView, welcome, TopButton, Button_Review, complaintFormVbox);
                return root;
        }

        // Method To on Notification Click
        private void initNotifyScene() {
                NotificationView NotifyView = new NotificationView();
                NotifyView.setNotificationViewPage(primaryStage);
                NotifyViewScene = new Scene(NotifyView.createNotificationViewScene(this::handleBack), 1500, 1000);
                primaryStage.show();
        }

        // Method To on Logout Click
        private void initOptionScene() {
                OptionPage OptionPage = new OptionPage();
                OptionPage.setOptionPage(primaryStage);
                OptionPageScene = new Scene(OptionPage.createOptionScene(this::handleBack), 1500, 1000);
                OptionPage.setOptionScene(OptionPageScene);
                primaryStage.show();
        }

        // Method To HostelView Page
        private void initHostelView() {
                HostelView HostelViewPage = new HostelView();
                HostelViewPage.setHostelViewPage(primaryStage);
                HostelViewScene = new Scene(HostelViewPage.createHostelViewScene(this::handleBack), 1500, 1000);
                primaryStage.setScene(HostelViewScene);
                primaryStage.show();
        }

        // Method To FlatView Page
        private void initflatView() {
                FlatView flatViewPage = new FlatView();
                flatViewPage.setFlatViewPage(primaryStage);
                FlatViewScene = new Scene(flatViewPage.createFlatViewScene(this::handleBack), 1500, 1000);
                primaryStage.setScene(FlatViewScene);
                primaryStage.show();
        }
        
        // Method To PGView Page
        private void initPGView() {
                PGView PGViewPage = new PGView();
                PGViewPage.setPGViewPage(primaryStage);
                PGViewScene = new Scene(PGViewPage.createPGViewScene(this::handleBack), 1500, 1000);
                primaryStage.setScene(PGViewScene);
                primaryStage.show();
        }

        //Method To Review Page
        private void initReviewView() {
                Review ReviewPage = new Review();
                ReviewPage.setReviewPage(primaryStage);
                ReviewScene = new Scene(ReviewPage.createReviewScene(this::handleBack), 1500, 1000);
                primaryStage.setScene(ReviewScene);
                primaryStage.show();
        }

        //Method To AboutUs Page
        private void initAboutUsView() {
                AboutUs AboutUsPage = new AboutUs();
                AboutUsPage.setAboutPage(primaryStage);
                AboutUsScene = new Scene(AboutUsPage.createAboutScene(this::handleBack), 1500, 1000);
                primaryStage.setScene(AboutUsScene);
                primaryStage.show();
        }

        private void handleBack() {
                System.out.println("In Handle Back");
                primaryStage.setScene(TenantScene);
        }

}
