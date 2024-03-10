import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Store2 {
    private static Store2 instance; //instance variable
    public static Store2 getInstance(){
        //checking is the instance is null abd creating if needed
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }

    List<Character> archers = new ArrayList<>();
    List<Character> knights = new ArrayList<>();
    List<Character> mages = new ArrayList<>();
    List<Character> healers = new ArrayList<>();
    List<Character> mythicalCreatures = new ArrayList<>();

    public void setArchers() {
        Character shooter = new Character("shooter","archer",null,80,11,4,6,9,null,null);
        Character ranger = new Character("ranger","archer",null,115,14,5,8,10,null,null);
        Character sunfire = new Character("sunfire","archer",null,160,15,5,7,14,null,null);
        Character zing = new Character("zing","archer",null,200,16,9,11,14,null,null);
        Character saggitarius = new Character("saggitarius","archer",null,230,18,7,12,17,null,null);
        archers.add(shooter);
        archers.add(ranger);
        archers.add(sunfire);
        archers.add(zing);
        archers.add(saggitarius);
    }
    public void setKnights(){
        Character squire = new Character("squire","knight",null,85,8,9,7,8,null,null);
        Character cavalier = new Character("cavalier","knight",null,110,10,12,7,10,null,null);
        Character templar = new Character("templar","knight",null,155,14,16,12,12,null,null);
        Character zoro = new Character("squire","knight",null,85,8,9,7,8,null,null);
        Character squire = new Character("squire","knight",null,85,8,9,7,8,null,null);

    }

}
