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
 * This class is used to create Countries in the program.
 * It corresponds with the countries table.
 * @author Will Lapinski
 */
public class Country {
    //fields
    private int Country_ID;
    private String Country;
    private LocalDateTime Create_Date;
    private String Created_By;
    private LocalDateTime Last_Update;
    private String Last_Updated_By;
    private static ObservableList<Country> countryList = FXCollections.observableArrayList();

    //constructor
    public Country(int country_ID, String country, LocalDateTime create_Date, String created_By, LocalDateTime last_Update, String last_Updated_By) {
        Country_ID = country_ID;
        Country = country;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By = last_Updated_By;
    }

    /**
     * This method is used to instantiate one Country object for each record in the countries table.
     * @author Will Lapinski
     */
    public static void pullCountries() throws SQLException {
        Connection connection = DBConnection.getConnection();
        DBQuery.setStatement(connection); //create Statement
        Statement statement = DBQuery.getStatement(); //get Statement
        String selectStatement = "SELECT * FROM countries";
        statement.execute(selectStatement);
        ResultSet rs = statement.getResultSet();

        //forward scroll through Countries
        while(rs.next()) {
            int countryId = rs.getInt("Country_ID");
            String countryName = rs.getString("Country");
            LocalDateTime createDate = rs.getTimestamp("Create_Date").toLocalDateTime();
            String createdBy = rs.getString("Created_By");
            LocalDateTime lastUpdateDateTime = rs.getTimestamp("Last_Update").toLocalDateTime();
            String lastUpdatedBy = rs.getString("Last_Updated_By");

            //for each record, instantiate a new Country object
            Country country = new Country (countryId, countryName, createDate, createdBy, lastUpdateDateTime, lastUpdatedBy);
            countryList.add(country);

            //print records
            System.out.println(countryId + ", " + countryName + ", " + createDate + ", " + createdBy + ", " + lastUpdateDateTime + ", " + lastUpdatedBy); //FIXME - It's wooorking!

        }
    }


    //getters and setters
    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
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

    public static ObservableList<Country> getCountryList() {
        return countryList;
    }

    public static Country lookupCountryByName(String countryName) {
        for (int i = 0; i < getCountryList().size(); i++) {
            if (getCountryList().get(i).getCountry().equals(countryName)) {
                return countryList.get(i);
            }
        }
        return null;
    }
    public static Country lookupCountryById(int countryId) {
        for (int i = 0; i < getCountryList().size(); i++) {
            if (getCountryList().get(i).getCountry_ID() == countryId) {
                return countryList.get(i);
            }
        }
        return null;
    }

    /**
     * @author Will Lapinski
     * @param country the given country
     * @return a list of all Divisions associated with the given Country
     * @throws SQLException
     */
    public static ObservableList<Division> getDivisions(Country country) throws SQLException {
        ObservableList<Division> divisionList = FXCollections.observableArrayList();

        //loop through the master Division list. If it belongs to the specified country, add it to our divisionList.
        for (int i = 0; i < Division.getDivisionList().size(); i++) {
            if (Division.getDivisionList().get(i).getCountry_ID() == country.getCountry_ID()) {
                divisionList.add(Division.getDivisionList().get(i));
            }
        }
        return divisionList;
    }

    public static ObservableList<String> getDivisionNames(Country country) throws SQLException {
        ObservableList<String> divisionList = FXCollections.observableArrayList();

        //loop through the master Division list. If it belongs to the specified country, add it to our divisionList.
        for (int i = 0; i < Division.getDivisionList().size(); i++) {
            if (Division.getDivisionList().get(i).getCountry_ID() == country.getCountry_ID()) {
                divisionList.add(Division.getDivisionList().get(i).getDivision());
            }
        }
        return divisionList;
    }

}
