package com.pgrental.dataAccess;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LongStringConverter;
import model.ContactTable;

public class ContactInfo {

    private Stage primaryStage;
    private Pane contactRoot;
    TableView<ContactTable> contactInfo;
    TableColumn<ContactTable, String> firstNameColumn;
    TableColumn<ContactTable, String> lastNameColumn;
    TableColumn<ContactTable, Long> contactColumn;
    TableColumn<ContactTable, String> mailIdColumn;

    TextField firstName;
    TextField lastName;
    TextField contact;
    TextField mailId;

    Button Add;
    Button Delete;

    public ContactInfo() {

    }

    // public void MainView() {
    //     buildTable();
    // }

    // Method To set primary stage
    public void setContactInfo(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // public Pane buildTable() {
    public Pane createContactInfoScene(Runnable ContactInfoBackHandler) {

        contactRoot = new Pane();

        // Back Button To Back Page
        Image imageBack = new Image("file:src\\main\\resources\\images\\backbg.png",
                1500, 1000, true, false);
        ImageView BackView = new ImageView(imageBack);
        BackView.setFitHeight(40);
        BackView.setFitWidth(45);

        Button Back = new Button();
        Back.setStyle(
                "-fx-background-radius: 5em; " +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 30px;");
        Back.setGraphic(BackView);
        Back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ContactInfoBackHandler.run();
            }
        });

        // Contacts Text
        Text Contacts = new Text("Contacts");
        Contacts.setFont(Font.font(null, FontWeight.BOLD, 35));

        // Three Dots To Clear
        Image imageDots = new Image(getClass().getResourceAsStream("/images/vertical-dots.png"), 1500, 1000,
                true,
                false);

        BackgroundSize Dotsbg = new BackgroundSize(
                BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        BackgroundImage DotsbgImage = new BackgroundImage(imageDots, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, Dotsbg);
        Background DotsBackground = new Background(DotsbgImage);
        Button Dots = new Button();
        Dots.setBackground(DotsBackground);

        HBox TopView = new HBox(590, Back, Contacts, Dots);
        TopView.setStyle("-fx-background-radius: 1em; -fx-background-color : #A9A9A9;");
        TopView.setPadding(new Insets(20));

        // TableView
        contactInfo = new TableView<ContactTable>();
        contactInfo.setEditable(true);
        contactInfo.setPrefSize(1500, 1000);

        firstNameColumn = new TableColumn<ContactTable, String>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<ContactTable, String>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<ContactTable, String>>() {

            public void handle(CellEditEvent<ContactTable, String> event) {
                ContactTable contact = event.getRowValue();
                contact.setFirstName(event.getNewValue());
            }
        });

        lastNameColumn = new TableColumn<ContactTable, String>("last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<ContactTable, String>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<ContactTable, String>>() {

            public void handle(CellEditEvent<ContactTable, String> event) {
                ContactTable contact = event.getRowValue();
                contact.setLastName(event.getNewValue());
            }
        });

        contactColumn = new TableColumn<ContactTable, Long>("Contact");
        contactColumn.setCellValueFactory(new PropertyValueFactory<ContactTable, Long>("contact"));
        contactColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        contactColumn.setOnEditCommit(new EventHandler<CellEditEvent<ContactTable, Long>>() {

            public void handle(CellEditEvent<ContactTable, Long> event) {
                ContactTable contact = event.getRowValue();
                contact.setContact(event.getNewValue());
            }
        });

        mailIdColumn = new TableColumn<ContactTable, String>("Email");
        mailIdColumn.setCellValueFactory(new PropertyValueFactory<ContactTable, String>("mailId"));
        mailIdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        mailIdColumn.setOnEditCommit(new EventHandler<CellEditEvent<ContactTable, String>>() {

            public void handle(CellEditEvent<ContactTable, String> event) {
                ContactTable contact = event.getRowValue();
                contact.setMailId(event.getNewValue());
            }
        });

        contactInfo.getColumns().add(firstNameColumn);
        contactInfo.getColumns().add(lastNameColumn);
        contactInfo.getColumns().add(contactColumn);
        contactInfo.getColumns().add(mailIdColumn);

        contactInfo.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //First Name
        firstName = new TextField();
        firstName.setPromptText("Enter First Name");
        firstName.setTooltip(new Tooltip("Enter First Name"));
        firstName.setAlignment(Pos.CENTER);

        //Last Name
        lastName = new TextField();
        lastName.setPromptText("Enter Last Name");
        lastName.setTooltip(new Tooltip("Enter Last Name"));
        lastName.setAlignment(Pos.CENTER);

        //Contact 
        contact = new TextField();
        contact.setPromptText("Enter Contact No.");
        contact.setTooltip(new Tooltip("Enter Contact No."));
        contact.setAlignment(Pos.CENTER);

        //Email
        mailId = new TextField();
        mailId.setPromptText("Enter Email");
        mailId.setTooltip(new Tooltip("Enter MailId"));
        mailId.setAlignment(Pos.CENTER);

        HBox TextFieldBox = new HBox(100, firstName, lastName, contact, mailId);
        TextFieldBox.setPadding(new Insets(20));
        TextFieldBox.setStyle("-fx-background-color : #696969;");
        TextFieldBox.setAlignment(Pos.CENTER);

        //Add Data
        Add = new Button("Add");
        Add.setStyle("-fx-background-radius : 2em; -fx-background-color : #DCDCDC;");
        Add.setPrefWidth(100);
        Add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ContactTable contactTable = new ContactTable(firstName.getText(), lastName.getText(), Long.parseLong(contact.getText()), mailId.getText());
                add(contactTable);
            }
        });

        //Delete Data
        Delete = new Button("Delete");
        Delete.setStyle("-fx-background-radius : 2em; -fx-background-color : #DCDCDC;");
        Delete.setPrefWidth(100);
        Delete.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int row = contactInfo.getSelectionModel().getSelectedIndex();
                delete(row);
            }
        });

        HBox buttonBox = new HBox(20, Add, Delete);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setStyle("-fx-background-color : #696969;");
        buttonBox.setAlignment(Pos.TOP_CENTER);

        VBox buttonTextBox = new VBox(TextFieldBox, buttonBox);
        buttonTextBox.setStyle("-fx-background-color : #696969;");

        VBox vb = new VBox(10, TopView, contactInfo, buttonTextBox);
        vb.setAlignment(Pos.CENTER);
        vb.setPrefSize(1500, 1000);
        vb.setPadding(new Insets(20));

        contactRoot.getChildren().addAll(vb);

        // Creating Scene
        // Scene scene = new Scene(contactRoot, 1500, 1000);

        // Setting the stage
        // primaryStage = new Stage(StageStyle.DECORATED);
        // primaryStage.setTitle("TableView Example");
        // primaryStage.setScene(scene);
        // primaryStage.show();

        return contactRoot;
    }

    // Method To set option Page Scene
    // public void setContactInfoScene(Scene TenantScene) {
    // this.TenantScene = TenantScene;
    // }


    // public void start(Stage primaryStage) throws Exception {
    //     MainView();        
    // }

    public void add(ContactTable contactTable) {
        System.out.println(contactTable);
        contactInfo.getItems().add(contactTable);
        clearFields();
    }

    public void delete(int row) {
        if(row >= 0) {
            contactInfo.getItems().remove(row);
            contactInfo.getSelectionModel().clearSelection();
        }
    }

    public void clearFields() {
        firstName.clear();
        lastName.clear();
        contact.clear();
        mailId.clear();
        firstName.requestFocus();
    }

    // public static void main(String[] args) {
    //     launch(args);
    // }
}

