import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private ArrayList<Item> items;

    public TodoList(ArrayList<Item> items) {
        this.items = items;
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println((items.indexOf(item) + 1) + ": " + item);
        }
    }

    public void runDialog() {
        boolean exitDialog = false;
        Scanner sc = new Scanner(System.in);
        int choice;

        String displayOptions = "1. Marker en opgave som 'done' \n" +
                "2. Tilføj en opgave \n" +
                "3. Afslut dialog";

        while (!exitDialog) {
            System.out.println();
            System.out.println(displayOptions);
            System.out.println("Vælg en mulighed (1-3)");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); //flush


                switch (choice) {
                    case 1:
                        displayItems();
                        System.out.println("Tast tallet du vil markere som 'done'");
                        if (sc.hasNextInt()) {
                            choice = sc.nextInt();
                            sc.nextLine(); //flush

                            if (choice > 0 && choice <= items.size()) {
                                items.get(choice - 1).setDone(true);
                                Main.itemLoader.saveFile("data/todo.csv", items, "Description, Done");
                            } else {
                                System.out.println("Ugyldigt nummer, prøv igen");
                            }

                        } else {
                            System.out.println("Indtast venligst et tal");
                            sc.nextLine();
                        }
                        break;

                    case 2:
                        String description;
                        System.out.println("Indtast en beskrivelse");
                        description = sc.nextLine();
                        items.add(new Item(description, false));
                        Main.itemLoader.saveFile("data/todo.csv", items, "Description, Done");
                        break;

                    case 3:
                        exitDialog = true;
                        System.exit(0);
                    default:
                        System.out.println("Ugyldigt input, prøv igen");
                }
            } else {
                System.out.println("Ugyldigt input, prøv igen");
                sc.nextLine(); //flush
            }
        }
    }
}