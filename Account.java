import java.util.Scanner;
public class Account {
    private static int noOfPlayers = 0;
    public static Player createAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Create New Account ---");
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the username: ");
        String userName = scanner.nextLine();

        //Should check whether the username is taken. If taken ask the user to enter a different one
        if(true){
            int userId = noOfPlayers++;
            Player player = new Player();

            return player;
        }
        return null;
    }

    public static Player logIn(){
        return new Player();
    }
}
