package com.pgrental.dataAccess;

import com.pgrental.DashBoard.controller.OwnerController;
import com.pgrental.DashBoard.controller.UserController;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SignupPage {

    private Group group;
    private TextField nameField;
    private Stage primaryStage;
    private Scene signupPageScene, tenantInfoScene, OwnerHomeScene;
    private String Text;
    private UserController userController = new UserController();
    private OwnerController ownerController = new OwnerController();

    public SignupPage(String Text) {
        this.Text = Text;
    }

    // Method To set primary stage
    public void setSignUpPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Method To set Signup Page Scene
    public void setSignUpScene(Scene signupPageScene) {
        this.signupPageScene = signupPageScene;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public Group createSignupScene(Runnable signUpBackHandler) {

        // GIF

        // MAIL GIF
        Image userImage = new Image(getClass().getResourceAsStream("/gif/email.gif"), 750, 1000, true, false);
        // Image userImage = new
        // Image(getClass().getResourceAsStream("/images/usericon.jpeg"), 750, 1000,
        // true, false);
        ImageView userImageView = new ImageView(userImage);
        userImageView.setFitWidth(150);
        userImageView.setFitHeight(150);

        VBox userGifBox = new VBox(userImageView);
        userGifBox.setLayoutX(100);
        userGifBox.setLayoutY(190);
        userGifBox.setPrefSize(100, 100);

        // PASSWORD GIF
        Image passwordImage = new Image(getClass().getResourceAsStream("/gif/pass.gif"), 100, 100, true, true);
        // Image userImage = new
        // Image(getClass().getResourceAsStream("/images/usericon.jpeg"), 750, 1000,
        // true, false);
        ImageView passwordImageView = new ImageView(passwordImage);
        userImageView.setFitWidth(150);
        userImageView.setFitHeight(150);

        VBox passwordGifBox = new VBox(passwordImageView);
        passwordGifBox.setLayoutX(128);
        passwordGifBox.setLayoutY(425);
        passwordGifBox.setPrefSize(10, 10);

        // Label for output messages
        Alert output = new Alert(AlertType.ERROR);
        Alert succesfully = new Alert(AlertType.INFORMATION);
        

        // RIGHT SIDE BACKGROUND
        Image imageTenant = new Image(getClass().getResourceAsStream("/images/13215343.jpg"), 1000, 1000,
                true, true);
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                true,
                false, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageTenant, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        // ANIMATION HBOX
        HBox animatedHBox = new HBox();
        animatedHBox.setPrefSize(350, 5);
        animatedHBox.setStyle("-Fx-Background-Color:BLUE");

        // ANIMATION HBOX 2
        HBox animatedHBox2 = new HBox();
        animatedHBox2.setPrefSize(350, 5);
        animatedHBox2.setStyle("-Fx-Background-Color:BLUE");
        animatedHBox2.setLayoutY(500);

        // IMAGE VBOX
        VBox imageVbox = new VBox();
        imageVbox.setPrefSize(750, 1000);
        imageVbox.setBackground(background);
        imageVbox.setLayoutX(730);
        // imageVbox.setStyle("-Fx-Background-Color:RED");

        // USER VBOX
        Label usernameLabel = new Label("USERNAME");
        usernameLabel.setAlignment(Pos.CENTER);
        usernameLabel.setFont(Font.font("MV Boli", FontWeight.BOLD, 30));
        usernameLabel.setTextFill(Color.BLACK);

        TextField usernameTextField = new TextField();
        usernameTextField.setMaxWidth(350);
        usernameTextField.setPrefWidth(350);
        usernameTextField.setAlignment(Pos.CENTER);
        ((TextInputControl) usernameTextField).setFont(Font.font(null, FontWeight.BOLD, 22));
        usernameTextField.setStyle("-Fx-Background-Color:WHITE");
        usernameTextField.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animatedHBox2.setPrefSize(350, 5);
                animatedHBox.setPrefSize(350, 10);

            }
        });

        // DO NOT HAVE AN ACCOUNT ? LABEL
        Label alreadyhaveanaccLabel = new Label("ALREADY HAVE AN ACCOUNT ?");
        alreadyhaveanaccLabel.setFont(Font.font("MV Boli", FontWeight.BOLD, 15));

        // SIGNUP BUTTON HBOX
        HBox loginHBox = new HBox(alreadyhaveanaccLabel);
        loginHBox.setPrefWidth(250);
        loginHBox.setLayoutX(160);
        loginHBox.setLayoutY(730);

        // signupButton
        Button loginButton = new Button();
        loginButton.setText("LOGIN");
        loginButton.setFont(Font.font(null, FontWeight.BOLD, 15));
        loginButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 100px; " +
                        "-fx-min-height: 30px; " +
                        "-fx-max-width: 200px; " +
                        "-fx-max-height: 30px;" + "-Fx-Background-Color:AQUA");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Login Button Click");
                signUpBackHandler.run();
            }

        });
        loginButton.setLayoutX(410);
        loginButton.setLayoutY(730);

        // USERNAME VBOX
        VBox usernameVBox = new VBox(5, usernameLabel, usernameTextField, animatedHBox);
        usernameVBox.setAlignment(Pos.CENTER);
        usernameVBox.setLayoutX(160);
        usernameVBox.setLayoutY(240);

        // PASSWORD VBOX
        Label passwordLabel = new Label("PASSWORD");
        passwordLabel.setFont(Font.font("MV Boli", FontWeight.BOLD, 30));
        usernameLabel.setTextFill(Color.BLACK);

        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(500);
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setFont(Font.font(null, FontWeight.BOLD, 22));
        passwordField.setStyle("-Fx-Background-Color:WHITE");
        passwordField.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                animatedHBox.setPrefSize(350, 5);
                animatedHBox2.setPrefSize(350, 10);

            }
        });

        // PASSWORD VBOX
        VBox passwordVBox = new VBox(5, passwordLabel, passwordField, animatedHBox2);
        passwordVBox.setAlignment(Pos.CENTER);
        passwordVBox.setLayoutX(150);
        passwordVBox.setLayoutY(440);

        TextField textFieldPassword = new TextField();
        textFieldPassword.setPromptText("Enter Password");
        textFieldPassword.setFocusTraversable(false);
        textFieldPassword.setVisible(false);
        textFieldPassword.setStyle("-fx-min-width: 270;-fx-min-height: 30; -fx-background-radius: 15;");
        textFieldPassword.textProperty().bindBidirectional(
        passwordField.textProperty());

        // Signup BUTTON
        Button signupButton = new Button("       SIGN UP       ");
        signupButton.setLayoutX(180);
        signupButton.setLayoutY(620);
        signupButton.setTextFill(Color.WHITE);

        signupButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 300px; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 300px; " +
                        "-fx-max-height: 70px;" + "-Fx-Background-Color:BLUE");
        signupButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        signupButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("In Signup Button");
                if (!usernameTextField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                    System.out.println("In if else");
                    if(Text == "Tenant") {
                    if (userController.handleSignup(Text,usernameTextField.getText(), passwordField.getText())) {
                        System.out.println("In User");
                        
                        succesfully.setAlertType(AlertType.INFORMATION);
                        succesfully.setHeaderText(null);
                        succesfully.setContentText("USER REGISTERED SUCCESSFULLY");
                        succesfully.showAndWait();
                        initTenantInfoPage();                       
                        
                    } 
                } else if (ownerController.handleSignup(usernameTextField.getText(), passwordField.getText())) {
                        System.out.println("In Owner");
                        
                        succesfully.setAlertType(AlertType.INFORMATION);
                        succesfully.setHeaderText(null);
                        succesfully.setContentText("USER REGISTERED SUCCESSFULLY");
                        succesfully.showAndWait();
                        initOwnerHome();

                    } else {
                        output.setAlertType(AlertType.ERROR);
                        output.setContentText("FAILED TO REGISTER USER");
                        output.show();
                    }
                } else {
                    output.setAlertType(AlertType.WARNING);
                    output.setContentText("PLEASE ENTER USERNAME AND PASSWORD");
                    output.show();
                }
            }
        });

        // MAIN VBOX
        VBox formVbox = new VBox(70);
        formVbox.setPrefSize(750, 1500);
        formVbox.setLayoutX(740);

        // GROUP
        group = new Group(userGifBox, passwordGifBox, imageVbox, usernameVBox, passwordVBox, signupButton, loginButton,
                loginHBox);

        // SCENE
        // Scene scene = new Scene(group);

        // primaryStage.setScene(scene);
        // primaryStage.show();
        return group;
    }

    private void initOwnerHome() {
        System.out.println("In Owner Home");
        OwnerHome OwnerHome = new OwnerHome();
        OwnerHome.setOwnerHome(primaryStage);
        OwnerHomeScene = new Scene(OwnerHome.createOwnerHomeScene(this::handleBack), 1500, 1000);
        OwnerHome.setOwnerHomeScene(OwnerHomeScene);
        primaryStage.setScene(OwnerHomeScene);
        primaryStage.show();
    }

    private void initTenantInfoPage() {
        
        TenantInfo TenantInfo = new TenantInfo();
        TenantInfo.setTenantInfoPage(primaryStage);
        tenantInfoScene = new Scene(TenantInfo.createTenantInfoScene(this::handleBack), 1500, 1000);
        TenantInfo.setTenantInfoScene(tenantInfoScene);
        primaryStage.setScene(tenantInfoScene);
        primaryStage.show();
    }

    private void handleBack() {
        primaryStage.setScene(signupPageScene);
    }
}
