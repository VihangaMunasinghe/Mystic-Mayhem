import java.util.List;

public abstract class HomeGround {
    private final String name;
    protected HomeGround(String name){
        this.name = name;
    }

    public abstract void updateArmy(List<Character> army);
    public String getName() {
        return name;
    }
}
