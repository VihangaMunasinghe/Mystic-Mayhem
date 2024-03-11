import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Combat {
    private final Player player1, player2;
    private Player player1Copy;
    private Player player2Copy;
    private final HomeGround homeGround;
    private Character player1Attacker = null, player1Defender = null, player2Attacker = null, player2Defender = null;
    private final Map<String, Integer> attackPriorityOrder = new HashMap<>() {{
        put("Healer", 1);
        put("Mage", 2);
        put("Mythical Creature", 3);
        put("Knight", 4);
        put("Archer", 5);
    }};
    private final Map<String, Integer> defendPriorityOrder = new HashMap<String, Integer>(){{
        put("Mage", 1);
        put("Knight", 2);
        put("Archer", 3);
        put("Mythical Creature", 4);
        put("Healer", 5);
    }};


    public Combat(Player player1, Player player2, HomeGround homeGround) {
        this.player1 = player1;
        this.player2 = player2;
        this.homeGround = homeGround;
        try {
            this.player1Copy = player1.clone();
            this.player2Copy = player2.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Player cloning failed!!!");
        }
        prepareArmy();
    }

    private void prepareArmy(){
        homeGround.updateArmy(player1Copy.getArmy());
        homeGround.updateArmy(player2Copy.getArmy());
    }

    public void fight(){
        System.out.println(player1.getName()+" vs "+player2.getName());
        for(int turn = 1; turn<=10; turn++) {
            if (player1Attacker == null) player1Attacker = getNextAttacker(player1Copy.getArmy());
            if (player1Defender == null) player1Defender = getNextDefender(player1Copy.getArmy());
            if (player2Attacker == null) player2Attacker = getNextAttacker(player2Copy.getArmy());
            if (player2Defender == null) player2Defender = getNextDefender(player2Copy.getArmy());

            if(player1Copy.getArmy().isEmpty() || player2Copy.getArmy().isEmpty()) break;

            //// Player1's turn
            System.out.println("Turn "+turn+": "+player1.getName());
            if(attack(player1, player1Attacker, player2Defender, 1)){
                player2Copy.getArmy().remove(player2Defender);
                if(player2Attacker == player2Defender) player2Attacker = null;
                player2Defender = null;
            }
            if(Objects.equals(homeGround.getName(), "Hillcrest") && Objects.equals(player1Attacker.getCategory(), "Highlander")){
                if (player2Attacker == null) player2Attacker = getNextAttacker(player2Copy.getArmy());
                if (player2Defender == null) player2Defender = getNextDefender(player2Copy.getArmy());

                if(attack(player1, player1Attacker, player2Defender, 0.2f)){
                    player2Copy.getArmy().remove(player2Defender);
                    if(player2Attacker == player2Defender) player2Attacker = null;
                    player2Defender = null;
                }
            } else if (Objects.equals(homeGround.getName(), "Arcane") && Objects.equals(player1Attacker.getCategory(), "Mystics")) {
                float healthChange = 0.1f * player1Attacker.getHealth();
                player1Attacker.changeHealth(healthChange);
            }

            //// Player2's turn
            System.out.println("Turn "+turn+": "+player2.getName());
            if(attack(player2,player2Attacker, player1Defender, 1)){
                player1Copy.getArmy().remove(player1Defender);
                if(player1Attacker == player1Defender) player1Attacker = null;
                player1Defender = null;
            }
            if(Objects.equals(homeGround.getName(), "Hillcrest") && Objects.equals(player1Attacker.getCategory(), "Highlander")){
                if (player1Attacker == null) player1Attacker = getNextAttacker(player1Copy.getArmy());
                if (player1Defender == null) player1Defender = getNextDefender(player1Copy.getArmy());

                if(attack(player2,player2Attacker, player1Defender, 0.2f)){
                    player1Copy.getArmy().remove(player1Defender);
                    if(player1Attacker == player1Defender) player1Attacker = null;
                    player1Defender = null;
                }
            } else if (Objects.equals(homeGround.getName(), "Arcane") && Objects.equals(player1Attacker.getCategory(), "Mystics")) {
                float healthChange = 0.1f * player2Attacker.getHealth();
                player2Attacker.changeHealth(healthChange);
            }
        }

        if(player1Copy.getArmy().isEmpty()){
            System.out.println(player2.getName()+" Won!");
            int goldCoinExchange = (int) (player1.getGoldCoins()*0.1f);
            player2.updateXp(1);
            player2.updateGoldCoins(goldCoinExchange);
            player1.updateGoldCoins(-goldCoinExchange);

        }else if(player2Copy.getArmy().isEmpty()) {
            System.out.println(player1.getName()+" Won!");
            int goldCoinExchange = (int) (player2.getGoldCoins()*0.1f);
            player1.updateXp(1);
            player1.updateGoldCoins(goldCoinExchange);
            player2.updateGoldCoins(-goldCoinExchange);
        }
        else{
            System.out.println("Draw");
        }
        System.out.println(player1.getName()+" XP: "+player1.getXp()+" GoldCoins: "+player1.getGoldCoins());
        System.out.println(player2.getName()+" XP: "+player2.getXp()+" GoldCoins: "+player2.getGoldCoins());
    }

    private boolean attack(Player attckingPlayer, Character attacker, Character defender, float attackPower){
        System.out.println(attacker.getName()+" attacks "+defender.getName());

        if(attacker.getType().equals("Healer")){
            //If the attacker is a Healer, increase the health of the character in his own army with the lowest heath by 10% of the attack value of the healer.
            getLowestHealthCharacter(attckingPlayer.getArmy()).changeHealth(0.1f*attacker.getAttack());
        }
        else{
            float damage = (attackPower*0.5f*attacker.getAttack() - 0.1f* defender.getDefence());
            defender.changeHealth(-damage);
        }

        System.out.println(defender.getName()+"'s Health: "+defender.getHealth());
        System.out.println(attacker.getName()+"'s Health: "+attacker.getHealth());
        if(defender.getHealth()==0){
            System.out.println(defender.getName()+" died!");
            return true;
        }
        else return false;
    }

    private Character getNextAttacker(List<Character> army){
        Character nextAttacker = army.getFirst();
        for(Character character: army){
            if(character.getSpeed() > nextAttacker.getSpeed()) nextAttacker = character;
            else if (character.getSpeed() == nextAttacker.getSpeed()) {
                if(attackPriorityOrder.get(character.getType()) > attackPriorityOrder.get(nextAttacker.getType())) nextAttacker = character;
            }
        }
        return nextAttacker;
    }

    private Character getNextDefender(List<Character> army){
        Character nextDefender = army.getFirst();
        for(Character character: army){
            if(character.getDefence() < nextDefender.getSpeed()) nextDefender = character;
            else if (character.getDefence() == nextDefender.getDefence()) {
                if(defendPriorityOrder.get(character.getType()) > defendPriorityOrder.get(nextDefender.getType())) nextDefender = character;
            }
        }
        return nextDefender;
    }
    private Character getLowestHealthCharacter(List<Character> army){
        Character lowestHealthCharacter = army.getFirst();
        for (Character character: army){
            if(lowestHealthCharacter.getHealth() > character.getHealth()){
                lowestHealthCharacter = character;
            }
        }
        return lowestHealthCharacter;
    }
}
