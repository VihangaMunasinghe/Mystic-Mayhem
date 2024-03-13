import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Player implements Serializable,Cloneable{
    private int userId;
    private String name;
    private String userName;
    private int xp;
    private int goldCoins;
    private HomeGround homeground;

    private List<Character> army = new ArrayList<>();

    public Player(){

    }
    public Player(int userId, String name, String userName, int xp, int goldCoins, List<Character> army) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.xp = xp;
        this.goldCoins = goldCoins;
        this.army = army;
    }

    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
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

    public void showArmy() {
        System.out.println("Your army: ");

        if(!army.isEmpty()){

            for (int i = 0; i < army.size(); i++) {
                System.out.print(i+1 + ". ");
                army.get(i).showBasicDetails();
            }
        }
        else{
            System.out.println("Your army is empty! Buy characters to build a army and battle!");
        }

    }
    public void showArmyMenu(){
        System.out.println("Enter 0 to go back");
        System.out.println("Enter your choice");
        System.out.print("Choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if(option == 0) return;
        if (option <= army.size()) {
            army.get(option-1).showDetails();
            System.out.println("1. Sell Character.");
            System.out.println("2. Buy Armour");
            System.out.println("2. Buy Artefact");
            System.out.println("Press 0 to go back");
            System.out.print("Choice: ");

            int option2 = scanner.nextInt();

            switch (option2) {
                case 1:
                    Character character = army.get(option - 1);
                    System.out.println("Are you sure you want to sell " + character.getName() + "? \n Y:Yes\nN:No");
                    String confirmOption = scanner.nextLine();
                    if (confirmOption.equals("Y")) {
                        sellCharacter(character);
                    }
                    break;
                case 2:
                    army.get(option).buyArmours(this);
                    break;
                case 3:
                    army.get(option).buyArtefacts(this);
                    break;
            }
        }
    }
    public HomeGround getHomeground() {
        return homeground;
    }

    public void setHomeground(HomeGround homeground) {
        this.homeground = homeground;
    }

    public void buyCharacter(){
        Store store = Store.getInstance();
        Character newCharacter = store.showCharacters();
        boolean flag = true;

        for(Character currentCharacter : army){
            if(currentCharacter.getType().equals(newCharacter.getType())){
                if(currentCharacter.getName().equals(newCharacter.getName())){
                    System.out.println("Already Taken");
                }
                else {
                    if (newCharacter.getCurrentValue() < this.getGoldCoins()){
                        sellCharacter(currentCharacter);
                        army.add(newCharacter);
                        flag = false;
                        updateGoldCoins(-newCharacter.getCurrentValue());
                    }
                    else{
                        System.out.println("Insufficient gold coins to buy this character.");
                    }
                }
            }
        }

        if(flag){
            army.add(newCharacter);
            updateGoldCoins(-newCharacter.getCurrentValue());
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
                    return;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input! Please enter a integer value.");
            }
        }

    }

    public void declareWar(Player opponent){

    }
    public Player searchForWar(){
        return new Player();
    }

    public void saveNewUser(){
        Database.saveNewUser(this);
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