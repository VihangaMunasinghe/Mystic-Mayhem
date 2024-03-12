import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Player implements Serializable,Cloneable{
    private int userId;
    private String name;
    private String userName;
    private int xp;
    private int goldCoins;
    private static int noOfPlayers = 0;
    private HomeGround homeground;

    private List<Character> army;

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
        for (int i = 0; i < army.size(); i++) {
            System.out.print(i + ". ");
            army.get(i).showBasicDetails();
        }
        System.out.println("Press 0 to go back");
        System.out.println("\nSelect option: ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if (option != 0 && option < army.size()) {
            army.get(option).showDetails();
            System.out.println("5. Sell Character.");
            System.out.println("6. Buy Equipment");
            System.out.println("Press 0 to go back");

            int option2 = scanner.nextInt();

            switch (option2) {
                case 5:
                    sellCharacter(army.get(option));
                    break;
                case 6:
                    System.out.println("7. Buy Armour.");
                    System.out.println("8. Buy Artefact.");
                    System.out.println("Press 0 to go back");

                    int option3 = scanner.nextInt();
                    switch (option3) {
                        case 7:
                            army.get(option).buyArmours(this);
                            break;
                        case 8:
                            army.get(option).buyArtefacts(this);
                            break;
                        case 0:
                            break;
                    }
                    break;
            }
        }
        scanner.close();
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

        for(Character currentCharacter : army){
            if(currentCharacter.getType().equals(newCharacter.getType())){
                if(currentCharacter.getName().equals(newCharacter.getName())){
                    System.out.println("Already Taken");
                }
                else {
                    if (newCharacter.getCurrentValue() < this.getGoldCoins()){
                        sellCharacter(currentCharacter);
                        army.add(newCharacter);
                        updateGoldCoins(-newCharacter.getCurrentValue());
                    }
                    else{
                        System.out.println("Insufficient gold coins to buy this character.");
                    }
                }
            }
        }
    }

    public void sellCharacter(Character character){
        updateGoldCoins((int)(character.getCurrentValue() * 0.9));
        army.remove(character);
    }

    public void sellCharacter(){

    }

    public void declareWar(){

    }

    public void saveNewUser(){
        Database.saveNewUser(this);
    }
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }
}