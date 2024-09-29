package com.pgrental.dataAccess;

import com.pgrental.dataAccess.NotificationView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.HostelDetail;

import java.util.List;

import com.pgrental.DashBoard.controller.HostelController;

public class HostelView  {

    Pane root;
    private Stage primaryStage;
    private ImageView imageView;
    private Rectangle clip;
    private String hostelurlImage, notification;
    private String TenantName = LoginPage.statusTenet;
    private HostelController HostelController = new HostelController();

    public HostelView() {

    }

    //Method To set primary stage
    public void setHostelViewPage(Stage primaryStage) {

        this.primaryStage = primaryStage;
    }


    public Pane createHostelViewScene(Runnable HostelViewBackHandler) {

        root = new Pane();
        VBox vbox = loadhostels();

        // Back Button To Back Page
        Button Back = new Button("Back");
        Back.setFont(new Font(30));
        Back.setLayoutX(150);
        Back.setLayoutY(30);
        Back.setStyle("-fx-background-radius: 2em;");
        Back.setAlignment(Pos.CENTER);

        Back.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    System.out.println("In HostelView Back");
                        HostelViewBackHandler.run();
                }
        });

        Text Hostels = new Text("Hostels");
        Hostels.setFont(Font.font("Goudy Stout", FontWeight.BOLD, 50));

        HBox Back_Title = new HBox(400, Back, Hostels);
        Back_Title.setPadding(new Insets(30));
        Back_Title.setStyle("-fx-background-color : #4969E1");

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setPrefSize(1500, 850);
        //scrollPane.setStyle("-fx-padding : 0 0 20 0");

        VBox BackHostels = new VBox(Back_Title, scrollPane);

        System.out.println("In CreateHostelView Pane");
        root.getChildren().addAll(BackHostels);
        return root;
    }

    public VBox loadhostels() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));

        List<HostelDetail> HostelList = HostelController.gethostelData();

        // Create Hostel cards for each Hostel in the list
        for (HostelDetail Hostel : HostelList) {
            HBox HostelCard = createHostelCard(Hostel);
            vbox.getChildren().add(HostelCard);
        }
        return vbox;
    }

    public HBox createHostelCard(HostelDetail hostel) {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("OWNER HAS BEEN NOTIFIED");

        HBox card = new HBox();
        card.setSpacing(200);
        // card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(10));
        card.setStyle("-fx-background-radius: 2em; -fx-border-color: black; -fx-border-width: 5; -fx-background-color:#87CEFA; -fx-border-radius: 20 20 20 20;");


        if (hostel != null) {
            if (hostel.getHostelImg() != null) {
                hostelurlImage = hostel.getHostelImg().toString();
                ImageView imageView = new ImageView(new Image(hostelurlImage, 0, 0, true, true));
                imageView.setFitWidth(250);
                imageView.setFitHeight(250);
                clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
                clip.setArcWidth(20);
                clip.setArcHeight(20);
                imageView.setClip(clip);
                this.imageView = imageView;
            }
        }

        VBox hostelVBox = new VBox();
        hostelVBox.setSpacing(5);
        hostelVBox.setPrefWidth(800);

        if (hostel != null) {
            if (hostel.getHostelName() != null) {
                Text HostelName = new Text("Hostel Name: ");
                HostelName.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label hostelName = new Label(hostel.getHostelName().toString());
                hostelName.setFont(new Font(20));
                HBox HosteNameBox = new HBox(HostelName, hostelName);
                HosteNameBox.setSpacing(5);
                hostelVBox.getChildren().add(HosteNameBox);
            }

            if (hostel.getGender() != null) {
                Text genderText = new Text("Only For : ");
                genderText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label gender = new Label(hostel.getGender().toString());
                gender.setFont(new Font(20));
                HBox GenderBox = new HBox(genderText, gender);
                GenderBox.setSpacing(5);
                hostelVBox.getChildren().add(GenderBox);
            }

            if (hostel.getOwnBy() != null) {
                Text ownByText = new Text("Hostel Own By : ");
                ownByText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label HostelOwn = new Label(hostel.getOwnBy().toString());
                HostelOwn.setFont(new Font(20));
                HBox HostelOwnBox = new HBox(ownByText, HostelOwn);
                HostelOwnBox.setSpacing(5);
                hostelVBox.getChildren().add(HostelOwnBox);
                Text HostelOwnerName;
                Label HostelOwner;
                HBox HostelOwnerBox = new HBox();

                if(hostel.getOwnBy().toString().equals("Private")) {
                    System.out.println("In if else Private");
                    if (hostel.getOwnerName() != null) {
                    System.out.println("In if else HostelOwnerName");
                        HostelOwnerName = new Text("Hostel Owner Name : ");
                        HostelOwnerName.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                        HostelOwner = new Label(hostel.getOwnerName().toString());
                        HostelOwner.setFont(new Font(20));
                        // HostelOwnerBox = new HBox(HostelOwnerName, HostelOwner);
                        HostelOwnerBox.getChildren().addAll(HostelOwnerName, HostelOwner);
                        // HostelOwnerBox.setSpacing(5);
                        
                    }
                } else {
                    
                }
                HostelOwnerBox.setSpacing(5);
                hostelVBox.getChildren().add(HostelOwnerBox);
            }

            if (hostel.getAddress() != null) {
                Text address = new Text("Location : ");
                address.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label HostelAddress = new Label(hostel.getAddress().toString());
                HostelAddress.setFont(new Font(20));
                HBox AddressBox = new HBox(5, address, HostelAddress);
                hostelVBox.getChildren().add(AddressBox);
            }

            if (hostel.getNoofBeds() != null) {
                Text Beds = new Text("Number of Beds : ");
                Beds.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label HostelBeds = new Label(hostel.getNoofBeds().toString());
                HostelBeds.setFont(new Font(20));
                HBox BedBox = new HBox(5, Beds, HostelBeds);
                hostelVBox.getChildren().add(BedBox);
            }

            if (hostel.getHostelFees() != null) {
                Text hostelFees = new Text("Hostel Fees : ");
                hostelFees.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label Fees = new Label(hostel.getHostelFees().toString());
                Fees.setFont(new Font(20));
                HBox feesBox = new HBox(5, hostelFees, Fees);
                hostelVBox.getChildren().add(feesBox);
            }

            if (hostel.getDeposit() != null) {
                Text Deposit = new Text("Deposit : ");
                Deposit.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label hostelDeposit = new Label(hostel.getDeposit().toString());
                hostelDeposit.setFont(new Font(20));
                HBox depositBox = new HBox(5, Deposit, hostelDeposit);
                hostelVBox.getChildren().add(depositBox);
            }
        }

        HBox infoBox = new HBox(50, imageView, hostelVBox);
        infoBox.setMaxWidth(1050);

        // Interested Button To Interested Page
        Button Interested = new Button("Interested");
        Interested.setFont(new Font(30));
        Interested.setTextFill(Color.WHITE);
        Interested.setStyle("-fx-background-radius: 2em; -fx-background-color: #0000FF;");
        Interested.setAlignment(Pos.CENTER);

        Interested.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    System.out.println("HostelView Interested Pressed");
                    notification = TenantName + " is Interested in Your Hostel";
                    NotificationView.addNotification(notification);
                    Interested.setDisable(true);
                    alert.showAndWait();
                }
        });

        HBox InterestedBox = new HBox(Interested);
        InterestedBox.setAlignment(Pos.CENTER);
        InterestedBox.setPrefWidth(400);

        card.getChildren().addAll(infoBox, InterestedBox);
        card.setPrefWidth(1450);
        
        return card;
    }
    
}