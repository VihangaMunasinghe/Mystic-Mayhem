import java.util.List;

public class Hillcrest extends HomeGround{
    private static Hillcrest instance = null;
    private Hillcrest(){
        super("Hillcrest");
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
            switch (character.getCategory()) {
                case "Highlander" :
                    character.changeAttack(1);
                    character.changeDefence(1);
                    break;

                case "Marshlander", "Sunchildren" :
                    character.changeSpeed(-1);
                    break;
            }
        }
    }
}
