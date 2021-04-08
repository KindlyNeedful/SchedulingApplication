package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Appointment;
import model.User;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class cancelAppointmentFormController {
    Stage stage;
    User authenticatedUser;
    Appointment selectedAppointment;
    boolean debug = true;

    @FXML
    private TextField cancelAppt_textField_apptId = new TextField();
    @FXML
    private TextField cancelAppt_textField_title = new TextField();
    @FXML
    private TextField cancelAppt_textField_description = new TextField();
    @FXML
    private TextField cancelAppt_textField_location = new TextField();
    @FXML
    private TextField cancelAppt_textField_type = new TextField();
    @FXML
    private TextField cancelAppt_textField_start = new TextField();
    @FXML
    private TextField cancelAppt_textField_end = new TextField();
    @FXML
    private TextField cancelAppt_textField_customerId = new TextField();
    @FXML
    private TextField cancelAppt_textField_contactId = new TextField();

    public void send(Stage sentStage, User user, Appointment appt) {
        stage = sentStage;
        authenticatedUser = user;
        selectedAppointment = appt;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);
        if (debug) System.out.println("Appointment to cancel: " + selectedAppointment);

        //populate the fields
        cancelAppt_textField_apptId.setText(String.valueOf(selectedAppointment.getAppointment_ID()));
        cancelAppt_textField_title.setText(selectedAppointment.getTitle());
        cancelAppt_textField_description.setText(selectedAppointment.getDescription());
        cancelAppt_textField_location.setText(selectedAppointment.getLocation());
        cancelAppt_textField_type.setText(selectedAppointment.getType());
        cancelAppt_textField_start.setText(String.valueOf(selectedAppointment.getStart()));
        cancelAppt_textField_end.setText(String.valueOf(selectedAppointment.getEnd()));
        cancelAppt_textField_customerId.setText(String.valueOf(selectedAppointment.getCustomer_ID()));
        cancelAppt_textField_contactId.setText(String.valueOf(selectedAppointment.getContact_ID()));
    }

    @FXML
    public void yesHandler() throws SQLException {
        if (debug) System.out.println("yesHandler called...");
        deleteAppointment(selectedAppointment);
        stage.close();
    }

    @FXML
    public void noHandler() {
        if (debug) System.out.println("noHandler called...");
        stage.close();
        //appointmentFormController.refreshTable(); //FIXME - need to refresh the main Appointments table
    }

    /**
     * This method runs the SQL command to delete the record.
     * @author Will Lapinski
     * @param appt the appointment to delete
     */
    public void deleteAppointment(Appointment appt) throws SQLException {
        int appt_id = appt.getAppointment_ID();
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement
        String deleteStatement = "DELETE FROM appointments WHERE Appointment_ID=" + appt_id;
        statement.execute(deleteStatement);
    }

    @FXML
    public void initialize() {
        if (debug) System.out.println("Cancel Appointment Form initializing...");


    }
}
