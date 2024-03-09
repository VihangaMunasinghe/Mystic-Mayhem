import java.util.List;

public abstract class HomeGround {
    protected String name;
    protected HomeGround(String name){
        this.name = name;
    }

    public abstract void updateArmy(List<Character> army);
}
