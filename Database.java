import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database implements Serializable {

    private static Database instance = null;
    private List<Player> players = new ArrayList<>();

    private static FileOutputStream fileOutputStream ;
    private static void createInstance(){

        if(instance == null){
            try {
                fileOutputStream = new FileOutputStream("Players.ser");
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
            try {
                FileInputStream fileInputStream = new FileInputStream("Players.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                instance = (Database) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                instance = new Database();
            }
        }
    }


    public static void saveNewPlayer(Player player){
        createInstance();
        instance.players.add(player);
        saveList();
    }
    public static boolean isUserNameAvailable(String userName){
        createInstance();
        if(!instance.players.isEmpty()) {
            for (Player player : instance.players) {
                if (userName.equals(player.getUserName())) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void updatePlayers(){
        createInstance();
        saveList();
    }
    public static Player getPlayer(String userName){
        createInstance();
        if(!instance.players.isEmpty()) {
            for (Player player : instance.players) {
                if (userName.equals(player.getUserName())) {
                    return player;
                }
            }
        }
        return null;
    }
    private static void saveList(){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(instance);
        } catch (IOException e) {
            System.out.println("File saving failed!");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Failed to close the Object output stream!");
            }
        }
    }
    public static int getNextUserId(){
        createInstance();
        if(!instance.players.isEmpty()) {
            return instance.players.getLast().getUserId() + 1;
        }
        return 1;
    }

    public static Player getRandomPlayer(Player currentPlayer){
        createInstance();
        int size = instance.players.size();
        Random random = new Random();
        while(true){
            Player randomPlayer = instance.players.get(random.nextInt(size));
            if(randomPlayer != currentPlayer){
                return randomPlayer;
            }
        }

    }
}



