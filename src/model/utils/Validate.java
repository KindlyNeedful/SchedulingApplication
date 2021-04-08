package model.utils;

/**
 * This class provides methods to validate user input.
 * @author Will Lapinski
 * @return 0 if the input is valid. Otherwise, return the error message to display to the user.
 */
public class Validate {
    //appointment validation
    public String validateTitle(String input) {
        if (input.isBlank()) {
            return ("Please enter a title.");
        }
        return "0";
    }
    public String validateDescription(String input) {
        if (input.isBlank()) {
            return ("Please enter a description.");
        }
        return "0";
    }
    public String validateLocation(String input) {
        if (input.isBlank()) {
            return ("Please enter a location.");
        }
        return "0";
    }
    public String validateType(String input) {
        if (input.isBlank()) {
            return ("Please enter a type.");
        }
        return "0";
    }
    public String validateStart(String input) { //FIXME - this needs to check whether the input matches the expected yyyy-mm-ddThh:mm:ss format.
        if (input.isBlank()) {
            return ("Please enter a start time.");
        }
        return "0";
    }
    public String validateEnd(String input) { //FIXME - this needs to check whether the input matches the expected yyyy-mm-ddThh:mm:ss format.
        if (input.isBlank()) {
            return ("Please enter an end time.");
        }
        return "0";
    }

    //customer validation
    public String validateName(String input) {
        if (input.isBlank()) {
            return ("Please enter a name.");
        }
        return "0";
    }
    public String validateAddress(String input) {
        if (input.isBlank()) {
            return ("Please enter an address.");
        }
        return "0";
    }
    public String validatePostalCode(String input) {
        if (input.isBlank()) {
            return ("Please enter a postal code.");
        }
        return "0";
    }
    public String validatePhoneNumber(String input) { //FIXME - input can be from 10 to ?? characters. Drop - and . if the user enters them. Server expects numbers like x-xxx-xxx-xxxx.
        if (input.isBlank()) {
            return ("Please enter a phone number.");
        }
        return "0";
    }

}
