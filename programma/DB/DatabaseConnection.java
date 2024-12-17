package programma.DB;

import java.sql.*;

public class DatabaseConnection {
    static String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true";

    static Connection con = null;

    static Statement stmt = null;

    static ResultSet rs = null;

    public static void connect() throws ClassNotFoundException, SQLException {

        // 'Importeer' de driver die je gedownload hebt.
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Maak de verbinding met de database.
        con = DriverManager.getConnection(connectionUrl);
    }

    public static ResultSet execute(String query) {
        try {
            connect();

            // Stel een SQL query samen.

            stmt = con.createStatement();
            // Voer de query uit op de database.
            return rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rs != null)
                try {
                    //  rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    // stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    // con.close();
                } catch (Exception e) {
                }
        }
    }
    public static boolean executeQuery(String query) {
        try {
            connect();

            // Stel een SQL query samen.

            stmt = con.createStatement();
            // Voer de query uit op de database.
            return stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (rs != null)
                try {
                    //  rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    // stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    // con.close();
                } catch (Exception e) {
                }
        }
    }
}