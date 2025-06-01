import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class ItemLoader {


    public ArrayList<Item> loadFile(String path) {

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

    public void saveFile(String path, ArrayList<Item> items, String header) {

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(header + "\n");
            for (Item item : items) {
                writer.write(item.toStringCSV() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("problem: " + e.getMessage());
        }
    }
}