package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import model.Appointment;
import model.User;

import java.awt.*;

public class appointmentFormController {

    private boolean debug = true;

    //fields
    private Stage stage;
    private User authenticatedUser = null;
    @FXML
    private Label appt_label_username = new Label();
    @FXML
    private Button appt_button_settings = new Button();
    @FXML
    private Button appt_button_signOut = new Button();
    @FXML
    private RadioButton appt_rb_week = new RadioButton();
    @FXML
    private RadioButton appt_rb_month = new RadioButton();
    @FXML
    private Button appt_button_update = new Button();
    @FXML
    private Button appt_button_cancel = new Button();
    @FXML
    private Button appt_button_newAppt = new Button();

    @FXML
    private TableView appt_tableView_appts = new TableView();
    @FXML
    private TableColumn appt_tableColumn_title = new TableColumn();
    @FXML
    private TableColumn appt_tableColumn_description = new TableColumn();
    @FXML
    private TableColumn appt_tableColumn_location = new TableColumn();
    @FXML
    private TableColumn appt_tableColumn_from = new TableColumn();
    @FXML
    private TableColumn appt_tableColumn_to = new TableColumn();


    private ObservableList<Appointment> appointments = FXCollections.observableArrayList();

    //handlers
    @FXML
    public void settingsHandler() {
        launchSettingsForm(authenticatedUser);

    }
    @FXML
    public void signOutHandler() {
        authenticatedUser = null;
        System.out.println("Exiting...");
        System.exit(1);
    }
    @FXML
    public void rb_weekHandler() {
        if (debug) System.out.println("rb_week clicked");
    }
    @FXML
    public void rb_monthHandler() {
        if (debug) System.out.println("rb_month clicked");
    }
    @FXML
    public void updateHandler() {
        launchAppointmentUpdateForm(authenticatedUser);
    }
    @FXML
    public void cancelHandler() {
        launchCancelAppointmentForm(authenticatedUser);
    }
    @FXML
    public void newApptHandler() {
        launchNewAppointmentForm();
    }


    @FXML
    public void launchSettingsForm(User authenticatedUser) {
        if (debug) System.out.println("Launching Settings Form as " + authenticatedUser + "...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/settingsForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Settings Form");
            stage.setScene(new Scene(root));
            stage.show();

            settingsFormController controller2 = loader.getController();
            controller2.send(stage, authenticatedUser);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void launchAppointmentUpdateForm(User authenticatedUser) {
        if (debug) System.out.println("Launching Update Appointment / Details Form as " + authenticatedUser + "...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/updateAppointmentForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Update Appointment Form");
            stage.setScene(new Scene(root));
            stage.show();

            updateAppointmentFormController controller3 = loader.getController();
            controller3.send(stage, authenticatedUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void launchCancelAppointmentForm(User authenticatedUser) {
        if (debug) System.out.println("Launching Cancel Appointment Form as " + authenticatedUser + "...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/cancelAppointmentForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Cancel Appointment Form");
            stage.setScene(new Scene(root));
            stage.show();

            cancelAppointmentFormController controller4 = loader.getController();
            controller4.send(stage, authenticatedUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void launchNewAppointmentForm() {
        if (debug) System.out.println("Launching New Appointment Form as " + authenticatedUser + "...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/newAppointmentForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("New Appointment Form");
            stage.setScene(new Scene(root));
            stage.show();

            newAppointmentFormController controller5 = loader.getController();
            controller5.send(stage, authenticatedUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
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
        appt_label_username.setText(authenticatedUser.getUser_Name());
    }


    /**
     * This initialize method populates the Appointments table.
     * @author Will Lapinski
     */
    @FXML
    public void initialize() {
        if (debug) System.out.println("Appointment Form initializing...");
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);

        appt_tableView_appts.setItems(Appointment.getAppointmentList());
        appt_tableColumn_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        appt_tableColumn_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        appt_tableColumn_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        appt_tableColumn_from.setCellValueFactory(new PropertyValueFactory<>("start"));
        appt_tableColumn_to.setCellValueFactory(new PropertyValueFactory<>("end"));

    }
}
