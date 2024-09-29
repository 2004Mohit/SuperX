package com.pgrental.dataAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Revenue {

        private Pane root;
        private Stage primaryStage;
        public String OwnerName = LoginPage.statusOwner;

        public Revenue() {

        }

        //Method To set primary stage
        public void setRevenuePage(Stage primaryStage) {
                this.primaryStage = primaryStage;
        }

        public Pane createRevenueScene(Runnable RevenueBackHandler) {

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

        //NET WORTH LABEL
        Label netWorthLabel = new Label("NET REVENUE");
        Label newWorthAmount = new Label("₹120000");
        netWorthLabel.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 30));
        newWorthAmount.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 28));
        newWorthAmount.setTextFill(Color.GREEN);

        //Dues
        Label Dues = new Label("Dues");
        Label DueAmount = new Label("₹56000");
        Dues.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 30));
        DueAmount.setFont(Font.font("Maiandra GD", FontWeight.BOLD, 28));
        DueAmount.setTextFill(Color.GREEN);


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

        // PIECHART
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("UNPAID RENT", 75),
                new PieChart.Data("RENT", 25));
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("RENT STATUS");
        chart.setLayoutY(100);
        

        // BARCHART
        // Defining the x-axis and y-axis
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        yAxis.setLabel("Revenue (Rs)");

        // Creating the BarChart
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Monthly Revenue Analysis");

        // Defining a series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("2024");

        // Adding data to the series
        series.getData().add(new XYChart.Data<>("January", 20000));
        series.getData().add(new XYChart.Data<>("February", 15000));
        series.getData().add(new XYChart.Data<>("March", 18000));
        series.getData().add(new XYChart.Data<>("April", 22000));
        series.getData().add(new XYChart.Data<>("May", 25000));
        series.getData().add(new XYChart.Data<>("June", 30000));
        series.getData().add(new XYChart.Data<>("July", 28000));
        series.getData().add(new XYChart.Data<>("August", 32000));
        series.getData().add(new XYChart.Data<>("September", 27000));
        series.getData().add(new XYChart.Data<>("October", 35000));
        series.getData().add(new XYChart.Data<>("November", 40000));
        series.getData().add(new XYChart.Data<>("December", 45000));

        barChart.getData().add(series);
        

        // VBOX FOR CHARTS
        VBox chartVBox = new VBox(80, chart, barChart);
        chartVBox.setLayoutX(950);
        chartVBox.setLayoutY(50);


        //MAIN HBOX
        HBox mainBox = new HBox(ownerLogoViewvBox);
        mainBox.setPrefSize(1500, 1000);
        mainBox.setBackground(background);

        // Back Button To Back Page
        Button Back = new Button("Back");
                Back.setFont(new Font(30));
                Back.setLayoutX(150);
                Back.setLayoutY(850);
                Back.setStyle("-fx-background-radius: 2em;");
                Back.setAlignment(Pos.CENTER);

                Back.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                                RevenueBackHandler.run();
                        }
                });

        //VBOX FOR WALLET AND REVENUE VALUE
        VBox NetRevenue = new VBox(netWorthLabel,newWorthAmount);
        NetRevenue.setStyle("-fx-background-radius: 2em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: linear-gradient(to top right, #FCCF31, #F55555);");
        NetRevenue.setAlignment(Pos.CENTER);
        NetRevenue.setPadding(new Insets(50));

        VBox DueBox = new VBox(Dues,DueAmount);
        DueBox.setStyle("-fx-background-radius: 2em; "+
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);"+
        "-fx-background-color: linear-gradient(to top right, #00a1ff, #00ff8f);");
        DueBox.setAlignment(Pos.CENTER);
        DueBox.setPadding(new Insets(50));

        VBox NetDueBox = new VBox(50,NetRevenue, DueBox);
        NetDueBox.setLayoutX(200);
        NetDueBox.setLayoutY(300);
 
        root.getChildren().addAll(mainBox, welcome, chartVBox, NetDueBox, Back);
        return root;
    }

}
