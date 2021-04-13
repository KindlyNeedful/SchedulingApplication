package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class newAppointmentFormController {
    Stage stage;
    User authenticatedUser;
    boolean debug = true;
    boolean prefill = true;

    @FXML
    private TextField newAppt_textField_title = new TextField();
    @FXML
    private TextField newAppt_textField_description = new TextField();
    @FXML
    private ChoiceBox newAppt_choiceBox_location = new ChoiceBox();
    @FXML
    private TextField newAppt_textField_type = new TextField();
    @FXML
    private TextField newAppt_textField_start = new TextField();
    @FXML
    private TextField newAppt_textField_end = new TextField();
    @FXML
    private TextField newAppt_textField_customerId = new TextField();
    @FXML
    private TextField newAppt_textField_contactId = new TextField();

    public void send(Stage sentStage, User user) {
        stage = sentStage;
        authenticatedUser = user;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);
        //prefill the fields, for debugging SQL syntax
        if (prefill) {
            newAppt_textField_title.setText("test title");
            newAppt_textField_description.setText("test description");
            //newAppt_textField_location.setText("test location");
            //newAppt_choiceBox_location.setSelectionModel("London, England");
            newAppt_choiceBox_location.getSelectionModel().selectFirst();
            newAppt_textField_type.setText("test type");
            newAppt_textField_start.setText("2021-01-01 00:00:00");
            newAppt_textField_end.setText("2021-01-01 00:00:00");
            newAppt_textField_customerId.setText("1");
            newAppt_textField_contactId.setText("1");
        }
    }

    public void saveHandler() throws SQLException {
        if (debug) System.out.println("Save handler called...");
        //FIXME - validate data
        //NOTE: the order of operations here is to run SQL to add the record, pull this down (including ApptID), create the object, and add it to the list of objects.
        //Then, refresh the table.

        String title = newAppt_textField_title.getText();
        String description = newAppt_textField_description.getText();
        String location = newAppt_choiceBox_location.getSelectionModel().getSelectedItem().toString();
        String type = newAppt_textField_type.getText();
        LocalDateTime start = (Timestamp.valueOf(newAppt_textField_start.getText())).toLocalDateTime();
        LocalDateTime end = (Timestamp.valueOf(newAppt_textField_end.getText())).toLocalDateTime();
        int customerId = Integer.parseInt(newAppt_textField_customerId.getText());
        int contactId = Integer.parseInt(newAppt_textField_contactId.getText());

        //pass the data into the SQL command method
        addAppointment(title, description, location, type, start, end, customerId, contactId);
        stage.close();

    }
    public void cancelHandler() {
        if (debug) System.out.println("Cancel handler called...");
        stage.close();
    }


    /**
     * This method runs the SQL command to add the record.
     * @author Will Lapinski
     */
    public void addAppointment(String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerId, int contactId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement

        int userId = authenticatedUser.getUser_ID();
        String addStatement = "INSERT INTO appointments(Title, Description, Location, Type, Start, End, Created_By, Last_Updated_By, Customer_ID, User_ID, Contact_ID) " +
                "VALUES (\"" + title + "\", \"" + description + "\", \"" + location + "\", \"" + type + "\", \'" + start + "\', \'" + end + "\', \"" + authenticatedUser.getUser_Name() + "\", \"" + authenticatedUser.getUser_Name() + "\", " + customerId + ", " + userId + ", " + contactId + ")";

        statement.execute(addStatement);

        //GET THE NUMBER OF AFFECTED ROWS
        if (statement.getUpdateCount() > 0) {
            System.out.println("Rows affected: " + statement.getUpdateCount());
        } else {
            System.out.println("No change.");
        }

        //appointmentFormController.refreshTable(); //FIXME - REFRESH!!!!!!
    }



    @FXML
    public void initialize() {
        if (debug) System.out.println("New Appointment Form initializing...");
        newAppt_choiceBox_location.getItems().add("London, England");
        newAppt_choiceBox_location.getItems().add("Montréal, Québec");
        newAppt_choiceBox_location.getItems().add("Phoenix, Arizona");
        newAppt_choiceBox_location.getItems().add("White Plains, New York");
    }
}
