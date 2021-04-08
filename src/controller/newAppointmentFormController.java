package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.User;

public class newAppointmentFormController {
    Stage stage;
    User authenticatedUser;
    boolean debug = true;

    public void send(Stage sentStage, User user) {
        stage = sentStage;
        authenticatedUser = user;
        if (debug) System.out.println("Received user: " + user);
        if (debug) System.out.println("Authenticated user: " + authenticatedUser);
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
        if (debug) System.out.println("New Appointment Form initializing...");

    }
}
