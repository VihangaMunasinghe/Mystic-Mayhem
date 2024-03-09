import java.util.List;
import java.util.Scanner;

public class Player{
    private int userId;
    private String name;
    private String userName;
    private int xp;
    private int goldCoins;

    private HomeGround homeground;

    private List<Character> army;

    public Player(){

    }


    public Player(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.xp = 0;
        this.goldCoins = 500;
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name: ");
        name = scanner.nextLine();

        System.out.println("Enter the username: ");
        userName = scanner.nextLine();

        Player player = new Player(name,userName);

        scanner.close();
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

    public void updateXp(int num){
        xp = xp + num;
    }

    public int getGoldCoins(){
        return goldCoins;
    }

    public void updateGoldCoins(){

    }

    public void getArmy(){

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


}