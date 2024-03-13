import javax.xml.crypto.Data;
import java.util.Scanner;
public class Account {
    public static Player createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Create New Account ***");
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the username: ");
        String userName = scanner.nextLine();
        if(Database.isUserNameAvailable(userName)){
            int userId = Database.getNextUserId();
            Player player = new Player(userId, name, userName);
            player.saveNewUser();
            return player;
        }
        return null;
    }

    public static Player logIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("***Login to your Account***");
        System.out.print("Enter the username: ");
        String userName = scanner.nextLine();
        return Database.getPlayer(userName);
    }
}
