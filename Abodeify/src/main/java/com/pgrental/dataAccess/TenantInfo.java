package com.pgrental.dataAccess;

import java.io.File;

import com.pgrental.DashBoard.controller.TenantInfoController;
import com.pgrental.Services.ImageUploader;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.TenantInfoDetail;

public class TenantInfo {

        private Stage primaryStage;
        private Scene tenantInfoScene, TenantPageScene;
        private String imgUrl;
        protected String Gender;
        static String fullName;
        private TenantInfoController tenantInfoController = new TenantInfoController();
        private String TenantName;

        // Output label for messages
        Alert output = new Alert(AlertType.ERROR);
        public Object lastnameTextField;

        public TenantInfo() {

        }

        // Method To set primary stage
        public void setTenantInfoPage(Stage primaryStage) {
                this.primaryStage = primaryStage;
        }

        // Method To set option Page Scene
        public void setTenantInfoScene(Scene tenantInfoScene) {
                this.tenantInfoScene = tenantInfoScene;
        }

        public VBox createTenantInfoScene(Runnable TenantBackHandler) {

                // Alert for Successful message
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Added successfully");

                Image imageHome = new Image("file:src\\main\\resources\\images\\Tenantbg.jpg",
                                1500, 1000, false, true);
                BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                                false, false, false);
                BackgroundImage backgroundImage = new BackgroundImage(
                                imageHome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                backgroundSize);
                Background background = new Background(backgroundImage);

                VBox root = new VBox(10);
                root.setAlignment(Pos.CENTER);
                // root.setStyle("-fx-background-color: linear-gradient(to bottom, #008080,
                // #005959);");
                root.setBackground(background);

                // Create a VBox for the login form
                VBox loginForm = new VBox(10);
                loginForm.setLayoutX(500);
                loginForm.setLayoutY(100);
                loginForm.setAlignment(Pos.CENTER_LEFT);
                loginForm.setStyle(
                                "-fx-background-color: rgba(255, 255, 255, 0.8);  -fx-background-radius: 10;");
                Label loginLabel = new Label("FILL YOUR INFORMATION");
                loginLabel.setFont(new Font("Arial", 24));
                loginLabel.setTextFill(Color.DARKCYAN);
                loginForm.setMaxWidth(400);
                loginForm.setPrefHeight(700);
                loginForm.setPadding(new Insets(20));

                // loginForm.setBlendMode(BlendMode.COLOR_BURN);
                // loginForm.setPrefSize(5, 700);
                Label firstnameLabel = new Label("FIRST NAME");
                firstnameLabel.setAlignment(Pos.CENTER_LEFT);
                firstnameLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                TextField firstnameTextField = new TextField();
                firstnameTextField.setPromptText("ENTER YOUR FIRST NAME");

                Label lastNameLabel = new Label("LAST NAME");
                lastNameLabel.setAlignment(Pos.CENTER_LEFT);
                lastNameLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                TextField lastnameTextField = new TextField();
                lastnameTextField.setPromptText("ENTER YOUR LAST NAME");

                Label phoneNoLabel = new Label("PHONE NUMBER");
                phoneNoLabel.setAlignment(Pos.CENTER_LEFT);
                phoneNoLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                TextField phoneNumberField = new TextField();
                phoneNumberField.setPromptText("ENTER YOUR PHONE NUMBER");

                Label addressLabel = new Label("ADDRESS");
                addressLabel.setAlignment(Pos.CENTER_LEFT);
                addressLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                TextField addresTextField = new TextField();
                addresTextField.setPromptText("ENTER YOUR PERMANENT ADDRESS");

                Label genderLabel = new Label("GENDER");
                genderLabel.setAlignment(Pos.CENTER_LEFT);
                genderLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                Label occupationLabel = new Label("OCCUPATION");
                occupationLabel.setAlignment(Pos.CENTER_LEFT);
                occupationLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                TextField occupationField = new TextField();
                occupationField.setPromptText("ENTER YOUR OCCUPATION");

                RadioButton Female = new RadioButton("Female");
                RadioButton Male = new RadioButton("Male");
                Female.setFont(Font.font(null, FontWeight.BOLD, 15));
                Male.setFont(Font.font(null, FontWeight.BOLD, 15));
                ToggleGroup toggleGroup = new ToggleGroup();
                Female.setToggleGroup(toggleGroup);
                Male.setToggleGroup(toggleGroup);

                fullName = firstnameTextField.getText() + lastnameTextField.getText();

                HBox genderButtonBox = new HBox(10);
                genderButtonBox.getChildren().addAll(Female, Male);
                toggleGroup.selectedToggleProperty();

                Male.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                Gender = "Male";
                                System.out.println(Gender);
                        }

                });

                Female.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                                Gender = "Female";
                                System.out.println(Gender);
                        }

                });

                // DOB
                Label date = new Label("ENTER DOB :");
                date.setFont(Font.font(null, FontWeight.BOLD, 15));

                DatePicker setDate = new DatePicker();
                setDate.setPromptText("DD-MM-YYYY");

                Button submitButton = new Button("SUBMIT");
                submitButton.setStyle(
                                "-fx-background-color: #333333; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");
                submitButton.setLayoutX(100);
                submitButton.setLayoutY(500);

                ImageView pgView = new ImageView();
                Button uploadButton = new Button("Upload Image");
                uploadButton.setTextFill(Color.WHITE);
                uploadButton.setStyle("-fx-background-color:blue;");

                Label profilepcLabel = new Label("PROFILE PHOTO");
                profilepcLabel.setAlignment(Pos.CENTER_LEFT);
                profilepcLabel.setFont(Font.font(null, FontWeight.BOLD, 15));

                // Set up the file chooser
                FileChooser pgFileChooser = new FileChooser();
                pgFileChooser.getExtensionFilters().addAll(
                                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

                // Set up the button action
                uploadButton.setOnAction(event -> {
                        File selectedFile = pgFileChooser.showOpenDialog(null);
                        if (selectedFile != null) {
                                String imageUrl = ImageUploader.uploadImage(selectedFile.getPath(),
                                                selectedFile.getName());

                                this.imgUrl = imageUrl;
                                if (imageUrl != null) {
                                        System.out.println(imageUrl);
                                        Image image = new Image(imageUrl);
                                        pgView.setImage(image);
                                }
                        }
                });

                // Back Button
                Button Back = new Button("Back");
                Back.setLayoutX(600);
                Back.setLayoutY(800);
                Back.setAlignment(Pos.CENTER);
                Back.setFont(Font.font(null, FontWeight.BOLD, 15));
                Back.setStyle(" -fx-background-color:red;-fx-padding: 10px 20px;");
                Back.setTextFill(Color.WHITE);
                Back.setOnAction(new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent event) {
                                TenantBackHandler.run();
                        }
                });

                // HBox buttonBox = new HBox(50, Back, submitButton);


                submitButton.setOnAction(new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent event) {

                                System.out.println("In Add Button");
                                TenantInfoDetail tenantInfoData = new TenantInfoDetail(firstnameTextField.getText(),
                                                lastnameTextField.getText(), phoneNumberField.getText(),
                                                addresTextField.getText(), occupationField.getText(), Gender,
                                                setDate.getValue().toString());

                                if (imgUrl != null) {
                                        tenantInfoData.setProfile(imgUrl);
                                } else {
                                        output.setContentText("Please add Image");
                                        output.showAndWait();
                                }

                                // Check if all compulsory fields are filled
                                if (checkCompulsoryFieldsofTenantInfo(tenantInfoData)) {
                                        // Attempt to add the Hostel using the HostelController
                                        if (tenantInfoController.addTenantInfoData(tenantInfoData)) {
                                                alert.showAndWait();
                                                initTenantScene();
                                                primaryStage.setScene(TenantPageScene);

                                                firstnameTextField.clear();
                                                lastnameTextField.clear();
                                                phoneNumberField.clear();
                                                addresTextField.clear();
                                                occupationField.clear();
                                                Gender = null;
                                                setDate.setValue(null);
                                                imgUrl = null;

                                        } else {
                                                output.setContentText("Hostel Not Added");
                                                output.showAndWait();

                                        }
                                } else {
                                        output.setContentText("Fields are Empty");
                                        output.showAndWait();
                                }
                        }
                });

                String TenantName = firstnameTextField.getText();
                this.TenantName = TenantName;
                // TenantName.setFont(new Font(20));

                loginForm.getChildren().addAll(loginLabel, firstnameLabel, firstnameTextField, lastNameLabel,
                                lastnameTextField, genderLabel, genderButtonBox, date, setDate, phoneNoLabel,
                                phoneNumberField,
                                addressLabel, addresTextField, occupationLabel, occupationField, profilepcLabel,
                                uploadButton, submitButton);
                root.getChildren().addAll(loginForm, Back);
                return root;
        }

        // Method To on Logout Click
        private void initTenantScene() {
                TenantPage TenantPage = new TenantPage();
                TenantPage.setTenantPage(primaryStage);
                TenantPage.setTenantName(TenantName);
                TenantPageScene = new Scene(TenantPage.createTenantPageScene(this::handleBack), 1500, 1000);
                TenantPage.setTenantPageScene(TenantPageScene);
                primaryStage.show();
        }

        private boolean checkCompulsoryFieldsofTenantInfo(TenantInfoDetail TenantInfo) {
                if (TenantInfo.getFirstName().trim().isEmpty()
                                || TenantInfo.getLastName().trim().isEmpty()
                                || TenantInfo.getPhoneNo().trim().isEmpty()
                                || TenantInfo.getAddress().trim().isEmpty()
                                || TenantInfo.getOccupation().trim().isEmpty()
                                || TenantInfo.getGender().trim().isEmpty()
                                || TenantInfo.getSetDate().trim().isEmpty()
                                || TenantInfo.getProfile().trim().isEmpty()) {

                        return false;

                }
                return true;
        }

        private void handleBack() {
                primaryStage.setScene(tenantInfoScene);
        }

}