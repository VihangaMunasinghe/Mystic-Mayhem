import java.util.List;

public class Desert extends HomeGround{
    private static Desert instance = null;
    private Desert(){
        super("Marshland", "In Desert, the health of marshlanders decreases by 1 \n" +
                                            "while the attack of sunchildren increases by 1.");
    }

    public static Desert getInstance() {
        if(instance == null){
            instance = new Desert();
        }
        return instance;
    }

    @Override
    public void updateArmy(List<Character> army) {
        for(Character character : army){
            if (character.getCategory().equals("Marshlander")) {
                character.changeHealth(-1);
            } else if (character.getCategory().equals("Sunchildren")) {
                character.changeAttack(1);
            }
        }
    }
}
