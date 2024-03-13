import java.sql.*;
import java.util.Scanner;
public class Account {
    private static int noOfPlayers = 0;
    public static Player createAccount() {
        String url = "jdbc:mysql://localhost/mysticmayhem";
        String username = "root";
        String password = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name: ");
        String name = scanner.nextLine();

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM userID WHERE userName=? ";

            boolean userNameAvailable = false;
            while(!userNameAvailable){
                System.out.println("Enter the username: ");
                String userName = scanner.nextLine();

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, userName);
                ResultSet result = stmt.executeQuery();

                if (!result.next()) {
                    userNameAvailable = true;
                    // Create the player account here
                    Player player = new Player(userName, name);
                    Database.saveNewUser(player);
                    return player;
                } else {
                    System.out.println("User name is already taken. Enter a new one.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        }
        return null;
    }

}
