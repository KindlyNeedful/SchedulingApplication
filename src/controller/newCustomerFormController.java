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
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    private TextField newCustomer_textField_phone = new TextField();
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
    public void saveHandler() throws SQLException {
        if (debug) System.out.println("saveHandler called");
        //FIXME - validate data

        String name = newCustomer_textField_name.getText();
        String address = newCustomer_textField_address.getText();
        String postalCode = newCustomer_textField_postalCode.getText();
        String phone = newCustomer_textField_phone.getText();
        int division = Division.lookupDivisionByName(newCustomer_comboBox_division.getSelectionModel().getSelectedItem().toString()).getDivision_ID();

        //pass the data into the SQL command method
        addCustomer(name, address, postalCode, phone, authenticatedUser.getUser_Name(), division);
        stage.close();
    }

    public void cancelHandler() {
        if (debug) System.out.println("cancelHandler called");
        stage.close();
    }

    /**
     * This method runs the SQL command to add the record.
     * @author Will Lapinski
     */
    public void addCustomer(String name, String address, String postalCode, String phone, String createdBy, int division) throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement

        String addStatement = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Created_By, Division_ID) VALUES (\"" + name + "\", \"" + address + "\", \"" + postalCode + "\", \"" + phone + "\", \"" + createdBy + "\", " + division + ");";
        statement.execute(addStatement);

        //GET THE NUMBER OF AFFECTED ROWS
        if (statement.getUpdateCount() > 0) {
            System.out.println("Rows affected: " + statement.getUpdateCount());
        } else {
            System.out.println("No change.");
        }

        //appointmentFormController.refreshTable(); //FIXME - REFRESH!!!!!!
    }

    //


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
