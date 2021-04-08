package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Appointment;
import model.User;

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
    private TextField updateAppt_textField_location = new TextField();
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
        updateAppt_textField_location.setText(selectedAppointment.getLocation());
        updateAppt_textField_type.setText(selectedAppointment.getType());
        updateAppt_textField_start.setText(String.valueOf(selectedAppointment.getStart()));
        updateAppt_textField_end.setText(String.valueOf(selectedAppointment.getEnd()));
        updateAppt_textField_customerId.setText(String.valueOf(selectedAppointment.getCustomer_ID()));
        updateAppt_textField_contactId.setText(String.valueOf(selectedAppointment.getContact_ID()));
    }

    public void saveHandler() {
        if (debug) System.out.println("Save handler called...");


    }
    public void cancelHandler() {
        if (debug) System.out.println("Cancel handler called...");
        stage.close();
    }

    @FXML
    public void initialize() {
        if (debug) System.out.println("Update Appointment Form initializing...");

    }
}
