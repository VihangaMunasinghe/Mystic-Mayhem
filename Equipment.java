class Equipment {
    private String name;
    private int price;
    private int attack;
    private int defense;
    private int health;
    private int speed;

    public Equipment(String name) {
        this.name = name;
        if (name.equals("Chainmail")) {
            this.price = 70;
            this.attack = 0;
            this.defense = 1;
            this.health = 0;
            this.speed = -1;
        } 
        else if (name.equals("Excalibur")) {
            this.price = 150;
            this.attack = 2;
            this.defense = 0;
            this.health = 0;
            this.speed = 0;
        }
        else if (name.equals("Regalia")) {
            this.price = 105;
            this.attack = 0;
            this.defense = 1;
            this.health = 0;
            this.speed = 0;
        }
        else if (name.equals("Amulet")) {
            this.price = 200;
            this.attack = 1;
            this.defense = -1;
            this.health = 1;
            this.speed = 1;
        }
        else if (name.equals("Fleece")) {
            this.price = 150;
            this.attack = 0;
            this.defense = 2;
            this.health = 1;
            this.speed = -1;
        }
        else if (name.equals("Crystal")) {
            this.price = 210;
            this.attack = 2;
            this.defense = 1;
            this.health = -1;
            this.speed = -1;
        }
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
