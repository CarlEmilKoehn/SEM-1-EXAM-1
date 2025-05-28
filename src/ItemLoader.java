import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class ItemLoader {


    ArrayList<Item> loadFile(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            ArrayList<Item> items = new ArrayList<>();
            sc.nextLine(); //skip header

            String[] values;

            while (sc.hasNextLine()) {
                values = sc.nextLine().split(",");
                values[0] = values[0].trim();
                values[1] = values[1].trim();

                Item item = new Item(values[0], parseBoolean(values[1]));
                items.add(item);
            }
            return items;
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
            return null;
        }
    }
}