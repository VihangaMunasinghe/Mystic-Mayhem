import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.SQLException;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class Database {
    public static boolean saveNewUser(Player user) {
        String url = "jdbc:mysql://localhost/mysticmayhem";
        String username = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO players (userId, userName, profile) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUserName());

            // Convert user object to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(user);
            oos.flush();
            byte[] userBytes = bos.toByteArray();

            // Set byte array to the prepared statement
            stmt.setBytes(3, userBytes);

            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Serialization failed!");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateUser(Player user) {
        String url = "jdbc:mysql://localhost/mysticmayhem";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "UPDATE players SET userName = ?, profile = ? WHERE userId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user.getUserName());

            // Convert user object to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(user);
            oos.flush();
            byte[] userBytes = bos.toByteArray();

            // Set byte array to the prepared statement
            stmt.setBytes(2, userBytes);
            stmt.setInt(3, user.getUserId());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Serialization failed!");
            e.printStackTrace();
        }
        return false;
    }


}



