package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private Connection conn;
    public static final String MYSQL_LOCAL = "jdbc:mysql://localhost:3306/test?" +
            "user=root&password=Crosshatch3&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public DBConnector() {
        try {
            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl == null){
                dbUrl = MYSQL_LOCAL;
            }

            this.conn = DriverManager.getConnection(dbUrl);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public Connection getConn() {
        return this.conn;
    }


}
