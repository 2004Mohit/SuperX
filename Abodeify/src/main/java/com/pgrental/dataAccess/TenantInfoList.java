package com.pgrental.dataAccess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TenantInfoDetail;

import java.util.List;

import com.pgrental.DashBoard.controller.TenantInfoController;

public class TenantInfoList  {

    Pane root;
    private Stage primaryStage;
    private ImageView imageView;
    private Circle clip;
    private String TenanturlImage;
    private TenantInfoController tenantInfoController = new TenantInfoController();

    public TenantInfoList() {

    }

    //Method To set primary stage
    public void setTenantInfoListPage(Stage primaryStage) {

        this.primaryStage = primaryStage;
    }


    public Pane createTenantListScene(Runnable TenantListBackHandler) {

        root = new Pane();
        VBox vbox = loadTenant();

        // Back Button To Back Page
        Button Back = new Button("Back");
        Back.setFont(new Font(30));
        Back.setLayoutX(150);
        Back.setLayoutY(30);
        Back.setStyle("-fx-background-radius: 2em;");
        Back.setAlignment(Pos.CENTER);

        Back.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                        TenantListBackHandler.run();
                }
        });

        Text Tenant = new Text("Tenants");
        Tenant.setFont(Font.font("Goudy Stout", FontWeight.BOLD, 50));

        HBox Back_Title = new HBox(400, Back, Tenant);
        Back_Title.setPadding(new Insets(30));
        Back_Title.setStyle("-fx-background-color : #4969E1");

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setPrefSize(1500, 850);
        // scrollPane.setStyle("-fx-padding : 0 0 20 0");

        VBox BackTenant = new VBox(Back_Title, scrollPane);

        System.out.println("In CreateTenantList Pane");
        root.getChildren().addAll(BackTenant);
        return root;
    }

    public VBox loadTenant() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        List<TenantInfoDetail> TenantList = tenantInfoController.getTenantInfoData();

        // Create Tenant cards for each Tenant in the list
        for (TenantInfoDetail Tenant : TenantList) {
            HBox TenantCard = createTenantCard(Tenant);
            vbox.getChildren().add(TenantCard);
        }

        return vbox;
    }

    public HBox createTenantCard(TenantInfoDetail Tenant) {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("OWNER HAS BEEN NOTIFIED");

        HBox card = new HBox();
        card.setSpacing(200);
        // card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(10));
        card.setStyle("-fx-background-radius: 2em; -fx-border-color: black; -fx-border-width: 5; -fx-background-color:#87CEFA; -fx-border-radius: 20 20 20 20;");


        if (Tenant != null) {
            if (Tenant.getProfile() != null) {
                TenanturlImage = Tenant.getProfile().toString();
                ImageView imageView = new ImageView(new Image(TenanturlImage, 150, 150, true, true));
                imageView.setFitWidth(250);
                imageView.setFitHeight(250);
                clip = new Circle(125, 125, 120);
                imageView.setClip(clip);
                this.imageView = imageView;
            }
        }

        VBox TenantVBox = new VBox();
        TenantVBox.setSpacing(5);
        TenantVBox.setMaxWidth(800);

        if (Tenant != null) {
            if (Tenant.getName() != null) {
                Text TenantName = new Text("Tenant Name : ");
                TenantName.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label TenantLabel = new Label(Tenant.getName().toString());
                TenantLabel.setFont(new Font(20));
                HBox TenantBox = new HBox(TenantName, TenantLabel);
                TenantBox.setSpacing(5);
                TenantVBox.getChildren().add(TenantBox);
            }


            if (Tenant.getPhoneNo() != null) {
                Text phoneNoText = new Text("Contact No : ");
                phoneNoText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label phoneNo = new Label(Tenant.getPhoneNo().toString());
                phoneNo.setFont(new Font(20));
                HBox phoneNoBox = new HBox(phoneNoText, phoneNo);
                phoneNoBox.setSpacing(5);
                TenantVBox.getChildren().add(phoneNoBox);
            }

            if (Tenant.getAddress() != null) {
                Text address = new Text("Location : ");
                address.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label TenantAddress = new Label(Tenant.getAddress().toString());
                TenantAddress.setFont(new Font(20));
                HBox AddressBox = new HBox(5, address, TenantAddress);
                TenantVBox.getChildren().add(AddressBox);
            }

            if (Tenant.getOccupation() != null) {
                Text Occupation = new Text("Occupation : ");
                Occupation.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label TenantOccupation = new Label(Tenant.getOccupation().toString());
                TenantOccupation.setFont(new Font(20));
                HBox OccupationBox = new HBox(5, Occupation, TenantOccupation);
                TenantVBox.getChildren().add(OccupationBox);
            }

            if (Tenant.getGender() != null) {
                Text Gender = new Text("Gender : ");
                Gender.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label TenantGender = new Label(Tenant.getGender().toString());
                TenantGender.setFont(new Font(20));
                HBox GenderBox = new HBox(5, Gender, TenantGender);
                TenantVBox.getChildren().add(GenderBox);
            }

            if (Tenant.getSetDate() != null) {
                Text dob = new Text("Date of Birth : ");
                dob.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label date = new Label(Tenant.getSetDate().toString());
                date.setFont(new Font(20));
                HBox dateBox = new HBox(5, dob, date);
                TenantVBox.getChildren().add(dateBox);
            }
        }

        HBox infoBox = new HBox(50, imageView, TenantVBox);
        infoBox.setMaxWidth(1050);

        card.getChildren().addAll(infoBox);
        card.setPrefWidth(1450);
        
        return card;
        
    }
    
}