package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Customer;
import model.User;

public class customerFormController {
    @FXML
    private TableView customer_tableView_customers = new TableView();
    @FXML
    private TableColumn customer_tableColumn_customerId = new TableColumn();
    @FXML
    private TableColumn customer_tableColumn_name = new TableColumn();
    @FXML
    private TableColumn customer_tableColumn_address = new TableColumn();
    @FXML
    private TableColumn customer_tableColumn_postalCode = new TableColumn();
    @FXML
    private TableColumn customer_tableColumn_division = new TableColumn();
    @FXML
    private TableColumn customer_tableColumn_phoneNumber = new TableColumn();

    @FXML
    private Button customer_button_newCustomer = new Button();
    @FXML
    private Button customer_button_updateCustomer = new Button();
    @FXML
    private Button customer_button_deleteCustomer = new Button();
    @FXML
    private Button customer_button_back = new Button();

    @FXML
    private Label customer_label_errorOutput = new Label();


    private boolean debug = true;
    private Stage stage = null;
    private User authenticatedUser = null;

    //handlers
    public void newCustomerHandler() {
        if (debug) System.out.println("newCustomerHandler called");
        launchNewCustomerForm();
    }
    public void updateCustomerHandler() {
        if (debug) System.out.println("updateCustomerHandler called");
        launchUpdateCustomerForm();
    }
    public void deleteCustomerHandler() {
        if (debug) System.out.println("deleteCustomerHandler called");
        launchDeleteCustomerForm();
    }
    public void backHandler() {
        if (debug) System.out.println("backHandler called");
        stage.close();
    }

    //launchers
    public void launchNewCustomerForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/newCustomerForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("New Customer Form");
            stage.setScene(new Scene(root));
            stage.show();

            newCustomerFormController controller8 = loader.getController();
            controller8.send(stage, authenticatedUser);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void launchUpdateCustomerForm() {

        if (customer_tableView_customers.getSelectionModel().getSelectedItems().isEmpty()) {
            System.out.println("Error: please select a customer."); //FIXME - add a Label.
            customer_label_errorOutput.setText("Error: please select a customer.");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/updateCustomerForm.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Update Customer Form");
                stage.setScene(new Scene(root));
                stage.show();

                Customer selectedCustomer = (Customer) customer_tableView_customers.getSelectionModel().getSelectedItem();

                updateCustomerFormController controller9 = loader.getController();
                controller9.send(stage, authenticatedUser, selectedCustomer);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    public void launchDeleteCustomerForm() {

        if (customer_tableView_customers.getSelectionModel().getSelectedItems().isEmpty()) {
            System.out.println("Error: please select a customer."); //FIXME - add a Label.
            customer_label_errorOutput.setText("Error: please select a customer.");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/deleteCustomerForm.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Delete Customer Form");
                stage.setScene(new Scene(root));
                stage.show();

                Customer selectedCustomer = (Customer) customer_tableView_customers.getSelectionModel().getSelectedItem();

                deleteCustomerFormController controller10 = loader.getController();
                controller10.send(stage, authenticatedUser, selectedCustomer);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




    /**
     * This method is used to receive the Authenticated User and Stage from the login form.
     * @param user
     */
    public void send(Stage sentStage, User user) {
        stage = sentStage;
        authenticatedUser = user;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);
    }

    /**
     * This initialize method populates the Customers table.
     * @author Will Lapinski
     */
    @FXML
    public void initialize() {
        if (debug) System.out.println("Customer Form initializing...");
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);

        customer_tableView_customers.setItems(Customer.getCustomerList());
        customer_tableColumn_customerId.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
        customer_tableColumn_name.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
        customer_tableColumn_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customer_tableColumn_postalCode.setCellValueFactory(new PropertyValueFactory<>("Postal_Code"));
        customer_tableColumn_division.setCellValueFactory(new PropertyValueFactory<>("Division_ID")); //FIXME - the table is showing Division ID, not Division Name.
        customer_tableColumn_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("Phone"));

    }

}
