import java.util.Scanner;
public class Store {
    Scanner scanner = new Scanner(System.in);

    private static Store instance; //instance variable

    public Store(){
        System.out.println("Welcome to the store");
        String userInput;

        while(true) {
            System.out.println("Enter 1 to view characters");
            System.out.println("Enter 2 to see Artefacts");
            System.out.println("Enter 3 to see Armour");
            userInput = scanner.nextLine();
            if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) {
                break;
            } else {
                System.out.println("Please enter a valid input");
            }
        }

        //show the characters
        if(userInput.equals("1")){
            showCharacters();
        }

        //show the Artefacts
        else if (userInput.equals("2")) {
            showArtefacts();
        }

        //show the Armour
        else {
            showArmour();
        }


    }


    public static Store getInstance(){
        //checking is the instance is null abd creating if needed
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }

    public void showCharacters(){
        System.out.println("Please Enter A Number");
        String userInputCharacter;

        while(true) {
            System.out.println("1 - Archers");
            System.out.println("2 - Knights");
            System.out.println("3 - Mages");
            System.out.println("4 - Healers");
            System.out.println("5 - Mythical Creatures");
            userInputCharacter = scanner.nextLine();
            if (userInputCharacter.equals("1") || userInputCharacter.equals("2") || userInputCharacter.equals("3") || userInputCharacter.equals("4") || userInputCharacter.equals("5")) {
                break;
            }
            else {
                System.out.println("Please enter a valid input");
            }
        }
        //shows the archers
        switch (userInputCharacter) {
            case "1" -> {
                System.out.println("    " + "Shooter");
                System.out.println("Price:  80 gc");
                System.out.println("Attack: 11");
                System.out.println("Defence: 4");
                System.out.println("Health:  6");
                System.out.println("Speed:   9\n");

                System.out.println("    " + "Ranger");
                System.out.println("Price:  115 gc");
                System.out.println("Attack: 14");
                System.out.println("Defence: 5");
                System.out.println("Health:  8");
                System.out.println("Speed:   10\n");

                System.out.println("    " + "Sunfire");
                System.out.println("Price:  160 gc");
                System.out.println("Attack: 15");
                System.out.println("Defence: 5");
                System.out.println("Health:  7");
                System.out.println("Speed:   14\n");

                System.out.println("    " + "Saggitarius");
                System.out.println("Price:  230 gc");
                System.out.println("Attack: 18");
                System.out.println("Defence: 7");
                System.out.println("Health:  12");
                System.out.println("Speed:   17\n");

                System.out.println("    " + "Zing");
                System.out.println("Price:  200 gc");
                System.out.println("Attack: 16");
                System.out.println("Defence: 9");
                System.out.println("Health:  11");
                System.out.println("Speed:   14\n");
            }

            //shows the Knights
            case "2" -> {
                System.out.println("    " + "Squire");
                System.out.println("Price:  85 gc");
                System.out.println("Attack: 8");
                System.out.println("Defence: 9");
                System.out.println("Health:  7");
                System.out.println("Speed:   8\n");

                System.out.println("    " + "Cavalier");
                System.out.println("Price:  110 gc");
                System.out.println("Attack: 10");
                System.out.println("Defence: 12");
                System.out.println("Health:  7");
                System.out.println("Speed:   10\n");

                System.out.println("    " + "Templar");
                System.out.println("Price:  155 gc");
                System.out.println("Attack: 14");
                System.out.println("Defence: 16");
                System.out.println("Health:  12");
                System.out.println("Speed:   12\n");

                System.out.println("    " + "Zoro");
                System.out.println("Price:  180 gc");
                System.out.println("Attack: 17");
                System.out.println("Defence: 16");
                System.out.println("Health:  13");
                System.out.println("Speed:   14\n");

                System.out.println("    " + "Swiftblade");
                System.out.println("Price:  250 gc");
                System.out.println("Attack: 18");
                System.out.println("Defence: 20");
                System.out.println("Health:  17");
                System.out.println("Speed:   13\n");
            }

            //shows the Mages
            case "3" -> {
                System.out.println("    " + "Warlock");
                System.out.println("Price:  100 gc");
                System.out.println("Attack: 12");
                System.out.println("Defence: 7");
                System.out.println("Health:  10");
                System.out.println("Speed:   12\n");

                System.out.println("    " + "Illusionist");
                System.out.println("Price:  120 gc");
                System.out.println("Attack: 13");
                System.out.println("Defence: 8");
                System.out.println("Health:  12");
                System.out.println("Speed:   14\n");

                System.out.println("    " + "Enchanter");
                System.out.println("Price:  160 gc");
                System.out.println("Attack: 16");
                System.out.println("Defence: 10");
                System.out.println("Health:  13");
                System.out.println("Speed:   16\n");

                System.out.println("    " + "Conjurer");
                System.out.println("Price:  195 gc");
                System.out.println("Attack: 18");
                System.out.println("Defence: 15");
                System.out.println("Health:  14");
                System.out.println("Speed:   12\n");

                System.out.println("    " + "Eldritch");
                System.out.println("Price:  270 gc");
                System.out.println("Attack: 19");
                System.out.println("Defence: 17");
                System.out.println("Health:  18");
                System.out.println("Speed:   14\n");
            }

            //shows the Healers
            case "4" -> {
                System.out.println("    " + "Soother");
                System.out.println("Price:  95 gc");
                System.out.println("Attack: 10");
                System.out.println("Defence: 8");
                System.out.println("Health:  9");
                System.out.println("Speed:   6\n");

                System.out.println("    " + "Medic");
                System.out.println("Price:  125 gc");
                System.out.println("Attack: 12");
                System.out.println("Defence: 9");
                System.out.println("Health:  10");
                System.out.println("Speed:   7\n");

                System.out.println("    " + "Alchemist");
                System.out.println("Price:  150 gc");
                System.out.println("Attack: 13");
                System.out.println("Defence: 13");
                System.out.println("Health:  13");
                System.out.println("Speed:   13\n");

                System.out.println("    " + "Saint");
                System.out.println("Price:  200 gc");
                System.out.println("Attack: 16");
                System.out.println("Defence: 14");
                System.out.println("Health:  17");
                System.out.println("Speed:   9\n");

                System.out.println("    " + "Lightbringer");
                System.out.println("Price:  260 gc");
                System.out.println("Attack: 17");
                System.out.println("Defence: 15");
                System.out.println("Health:  19");
                System.out.println("Speed:   12\n");
            }

            //shows the Mythical Creatures
            default -> {
                System.out.println("    " + "Dragon");
                System.out.println("Price:  120 gc");
                System.out.println("Attack: 12");
                System.out.println("Defence: 14");
                System.out.println("Health:  15");
                System.out.println("Speed:   8\n");

                System.out.println("    " + "Basilisk");
                System.out.println("Price:  165 gc");
                System.out.println("Attack: 15");
                System.out.println("Defence: 11");
                System.out.println("Health:  10");
                System.out.println("Speed:   12\n");

                System.out.println("    " + "Hydra");
                System.out.println("Price:  205 gc");
                System.out.println("Attack: 12");
                System.out.println("Defence: 16");
                System.out.println("Health:  15");
                System.out.println("Speed:   11\n");

                System.out.println("    " + "Phoenix");
                System.out.println("Price:  275 gc");
                System.out.println("Attack: 17");
                System.out.println("Defence: 13");
                System.out.println("Health:  17");
                System.out.println("Speed:   19\n");

                System.out.println("    " + "Pegasus");
                System.out.println("Price:  340 gc");
                System.out.println("Attack: 14");
                System.out.println("Defence: 18");
                System.out.println("Health:  20");
                System.out.println("Speed:   20\n");
            }
        }


    }

    public void showArmour(){
        System.out.println("    " + "Chainmail");
        System.out.println("Price:  70 gc");
        System.out.println("Attack: no change");
        System.out.println("Defence: +1");
        System.out.println("Health:  no change");
        System.out.println("Speed:   -1\n");

        System.out.println("    " + "Regalia");
        System.out.println("Price:  105 gc");
        System.out.println("Attack: no change");
        System.out.println("Defence: +1");
        System.out.println("Health:  no change");
        System.out.println("Speed:   no change\n");

        System.out.println("    " + "Fleece");
        System.out.println("Price:  150 gc");
        System.out.println("Attack: no change");
        System.out.println("Defence: +2");
        System.out.println("Health:  +1");
        System.out.println("Speed:   -1\n");
    }

    public void showArtefacts(){
        System.out.println("    " + "Excalibur");
        System.out.println("Price:  150 gc");
        System.out.println("Attack: +2");
        System.out.println("Defence: no change");
        System.out.println("Health:  no change");
        System.out.println("Speed:   no change\n");

        System.out.println("    " + "Amulet");
        System.out.println("Price:  200 gc");
        System.out.println("Attack: +1");
        System.out.println("Defence: -1");
        System.out.println("Health:  +1");
        System.out.println("Speed:   +1\n");

        System.out.println("    " + "Crystal");
        System.out.println("Price:  210 gc");
        System.out.println("Attack: +2");
        System.out.println("Defence: +1");
        System.out.println("Health:  -1");
        System.out.println("Speed:   -1\n");

    }
}
