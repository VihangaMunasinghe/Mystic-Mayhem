import java.util.List;
import java.util.Scanner;

public class Player implements Cloneable{
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

    public void createAccount(){

    }
    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public void setName(){

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

    public HomeGround getHomeground() {
        return homeground;
    }

    public void setHomeground(HomeGround homeground) {
        this.homeground = homeground;
    }

    public void buyCharacter(){

    }

    public void sellCharacter(){

    }

    public void declareWar(){

    }

    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }
}