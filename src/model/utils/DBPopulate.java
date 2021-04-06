package model.utils;

public class DBPopulate {

    //script to run
    public static String script = "-- \n" +
            "-- THIS SCRIPT ONLY FOR STUDENTS IN THE LATEST VERSION OF THE ASSESSMENT\n" +
            "-- (Start course on/after 9-15-2020 - PLease check with CI if unsure)\n" +
            "-- This script should be run in the MySql Workbench\n" +
            "-- It will reset the data to insert the countries and first level divisions\n" +
            "-- that you should use in the project\n" +
            "-- NOTE: This Script removes EVERYTHING because of the necessary FK dependencies\n" +
            "-- \n" +
            "-- questions mark.kinkead@wgu.edu\n" +
            "-- \n" +
            "\n" +
            "DELETE FROM appointments WHERE Appointment_ID < 10000;\n" +
            "DELETE FROM customers WHERE Customer_ID < 10000;\n" +
            "DELETE FROM first_level_divisions where Division_ID < 10000;\n" +
            "DELETE FROM countries where Country_ID < 10000;\n" +
            "DELETE FROM users WHERE User_ID < 10000;\n" +
            "DELETE FROM contacts where Contact_ID < 10000;\n" +
            "\n" +
            "-- users\n" +
            "\n" +
            "INSERT INTO users VALUES(1, 'test', 'test', NOW(), 'script', NOW(), 'script');\n" +
            "INSERT INTO users VALUES(2, 'admin', 'admin', NOW(), 'script', NOW(), 'script');\n" +
            "\n" +
            "-- contacts\n" +
            "\n" +
            "INSERT INTO contacts VALUES(1,\t'Anika Costa', 'acoasta@company.com');\n" +
            "INSERT INTO contacts VALUES(2,\t'Daniel Garcia',\t'dgarcia@company.com');\n" +
            "INSERT INTO contacts VALUES(3,\t'Li Lee',\t'llee@company.com');\n" +
            "\n" +
            "-- Counties\n" +
            "\n" +
            "INSERT INTO countries VALUES(1,\t'U.S',\tNOW(), 'script', NOW(), 'script');\n" +
            "INSERT INTO countries VALUES(2,\t'UK',\tNOW(), 'script', NOW(), 'script');\n" +
            "INSERT INTO countries VALUES(3,\t'Canada',\tNOW(), 'script', NOW(), 'script');\n" +
            "\n" +
            "-- First Level Divisions\n" +
            "\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Alabama', 1, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Alaska', 54, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Arizona', 02, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Arkansas', 03, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('California', 04, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Colorado', 05, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Connecticut', 06, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Delaware', 07, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('District of Columbia', 08, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Florida', 09, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Georgia', 10, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Hawaii', 52, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Idaho', 11, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Illinois', 12, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Indiana', 13, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Iowa', 14, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Kansas', 15, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Kentucky', 16, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Louisiana', 17, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Maine', 18, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Maryland', 19, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Massachusetts', 20, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Michigan', 21, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Minnesota', 22, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Mississippi', 23, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Missouri', 24, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Montana', 25, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Nebraska', 26, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Nevada', 27, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('New Hampshire', 28, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('New Jersey', 29, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('New Mexico', 30, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('New York', 31, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('North Carolina', 32, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('North Dakota', 33, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Ohio', 34, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Oklahoma', 35, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Oregon', 36, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Pennsylvania', 37, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Rhode Island', 38, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('South Carolina', 39, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('South Dakota', 40, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Tennessee', 41, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Texas', 42, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Utah', 43, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Vermont', 44, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Virginia', 45, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Washington', 46, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('West Virginia', 47, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Wisconsin', 48, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Wyoming', 49, NOW(), 'script', NOW(), 'script', 1 );\n" +
            "\n" +
            "\n" +
            "\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Alberta', 61, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('British Columbia', 62, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Manitoba', 63, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('New Brunswick', 64, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Newfoundland and Labrador', 72, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Northwest Territories', 60, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Nova Scotia', 65, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Nunavut', 70, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Ontario', 67, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Prince Edward Island', 66, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Québec', 68, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Saskatchewan', 69, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Yukon', 71, NOW(), 'script', NOW(), 'script', 3 );\n" +
            "\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('England', 101, NOW(), 'script', NOW(), 'script', 2 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Wales', 102, NOW(), 'script', NOW(), 'script', 2 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Scotland',103, NOW(), 'script', NOW(), 'script', 2 );\n" +
            "INSERT INTO first_level_divisions(Division, Division_ID, Create_Date, Created_By, Last_Update, Last_Updated_By, COUNTRY_ID) VALUES('Northern Ireland', 104, NOW(), 'script', NOW(), 'script', 2 );\n" +
            "\n" +
            "-- Customers\n" +
            "\n" +
            "INSERT INTO customers VALUES(1, 'Daddy Warbucks', '1919 Boardwalk', '01291', '869-908-1875', NOW(), 'script', NOW(), 'script', 29);\n" +
            "INSERT INTO customers VALUES(2, 'Lady McAnderson', '2 Wonder Way', 'AF19B', '11-445-910-2135', NOW(), 'script', NOW(), 'script', 103);\n" +
            "INSERT INTO customers VALUES(3, 'Dudley Do-Right', '48 Horse Manor ', '28198', '874-916-2671', NOW(), 'script', NOW(), 'script', 60);\n" +
            "\n" +
            "-- Appointments\n" +
            "\n" +
            "INSERT INTO appointments VALUES(1, 'title', 'description', 'location', 'Planning Session', '2020-05-28 12:00:00', '2020-05-28 13:00:00', NOW(), 'script', NOW(), 'script', 1, 1, 3);\n" +
            "INSERT INTO appointments VALUES(2, 'title', 'description', 'location', 'De-Briefing', '2020-05-29 12:00:00', '2020-05-29 13:00:00', NOW(), 'script', NOW(), 'script', 2, 2, 2);\n";

    public static String getScript() {
        return script;
    }
}
