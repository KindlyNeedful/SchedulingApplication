package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Country;
import model.Customer;
import model.Division;
import model.User;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class updateCustomerFormController {
    Stage stage;
    User authenticatedUser;
    Customer selectedCustomer;
    boolean debug = true;

    @FXML
    private TextField updateCustomer_textField_customerId = new TextField();
    @FXML
    private TextField updateCustomer_textField_name = new TextField();
    @FXML
    private TextField updateCustomer_textField_address = new TextField();
    @FXML
    private TextField updateCustomer_textField_postalCode = new TextField();
    @FXML
    private ComboBox updateCustomer_comboBox_country = new ComboBox();
    @FXML
    private ComboBox updateCustomer_comboBox_division = new ComboBox();
    @FXML
    private TextField updateCustomer_textField_phone = new TextField();
    @FXML
    private Button updateCustomer_button_save = new Button();
    @FXML
    private Button updateCustomer_button_cancel = new Button();

    //handlers
    public void saveHandler() throws SQLException {
        if (debug) System.out.println("saveHandler called");
        //FIXME - validate data

        String name = updateCustomer_textField_name.getText();
        String address = updateCustomer_textField_address.getText();
        String postalCode = updateCustomer_textField_postalCode.getText();
        String phone = updateCustomer_textField_phone.getText();
        int division = Division.lookupDivisionByName(updateCustomer_comboBox_division.getSelectionModel().getSelectedItem().toString()).getDivision_ID();

        //pass the data into the SQL command method
        updateCustomer(name, address, postalCode, phone, division);
        stage.close();

    }

    public void cancelHandler() {
        if (debug) System.out.println("cancelHandler called");
        stage.close();
    }



    public void send(Stage sentStage, User user, Customer customer) {
        stage = sentStage;
        authenticatedUser = user;
        selectedCustomer = customer;
        if (debug) {
            System.out.println("Received user: " + user);
            System.out.println("Authenticated user: " + authenticatedUser);
            System.out.println("Customer to delete: " + selectedCustomer);
        }

        Division customerDivision = Division.lookupDivisionById(selectedCustomer.getDivision_ID());
        Country customerCountry = Country.lookupCountryById(customerDivision.getCountry_ID());

        //populate the fields
        updateCustomer_textField_customerId.setText(String.valueOf(selectedCustomer.getCustomer_ID()));
        updateCustomer_textField_name.setText(selectedCustomer.getCustomer_Name());
        updateCustomer_textField_address.setText(selectedCustomer.getAddress());
        updateCustomer_textField_postalCode.setText(selectedCustomer.getPostal_Code());
        //updateCustomer_comboBox_division.getSelectionModel().select;
        updateCustomer_textField_phone.setText(selectedCustomer.getPhone());

        updateCustomer_comboBox_division.getSelectionModel().select(customerDivision.getDivision());
        updateCustomer_comboBox_country.getSelectionModel().select(customerCountry.getCountry());



    }

    public void filterDivisions() throws SQLException {
        if (debug) System.out.println("Filtering divisions");

        //get the selected item
        String selectedCountryName = updateCustomer_comboBox_country.getSelectionModel().getSelectedItem().toString();
        System.out.println("Selected country: " + selectedCountryName); //FIXME - I'm getting a String but need the Country.
        Country selectedCountry = Country.lookupCountryByName(updateCustomer_comboBox_country.getSelectionModel().getSelectedItem().toString());
        System.out.println("Selected country: " + selectedCountry);

        //filter the divisions comboBox
        updateCustomer_comboBox_division.setItems(Country.getDivisionNames(selectedCountry));
    }



    /**
     * This method runs the SQL command to update the customer record.
     * @author Will Lapinski
     */
    public void updateCustomer(String name, String address, String postalCode, String phone, int division) throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement

        int customerId = selectedCustomer.getCustomer_ID();

        String updateStatement = "UPDATE customers SET Customer_Name=\"" + name + "\",Address=\"" + address + "\",Postal_Code=\"" + postalCode + "\",Phone=\"" + phone + "\",Division_ID=" + division + " WHERE (Customer_ID=" + customerId + ");";
        statement.execute(updateStatement);

        //GET THE NUMBER OF AFFECTED ROWS   //FIXME - DRY!
        if (statement.getUpdateCount() > 0) {
            System.out.println("Rows affected: " + statement.getUpdateCount());
        } else {
            System.out.println("No change.");
        }
    }

    @FXML
    public void initialize() {
        //for each item in the countries list, add it to the combo box.
        for (int i = 0; i < Country.getCountryList().size(); i++) {
            updateCustomer_comboBox_country.getItems().add(Country.getCountryList().get(i).getCountry());
        }
        //for each item in the division list, add it to the combo box.
        for (int i = 0; i < Division.getDivisionList().size(); i++) {
            updateCustomer_comboBox_division.getItems().add(Division.getDivisionList().get(i).getDivision());
        }
    }
}
