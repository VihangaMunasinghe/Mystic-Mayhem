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
    private Equipment currentArmour;
    private Equipment currentArtefact;

    public Character(String name, String type, String category, int price,
                     int attack, int defense, int health, int speed,Equipment currentArmour,
                     Equipment currentArtefact) {
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

    public void buyArmours(Player currentPlayer) {
        Store store = new Store();
        Equipment newArmour =store.showArmour();
        if(newArmour==currentArmour){
            System.out.println("Already Taken");
        }
        else{
            int armorPrice = newArmour.getPrice();
            int goldCoins = currentPlayer.getGoldCoins();
            if (goldCoins >= armorPrice) {
                currentPlayer.updateGoldCoins(-armorPrice);
                currentArmour = newArmour;
                System.out.println(name + " purchased armor for " + armorPrice + " gold coins.");
            }
            else
            {
                System.out.println("Insufficient gold coins to buy armor.");
            }
        }}
    public void buyArtefacts(Player currentPlayer) {
        Store store = new Store();
        Equipment newArtefact =store.showArmour();
        if(newArtefact==currentArtefact){
            System.out.println("Already Taken");
        }
        else{
            int artefactPrice = newArtefact.getPrice();
            int goldCoins = currentPlayer.getGoldCoins();
            if (goldCoins >= artefactPrice) {
                currentPlayer.updateGoldCoins(-artefactPrice);
                currentArtefact = newArtefact;
                System.out.println(name + " purchased artefact for " + artefactPrice + " gold coins.");
            }
            else
            {
                System.out.println("Insufficient gold coins to buy armor.");
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

    public Equipment getCurrentArmour() {
        return currentArmour;
    }

    public Equipment getCurrentArtefact() {
        return currentArtefact;
    }
    public void changeSpeed(int amount){
       this.speed+=amount;
    }
    public void changeAttack(int amount){
        this.attack+=amount;
    }
    public void changeDefence(int amount){
        this.defense+=amount;
    }
    public void changeHealth(int amount){
        this.health+=amount;
    }
}




