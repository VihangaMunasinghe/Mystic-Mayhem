import java.util.List;

public class Arcane extends HomeGround{
    private static Arcane instance = null;
    private Arcane(){
        super("Marshland");
    }

    public static Arcane getInstance() {
        if(instance == null){
            instance = new Arcane();
        }
        return instance;
    }

    @Override
    public void updateArmy(List<Character> army) {
        for(Character character : army){
            switch (character.getCategory()) {
                case "Mystic" :
                    character.changeAttack(2);
                    break;
                case "Highlander", "Marshlander" :
                    character.changeDefence(-1);
                    character.changeSpeed(-1);
                    break;
            }
        }
    }
}
