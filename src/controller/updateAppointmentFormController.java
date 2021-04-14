package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Appointment;
import model.User;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class updateAppointmentFormController {
    Stage stage;
    User authenticatedUser;
    Appointment selectedAppointment;
    boolean debug = true;

    @FXML
    private TextField updateAppt_textField_apptId = new TextField();
    @FXML
    private TextField updateAppt_textField_title = new TextField();
    @FXML
    private TextField updateAppt_textField_description = new TextField();
    @FXML
    private ChoiceBox updateAppt_choiceBox_location = new ChoiceBox();
    @FXML
    private TextField updateAppt_textField_type = new TextField();
    @FXML
    private TextField updateAppt_textField_start = new TextField();
    @FXML
    private TextField updateAppt_textField_end = new TextField();
    @FXML
    private TextField updateAppt_textField_customerId = new TextField();
    @FXML
    private TextField updateAppt_textField_contactId = new TextField();

    private int appointmentId = 0;
    private String title = "";
    private String description = "";
    private String location = "";
    private String type = "";
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerId = 0;
    private int contactId = 0;

    public void send(Stage sentStage, User user, Appointment appt) {
        stage = sentStage;
        authenticatedUser = user;
        selectedAppointment = appt;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);
        if (debug) System.out.println("Appointment to update: " + user);

        //populate the fields
        updateAppt_textField_apptId.setText(String.valueOf(selectedAppointment.getAppointment_ID()));
        updateAppt_textField_title.setText(selectedAppointment.getTitle());
        updateAppt_textField_description.setText(selectedAppointment.getDescription());
        updateAppt_choiceBox_location.getSelectionModel().select(selectedAppointment.getLocation());
        updateAppt_textField_type.setText(selectedAppointment.getType());
        updateAppt_textField_start.setText(String.valueOf(selectedAppointment.getStart()));
        updateAppt_textField_end.setText(String.valueOf(selectedAppointment.getEnd()));
        updateAppt_textField_customerId.setText(String.valueOf(selectedAppointment.getCustomer_ID()));
        updateAppt_textField_contactId.setText(String.valueOf(selectedAppointment.getContact_ID()));

    }

    public void saveHandler() throws SQLException {
        if (debug) System.out.println("Save handler called...");

        //update local variables
        appointmentId = selectedAppointment.getAppointment_ID();
        title = updateAppt_textField_title.getText();
        description = updateAppt_textField_description.getText();
        location = updateAppt_choiceBox_location.getSelectionModel().getSelectedItem().toString();
        type = updateAppt_textField_type.getText();
//        start = (Timestamp.valueOf(updateAppt_textField_start.getText())).toLocalDateTime();
//        end = (Timestamp.valueOf(updateAppt_textField_end.getText())).toLocalDateTime();
        start = LocalDateTime.parse(updateAppt_textField_start.getText());
        end = LocalDateTime.parse(updateAppt_textField_end.getText());
        System.out.println(start);
        System.out.println(end);

        customerId = Integer.parseInt(updateAppt_textField_customerId.getText());
        contactId = Integer.parseInt(updateAppt_textField_contactId.getText());

        //pass the data into the SQL command method
        updateAppointment(appointmentId, title, description, location, type, start, end, customerId, contactId); //FIXME
        stage.close();

    }
    public void cancelHandler() {
        if (debug) System.out.println("Cancel handler called...");
        stage.close();
    }

    /**
     * This method runs the SQL command to update a record.
     * @author Will Lapinski
     */
    public void updateAppointment(int appointmentId, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerId, int contactId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement

        start = Timestamp.valueOf(start).toLocalDateTime();
        end = Timestamp.valueOf(end).toLocalDateTime();

        int userId = authenticatedUser.getUser_ID();

        String updateStatement = "UPDATE appointments \n" +
                "\tSET Title=\"" + title + "\",\n" +
                "    Description=\"" + description + "\",\n" +
                "    Location=\"" + location + "\",\n" +
                "    Type=\"" + type + "\",\n" +
                "    Start=\'" + start + "\',\n" +
                "    End=\'" + end + "\',\n" +
                "    Customer_ID=" + customerId + ",\n" +
                "    Contact_ID=" + contactId + "\n" +
                "    WHERE (Appointment_ID=" + appointmentId + ");";
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
        if (debug) System.out.println("Update Appointment Form initializing...");

        updateAppt_choiceBox_location.getItems().add("London, England");
        updateAppt_choiceBox_location.getItems().add("Montréal, Québec");
        updateAppt_choiceBox_location.getItems().add("Phoenix, Arizona");
        updateAppt_choiceBox_location.getItems().add("White Plains, New York");

    }
}
