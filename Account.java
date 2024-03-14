import javax.xml.crypto.Data;
import java.util.Scanner;
public class Account {
    public static Player createAccount(){
        String userName,name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Create New Account ***");

        while(true) {
            System.out.print("Enter the name: ");
            name = scanner.nextLine();

            if(!name.equals(""))
                break;
            else
                System.out.println("Name cannot be empty");
        }


        while(true) {
            while(true) {
                System.out.print("Enter the username: ");
                userName = scanner.nextLine();

                if(!userName.equals(""))
                    break;
                else
                    System.out.println("Username cannot be empty");
            }
            if (Database.isUserNameAvailable(userName)) {
                int userId = Database.getNextUserId();
                Player player = new Player(userId, name, userName);
                player.saveNewUser();
                return player;
            }
            else {
                System.out.println("Username is not available. Enter new username.");
            }
        }
    }

    public static Player logIn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("***Login to your Account***");
        System.out.print("Enter the username: ");
        String userName = scanner.nextLine();
        return Database.getPlayer(userName);
    }
}