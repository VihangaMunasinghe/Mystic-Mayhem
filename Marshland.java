import java.util.List;

public class Marshland extends HomeGround{
    private static Marshland instance = null;
    private Marshland(){
        super("Marshland");
    }

    public static Marshland getInstance() {
        if(instance == null){
            instance = new Marshland();
        }
        return instance;
    }

    @Override
    public void updateArmy(List<Character> army) {
        for(Character character : army){
            switch (character.getCategory()) {
                case "Marshlander" :
                    character.changeDefence(2);
                    break;
                case "Sunchildren" :
                    character.changeAttack(-1);
                    break;
                case "Mystics" :
                    character.changeSpeed(-1);
                    break;
            }
        }
    }
}
