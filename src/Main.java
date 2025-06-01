import java.util.ArrayList;

public class Main {

    //Instantiate itemloader
    static ItemLoader itemLoader = new ItemLoader();

    public static void main(String[] args) {


        //Creating itemlist with ItemLoader.loadFile
        ArrayList<Item> items = itemLoader.loadFile("data/todo.csv");

        //Instantiating TodoList with the item list as parameter and running the displayItems method
        TodoList todoList = new TodoList(items);
        todoList.displayItems();
        todoList.runDialog();

    }
}