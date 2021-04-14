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
 * This class is used to create (first-level) Divisions in the program.
 * It corresponds with the first_level_divisions table.
 * @author Will Lapinski
 */
public class Division {
    //fields
    private int Division_ID;
    private String Division;
    private LocalDateTime Create_Date;
    private String Created_By;
    private LocalDateTime Last_Update;
    private String Last_Updated_By;
    private int Country_ID;
    private static ObservableList<Division> divisionList = FXCollections.observableArrayList();

    //constructor
    public Division(int division_ID, String division, LocalDateTime create_Date, String created_By, LocalDateTime last_Update, String last_Updated_By, int country_ID) {
        Division_ID = division_ID;
        Division = division;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
        Country_ID = country_ID;
    }

    /**
     * This method is used to instantiate one Division object for each record in the divisions table.
     * @author Will Lapinski
     */
    public static void pullDivisions() throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement
        String selectStatement = "SELECT * FROM first_level_divisions";
        statement.execute(selectStatement);
        ResultSet rs = statement.getResultSet();

        //forward scroll through Divisions
        while (rs.next()) {
            int divisionId = rs.getInt("Division_ID");
            String divisionName = rs.getString("Division");
            LocalDateTime createDate = rs.getTimestamp("Create_Date").toLocalDateTime();
            String createdBy = rs.getString("Created_By");
            LocalDateTime lastUpdate = rs.getTimestamp("Last_Update").toLocalDateTime();
            String lastUpdatedBy = rs.getString("Last_Updated_By");
            int countryId = rs.getInt("Country_ID");

            //for each record, instantiate a new Division object
            Division division = new Division (divisionId, divisionName, createDate, createdBy, lastUpdate, lastUpdatedBy, countryId);
            divisionList.add(division);

            //print records
            System.out.println(divisionId + ", " + divisionName + "...");

        }
    }

    //getters and setters
    public int getDivision_ID() {
        return Division_ID;
    }

    public void setDivision_ID(int division_ID) {
        Division_ID = division_ID;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
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

    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

    public static ObservableList<Division> getDivisionList() {
        return divisionList;
    }

    public static Division lookupDivisionByName(String divisionName) {
        for (int i = 0; i < getDivisionList().size(); i++) {
            if (getDivisionList().get(i).getDivision().equals(divisionName)) {
                return divisionList.get(i);
            }
        }
        return null;
    }
    public static Division lookupDivisionById(int divisionId) {
        for (int i = 0; i < getDivisionList().size(); i++) {
            if (getDivisionList().get(i).getDivision_ID() == divisionId) {
                return divisionList.get(i);
            }
        }
        return null;
    }


}
