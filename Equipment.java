import java.io.Serializable;

public class Equipment implements Cloneable, Serializable {
    private final String name;
    private final String type;
    private final int price;
    private final int attack;
    private final int defence;
    private final int health;
    private final int speed;

    public Equipment(String name, String type, int price, int attack, int defense, int health, int speed) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.attack = attack;
        this.defence = defense;
        this.health = health;
        this.speed = speed;
    }
    public void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Speed Change: " + (speed > 0 ? "+"+speed : speed));
        System.out.println("Health Change: " + (health > 0 ? "+"+health : health));
        System.out.println("Attack Change: " + (attack > 0 ? "+"+attack : attack));
        System.out.println("Defence Change: " + (defence > 0 ? "+"+defence : defence));
        System.out.println("Price: " + price);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public Equipment clone() throws CloneNotSupportedException {
        return (Equipment) super.clone();
    }
}
