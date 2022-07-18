import java.sql.*;

public class Jdbc {
    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";
    public static Connection CONNECTION;
    public static Statement STATMENT;
    public static ResultSet RS;
    public static void query(String query) {
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);

            STATMENT = CONNECTION.createStatement();

            RS = STATMENT.executeQuery(query);

            while (RS.next()) {
                int id = RS.getInt("id");
                String name = RS.getString("name");
                String specialty = RS.getString("specialty");
                double salary = RS.getDouble("salary");
                System.out.println("Info:");
                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("specialty: " + specialty);
                System.out.println("salary: " + salary);
            }
        } catch (SQLException e) {
            e.getErrorCode();
        } finally {
            try {
                CONNECTION.close();
            } catch (SQLException e) {
                e.getErrorCode();
            }
            try {
                STATMENT.close();
            } catch (SQLException e) {
                e.getErrorCode();
            }
            try {
                RS.close();
            } catch (SQLException e) {
                e.getErrorCode();
            }
        }
    }
}
