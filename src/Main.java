import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Instantiate itemloader
        ItemLoader itemLoader = new ItemLoader();

        //Creating itemlist with ItemLoader.loadFile
        ArrayList<Item> items = itemLoader.loadFile("doc/todo.csv");

        //Instantiating TodoList with the item list as parameter and running the displayItems method
        TodoList todoList = new TodoList(items);
        todoList.displayItems();
    }
}