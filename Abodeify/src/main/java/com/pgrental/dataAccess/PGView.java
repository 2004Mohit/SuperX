package com.pgrental.dataAccess;

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
import model.PgDetail;
import java.util.List;

import com.pgrental.DashBoard.controller.PgController;

public class PGView  {

    Pane root;
    private Stage primaryStage;
    private ImageView imageView;
    private Rectangle clip;
    private String pgurlImage;
    private PgController pgController = new PgController();

    public PGView() {

    }

    //Method To set primary stage
    public void setPGViewPage(Stage primaryStage) {

        this.primaryStage = primaryStage;
    }

    // public void setPGViewScene(Scene pgScene) {

    //     this.pgScene = pgScene;
    // }

    public Pane createPGViewScene(Runnable PGViewBackHandler) {

        root = new Pane();
        VBox vbox = loadPG();

        // Back Button To Back Page
        Button Back = new Button("Back");
        Back.setFont(new Font(30));
        Back.setLayoutX(150);
        Back.setLayoutY(30);
        Back.setStyle("-fx-background-radius: 2em;");
        Back.setAlignment(Pos.CENTER);

        Back.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                        PGViewBackHandler.run();
                }
        });

        Text PG = new Text("PG");
        PG.setFont(Font.font("Goudy Stout", FontWeight.BOLD, 50));

        HBox Back_Title = new HBox(400, Back, PG);
        Back_Title.setPadding(new Insets(30));
        Back_Title.setStyle("-fx-background-color : #4969E1");

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setPrefSize(1500, 850);
        // scrollPane.setStyle("-fx-padding : 0 0 20 0");

        VBox BackPG = new VBox(Back_Title, scrollPane);

        System.out.println("In CreatePGView Pane");
        root.getChildren().addAll(BackPG);
        return root;
    }

    public VBox loadPG() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));

        List<PgDetail> pgList = pgController.getpgData();

        // Create pg cards for each pg in the list
        for (PgDetail pg : pgList) {
            HBox pgCard = createpgCard(pg);
            vbox.getChildren().add(pgCard);
        }

        return vbox;
    }

    public HBox createpgCard(PgDetail pg) {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("OWNER HAS BEEN NOTIFIED");

        HBox card = new HBox();
        card.setSpacing(200);
        card.setPadding(new Insets(10));
        card.setStyle("-fx-background-radius: 2em; -fx-border-color: black; -fx-border-width: 5; -fx-background-color:#87CEFA; -fx-border-radius: 20 20 20 20;");


        if (pg != null) {
            if (pg.getPgImg() != null) {
                pgurlImage = pg.getPgImg().toString();
                ImageView imageView = new ImageView(new Image(pgurlImage, 0, 0, true, true));
                imageView.setFitWidth(250);
                imageView.setFitHeight(250);
                clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
                clip.setArcWidth(20);
                clip.setArcHeight(20);
                imageView.setClip(clip);
                this.imageView = imageView;
            }
        }

        VBox pgVBox = new VBox();
        pgVBox.setSpacing(5);
        pgVBox.setPrefWidth(800);

        if (pg != null) {
            if (pg.getPgName() != null) {
                Text pgNameText = new Text("PG Name: ");
                pgNameText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label pgName = new Label(pg.getPgName().toString());
                pgName.setFont(new Font(20));
                HBox pgNameBox = new HBox(pgNameText, pgName);
                pgNameBox.setSpacing(5);
                pgVBox.getChildren().add(pgNameBox);
            }

            if (pg.getTotalBeds() != null) {
                Text TotalBedsText = new Text("Total Beds : ");
                TotalBedsText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label TotalBeds = new Label(pg.getTotalBeds().toString());
                TotalBeds.setFont(new Font(20));
                HBox TotalBedsBox = new HBox(TotalBedsText, TotalBeds);
                TotalBedsBox.setSpacing(5);
                pgVBox.getChildren().add(TotalBedsBox);
            }

            if (pg.getPgFor() != null) {
                Text Gender = new Text("PG For : ");
                Gender.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label pgFor = new Label(pg.getPgFor().toString());
                pgFor.setFont(new Font(20));
                HBox genderBox = new HBox(Gender, pgFor);
                genderBox.setSpacing(5);
                pgVBox.getChildren().add(genderBox);
            }

            if (pg.getCommonArea() != null) {
                Text CommonArea = new Text("Common Areas : ");
                CommonArea.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label pgCommonArea = new Label(pg.getCommonArea().toString());
                pgCommonArea.setFont(new Font(20));
                HBox CommonAreaBox = new HBox(5, CommonArea, pgCommonArea);
                pgVBox.getChildren().add(CommonAreaBox);
            }

            if (pg.getPropertyManager() != null) {
                Text Manager = new Text("PG Manager : ");
                Manager.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label pgManager = new Label(pg.getPropertyManager().toString());
                pgManager.setFont(new Font(20));
                HBox managerBox = new HBox(5, Manager, pgManager);
                pgVBox.getChildren().add(managerBox);
            }

            if (pg.getAmenities() != null) {
                Text AmenitiesText = new Text("Amenities : ");
                AmenitiesText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label amenities = new Label(pg.getAmenities().toString());
                amenities.setFont(new Font(20));
                HBox amenitiesBox = new HBox(5, AmenitiesText, amenities);
                pgVBox.getChildren().add(amenitiesBox);
            }

            if (pg.getPgFees() != null) {
                Text Fees = new Text("Fees : ");
                Fees.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label pgFees = new Label(pg.getPgFees().toString());
                pgFees.setFont(new Font(20));
                HBox FeesBox = new HBox(5, Fees, pgFees);
                pgVBox.getChildren().add(FeesBox);
            }
        }

        HBox infoBox = new HBox(50, imageView, pgVBox);
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
    
}