import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.SQLException;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class Database {
    public static boolean saveNewUser(Player user) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO players (userId, profile) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, user.getUserId());

            // Convert user object to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(user);
            oos.flush();
            byte[] userBytes = bos.toByteArray();

            // Set byte array to the prepared statement
            stmt.setBytes(2, userBytes);

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
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "UPDATE players SET profile = ? WHERE userId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Convert user object to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(user);
            oos.flush();
            byte[] userBytes = bos.toByteArray();

            // Set byte array to the prepared statement
            stmt.setBytes(1, userBytes);
            stmt.setInt(2, user.getUserId());

            stmt.executeUpdate();
            stmt.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
        } catch (IOException e) {
            System.out.println("Serialization failed!");
        }
        return false;
    }

    public static Player getRandomPlayer(Player currentPlayer){
        // Current player is used to check and ensure whether the returning player is not current player.
        return new Player();
    }
}



