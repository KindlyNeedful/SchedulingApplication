package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.utils.DBConnection;
import model.utils.DBQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class is used to create Users in the program.
 * It corresponds with the users table.
 * @author Will Lapinski
 */
public class User {
    //fields
    private int User_ID;
    private String User_Name;
    private String Password;
    private LocalDateTime Create_Date;
    private String Created_By;
    private LocalDateTime Last_Update;
    private String Last_Updated_By;
    private static ObservableList<User> userList = FXCollections.observableArrayList();

    /**
     * This method is used to instantiate one User object for each record in the users table.
     * @author Will Lapinski
     */
    public static void pullUsers() throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection);
        Statement statement = DBQuery.getStatement();
        String selectStatement = "SELECT * FROM users";
        statement.execute(selectStatement);
        ResultSet rs = statement.getResultSet();

        //forward scroll through Users
        while (rs.next()) {
            int userId = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");
            String password = rs.getString("Password");
//            LocalDate createDate = rs.getDate("Create_Date").toLocalDate();
//            LocalTime createTime = rs.getTime("Create_Date").toLocalTime();
            LocalDateTime createDateTime = rs.getTimestamp("Create_Date").toLocalDateTime();    //FIXME - possibly easier to pass this into the constructor?
            String createdBy = rs.getString("Created_By");
            LocalDateTime lastUpdate = rs.getTimestamp("Last_Update").toLocalDateTime();
            String lastUpdatedBy = rs.getString("Last_Updated_By");

            User user = new User(userId, userName, password, createDateTime, createdBy, lastUpdate, lastUpdatedBy);
            userList.add(user);

            System.out.println(userId + ", " + userName + ", " + password + ", " + createDateTime + ", " + createdBy + ", " + lastUpdate + ", " + lastUpdatedBy);
        }
    }

    //constructor
    public User(int user_ID, String user_Name, String password, LocalDateTime create_Date, String created_By, LocalDateTime last_Update, String last_Updated_By) {
        User_ID = user_ID;
        User_Name = user_Name;
        Password = password;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;

        System.out.println("Creating new user: " + user_ID + ", " + User_Name);
    }

    //getters and setters
    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    public static ObservableList<User> getUserList() {
        return userList;
    }
}
