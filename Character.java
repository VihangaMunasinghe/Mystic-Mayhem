import javax.lang.model.element.Name;

class Character implements Cloneable{
    private final String name;
    private final String type;
    private final String category;
    private final int price;
    private final int currentValue;
    private int attack;
    private int defence;
    private float health;
    private int speed;
    private Equipment currentArmour;
    private Equipment currentArtefact;

    public Character(String name, String type, String category, int price,
                     int attack, int defence, int health, int speed, Equipment currentArmour,
                     Equipment currentArtefact) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.price = price;
        this.currentValue = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
        this.currentArmour=currentArmour;
        this.currentArtefact=currentArtefact;
    }

    public void buyArmours(Player currentPlayer) {
        Store store = Store.getInstance();
        Equipment newArmour = store.showArmour();
        if(newArmour==currentArmour){
            System.out.println("Already Taken");
        }
        else{
            int armorPrice = newArmour.getPrice();
            int goldCoins = currentPlayer.getGoldCoins();
            if (goldCoins >= armorPrice) {
                currentPlayer.updateGoldCoins(-armorPrice);
                updateCharacter(currentArmour,newArmour);
                currentArmour = newArmour;
                System.out.println(name + " purchased armor for " + armorPrice + " gold coins.");
            }
            else
            {
                System.out.println("Insufficient gold coins to buy armor.");
            }
        }}

    public void buyArtefacts(Player currentPlayer) {
        Store store = Store.getInstance();
        Equipment newArtefact = store.showArmour();
        if(newArtefact==currentArtefact){
            System.out.println("Already Taken");
        }
        else{
            int artefactPrice = newArtefact.getPrice();
            int goldCoins = currentPlayer.getGoldCoins();
            if (goldCoins >= artefactPrice) {
                currentPlayer.updateGoldCoins(-artefactPrice);
                updateCharacter(currentArtefact,newArtefact);
                currentArtefact = newArtefact;
                System.out.println(name + " purchased artefact for " + artefactPrice + " gold coins.");
            }
            else
            {
                System.out.println("Insufficient gold coins to buy armour.");
            }
        }
    }
    private void updateCharacter(Equipment currentEquipment, Equipment newEquipment) {
        if (currentEquipment != null) {
            changeAttack(-currentEquipment.getAttack());
            changeSpeed(-currentEquipment.getSpeed());
            changeHealth(-currentEquipment.getHealth());
            changeDefence(-currentEquipment.getDefence());
        }
        changeAttack(newEquipment.getAttack());
        changeSpeed(newEquipment.getSpeed());
        changeHealth(newEquipment.getHealth());
        changeDefence(newEquipment.getDefence());
    }
    public void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Category: " + category);
        System.out.println("Speed: " + speed);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defence: " + defence);
        System.out.println("Price: " + price);
    }
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

    public int getDefence() {
        return defence;
    }

    public float getHealth() {
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
        this.defence +=amount;
    }
    public void changeHealth(float amount){
        this.health+=amount;
        if(health<0f){
            health = 0f;
        }
    }

    public Character clone() throws CloneNotSupportedException {
        return (Character) super.clone();
    }
}