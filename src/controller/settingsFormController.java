package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;


/**
 *
 */
public class settingsFormController {
    Stage stage;
    User authenticatedUser;
    boolean debug = true;

    @FXML
    private TextField settings_textField_name = new TextField();
    @FXML
    private TextField settings_textField_address = new TextField();
    @FXML
    private TextField settings_textField_division = new TextField();
    @FXML
    private TextField settings_textField_postalCode = new TextField();
    @FXML
    private TextField settings_textField_phoneNumber = new TextField();

    @FXML
    private ChoiceBox settings_choiceBox_language = new ChoiceBox();
    @FXML
    private ChoiceBox settings_choiceBox_timeZone = new ChoiceBox();

    @FXML
    private Button settings_button_detectLanguage = new Button();
    @FXML
    private Button settings_button_detectTimeZone = new Button();
    @FXML
    private Button settings_button_save = new Button();
    @FXML
    private Button settings_button_back = new Button();


    @FXML
    public void detectLanguageHandler() {
        System.out.println("Detect Language Handler called...");
    }
    @FXML
    public void detectTimeZoneHandler() {
        System.out.println("Detect Timezone Handler called...");
    }
    @FXML
    public void saveHandler() {
        System.out.println("Save Handler called...");
    }
    @FXML
    public void backHandler() {
        System.out.println("Back Handler called...");
        stage.close();
    }



    public void send(Stage sentStage, User user) {
        stage = sentStage;
        authenticatedUser = user;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);

        settings_textField_name.setText(authenticatedUser.getUser_Name()); //FIXME - should actually pull from Customer table. How do Users correspond to Customers?

        //populate choiceboxes
        settings_choiceBox_language.getItems().add("English");
        settings_choiceBox_language.getItems().add("French");

        settings_choiceBox_timeZone.getItems().add("London, England");
        settings_choiceBox_timeZone.getItems().add("Montréal, Québec");
        settings_choiceBox_timeZone.getItems().add("Phoenix, Arizona");
        settings_choiceBox_timeZone.getItems().add("White Plains, New York");



    }

    @FXML
    public void initialize() {
        if (debug) System.out.println("Settings Form initializing...");


    }
}
