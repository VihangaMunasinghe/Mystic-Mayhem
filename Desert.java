import java.util.List;

public class Desert extends HomeGround{
    private static Desert instance = null;
    private Desert(){
        super("Marshland");
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
            switch (character.getCategory()) {
                case "Marshlander" :
                    character.changeHealth(-1);
                    break;
                case "Sunchildren" :
                    character.changeAttack(1);
                    break;
            }
        }
    }
}
