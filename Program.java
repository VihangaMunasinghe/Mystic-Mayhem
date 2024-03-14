import java.util.Scanner;

public class Program {
    private static Player currentPlayer = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        while (true){
            if(currentPlayer == null){
                createOrLoadPlayer();
                if(currentPlayer != null){
                    currentPlayer.showDetails();
                }
            }
            if(currentPlayer != null){
                showPlayerMenu();
            }
        }
    }

    private static void createOrLoadPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n****************************************");
        System.out.println("********Welcome to Mystic Mayhem********");
        System.out.println("****************************************\n");
        System.out.println("Choose an option");
        System.out.println("1. Create an Account\n2. Use an Existing Account");
        while (true) {
            int choice = 0;
            try{
                System.out.print("Choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception ex) {
                System.out.println("Invalid Input. Enter a correct input.");
            }
            if (choice == 1) {
                currentPlayer = Account.createAccount();
                break;
            } else if (choice == 2) {
                currentPlayer = Account.logIn();
                break;
            } else {
                System.out.println("Invalid Input. Enter a integer from 1 to 2.");
            }
        }
    }

    private static void showPlayerMenu(){
        System.out.println("\n** Menu ** (Choose an option)");
        System.out.println("1. Show my Details\n2. Show my army\n3. Buy a Character\n4. Sell a Character\n5. Search for a War\n6. Show my HomeGround\n7. Change the HomeGround\n8. Change name\n9. Log out");
        while (true) {
            int choice = 0;
            try{
                System.out.print("Choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception ex){
                System.out.println("Invalid Input. Enter a integer from 1 to 8.");
                continue;
            }
            if (choice == 1) {
                currentPlayer.showDetails();
                break;
            } else if (choice == 2) {
                if(currentPlayer.showArmy()){
                    currentPlayer.showArmyMenu();
                }
                break;
            } else if (choice == 3) {
                currentPlayer.buyCharacter();
                break;
            } else if (choice == 4) {
                currentPlayer.sellCharacter();
                break;
            } else if (choice == 5) {
                Player opponent = currentPlayer.searchOpponentForWar();
                if (opponent != null) {
                    currentPlayer.declareWar(opponent);
                }
                break;
            } else if (choice == 6) {
                currentPlayer.showHomeGround();
                break;
            }else if (choice == 7) {
                currentPlayer.setHomeGround(HomeGround.showHomeGrounds());
                break;
            } else if (choice == 8) {
                currentPlayer.changeName();
                break;
            }else if (choice == 9) {
                currentPlayer = null;
                break;
            } else {
                System.out.println("Invalid Input. Enter a correct input.");
            }
        }
    }
}