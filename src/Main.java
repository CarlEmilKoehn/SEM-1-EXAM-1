import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ItemLoader itemLoader = new ItemLoader();

        ArrayList<Item> items = itemLoader.loadFile("doc/todo.csv");

        TodoList todoList = new TodoList(items);
        todoList.displayItems();
    }
}