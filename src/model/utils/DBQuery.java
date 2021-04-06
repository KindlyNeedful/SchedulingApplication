package model.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class will be used to query the database.
 * @author Will Lapinski
 */
public class DBQuery {

    private static Statement statement;

    /**
     * This method creates our Statement.
     */
    public static void setStatement(Connection connection) throws SQLException {
        statement = connection.createStatement();
    }

    /**
     * This method retrieves our Statement.
     * @return statement
     */
    public static Statement getStatement() {
        return statement;
    }

}
