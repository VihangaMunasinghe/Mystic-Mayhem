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

    public void showArmy(){
        System.out.println("Your army: ");
        System.out.println("1. Sell Character.");
        System.out.println("2. Buy armour.");
        System.out.println("3. Back.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select any option");
        String option = scanner.nextLine();


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