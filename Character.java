class Character {
    private String name;
    private String type;
    private String category; 
    private int price;
    private int currentValue; 
    private int attack;
    private int defense;
    private int health;
    private int speed;
    private String currentArmour;
    private String currentArtefact;

    public Character(String name, String type, String category, int price,
                     int attack, int defense, int health, int speed,String currentArmour,
                     String currentArtefact) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.price = price;
        this.currentValue = price; 
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
        this.currentArmour=currentArmour;
        this.currentArtefact=currentArtefact;
    }

    public void buyArmours(String newArmour) {
        Store store = new Store();
        newArmour =store.showArmours();
        if(newArmour==currentArmour){
            System.out.println("Already Taken");
        }
        else{
            Equipment equipment =new Equipment(newArmour);
            int armorPrice = equipment.getPrice();
            if (currentValue >= armorPrice) {
                currentValue -= armorPrice;
                currentArmour = newArmour;
                System.out.println(name + " purchased armor for " + armorPrice + " gold coins.");
            }
            else
            {
                System.out.println("Insufficient gold coins to buy armor.");
            }
    }}
    public void buyArtefact(String newArtefact) {
        Store store = new Store();
        newArtefact=store.showArtefacts();
        if(newArtefact==currentArtefact){
            System.out.println("Already Taken");
        }
        else{
            Equipment equipment =new Equipment(newArtefact);
            int artefactsPrice = equipment.getPrice();
            if (currentValue >= artefactsPrice) {
                currentValue -= artefactsPrice;
                currentArtefact = newArtefact;
                System.out.println(name + " purchased artefacts for " + artefactsPrice + " gold coins.");
            }
            else
            {
                System.out.println("Insufficient gold coins to buy artefact.");
            }
    }}
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getCurrentValue() {
        return currentValue;
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

    public String getCurrentArmour() {
        return currentArmour;
    }

    public String getCurrentArtefact() {
        return currentArtefact;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeType(String type) {
        this.type = type;
    }

    public void changeCategory(String category) {
        this.category = category;
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public void changeCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void changeAttack(int attack) {
        this.attack = attack;
    }

    public void changeDefense(int defense) {
        this.defense = defense;
    }

    public void changeHealth(int health) {
        this.health = health;
    }

    public void changeSpeed(int speed) {
        this.speed = speed;
    }

    public void changeCurrentArmour(String currentArmour) {
        this.currentArmour = currentArmour;
    }

    public void changeCurrentArtefact(String currentArtefact) {
        this.currentArtefact = currentArtefact;
    }
}



