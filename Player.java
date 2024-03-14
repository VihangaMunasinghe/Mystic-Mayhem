import java.util.*;
import java.io.*;

public class Player implements Serializable,Cloneable{
    private int userId;
    private String name;
    private String userName;
    private int xp;
    private int goldCoins;
    private HomeGround homeGround;

    private List<Character> army = new ArrayList<>();

    public Player(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    public Player(){

    }

    public Player(int userId, String name, String userName) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.goldCoins = 500;
        this.xp = 1;
    }

    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public void changeName(){
        System.out.println("\n** Change Your Name **");
        while(true) {
            System.out.print("Enter the new Name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                this.name = name;
                updateUser();
                break;
            }
            else{
                System.out.print("Name cannot be empty.");
            }
        }
    }
    public String getUserName(){
        return userName;
    }

    public int getXp(){
        return xp;
    }

    public void updateXp(int x){
        xp = xp + x;
    }

    public int getGoldCoins(){
        return goldCoins;
    }

    public void updateGoldCoins(int x){
        goldCoins = goldCoins + x;
    }

    public List<Character> getArmy(){
        return army;
    }

    public boolean showArmy() {
        System.out.println("\nArmy: ");

        if(!army.isEmpty()){

            for (int i = 0; i < army.size(); i++) {
                System.out.print(i+1 + ". ");
                army.get(i).showBasicDetails();
            }
            return true;
        }
        System.out.println("Army is Empty!");
        return false;
    }
    public void showArmyMenu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 0 to go back");
        System.out.println("Enter your choice");
        while (true) {
            System.out.print("Choice: ");
            try{
                option = Integer.parseInt(scanner.nextLine());
                if (option == 0) {
                    return;
                } else if (option>0 && option <= army.size()) {
                    break;
                } else {
                    System.out.println("Invalid Input. Enter a correct input.");
                }
            }
            catch (Exception e){
                System.out.println("Invalid Input. Enter a integer.");
            }
        }
        army.get(option - 1).showDetails();
        System.out.println("1. Sell Character.");
        System.out.println("2. Buy Armour");
        System.out.println("3. Buy Artefact");
        System.out.println("Press 0 to go back");
        System.out.print("Choice: ");
        String option2;
        while (true) {
            option2 = scanner.nextLine();
            if(option2.equals("0")) return;
            else if (Objects.equals(option2, "1") || Objects.equals(option2, "2") || Objects.equals(option2, "3")) {
                switch (option2) {
                    case "1":
                        Character character = army.get(option - 1);
                        System.out.println("Are you sure you want to sell " + character.getName() + "? \n Y:Yes\nN:No");
                        while (true) {
                            System.out.print("Choice: ");
                            String confirmOption = scanner.nextLine();
                            if (confirmOption.equals("Y")) {
                                sellCharacter(character);
                                break;
                            } else if (confirmOption.equals("N")) {
                                break;
                            } else {
                                System.out.println("Invalid Input. Enter a correct input.");
                            }
                        }
                        break;
                    case "2":
                        army.get(option-1).buyArmours(this);
                        break;
                    case "3":
                        army.get(option-1).buyArtefacts(this);
                        break;
                    default:
                        System.out.println();
                }
                break;
            } else {
                System.out.println("Invalid Input. Enter a correct input.");
            }
        }
    }
    public HomeGround getHomeGround() {
        return homeGround;
    }
    public void showHomeGround(){
        System.out.println("Home Ground");
        if(homeGround != null){
            homeGround.showDetails();
        }
        else{
            System.out.println("No Home Ground Selected!");
        }
        System.out.println();
    }
    public void setHomeGround(HomeGround homeGround) {
        this.homeGround = homeGround;
    }

    public void buyCharacter(){
        Store store = Store.getInstance();
        Character newCharacter = store.showCharacters();
        if(newCharacter != null) {
            boolean flag = true;

            for (Character currentCharacter : army) {
                if (currentCharacter.getType().equals(newCharacter.getType())) {
                    if (currentCharacter.getName().equals(newCharacter.getName())) {
                        System.out.println("Already Taken");
                    } else {
                        if (newCharacter.getPrice() < this.getGoldCoins()) {
                            Scanner scanner = new Scanner(System.in);
                            System.out.println("Are you sure you want to sell " + currentCharacter.getName() + " and buy " + newCharacter.getName() + "? \nY:Yes\nN:No");
                            while (true) {
                                System.out.print("Choice: ");
                                String confirmOption = scanner.nextLine();
                                if (confirmOption.equals("Y")) {
                                    sellCharacter(currentCharacter);
                                    break;
                                } else if (confirmOption.equals("N")) {
                                    break;
                                } else {
                                    System.out.println("Invalid Input. Enter a correct input.");
                                }
                            }
                            army.add(newCharacter);
                            flag = false;
                            updateGoldCoins(-newCharacter.getCurrentValue());
                            updateUser();
                        } else {
                            System.out.println("Insufficient gold coins to buy this character.");
                            flag = false;
                        }
                    }
                }
            }

            if (flag) {
                if (newCharacter.getPrice() < this.getGoldCoins()) {
                    army.add(newCharacter);
                    updateGoldCoins(-newCharacter.getCurrentValue());
                    updateUser();
                } else {
                    System.out.println("Insufficient gold coins to buy this character.");
                }
            }
        }
    }

    public void sellCharacter(Character character){
        updateGoldCoins((int)(character.getCurrentValue() * 0.9));
        army.remove(character);
    }

    public void sellCharacter(){
        showArmy();
        System.out.println("Enter the index of the character you want to sell");
        System.out.println("Press 0 to go back");
        while(true) {
            System.out.print("Choice: ");
            Scanner scanner = new Scanner(System.in);
            try {
                int option = scanner.nextInt();
                if (option == 0) return;
                if (0 < option && option <= army.size()) {
                    Character character = army.get(option - 1);
                    System.out.println("Are you sure you want to sell " + character.getName() + "? \n Y:Yes\nN:No");
                    String confirmOption = scanner.nextLine();
                    if (confirmOption.equals("Y")) {
                        sellCharacter(character);
                    }
                    updateUser();
                    return;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a integer value.");
            }
        }

    }

    public void declareWar(Player opponent){
        Combat combat = new Combat(this, opponent, opponent.getHomeGround());
        combat.fight();
        this.updateUser(); /// This will save both players data in the file.
    }
    public Player searchOpponentForWar(){
        System.out.println("\nSearch an Opponent");
        while (true){
            Player player = Database.getRandomPlayer(this);
            if(player.army.size()<5) continue;
            player.showDetails();
            player.showArmy();
            System.out.println("Do you want to declare war with "+player.getName()+"?");
            System.out.println("1. Yes! Attack!!!!\n2. No, next player");
            System.out.println("Enter 0 to Stop Searching");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Choice: ");System.out.print("Choice: ");
                try {
                    int option = scanner.nextInt();
                    if(option == 0) return null;
                    if(option == 1){
                        this.declareWar(player);
                        return player;
                    }
                    else if(option == 2) break;
                    else System.out.println("Invalid input! Please enter 1 or 2.");

                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input! Please enter 1 or 2.");
                }
            }
        }
    }
    public void saveNewUser(){
        Database.saveNewPlayer(this);
    }
    public void updateUser(){
        Database.updatePlayers();
    }
    public void showDetails(){
        System.out.println("\n** Player Details **");
        System.out.println("Name: "+name);
        System.out.println("User Id:"+userId);
        System.out.println("Username: "+userName);
        System.out.println("XP: "+xp);
        System.out.println("Gold Coins: "+goldCoins);
    }
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }
}