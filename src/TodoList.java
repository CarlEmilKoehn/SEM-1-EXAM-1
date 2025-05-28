import java.util.ArrayList;

public class TodoList {

    private ArrayList<Item> items;


    public TodoList(ArrayList<Item> items) {
        this.items = items;
    }

    void displayItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}