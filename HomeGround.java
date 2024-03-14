import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public abstract class HomeGround implements Serializable {
    private final String name, description;
    protected HomeGround(String name, String description){
        this.name = name;
        this.description = description;
    }

    public static HomeGround showHomeGrounds(){
        System.out.println("\n**Home Grounds** (Choose an option)");
        System.out.print("1. "); Hillcrest.getInstance().showDetails();
        System.out.print("2. "); Marshland.getInstance().showDetails();
        System.out.print("3. "); Desert.getInstance().showDetails();
        System.out.print("4. "); Arcane.getInstance().showDetails();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = 0;
            try{
                System.out.print("Choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception ex){
                System.out.println("Invalid Input. Enter a integer from 1 to 4.");
                continue;
            }
            if (choice == 1) {
                return Hillcrest.getInstance();
            } else if (choice == 2) {
                return Marshland.getInstance();
            } else if (choice == 3) {
                return Desert.getInstance();
            } else if (choice == 4) {
                return Arcane.getInstance();
            } else {
                System.out.println("Invalid Input. Enter a correct input.");
            }
        }

    }
    public abstract void updateArmy(List<Character> army);
    public String getName() {
        return name;
    }

    public void showDetails() {
        System.out.println("Name: "+name);
        System.out.println("Description: \n"+description);
    }
}
