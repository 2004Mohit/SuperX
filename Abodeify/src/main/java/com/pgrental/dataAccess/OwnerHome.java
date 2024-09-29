package com.pgrental.dataAccess;

import java.io.File;

import com.pgrental.DashBoard.controller.FlatController;
import com.pgrental.DashBoard.controller.HostelController;
import com.pgrental.DashBoard.controller.PgController;
import com.pgrental.Services.ImageUploader;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.FlatDetail;
import model.HostelDetail;
import model.PgDetail;;

public class OwnerHome {

    private Pane root;
    private Stage primaryStage;
    private Scene OwnerScene;
    private String Gender;
    private Scene NotifyViewScene;
    private String ownby;
    private String properyManager;
    private Button addButton;
    private Scene RevenueScene, OptionPageScene, TenantInfoListPageScene, AnnounceScene, ContactInfoPageScene;
    private String imgUrl;
    private Rectangle clip;
    private Tooltip ButtonContactInfo, ButtonAnnounceInfo, ButtonRevneueInfo, ButtonTenantInfo, ButtonInfo;
    public static TextField HostelnameField, ownerField;
    public static String flatOwner, PGName, HostelOwner;
    private String OwnerName = LoginPage.statusOwner;

    // Output label for messages
    Alert output = new Alert(AlertType.ERROR);

    private HostelController HostelController = new HostelController();
    private FlatController FlatController = new FlatController();
    private PgController PGController = new PgController();

    private static final String[] IMAGE_PATHS = {
        "file:src\\main\\resources\\images\\Hostel Image.jpg",
        "file:src\\main\\resources\\images\\PG.jpg",
        "file:src\\main\\resources\\images\\Room.jpeg",
        "file:src\\main\\resources\\images\\HostelImage.jpg",
        "file:src\\main\\resources\\images\\building.jpg",
        "file:src\\main\\resources\\images\\Stanza.jpg",
        "file:src\\main\\resources\\images\\luxury.jpg"
    };

    public OwnerHome() {

    }

    // Method To set primary stage
    public void setOwnerHome(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Method To set option Page Scene
    public void setOwnerHomeScene(Scene OwnerScene) {
        this.OwnerScene = OwnerScene;
    }

    public Pane createOwnerHomeScene(Runnable OwnerBackHandler) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Added successfully");

        Image imageHome = new Image("file:src\\main\\resources\\images\\ownerbg.jpg",
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

        Image ImageOfOwner = new Image("file:src\\main\\resources\\images\\owner1.png");
        ImageView imageOfOwner = new ImageView(ImageOfOwner);
        imageOfOwner.setFitHeight(180);
        imageOfOwner.setFitWidth(180);
        imageOfOwner.setLayoutX(18);
        imageOfOwner.setLayoutY(20);

        Label welcome = new Label("WELCOME,\n               " + OwnerName);
        welcome.setFont(Font.font("Maiandra GD", FontWeight.NORMAL, 35));
        welcome.setLayoutX(230);
        welcome.setLayoutY(60);

        Image imagelogout = new Image(getClass().getResourceAsStream("/images/Logoutbg.png"), 1500, 1000, true,
                false);

        BackgroundSize logoutbg = new BackgroundSize(
                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage logoutbgImage = new BackgroundImage(
                imagelogout, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                logoutbg);
        Background logoutBackground = new Background(logoutbgImage);

        // LOGOUT BUTTON
        Button logoutButton = new Button();
        logoutButton.setFont(new Font(40));
        logoutButton.setLayoutX(1150);
        logoutButton.setLayoutY(35);
        logoutButton.setBackground(logoutBackground);
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initOptionScene();
                primaryStage.setScene(OptionPageScene);
            }
        });

        // CUSTOMER CARE
        String pg_contents[] = { "9234765874", "7285937634" };
        @SuppressWarnings("rawtypes")
        ComboBox care_box = new ComboBox<>(FXCollections.observableArrayList(pg_contents));
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
                // totalCnt = 0;
            }
        });

        //Hbox for Logout, careBox & Notify Button
        HBox TopButton = new HBox(20, logoutButton, care_box, notify);
        TopButton.setAlignment(Pos.CENTER);
        TopButton.setLayoutX(1130);
        TopButton.setLayoutY(50);

        // HostelPage

        // TitlePane
        TitledPane HostelpageRoot = new TitledPane();
        HostelpageRoot.setAlignment(Pos.TOP_RIGHT);

        // GridPane
        GridPane hostel = new GridPane();
        hostel.setPadding(new Insets(10));

        // Hostel Name
        Label HostelName = new Label("Hostel Name :");
        HostelName.setFont(Font.font(null, FontWeight.BOLD, 20));
        HostelnameField = new TextField();

        HBox hostelName_hb = new HBox(10, HostelName, HostelnameField);
        hostelName_hb.setMaxSize(400, 20);

        // Hostel For
        Label hostelFor = new Label("Hostel For :");
        hostelFor.setFont(Font.font(null, FontWeight.BOLD, 20));

        // RADIO BUTTONS FOR MALE/FEMALE IN HOSTEL SECTION
        RadioButton Female = new RadioButton("Female");
        RadioButton Male = new RadioButton("Male");
        Female.setFont(Font.font(null, FontWeight.BOLD, 15));
        Male.setFont(Font.font(null, FontWeight.BOLD, 15));

        ToggleGroup toggleGroup = new ToggleGroup();
        Female.setToggleGroup(toggleGroup);
        Male.setToggleGroup(toggleGroup);

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

        // RADIO BUTTONS FOR COLLEGE/PRIVATE IN HOSTEL SECTION

        // Private Owner Name
        Label PrivateOwner = new Label("Hostel\nOwner Name : ");
        PrivateOwner.setOpacity(0.3);
        PrivateOwner.setFont(Font.font(null, FontWeight.BOLD, 15));
        TextField HostelOwnerName = new TextField();
        HostelOwnerName.setDisable(true);

        // College Name
        Label CollegeName = new Label("College Name : ");
        CollegeName.setOpacity(0.3);
        CollegeName.setFont(Font.font(null, FontWeight.BOLD, 15));
        TextField clgName = new TextField();
        clgName.setDisable(true);
        clgName.setPromptText("Enter College Name");

        RadioButton College = new RadioButton("College");
        RadioButton Private = new RadioButton("Private");
        College.setFont(Font.font(null, FontWeight.BOLD, 15));
        Private.setFont(Font.font(null, FontWeight.BOLD, 15));

        ToggleGroup toggleGroupHostel = new ToggleGroup();
        College.setToggleGroup(toggleGroupHostel);
        Private.setToggleGroup(toggleGroupHostel);

        genderButtonBox.getChildren().addAll(College, Private);
        toggleGroup.selectedToggleProperty();

        Private.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ownby = "Private";
                CollegeName.setOpacity(0.3);
                clgName.setDisable(true);
                PrivateOwner.setOpacity(1);
                HostelOwnerName.setDisable(false);
                System.out.println(ownby);
            }

        });

        College.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ownby = "College";
                CollegeName.setOpacity(1);
                clgName.setDisable(false);
                PrivateOwner.setOpacity(0.3);
                HostelOwnerName.setDisable(true);
                System.out.println(ownby);
            }

        });

        HBox buttonBox = new HBox(28, Private, College);

        Label own = new Label("Hostel Own by :");
        own.setFont(Font.font(null, FontWeight.BOLD, 15));
        TextField collegeName = new TextField();
        collegeName.setPromptText("Enter College Name");

        // Address
        Label address = new Label("Address :");
        address.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField addressField = new TextField();

        // Number of Beds
        Label NOB = new Label("Number\n of Beds :");
        NOB.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField nobField = new TextField();

        // fees
        Label fees = new Label("Hostel fees :");
        fees.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField feesField = new TextField();

        // Deposit
        Label deposit = new Label("Deposit :");
        deposit.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField depositField = new TextField();

        // Photo
        Label photo = new Label("Photo :");
        photo.setFont(Font.font(null, FontWeight.BOLD, 20));

        ImageView imageView = new ImageView();
        Button uploadButton = new Button("Upload Image");
        uploadButton.setTextFill(Color.WHITE);
        uploadButton.setStyle("-fx-background-color:blue;");
        // Set up the file chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        // Set up the button action
        uploadButton.setOnAction(event -> {
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                String imageUrl = ImageUploader.uploadImage(selectedFile.getPath(), selectedFile.getName());

                this.imgUrl = imageUrl;
                if (imageUrl != null) {
                    System.out.println(imageUrl);
                    Image image = new Image(imageUrl);
                    imageView.setImage(image);
                }
            }
        });

        HBox HostelImage_hb = new HBox(imageView);
        HostelImage_hb.setStyle("-fx-pref-size : 350;-fx-alignment : CENTER");

        // Add Button
        addButton = new Button("Add Data");
        addButton.setStyle("-fx-font-size:18;-fx-font-weight:bold");

        hostel.add(HostelName, 0, 0, 1, 1);
        hostel.add(HostelnameField, 1, 0, 1, 1);
        hostel.add(hostelFor, 0, 1, 1, 1);
        hostel.add(genderButtonBox, 1, 1, 1, 1);
        hostel.add(own, 0, 2, 1, 1);
        hostel.add(buttonBox, 1, 2, 1, 1);
        hostel.add(CollegeName, 0, 3, 1, 1);
        hostel.add(clgName, 1, 3, 1, 1);
        hostel.add(PrivateOwner, 0, 4, 1, 1);
        hostel.add(HostelOwnerName, 1, 4, 1, 1);
        hostel.add(address, 0, 5, 1, 1);
        hostel.add(addressField, 1, 5, 1, 1);
        hostel.add(NOB, 0, 6, 1, 1);
        hostel.add(nobField, 1, 6, 1, 1);
        hostel.add(fees, 0, 7, 1, 1);
        hostel.add(feesField, 1, 7, 1, 1);
        hostel.add(deposit, 0, 8, 1, 1);
        hostel.add(depositField, 1, 8, 1, 1);
        hostel.add(photo, 0, 9, 1, 1);
        hostel.add(uploadButton, 1, 9, 1, 1);
        hostel.add(addButton, 1, 10, 1, 1);
        hostel.setVgap(10);
        hostel.setHgap(4);

        HostelpageRoot.setContent(hostel);
        HostelpageRoot.setText("Hostel");
        HostelpageRoot.setFont(Font.font(null, FontWeight.BOLD, 15));
        HostelpageRoot.setAlignment(Pos.CENTER);
        HostelpageRoot.setExpanded(false);

        HBox hostelBox = new HBox(HostelpageRoot);

        // Action handler for addButton
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                if (College.isSelected()) {
                    HostelOwner = clgName.getText();
                    System.out.println(HostelOwner);
                } else {
                    HostelOwner = HostelOwnerName.getText();
                    System.out.println(HostelOwner);
                }

                System.out.println("In Add Button");
                // Create a hostelDetail object and set its attributes from the input fields
                HostelDetail HostelData = new HostelDetail(OwnerName, HostelnameField.getText(), Gender, ownby,
                        HostelOwner, addressField.getText(), nobField.getText(), feesField.getText(),
                        depositField.getText());

                if (imgUrl != null) {
                    HostelData.setHostelImg(imgUrl);
                } else {
                    output.setContentText("Please add Image");
                    output.showAndWait();
                }

                // Check if all compulsory fields are filled
                if (checkCompulsoryFieldsofHostel(HostelData)) {
                    // Attempt to add the Hostel using the HostelController
                    if (HostelController.addHostelData(HostelData)) {
                        alert.showAndWait();
                        HostelnameField.clear();
                        Gender = null;
                        ownby = null;
                        clgName.clear();
                        HostelOwner = null;
                        addressField.clear();
                        nobField.clear();
                        feesField.clear();
                        depositField.clear();
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

        Label add = new Label("New Addition");
        add.setFont(Font.font(null, FontWeight.BOLD, 25));

        // Flat Page

        // TitlePane
        TitledPane flatpageRoot = new TitledPane();

        // GridPane
        GridPane flat = new GridPane();
        flat.setPadding(new Insets(10));

        // Owner Name
        Label FlatOwnerName = new Label("Flat Owner:");
        FlatOwnerName.setFont(Font.font(null, FontWeight.BOLD, 20));
        ownerField = new TextField();
        flatOwner = ownerField.getText();
        ownerField.setMaxWidth(200);

        // City
        Label city = new Label("City :");
        city.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField cityField = new TextField();
        cityField.setMaxWidth(200);

        // Building/Project/Society Name
        Label buildingName = new Label("Building/Project/\nSociety Name :");
        buildingName.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField building = new TextField();
        building.setMaxWidth(200);

        // Address
        Label flataddressLabel = new Label("Address :");
        flataddressLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField flataddressField = new TextField();
        flataddressField.setMaxWidth(200);

        // BHK
        Label bhk = new Label("BHK :");
        bhk.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField bhkField = new TextField();
        bhkField.setMaxWidth(200);

        // Rent
        Label rent = new Label("Rent :");
        rent.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField rentField = new TextField();
        rentField.setMaxWidth(200);

        // Available Date From
        Label date = new Label("Available From :");
        date.setFont(Font.font(null, FontWeight.BOLD, 20));

        DatePicker setDate = new DatePicker();
        setDate.setPromptText("DD-MM-YYYY");

        // Deposit
        Label flatDeposit = new Label("Deposit :");
        flatDeposit.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField flatDepositField = new TextField();
        flatDepositField.setMaxWidth(200);

        // Photo
        Label flatPhoto = new Label("Photo :");
        flatPhoto.setFont(Font.font(null, FontWeight.BOLD, 20));

        ImageView flatImageView = new ImageView();
        Button upload = new Button("Upload Image");
        upload.setTextFill(Color.WHITE);
        upload.setStyle("-fx-background-color:blue;");

        // Set up the file chooser
        FileChooser flatFileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        // Set up the button action
        upload.setOnAction(event -> {
            File selectedFile = flatFileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                String imageUrl = ImageUploader.uploadImage(selectedFile.getPath(),
                        selectedFile.getName());

                this.imgUrl = imageUrl;
                if (imageUrl != null) {
                    System.out.println(imageUrl);
                    Image image = new Image(imageUrl);
                    flatImageView.setImage(image);
                }
            }
        });

        // Add Button
        addButton = new Button("Add Data");
        addButton.setStyle("-fx-font-size:18;-fx-font-weight:bold");

        flat.add(FlatOwnerName, 0, 0, 5, 1);
        flat.add(ownerField, 1, 0, 1, 1);
        flat.add(city, 0, 1, 1, 1);
        flat.add(cityField, 1, 1, 1, 1);
        flat.add(buildingName, 0, 2, 1, 1);
        flat.add(building, 1, 2, 1, 1);
        flat.add(flataddressLabel, 0, 3, 1, 1);
        flat.add(flataddressField, 1, 3, 1, 1);
        flat.add(bhk, 0, 4, 1, 1);
        flat.add(bhkField, 1, 4, 1, 1);
        flat.add(rent, 0, 5, 1, 1);
        flat.add(rentField, 1, 5, 1, 1);
        flat.add(date, 0, 6, 1, 1);
        flat.add(setDate, 1, 6, 1, 1);
        flat.add(flatDeposit, 0, 7, 1, 1);
        flat.add(flatDepositField, 1, 7, 1, 1);
        flat.add(flatPhoto, 0, 8, 1, 1);
        flat.add(upload, 1, 8, 1, 1);
        flat.add(addButton, 1, 9, 1, 1);
        flat.setVgap(10);

        flat.setPadding(new Insets(20));
        flatpageRoot.setContent(flat);
        flatpageRoot.setMaxWidth(500);
        flatpageRoot.setText("Flat");
        flatpageRoot.setFont(Font.font(null, FontWeight.BOLD, 15));
        flatpageRoot.setAlignment(Pos.CENTER);
        flatpageRoot.setExpanded(false);

        HBox flatBox = new HBox(flatpageRoot);
        flatBox.setLayoutX(100);
        flatBox.setLayoutY(200);

        // Action handler for addButton
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("In Flat Add Button");

                // Create a flatDetail object and set its attributes from the input fields
                FlatDetail FlatData = new FlatDetail(ownerField.getText(), cityField.getText(), building.getText(),
                        flataddressField.getText(), bhkField.getText(), rentField.getText(),
                        setDate.getValue().toString(), flatDepositField.getText());

                if (imgUrl != null) {

                    FlatData.setFlatImg(imgUrl);

                } else {
                    System.out.println("Image Null");
                    output.setContentText("Please add Image");
                    output.showAndWait();
                }

                System.out.println(FlatData);
                // Check if all compulsory fields are filled
                if (checkCompulsoryFieldsofFlat(FlatData)) {
                    System.out.println("In Compulsory Field");
                    // Attempt to add the flat using the flatControllerI
                    if (FlatController.addflatData(FlatData)) {
                        System.out.println(FlatData);
                        alert.showAndWait();
                        ownerField.clear();
                        cityField.clear();
                        building.clear();
                        flataddressField.clear();
                        bhkField.clear();
                        rentField.clear();
                        setDate.setValue(null);
                        flatDepositField.clear();
                        imgUrl = null;

                    } else {
                        System.out.println("Flat Null");
                        output.setContentText("flat Not Added");
                        output.showAndWait();

                    }
                } else {
                    System.out.println("Fields Null");
                    output.setContentText("Fields are Empty");
                    output.showAndWait();

                }
            }
        });

        // PG Page

        TitledPane pgPageRoot = new TitledPane();
        pgPageRoot.setAlignment(Pos.TOP_RIGHT);

        // GridPane
        GridPane pg = new GridPane();
        pg.setPadding(new Insets(10));

        // PG Name
        Label pgName = new Label("Pg Name :");
        pgName.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField pgNameField = new TextField();
        PGName = pgNameField.getText();
        pgNameField.setPrefWidth(300);

        // Number of Beds
        Label bed = new Label("Total Bed :");
        bed.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField bedField = new TextField();
        bedField.setPrefWidth(300);

        // PG For
        Label pgfor = new Label("PG For :");
        pgfor.setFont(Font.font(null, FontWeight.BOLD, 20));

        RadioButton femalePg = new RadioButton("Female");
        RadioButton malePg = new RadioButton("Male");
        femalePg.setFont(Font.font(null, FontWeight.BOLD, 20));
        malePg.setFont(Font.font(null, FontWeight.BOLD, 20));

        ToggleGroup toggleGrouppg = new ToggleGroup();
        femalePg.setToggleGroup(toggleGrouppg);
        malePg.setToggleGroup(toggleGrouppg);

        HBox genderButtonBoxPg = new HBox(10);
        genderButtonBoxPg.getChildren().addAll(femalePg, malePg);

        toggleGroup.selectedToggleProperty();

        malePg.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Gender = "Male";
                System.out.println(Gender);
            }

        });
        femalePg.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Gender = "Female";
                System.out.println(Gender);
            }

        });

        // Common Areas
        Label commonarea = new Label("Common Area :");
        commonarea.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField commonAreaField = new TextField();
        commonAreaField.setPrefWidth(300);
        commonAreaField.setPromptText("Gaming Area,Dining Area,etc");

        // Property Managed by
        Label propertymanaged = new Label("Property Managed :");
        propertymanaged.setFont(Font.font(null, FontWeight.BOLD, 20));

        RadioButton landLord = new RadioButton("Landlord");
        RadioButton caretaker = new RadioButton("Caretaker");
        landLord.setFont(Font.font(null, FontWeight.BOLD, 20));
        caretaker.setFont(Font.font(null, FontWeight.BOLD, 20));

        ToggleGroup toggleGrouppg2 = new ToggleGroup();
        landLord.setToggleGroup(toggleGrouppg2);
        caretaker.setToggleGroup(toggleGrouppg2);

        HBox mangerBox = new HBox(10);
        mangerBox.getChildren().addAll(landLord, caretaker);

        toggleGroup.selectedToggleProperty();

        caretaker.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                properyManager = "Caretaker";
                System.out.println(properyManager);
            }

        });
        landLord.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                properyManager = "Landlord";
                System.out.println(properyManager);
            }

        });
        HBox managerBox = new HBox(20, landLord, caretaker);

        // Amenities
        Label Amenities = new Label("Amenities :");
        Amenities.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField amenitiesField = new TextField();
        amenitiesField.setPrefWidth(300);
        amenitiesField.setPromptText("CCTV,Washing Machine,Fridge,etc");

        // PG Fees
        Label pgfees = new Label("Pg Fees :");
        pgfees.setFont(Font.font(null, FontWeight.BOLD, 20));
        TextField pgFeesField = new TextField();
        pgFeesField.setPrefWidth(300);

        // PG Photos
        // Photo
        Label pgphoto = new Label("Photo :");
        pgphoto.setFont(Font.font(null, FontWeight.BOLD, 20));

        ImageView pgView = new ImageView();
        Button pgUpload = new Button("Upload Image");
        pgUpload.setTextFill(Color.WHITE);
        pgUpload.setStyle("-fx-background-color:blue;");

        // Set up the file chooser
        FileChooser pgFileChooser = new FileChooser();
        pgFileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        // Set up the button action
        pgUpload.setOnAction(event -> {
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

        // Add Button
        Button addButton = new Button("Add Data");
        addButton.setStyle("-fx-font-size:18;-fx-font-weight:bold");

        pg.add(pgName, 0, 0, 1, 1);
        pg.add(pgNameField, 1, 0, 1, 1);
        pg.add(bed, 0, 1, 1, 1);
        pg.add(bedField, 1, 1, 1, 1);
        pg.add(pgfor, 0, 2, 1, 1);
        // pg.add(genderBox, 1,2,1,1);
        pg.add(genderButtonBoxPg, 1, 2, 1, 1);
        pg.add(commonarea, 0, 3, 1, 1);
        pg.add(commonAreaField, 1, 3, 1, 1);
        pg.add(propertymanaged, 0, 4, 1, 1);
        pg.add(managerBox, 1, 4, 1, 1);
        pg.add(Amenities, 0, 5, 1, 1);
        pg.add(amenitiesField, 1, 5, 1, 1);
        pg.add(pgfees, 0, 6, 1, 1);
        pg.add(pgFeesField, 1, 6, 1, 1);
        pg.add(pgphoto, 0, 7, 1, 1);
        pg.add(pgUpload, 1, 7, 1, 1);
        pg.add(addButton, 1, 8, 1, 1);
        pg.setVgap(10);

        pgPageRoot.setContent(pg);

        pgPageRoot.setText("PG");
        pgPageRoot.setFont(Font.font(null, FontWeight.BOLD, 15));
        pgPageRoot.setAlignment(Pos.CENTER);
        pgPageRoot.setExpanded(false);

        HBox hbPGBox = new HBox(pgPageRoot);
        hbPGBox.setLayoutX(100);
        hbPGBox.setLayoutY(200);

        // Action handler for addButton
        addButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("In PG Add Button");
                // Create a flatDetail object and set its attributes from the input fields
                PgDetail PGData = new PgDetail(pgNameField.getText(), bedField.getText(), Gender,
                        commonAreaField.getText(), properyManager, amenitiesField.getText(), pgFeesField.getText());

                if (imgUrl != null) {
                    PGData.setPgImg(imgUrl);
                } else {
                    output.setContentText("Please add Image");
                    output.showAndWait();
                }

                // Check if all compulsory fields are filled
                if (checkCompulsoryFieldsofPg(PGData)) {
                    // Attempt to add the flat using the flatController
                    if (PGController.addpgData(PGData)) {
                        alert.showAndWait();

                        pgNameField.clear();
                        bedField.clear();
                        Gender = null;
                        commonAreaField.clear();
                        properyManager = null;
                        amenitiesField.clear();
                        pgFeesField.clear();
                        imgUrl = null;

                    } else {
                        output.setContentText("flat Not Added");
                        output.showAndWait();

                    }
                } else {
                    output.setContentText("Fields are Empty");
                    output.showAndWait();

                }
            }
        });

        // Mouse Click Event
        HostelpageRoot.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                flatpageRoot.setExpanded(false);
                pgPageRoot.setExpanded(false);
                HostelpageRoot.setOpacity(1);
                flatpageRoot.setOpacity(0.3);
                pgPageRoot.setOpacity(0.3);
            }
        });
        flatpageRoot.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                HostelpageRoot.setExpanded(false);
                pgPageRoot.setExpanded(false);
                flatpageRoot.setOpacity(1);
                HostelpageRoot.setOpacity(0.3);
                pgPageRoot.setOpacity(0.3);
            }
        });
        pgPageRoot.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                HostelpageRoot.setExpanded(false);
                flatpageRoot.setExpanded(false);
                pgPageRoot.setOpacity(1);
                HostelpageRoot.setOpacity(0.3);
                flatpageRoot.setOpacity(0.3);
            }
        });

        // HBox for Hostel, Flat & PG
        HBox titledPaneBox = new HBox(50, hostelBox, flatBox, hbPGBox);

        VBox addBox = new VBox(25, add, titledPaneBox);
        addBox.setPadding(new Insets(10));
        addBox.setAlignment(Pos.CENTER_LEFT);

        // Quick Action

        Label QuickAction = new Label("Quick Action");
        QuickAction.setFont(Font.font(null, FontWeight.BOLD, 25));

        DropShadow shadow = new DropShadow();
        Image imageContact = new Image("file:src\\main\\resources\\images\\contact.png",
                1500, 1500, true, false);
        ImageView ContactView = new ImageView(imageContact);
        ContactView.setFitHeight(50);
        ContactView.setFitWidth(50);

        Button ContactButton = new Button();
        ContactButton.setStyle(
                "-fx-background-radius: 7em; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px;");
        ContactButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ButtonContactInfo = new Tooltip();
                ButtonContactInfo.setText("Add Contact");
                ButtonContactInfo.setFont(Font.font(20));
                ContactButton.setTooltip(ButtonContactInfo);
                ContactButton.setEffect(shadow);
            }
        });
        ContactButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ContactButton.setEffect(null);
            }
        });
        ContactButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initContactInfoListScene();
                primaryStage.setScene(ContactInfoPageScene);
            }
        });

        ContactButton.setGraphic(ContactView);
        ContactButton.setLayoutX(630);
        ContactButton.setLayoutY(630);
        ContactButton.setPrefSize(60, 60);

        Image imageAnnounce = new Image("file:src\\main\\resources\\images\\announce.png",
                1500, 1000, true, false);
        ImageView announcView = new ImageView(imageAnnounce);
        announcView.setFitHeight(40);
        announcView.setFitWidth(50);

        Button announceButton = new Button();
        announceButton.setStyle(
                "-fx-background-radius: 7em; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px;");
        announceButton.setGraphic(announcView);
        announceButton.setLayoutX(630);
        announceButton.setLayoutY(630);
        announceButton.setPrefSize(60, 60);
        announceButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                ButtonAnnounceInfo = new Tooltip();
                ButtonAnnounceInfo.setText("Announcement");
                ButtonAnnounceInfo.setFont(Font.font(20));
                announceButton.setTooltip(ButtonAnnounceInfo);
                announceButton.setEffect(shadow);

            }
        });
        announceButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                announceButton.setEffect(null);
            }
        });
        announceButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initAnnounce();
                primaryStage.setScene(AnnounceScene);
            }
        });

        Image imageTenant = new Image("file:src\\main\\resources\\images\\tenant.png",
                1500, 1000, true, false);
        ImageView TenantView = new ImageView(imageTenant);
        TenantView.setFitHeight(50);
        TenantView.setFitWidth(50);

        Button tenantButton = new Button();
        tenantButton.setStyle(
                "-fx-background-radius: 7em; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px;");
        tenantButton.setGraphic(TenantView);
        tenantButton.setLayoutX(630);
        tenantButton.setLayoutY(630);
        tenantButton.setPrefSize(60, 60);
        tenantButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                ButtonTenantInfo = new Tooltip();
                ButtonTenantInfo.setText("Tenant List");
                ButtonTenantInfo.setFont(Font.font(20));
                tenantButton.setTooltip(ButtonTenantInfo);
                tenantButton.setEffect(shadow);
            }
        });
        tenantButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                tenantButton.setEffect(null);
            }
        });
        tenantButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initTenantInfoListScene();
                primaryStage.setScene(TenantInfoListPageScene);
            }
        });

        Image imageDue = new Image("file:src\\main\\resources\\images\\DueImage.png",
                1500, 1000, true, false);
        ImageView DueView = new ImageView(imageDue);
        DueView.setFitHeight(40);
        DueView.setFitWidth(50);

        Button DueButton = new Button();
        DueButton.setStyle(
                "-fx-background-radius: 7em; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px;");
        DueButton.setGraphic(DueView);
        DueButton.setLayoutX(630);
        DueButton.setLayoutY(630);
        DueButton.setPrefSize(60, 60);
        DueButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                ButtonInfo = new Tooltip();
                ButtonInfo.setText("Tenant Dues");
                ButtonInfo.setFont(Font.font(20));
                DueButton.setTooltip(ButtonInfo);
                DueButton.setEffect(shadow);
            }
        });
        DueButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                DueButton.setEffect(null);
            }
        });

        Image imageRevenue = new Image("file:src\\main\\resources\\images\\revenue.png",
                1500, 1000, true, false);
        ImageView RevenueView = new ImageView(imageRevenue);
        RevenueView.setFitHeight(60);
        RevenueView.setFitWidth(60);

        Button revenueButton = new Button();
        revenueButton.setStyle(
                "-fx-background-radius: 7em; " +
                        "-fx-min-height: 70px; " +
                        "-fx-max-width: 70px;");
        revenueButton.setGraphic(RevenueView);
        revenueButton.setLayoutX(630);
        revenueButton.setLayoutY(630);
        revenueButton.setPrefSize(60, 60);
        revenueButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ButtonRevneueInfo = new Tooltip();
                ButtonRevneueInfo.setText("Check Revenue");
                ButtonRevneueInfo.setFont(Font.font(20));
                revenueButton.setTooltip(ButtonRevneueInfo);
                revenueButton.setEffect(shadow);
            }
        });
        revenueButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                revenueButton.setEffect(null);
            }
        });
        revenueButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                initRevenue();
                primaryStage.setScene(RevenueScene);
            }
        });

        HBox hbQuick = new HBox(50, ContactButton, announceButton, tenantButton, DueButton, revenueButton);

        VBox quickBox = new VBox(25, QuickAction, hbQuick);
        quickBox.setAlignment(Pos.CENTER_LEFT);
        quickBox.setPadding(new Insets(10));

        VBox feature = new VBox(20, addBox, quickBox);
        feature.setAlignment(Pos.CENTER_LEFT);
        feature.setStyle(
                "-fx-background-radius: 2em; " + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);" +
                        "-fx-background-color: linear-gradient(to right, #808991, #5C6366);");
        feature.setLayoutX(50);
        feature.setLayoutY(200);

        //Album Box
        Label myAlbum = new Label("My Album");
        myAlbum.setFont(Font.font(null, FontWeight.BOLD, 25));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle(
            "-fx-padding: 10; -fx-background-color: linear-gradient(to right, #808991, #5C6366);");
        hBox.setPrefSize(1400, 300);

        for (String imagePath : IMAGE_PATHS) {
            Image image = new Image(imagePath);
            ImageView imageSliderView = new ImageView(image);
            imageSliderView.setFitWidth(300);
            imageSliderView.setFitHeight(250);
            clip = new Rectangle(imageSliderView.getFitWidth(), imageSliderView.getFitHeight());
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            imageSliderView.setClip(clip);
            hBox.getChildren().add(imageSliderView);
        }

        ScrollPane scrollPane = new ScrollPane(hBox);
        scrollPane.setFitToHeight(true);
        scrollPane.setPannable(true);
        scrollPane.setStyle(
            "-fx-background-radius: 2em; -fx-background-color: linear-gradient(to right, #808991, #5C6366);");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(600), event -> {
            double hValue = scrollPane.getHvalue();
            hValue += 1.0 / (IMAGE_PATHS.length - 1);
            if (hValue > 1) {
                hValue = 0;
            }
            scrollPane.setHvalue(hValue);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    
        VBox AlbumBox = new VBox(10, myAlbum, scrollPane);
        AlbumBox.setAlignment(Pos.CENTER_LEFT);
        AlbumBox.setPadding(new Insets(10));
        AlbumBox.setStyle(
            "-fx-background-radius: 2em; " + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5,0,0,0);" +
                    "-fx-background-color: linear-gradient(to right, #808991, #5C6366);");

        FlowPane flow = new FlowPane(feature, AlbumBox);
        flow.setLayoutY(250);
        flow.setLayoutX(50);
        flow.setVgap(50);

        root.getChildren().addAll(imageOfOwner, welcome, TopButton, flow);
        return root;
    }

    // Method To on Notification Click
    private void initNotifyScene() {
        NotificationView NotifyView = new NotificationView();
        NotifyView.setNotificationViewPage(primaryStage);
        NotifyViewScene = new Scene(NotifyView.createNotificationViewScene(this::handleBack), 1500, 1000);
        primaryStage.show();
    }

    // Method To Go To Revenue
    private void initRevenue() {
        Revenue RevenuePage = new Revenue();
        RevenuePage.setRevenuePage(primaryStage);
        RevenueScene = new Scene(RevenuePage.createRevenueScene(this::handleBack), 1500, 1000);
        primaryStage.setScene(RevenueScene);
        primaryStage.show();
    }

    // Method For Announce
    private void initAnnounce() {
        Announce AnnouncePage = new Announce();
        AnnouncePage.setAnnouncePage(primaryStage);
        AnnounceScene = new Scene(AnnouncePage.createAnnounceScene(this::handleBack), 1500, 1000);
        primaryStage.setScene(AnnounceScene);
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

    // Method To on TenantList Click
    private void initTenantInfoListScene() {
        TenantInfoList TenantInfoListPage = new TenantInfoList();
        TenantInfoListPage.setTenantInfoListPage(primaryStage);
        TenantInfoListPageScene = new Scene(TenantInfoListPage.createTenantListScene(this::handleBack), 1500, 1000);
        primaryStage.show();
    }

    // Method To on TenantList Click
    private void initContactInfoListScene() {
        ContactInfo ContactInfoListPage = new ContactInfo();
        ContactInfoListPage.setContactInfo(primaryStage);
        ContactInfoPageScene = new Scene(ContactInfoListPage.createContactInfoScene(this::handleBack), 1500, 1000);
        primaryStage.show();
    }

    private void handleBack() {
        primaryStage.setScene(OwnerScene);
    }

    private boolean checkCompulsoryFieldsofHostel(HostelDetail Hostel) {
        if (Hostel.getHostelName().trim().isEmpty()
                || Hostel.getGender().trim().isEmpty()
                || Hostel.getOwnBy().trim().isEmpty()
                || Hostel.getHostelOwner().trim().isEmpty()
                || Hostel.getAddress().trim().isEmpty()
                || Hostel.getNoofBeds().trim().isEmpty()
                || Hostel.getHostelFees().trim().isEmpty()
                || Hostel.getDeposit().trim().isEmpty()
                || Hostel.getHostelImg().trim().isEmpty()) {

            return false;

        }
        return true;
    }

    private boolean checkCompulsoryFieldsofFlat(FlatDetail Flat) {
        if (Flat.getFlatOwner().trim().isEmpty()
                || Flat.getCity().trim().isEmpty()
                || Flat.getBuildingName().trim().isEmpty()
                || Flat.getFlatAddress().trim().isEmpty()
                || Flat.getBhk().trim().isEmpty()
                || Flat.getRent().trim().isEmpty()
                || Flat.getAvailableFrom().trim().isEmpty()
                || Flat.getFlatDeposit().trim().isEmpty()
                || Flat.getFlatImg().trim().isEmpty()) {

            return false;
        }
        return true;
    }

    private boolean checkCompulsoryFieldsofPg(PgDetail PG) {
        if (PG.getPgName().trim().isEmpty()
                || PG.getTotalBeds().trim().isEmpty()
                || PG.getPgFor().trim().isEmpty()
                || PG.getCommonArea().trim().isEmpty()
                || PG.getPropertyManager().trim().isEmpty()
                || PG.getAmenities().trim().isEmpty()
                || PG.getPgFees().trim().isEmpty()
                || PG.getPgFees().trim().isEmpty()
                || PG.getPgImg().trim().isEmpty()) {

            return false;

        }
        return true;
    }
}