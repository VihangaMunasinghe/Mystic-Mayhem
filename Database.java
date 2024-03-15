import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Database instance = null;
    private List<Player> players = new ArrayList<>();
    private static final String FILE_NAME = "Players.ser";

    private Database() {
    }

    public static synchronized void getInstance() {
        if (instance == null) {
            loadInstance();
            if(instance != null && instance.players.isEmpty()){
                Player defaultPlayer = Player.getDefaultPlayer();
                saveNewPlayer(defaultPlayer);
            }
        }
    }

    private static void loadInstance() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            instance = (Database) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading database: " + e.getMessage());
            instance = new Database();
        }
    }

    public static synchronized void saveNewPlayer(Player player) {
        getInstance();
        instance.players.add(player);
        saveInstance();
    }

    public static synchronized boolean isUserNameAvailable(String userName) {
        getInstance();
        return instance.players.stream().noneMatch(player -> userName.equals(player.getUserName()));
    }

    public static synchronized void updatePlayers() {
        getInstance();
        saveInstance();
    }

    public static synchronized Player getPlayer(String userName) {
        getInstance();
        return instance.players.stream()
                .filter(player -> userName.equals(player.getUserName()))
                .findFirst()
                .orElse(null);
    }

    private static void saveInstance() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(instance);
        } catch (IOException e) {
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    public static synchronized int getNextUserId() {
        getInstance();
        return instance.players.isEmpty() ? 1 : instance.players.getLast().getUserId() + 1;
    }

    public static synchronized Player getRandomPlayer(Player currentPlayer) {
        getInstance();
        Random random = new Random();
        int size = instance.players.size();
        int count = 0;
        while (true) {
            count++;
            if(count==100) {
                System.out.println("No Opponent Found!!");
                return null;
            }
            Player randomPlayer = instance.players.get(random.nextInt(size));
            if (!randomPlayer.equals(currentPlayer) && randomPlayer.getHomeGround() != null && !(randomPlayer.getArmy().size()<5)) {
                return randomPlayer;
            }
        }
    }
}