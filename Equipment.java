public class Equipment {
    private String name;
    private int price;
    private int attack;
    private int defense;
    private int health;
    private int speed;

    public Equipment(String name, int price, int attack, int defense, int health, int speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }
}
