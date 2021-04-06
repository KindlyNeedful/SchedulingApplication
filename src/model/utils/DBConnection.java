package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class will be used to setup the JDBC URL and connect to the JDBC interfaces.
 * @author Will Lapinski
 */
public class DBConnection {
    //JDBC URL
    private static String protocol = "jdbc";
    private static String vendorName = "mysql"; //need to inject colons between these sections
    private static String path = "wgudb.ucertify.com:3306"; //FIXME - added port number
    private static String dbName = "WJ07Vkg";
    //completed url: jdbc:mysql://wgudb.ucertify.com:3306/WJ07Vkg
    private static String jdbcUrl = protocol + ":" + vendorName + "://" + path + "/" + dbName;

    //Driver and Connection interface reference
    private static String mysqlJdbcDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection0 = null;   //FIXME - I think Malcolm made this public? Connecting-to-the-db 47:00ish

    //database credentials
    private static String username = "U07Vkg";
    private static String password = "53689141207";
    private static String badPassword = "badPassword";

    /**
     * This method is used to initiate a connection to the database.
     */
    public static Connection initConnection() { //FIXME - Malcolm renamed this to from initConnection to getConnection.
        try {
            Class.forName(mysqlJdbcDriver);
            connection0 = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection established.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection0;
    }

    /**
     * This method is used to close the connection to the database.
     */
    public static void closeConnection() {
        try {
            connection0.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This statement is used to retrieve the connection.
     * @return connection0 the connection
     */
    public static Connection getConnection() {
        return connection0;
    }



}
