package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Country;
import model.Division;
import model.User;

import java.sql.SQLException;

public class newCustomerFormController {
    //fields
    @FXML
    private TextField newCustomer_textField_customerId = new TextField();
    @FXML
    private TextField newCustomer_textField_name = new TextField();
    @FXML
    private TextField newCustomer_textField_address = new TextField();
    @FXML
    private TextField newCustomer_textField_postalCode = new TextField();
    @FXML
    private TextField newCustomer_textField_country = new TextField();
    @FXML
    private ComboBox newCustomer_comboBox_country = new ComboBox();
    @FXML
    private ComboBox newCustomer_comboBox_division = new ComboBox();
    @FXML
    private Button newCustomer_button_save = new Button();
    @FXML
    private Button newCustomer_button_cancel = new Button();

    private Stage stage;
    private User authenticatedUser = null;
    private boolean debug = true;

    //handlers
    public void saveHandler() {
        if (debug) System.out.println("saveHandler called");
    }
    public void cancelHandler() {
        if (debug) System.out.println("cancelHandler called");
        stage.close();
    }
    public void filterDivisions() throws SQLException {
        if (debug) System.out.println("Filtering divisions");

        //get the selected item
        String selectedCountryName = newCustomer_comboBox_country.getSelectionModel().getSelectedItem().toString();
        System.out.println("Selected country: " + selectedCountryName); //FIXME - I'm getting a String but need the Country.
        Country selectedCountry = Country.lookupCountryByName(newCustomer_comboBox_country.getSelectionModel().getSelectedItem().toString());
        System.out.println("Selected country: " + selectedCountry);

        //filter the divisions comboBox
        newCustomer_comboBox_division.setItems(Country.getDivisionNames(selectedCountry));

    }

    public void send(Stage sentStage, User user) {
        stage = sentStage;
        authenticatedUser = user;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);

        //FIXME - possibly add prefill option in here

    }

    @FXML
    public void initialize() {
        //for each item in the countries list, add it to the combo box.
        for (int i = 0; i < Country.getCountryList().size(); i++) {
            newCustomer_comboBox_country.getItems().add(Country.getCountryList().get(i).getCountry());
        }

    }
}
