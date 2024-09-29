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
import model.OwnerDetail;
import model.UserDetail;

public class LoginPage {
    // public class LoginPage extends Application {

    private Scene OwnerHomeScene, TenantPageScene, 
                signupPageScene, 
                loginPageScene;
    private Stage primaryStage;
    private String Text;
    public static String statusOwner;
    public static String statusTenet;

    private UserController userController = new UserController();

    public void setText(String Text) {
        this.Text = Text;
    }

    //Method To set primary stage
    public void setLoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
 
    //Method To set option Page Scene
    public void setLoginScene(Scene loginPageScene) {
        this.loginPageScene = loginPageScene;
    }
    
    public Group createLoginScene(Runnable logoutHandler) throws Exception {     
        // public void start(Stage primaryStage) throws Exception {   
        
        //GIF
        //MAIL GIF
        Image userImage = new Image(getClass().getResourceAsStream("/gif/email.gif"), 750, 1000, true, false);
        //Image userImage = new Image(getClass().getResourceAsStream("/images/usericon.jpeg"), 750, 1000, true, false);
        ImageView userImageView = new ImageView(userImage);
        userImageView.setFitWidth(150);
        userImageView.setFitHeight(150);

        VBox userGifBox = new VBox(userImageView);
        userGifBox.setLayoutX(900);
        userGifBox.setLayoutY(200);
        userGifBox.setPrefSize(100, 100);


        //PASSWORD GIF
        Image passwordImage = new Image(getClass().getResourceAsStream("/gif/pass.gif"), 100, 100, true, false);
        //Image userImage = new Image(getClass().getResourceAsStream("/images/usericon.jpeg"), 750, 1000, true, false);
        ImageView passwordImageView = new ImageView(passwordImage);
        userImageView.setFitWidth(150);
        userImageView.setFitHeight(150);

        VBox passwordGifBox = new VBox(passwordImageView);
        passwordGifBox.setLayoutX(928);
        passwordGifBox.setLayoutY(425);
        passwordGifBox.setPrefSize(10, 10);


        // LEFT SIDE BACKGROUND
        Image imageTenant = new Image(getClass().getResourceAsStream("/images/login2.png"), 900, 1000,true, true);
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


        // USER VBOX
        Label usernameLabel = new Label("USERNAME");
        usernameLabel.setAlignment(Pos.CENTER);
        usernameLabel.setFont(Font.font("MV Boli", FontWeight.BOLD, 30));
        usernameLabel.setTextFill(Color.BLACK);


        TextField usernameTextField = new TextField();
        usernameTextField.setMaxWidth(500);
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
 
        // USERNAME VBOX
                VBox usernameVBox = new VBox(5, usernameLabel, usernameTextField, animatedHBox);
                usernameVBox.setAlignment(Pos.CENTER);
                usernameVBox.setLayoutX(950);
                usernameVBox.setLayoutY(250);
      
      
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

        //DO NOT HAVE AN ACCOUNT ? LABEL
        Label donothaveanaccLabel = new Label("DO NOT HAVE AN ACCOUNT ?");
        donothaveanaccLabel.setFont(Font.font("MV Boli", FontWeight.BOLD, 15));

        //SIGNUP BUTTON
        Button signUpButton = new Button();
        signUpButton.setText("SIGN UP");
        signUpButton.setFont(Font.font(null, FontWeight.BOLD, 15));
        signUpButton.setStyle(
                                "-fx-background-radius: 5em; " +
                                                "-fx-min-width: 140px; " +
                                                "-fx-min-height: 30px; " +
                                                "-fx-max-width: 140px; " +
                                                "-fx-max-height: 30px;" + "-Fx-Background-Color:AQUA");
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                        
                        initSignupPage();
                        primaryStage.setScene(signupPageScene);
                        
                        usernameTextField.clear(); // Clear username field
                        passwordField.clear(); // Clear password field
                }
        });
        signUpButton.setLayoutX(1200);
        signUpButton.setLayoutY(740);
        
        //SIGNUP BUTTON HBOX
        HBox signupHBox = new HBox(10, donothaveanaccLabel, signUpButton);
        // signupHBox.setPrefWidth(500);
        signupHBox.setLayoutX(925);
        signupHBox.setLayoutY(740);

        // PASSWORD VBOX
        VBox passwordVBox = new VBox(5, passwordLabel, passwordField, animatedHBox2);
        passwordVBox.setAlignment(Pos.CENTER);
        passwordVBox.setLayoutX(950);
        passwordVBox.setLayoutY(440);

        // Back Button To Back Page
        Button Back = new Button("Back");
                Back.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
                Back.setTextFill(Color.WHITE);
                // Back.setLayoutX(950);
                // Back.setLayoutY(640);
                Back.setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 170px; " +
                            "-fx-min-height: 70px; " +
                            "-fx-max-width: 170px; " +
                            "-fx-max-height: 70px;" + "-Fx-Background-Color:RED");
                Back.setAlignment(Pos.CENTER);

                Back.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                logoutHandler.run();
                        }
                });

        Alert output = new Alert(AlertType.ERROR); // Label for output messages

        
        // LOGIN BUTTON
        Button loginButton = new Button("   LOGIN   ");

        loginButton.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-width: 150px; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 150px; " +
                        "-fx-max-height: 70px;" + "-Fx-Background-Color:BLUE");
        loginButton.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
        loginButton.setTextFill(Color.WHITE);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if(!usernameTextField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                    System.out.println("In Empty");
                    if(Text == "Tenant") {
                        statusTenet = usernameTextField.getText();
                        System.out.println(statusTenet);
                        if (userController.authenticateUser(usernameTextField.getText(), passwordField.getText())) {
                            System.out.println("In Authen");
                            UserDetail userDetail = userController.getUserDetail(usernameTextField.getText());
                            System.out.println(userDetail);
                            System.out.println("In Tenant");
                                
                                initTenantPage(); // Initialize user scene
                                primaryStage.setScene(TenantPageScene); // Show user scene
                        }else{
                            output.setAlertType(AlertType.ERROR);
                            output.setContentText("INVALID CREDENTIALS");
                            output.show();
                        }
                    } else {
                        System.out.println("In Owner");
                        if (OwnerController.authenticateOwner(usernameTextField.getText(), passwordField.getText())) {
                            System.out.println("In Authen");
                            OwnerDetail ownerDetail = OwnerController.getOwnerDetail(usernameTextField.getText());
                            System.out.println(ownerDetail);
                            statusOwner = usernameTextField.getText();
                            System.out.println(statusOwner);
                            initOwnerHome(); // Initialize user scene
                            primaryStage.setScene(OwnerHomeScene); // Show user scene
                        } else {
                            output.setAlertType(AlertType.ERROR);
                            output.setContentText("INVALID CREDENTIALS");
                            output.show();
                        }
                    }
                    usernameTextField.clear(); // Clear username field
                    passwordField.clear(); // Clear password field
                    
                } else {
                    output.setAlertType(AlertType.WARNING);
                            output.setContentText("PLEASE ENTER USERNAME AND PASSWORD");
                            output.show();
                }
            }
    });



    //HBox for Back and Login Button
    HBox ButtonBox = new HBox(20, Back, loginButton);
    ButtonBox.setLayoutY(640);
    ButtonBox.setLayoutX(950);

        // MAIN VBOX
        VBox formVbox = new VBox(70);
        formVbox.setPrefSize(750, 1500);
        formVbox.setLayoutX(750);


        // GROUP
        Group group = new Group(userGifBox,passwordGifBox,imageVbox, usernameVBox, passwordVBox, ButtonBox, signupHBox);
        group.setStyle("-Fx-Background-Color:BLUE");

        // SCENE
        // Scene scene = new Scene(group);

        // primaryStage.setScene(scene);
        // primaryStage.show();
        return group;
    }

    private void initOwnerHome() {
        OwnerHome OwnerHome = new OwnerHome();
        OwnerHome.setOwnerHome(primaryStage);
        OwnerHomeScene = new Scene(OwnerHome.createOwnerHomeScene(this::handleBack), 1500, 1000);
        OwnerHome.setOwnerHomeScene(OwnerHomeScene);
        primaryStage.setScene(OwnerHomeScene);
        primaryStage.show();
    }

    private void initTenantPage() {
        TenantPage TenantPage = new TenantPage();
        TenantPage.setTenantPage(primaryStage);
        TenantPageScene = new Scene(TenantPage.createTenantPageScene(this::handleBack), 1500, 1000);
        TenantPage.setTenantPageScene(TenantPageScene);
        primaryStage.show();
}

    private void initSignupPage() {
        
        SignupPage signupPage = new SignupPage(Text);
        signupPage.setSignUpPage(primaryStage);
        signupPageScene = new Scene(signupPage.createSignupScene(this::handleBack), 1500, 1000);
        signupPage.setSignUpScene(signupPageScene);
        primaryStage.setScene(signupPageScene);
        primaryStage.show();
    }

    private void handleBack() {
        System.out.println("In Handle Back");
        primaryStage.setScene(loginPageScene);
    }

}
