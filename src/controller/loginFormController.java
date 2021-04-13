package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Main;
import model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

public class loginFormController {
    @FXML
    private TextField login_textField_username = new TextField();
    @FXML
    private TextField login_textField_password = new TextField();
    @FXML
    private Button login_button_go = new Button();
    @FXML
    private Button login_button_exit = new Button();
    @FXML
    private Label login_label = new Label();
    @FXML
    private Label locationLabel = new Label();

    //this toggles auto-population of the login fields.
    private boolean easyLogin = true;
    private boolean debug = true;

    @FXML
    public void loginHandler() throws IOException {
        if (debug) System.out.println("loginHandler called");
        validateLogin();
    }
    @FXML
    public void exitHandler() {
        System.out.println("Exiting...");
        System.exit(1);
    }
    @FXML
    public void locationHandler() {
        if (debug) System.out.println("locationHandler called");
    }

    public void logActivity(String username, Boolean success) throws IOException {
        String successFailure = "";
        if (debug) System.out.println("logActivity called with user " + username + ", " + "login " + success);
        if (success) {
            successFailure = "success";
        } else {
            successFailure = "failure";
        }

        FileWriter fw = new FileWriter("login_activity.txt", true); //True opens FileWriter in Append mode.
        PrintWriter pw = new PrintWriter(fw);
        pw.println(LocalDateTime.now() + "," + username + "," + successFailure);
        pw.close();
    }


    /**
     * This method first ensures neither the username nor password fields are empty.
     * Then it checks them against the somethingSomething //FIXME - REEEE
     * @return true if neither the username nor password are blank AND the username/password are a valid combination
     */
    public boolean validateLogin() throws IOException {
        //first ensure neither the username/password fields are empty.  //FIXME - add a specific message "Please enter username AND password".
        if ((login_textField_password.getText().isBlank()) && (login_textField_username.getText().isBlank())) {
            logActivity(login_textField_username.getText(), false);
            login_label.setText("Please enter a username and password.");
            return false;
        } else if (login_textField_username.getText().isBlank()) {
            logActivity(login_textField_username.getText(), false);
            login_label.setText("Please enter a username.");
            return false;
        } else if (login_textField_password.getText().isBlank()) {
            logActivity(login_textField_username.getText(), false);
            login_label.setText("Please enter a password.");
            return false;
        } else {
            //FIXME - ensure the User.User_Name and User.User_Password are a valid combination.
            login_label.setText("");
            logActivity(login_textField_username.getText(), true);
            checkCredentials(login_textField_username.getText(), login_textField_password.getText());
            return true;
        }

    }

    public boolean checkCredentials(String username, String password) {
        System.out.println("Checking credentials... " + username + " " + password);

        //if the username is found in the list of users, check the password.
        for (int i = 0; i < User.getUserList().size(); i++) {
            User user = User.getUserList().get(i);
            if (user.getUser_Name().equals(username)) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Login successful.");
                    login_textField_username.setText("");
                    login_textField_password.setText("");
                    //Launch AppointmentForm, pass in the authenticated user.
                    //launchAppointmentForm(user);
                    launchMainForm(user);

                    return true;
                }
            }
        }
        login_label.setText("Login failure.");
        return false;

    }

    @FXML
    private void launchMainForm(User authenticatedUser) {
        try {
            System.out.println("Launching Appointment Form as " + authenticatedUser + "...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/mainForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();

            mainFormController controller6 = loader.getController();
            controller6.send(stage, authenticatedUser);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Main Form");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void launchAppointmentForm(User authenticatedUser) {
        try {
            System.out.println("Launching Appointment Form as " + authenticatedUser + "...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/appointmentForm.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();

            appointmentFormController controller1 = loader.getController();
            controller1.send(stage, authenticatedUser);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Appointment Form");
            stage.setScene(new Scene(root));
            stage.show();



        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void initialize() {
        if (easyLogin) {
            login_textField_username.setText("test");
            login_textField_password.setText("test");
        }
        System.out.println("Default system Zone ID: " + ZoneId.systemDefault());
        locationLabel.setText("Location: " + ZoneId.systemDefault());

        String defaultLanguage = Locale.getDefault().getLanguage();

        Locale.getDefault();
        System.out.println("Java default locale: " + Locale.getDefault());
        System.out.println("Java country: " + Locale.getDefault().getCountry());
        System.out.println("Java language: " + Locale.getDefault().getLanguage());


    }

}
