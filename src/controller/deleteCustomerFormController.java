package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteCustomerFormController {
    Stage stage;
    User authenticatedUser;
    Customer selectedCustomer;
    boolean debug = true;

    @FXML
    private TextField deleteCustomer_textField_customerId = new TextField();
    @FXML
    private TextField deleteCustomer_textField_name = new TextField();
    @FXML
    private TextField deleteCustomer_textField_address = new TextField();
    @FXML
    private TextField deleteCustomer_textField_postalCode = new TextField();
    @FXML
    private TextField deleteCustomer_textField_division = new TextField();
    @FXML
    private TextField deleteCustomer_textField_country = new TextField();



    public void send(Stage sentStage, User user, Customer customer) {
        stage = sentStage;
        authenticatedUser = user;
        selectedCustomer = customer;
        if (debug) {
            System.out.println("Received user: " + user);
            System.out.println("Authenticated user: " + authenticatedUser);
            System.out.println("Customer to delete: " + selectedCustomer);
        }

        Division customerDivision = Division.getDivisionList().get(selectedCustomer.getDivision_ID());
        Country customerCountry = Country.lookupCountryById(customerDivision.getCountry_ID());

        //populate the fields
        deleteCustomer_textField_customerId.setText(String.valueOf(selectedCustomer.getCustomer_ID()));
        deleteCustomer_textField_name.setText(selectedCustomer.getCustomer_Name());
        deleteCustomer_textField_address.setText(selectedCustomer.getAddress());
        deleteCustomer_textField_postalCode.setText(selectedCustomer.getPostal_Code());
        deleteCustomer_textField_division.setText(customerDivision.getDivision());
        deleteCustomer_textField_country.setText(customerCountry.getCountry());
    }

    @FXML
    public void yesHandler() throws SQLException {
        if (debug) System.out.println("yesHandler called...");
        deleteCustomer(selectedCustomer);
        stage.close();
    }
    @FXML
    public void noHandler() {
        if (debug) System.out.println("noHandler called...");
        stage.close();
        //appointmentFormController.refreshTable(); //FIXME - need to refresh the main Customers table
    }

    /**
     * This method runs the SQL command to delete the customer record.
     * @author Will Lapinski
     * @param customer the customer to delete
     */
    public void deleteCustomer(Customer customer) throws SQLException {
        int customerId = customer.getCustomer_ID();
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement
        String deleteStatement = "DELETE FROM customers WHERE Customer_ID=" + customerId;
        statement.execute(deleteStatement);

        //GET THE NUMBER OF AFFECTED ROWS
        if (statement.getUpdateCount() > 0) {
            System.out.println("Rows affected: " + statement.getUpdateCount());
        } else {
            System.out.println("No change.");
        }
    }
}
