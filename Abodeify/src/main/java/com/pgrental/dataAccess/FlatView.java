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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.FlatDetail;

import java.util.List;

import com.pgrental.DashBoard.controller.FlatController;

public class FlatView  {

    Pane root;
    private Stage primaryStage;
    private ImageView imageView;
    private Rectangle clip;
    private String flaturlImage;
    private FlatController flatController = new FlatController();

    public FlatView() {

    }

    //Method To set primary stage
    public void setFlatViewPage(Stage primaryStage) {

        this.primaryStage = primaryStage;
    }


    public Pane createFlatViewScene(Runnable FlatViewBackHandler) {

        root = new Pane();
        VBox vbox = loadFlats();

        // Back Button To Back Page
        Button Back = new Button("Back");
        Back.setFont(new Font(30));
        Back.setLayoutX(150);
        Back.setLayoutY(30);
        Back.setStyle("-fx-background-radius: 2em;");
        Back.setAlignment(Pos.CENTER);

        Back.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                        FlatViewBackHandler.run();
                }
        });

        Text Flats = new Text("Flats");
        Flats.setFont(Font.font("Goudy Stout", FontWeight.BOLD, 50));

        HBox Back_Title = new HBox(400, Back, Flats);
        Back_Title.setPadding(new Insets(30));
        Back_Title.setStyle("-fx-background-color : #4969E1");

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setPrefSize(1500, 850);

        VBox BackFlats = new VBox(Back_Title, scrollPane);

        System.out.println("In CreateFlatView Pane");
        root.getChildren().addAll(BackFlats);
        return root;
    }

    public VBox loadFlats() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));

        List<FlatDetail> flatList = flatController.getflatData();

        // Create flat cards for each flat in the list
        for (FlatDetail flat : flatList) {
            HBox flatCard = createflatCard(flat);
            vbox.getChildren().add(flatCard);
        }

        return vbox;
    }

    public HBox createflatCard(FlatDetail flat) {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("OWNER HAS BEEN NOTIFIED");

        HBox card = new HBox();
        card.setSpacing(200);
        // card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(10));
        card.setStyle("-fx-background-radius: 2em; -fx-border-color: black; -fx-border-width: 5; -fx-background-color:#87CEFA; -fx-border-radius: 20 20 20 20;");


        if (flat != null) {
            if (flat.getFlatImg() != null) {
                flaturlImage = flat.getFlatImg().toString();
                ImageView imageView = new ImageView(new Image(flaturlImage, 0, 0, true, true));
                imageView.setFitWidth(250);
                imageView.setFitHeight(250);
                clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
                clip.setArcWidth(20);
                clip.setArcHeight(20);
                imageView.setClip(clip);
                this.imageView = imageView;
            }
        }

        VBox flatVBox = new VBox();
        flatVBox.setSpacing(5);
        flatVBox.setPrefWidth(800);

        if (flat != null) {
            if (flat.getFlatOwner() != null) {
                Text flatOwnerName = new Text("flat Owner: ");
                flatOwnerName.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label flatOwner = new Label(flat.getFlatOwner().toString());
                flatOwner.setFont(new Font(20));
                HBox flatOwnerBox = new HBox(flatOwnerName, flatOwner);
                flatOwnerBox.setSpacing(5);
                flatVBox.getChildren().add(flatOwnerBox);
            }

            if (flat.getCity() != null) {
                Text CityText = new Text("Only For : ");
                CityText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label City = new Label(flat.getCity().toString());
                City.setFont(new Font(20));
                HBox CityBox = new HBox(CityText, City);
                CityBox.setSpacing(5);
                flatVBox.getChildren().add(CityBox);
            }

            if (flat.getBuildingName() != null) {
                Text BuildingNameText = new Text("flat Own By : ");
                BuildingNameText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label buildingName = new Label(flat.getBuildingName().toString());
                buildingName.setFont(new Font(20));
                HBox buildingNameBox = new HBox(BuildingNameText, buildingName);
                buildingNameBox.setSpacing(5);
                flatVBox.getChildren().add(buildingNameBox);
            }

            if (flat.getFlatAddress() != null) {
                Text address = new Text("Location : ");
                address.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label flatAddress = new Label(flat.getFlatAddress().toString());
                flatAddress.setFont(new Font(20));
                HBox AddressBox = new HBox(5, address, flatAddress);
                flatVBox.getChildren().add(AddressBox);
            }

            if (flat.getBhk() != null) {
                Text bhk = new Text("BHK : ");
                bhk.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label flatBhk = new Label(flat.getBhk().toString());
                flatBhk.setFont(new Font(20));
                HBox bhkBox = new HBox(5, bhk, flatBhk);
                flatVBox.getChildren().add(bhkBox);
            }

            if (flat.getAvailableFrom() != null) {
                Text AvailableFrom = new Text("Available From : ");
                AvailableFrom.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label date = new Label(flat.getAvailableFrom().toString());
                date.setFont(new Font(20));
                HBox dateBox = new HBox(5, AvailableFrom, date);
                flatVBox.getChildren().add(dateBox);
            }

            if (flat.getFlatDeposit() != null) {
                Text Deposit = new Text("Deposit : ");
                Deposit.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label flatDeposit = new Label(flat.getFlatDeposit().toString());
                flatDeposit.setFont(new Font(20));
                HBox depositBox = new HBox(5, Deposit, flatDeposit);
                flatVBox.getChildren().add(depositBox);
            }
        }

        HBox infoBox = new HBox(50, imageView, flatVBox);
        infoBox.setMaxWidth(1050);

        // Interested Button To Interested Page
        Button Interested = new Button("Interested");
        Interested.setFont(new Font(30));
        Interested.setTextFill(Color.WHITE);
        Interested.setStyle("-fx-background-radius: 2em; -fx-background-color: #0000FF;");
        Interested.setAlignment(Pos.CENTER);

        Interested.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    //Logic for Notification To Owner
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

    // private void handleBack() {
    //     primaryStage.setScene(Flatscene);
    // }

    
}