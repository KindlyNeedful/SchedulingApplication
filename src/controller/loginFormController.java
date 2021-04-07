package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class loginFormController {
    @FXML
    private TextField login_textField_username = new TextField();
    @FXML
    private TextField login_textField_password = new TextField();
    @FXML
    private Button login_button_go = new Button();
    @FXML
    private Label login_label = new Label();

    @FXML
    public void loginHandler() {
        System.out.println("loginHandler called");
        validateLogin();
    }


    /**
     * This method first ensures neither the username nor password fields are empty.
     * Then it checks them against the somethingSomething //FIXME - REEEE
     * @return true if neither the username nor password are blank AND the username/password are a valid combination
     */
    public boolean validateLogin() {
        //first ensure neither the username/password fields are empty.  //FIXME - add a specific message "Please enter username AND password".
        if ((login_textField_password.getText().isBlank()) && (login_textField_username.getText().isBlank())) {
            login_label.setText("Please enter a username and password.");
            return false;
        } else if (login_textField_username.getText().isBlank()) {
            login_label.setText("Please enter a username.");
            return false;
        } else if (login_textField_password.getText().isBlank()) {
            login_label.setText("Please enter a password.");
            return false;
        } else {
            //FIXME - ensure the User.User_Name and User.User_Password are a valid combination.
            login_label.setText("");
            checkCredentials(login_textField_username.getText(), login_textField_password.getText());
            return true;
        }

    }

    public boolean checkCredentials(String username, String password) {
        System.out.println("Checking credentials... " + username + " " + password);
        if ((username.equals("admin")) && (password.equals("password"))) { //FIXME - If the user.username + user.password match, then return true. Otherwise return false.
            login_label.setText("Login success!");
            //Launch the AppointmentForm. Pass in the authenticated User.
            return true; //FIXME

        }
        login_label.setText("Login failure.");
        return false;
    }

}
