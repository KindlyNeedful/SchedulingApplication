package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 * This class is used to create Customers in the program.
 * It corresponds with the customers table.
 * @author Will Lapinski
 */
public class Customer {
    //fields
    private int Customer_ID;
    private String Customer_Name;
    private String Address;
    private String Postal_Code;
    private String Phone;
    private LocalDateTime Create_Date;
    private String Created_By;
    private LocalDateTime Last_Update;
    private String Last_Updated_By;
    private int Division_ID;
    private static ObservableList<Customer> customerList = FXCollections.observableArrayList();

    //constructor
    public Customer(int customer_ID, String customer_Name, String address, String postal_Code, String phone, LocalDateTime create_Date, String created_By, LocalDateTime last_Update, String last_Updated_By, int division_ID) {
        Customer_ID = customer_ID;
        Customer_Name = customer_Name;
        Address = address;
        Postal_Code = postal_Code;
        Phone = phone;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
        Division_ID = division_ID;
    }

    /**
     * This method is used to instantiate one Customer object for each record in the customers table.
     * @author Will Lapinski
     */
    public static void pullCustomers() throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement
        String selectStatement = "SELECT * FROM customers";
        statement.execute(selectStatement);
        ResultSet rs = statement.getResultSet();

        //forward scroll through Customers
        while(rs.next()) {
            int customerId = rs.getInt("Customer_ID");
            String customerName = rs.getString("Customer_Name");
            String address = rs.getString("Address");
            String postalCode = rs.getString("Postal_Code");
            String phoneNumber = rs.getString("Phone");
            LocalDateTime createDate = rs.getTimestamp("Create_Date").toLocalDateTime();
            String createdBy = rs.getString("Created_By");
            LocalDateTime lastUpdate = rs.getTimestamp("Last_Update").toLocalDateTime();
            String lastUpdatedBy = rs.getString("Last_Updated_By");
            int divisionId = rs.getInt("Division_ID");

            //for each record, instantiate a new Customer object
            Customer customer = new Customer (customerId, customerName, address, postalCode, phoneNumber, createDate, createdBy, lastUpdate, lastUpdatedBy, divisionId);
            customerList.add(customer);
        }
    }

    /**
     * This method checks to see whether a given customer has any appointments.
     * @return true if there are associated appointments.
     */
    public boolean hasAppointments() {
        for (int i = 0; i < Appointment.getAppointmentList().size(); i++) {
            if (Appointment.getAppointmentList().get(i).getCustomer_ID() == this.getCustomer_ID()) {
                return true;
            }
        }
        return false;
    }

    //getters and setters
    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostal_Code() {
        return Postal_Code;
    }

    public void setPostal_Code(String postal_Code) {
        Postal_Code = postal_Code;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public LocalDateTime getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(LocalDateTime create_Date) {
        Create_Date = create_Date;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public LocalDateTime getLast_Update() {
        return Last_Update;
    }

    public void setLast_Update(LocalDateTime last_Update) {
        Last_Update = last_Update;
    }

    public String getLast_Updated_By() {
        return Last_Updated_By;
    }

    public void setLast_Updated_By(String last_Updated_By) {
        Last_Updated_By = last_Updated_By;
    }

    public int getDivision_ID() {
        return Division_ID;
    }

    public void setDivision_ID(int division_ID) { Division_ID = division_ID; }

    public static ObservableList<Customer> getCustomerList() {return customerList;}
}
