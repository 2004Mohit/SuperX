package com.pgrental.dataAccess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Review  {
    private Pane root;
    private Stage primaryStage;

    public Review() {

    }

    public void setReviewPage(Stage primaryStage) {

        this.primaryStage = primaryStage;
    }

    public Pane createReviewScene(Runnable ReviewBackHandler) {
            
                root = new Pane();

                Image logo = new Image("file:src\\main\\resources\\images\\icon3.png", 1500, 1000, true, true);
                ImageView logoImageView = new ImageView(logo);
                logoImageView.setPreserveRatio(true);
                logoImageView.setFitHeight(230);
                logoImageView.setFitWidth(300);
                logoImageView.setLayoutX(5);
                logoImageView.setLayoutY(10);

                // VBOX
                VBox vb = new VBox(logoImageView);
                vb.setPrefSize(300, 210);

                // RATING 1
                Label lb = new Label("Priya Dhamdhere");
                lb.setFont(new Font(40));
                lb.setLayoutX(40);
                // lb.setAlignment(Pos.CENTER);

                Image ig = new Image("file:src\\main\\resources\\images\\p2.png");
                ImageView iv = new ImageView(ig);
                iv.setFitHeight(80);
                iv.setFitWidth(80);

                Image ig1 = new Image("file:src\\main\\resources\\images\\rating1.png");
                ImageView iv1 = new ImageView(ig1);
                iv1.setFitHeight(70);
                iv1.setFitWidth(130);
                iv1.setLayoutX(15);
                iv1.setLayoutY(270);

                Text tx = new Text(10, 350,
                                "Easy to operate\n"
                                                + "& can find better palces at your locality");
                tx.setFont(new Font(25));

                // tx.setLayoutX(40);
                // tx.setLayoutY(100);

                HBox hb = new HBox(iv, lb);
                hb.setPrefWidth(1500);
                hb.setPrefHeight(200);
                hb.setLayoutY(210);
                hb.setStyle("-fx-border-color:black");

                // SECOND RATING

                Label lb1 = new Label("Pranali chaskar");
                lb1.setFont(new Font(40));
                lb1.setLayoutX(40);
                // lb.setAlignment(Pos.CENTER);

                Image Img = new Image("file:src\\main\\resources\\images\\p2.png");
                ImageView iv2 = new ImageView(Img);
                iv2.setFitHeight(80);
                iv2.setFitWidth(80);

                Image ig2 = new Image("file:src\\main\\resources\\images\\rating1.png");
                ImageView iv3 = new ImageView(ig2);
                iv3.setFitHeight(70);
                iv3.setFitWidth(130);
                iv3.setLayoutX(15);
                iv3.setLayoutY(470);

                Text tx1 = new Text(10, 550,
                                " \"With its user-friendly interface and great filtering options, [Abodify] is a 5-star pick for finding your perfect PG.\"\n"
                                                + " & helping to find best properties");
                tx1.setFont(new Font(25));

                HBox hb2 = new HBox(iv2, lb1);
                hb2.setPrefWidth(1500);
                hb2.setPrefHeight(200);
                hb2.setLayoutY(410);
                hb2.setStyle("-fx-border-color:black");

                // THIRD Rating

                Label lb2 = new Label("Nita Ambani");
                lb2.setFont(new Font(40));
                lb2.setLayoutX(40);
                // lb.setAlignment(Pos.CENTER);

                Image Img2 = new Image("file:src\\main\\resources\\images\\n2.png");
                ImageView iv4 = new ImageView(Img2);
                iv4.setFitHeight(60);
                iv4.setFitWidth(60);

                Image ig3 = new Image("file:src\\main\\resources\\images\\rating1.png");
                ImageView iv5 = new ImageView(ig3);
                iv5.setFitHeight(70);
                iv5.setFitWidth(130);
                iv5.setLayoutX(15);
                iv5.setLayoutY(670);

                Text tx2 = new Text(10, 750,
                                " \"[Abodify] offers a decent selection of PG listings, but user reviews mention occasional bugs. It might be worth a 4.8-star rating.\"\n");
                tx2.setFont(new Font(25));

                HBox hb3 = new HBox(iv4, lb2);
                hb3.setPrefWidth(1500);
                hb3.setPrefHeight(170);
                hb3.setLayoutY(610);
                hb3.setStyle("-fx-border-color:black");

                // 4th rating

                Label lb3 = new Label("Gayatri Takale");
                lb3.setFont(new Font(40));
                lb3.setLayoutX(40);
                // lb.setAlignment(Pos.CENTER);

                Image Img3 = new Image("file:src\\main\\resources\\images\\g2.png");
                ImageView iv6 = new ImageView(Img3);
                iv6.setFitHeight(60);
                iv6.setFitWidth(60);

                Image ig4 = new Image("file:src\\main\\resources\\images\\rating1.png");
                ImageView iv7 = new ImageView(ig4);
                iv7.setFitHeight(70);
                iv7.setFitWidth(130);
                iv7.setLayoutX(15);
                iv7.setLayoutY(820);

                Text tx3 = new Text(10, 900,
                                "\"Find your dream home fast and stress-free with [Abodify]'s user-friendly search and filtering options.\"\n"
                                                + //
                                                "\n"

                );
                tx3.setFont(new Font(25));

                HBox hb4 = new HBox(iv6, lb3);
                hb4.setPrefWidth(1500);
                hb4.setPrefHeight(175);
                hb4.setLayoutY(780);
                hb4.setStyle("-fx-border-color:black");

                Label reviewlabel = new Label("REVIEW PAGE");
                reviewlabel.setFont(Font.font("Bauhaus 93", FontWeight.BOLD, 150));
                reviewlabel.setLayoutY(15);
                reviewlabel.setPadding(new Insets(30, 0, 0, 20));

                HBox hb5 = new HBox(reviewlabel);
                hb5.setPrefWidth(1200);
                hb5.setPrefHeight(210);
                // hb5.setLayoutY(100);
                hb5.setLayoutX(300);

                // button
                Button bt = new Button("Back");

                bt.setPrefSize(100, 50);
                bt.setLayoutX(1350);
                bt.setLayoutY(50);
                bt.setFont(new Font(25));
                bt.setStyle("-fx-background-radius: 2em;");
                bt.setStyle("-fx-background-color:red");
                bt.setOnAction(new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent event) {
                                ReviewBackHandler.run();
                        }
                });

                root.getChildren().addAll(hb, iv1, tx, hb2, iv3, tx1, hb3, iv5, tx2, hb4, iv7, tx3, vb, hb5, bt);
                //pn.setBackground(background);
              
                // Scene sc = new Scene(pn);

                // prStage.setScene(sc);
                // prStage.show();
                return root;
        }

}