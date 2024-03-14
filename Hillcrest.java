import java.util.List;

public class Hillcrest extends HomeGround{
    private static Hillcrest instance = null;
    private Hillcrest(){
        super("Hillcrest", "In Hillcrest, the attack and defence of highlanders increase by 1 \n" +
                                            "while the speed of marshlanders and sunchildren decrease by 1.\n" +
                                            "When attacking in Hillcrest, each highlander can follow each of their \n" +
                                            "turns with a bonus turn with 20% of their attack power.");
    }

    public static Hillcrest getInstance() {
        if(instance == null){
            instance = new Hillcrest();
        }
        return instance;
    }

    @Override
    public void updateArmy(List<Character> army) {
        for(Character character : army){
            if (character.getCategory().equals("Highlander")) {
                character.changeAttack(1);
                character.changeDefence(1);
            } else if (character.getCategory().equals("Marshlander") || character.getCategory().equals("Sunchildren")) {
                character.changeSpeed(-1);
            }
        }
    }
}
