package program;
import items.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileIO {
    /* TODO
    function1: given a file name, find it and read it into arraylist. Store that list in the static storage class
        if the files dne, throw exception/error
    function2: given file name and arraylist, open (or create) file, write contents of list to that file
     */

    private ArrayList<GenericItem> items;

    public FileIO() {
        items = new ArrayList<GenericItem>();
    }

    //read in file "name" and parse its contents into this.items
    public void readFile(String name) {
        //using code taken from: https://www.tutorialspoint.com/java/java_files_io.htm
        File file = new File("src\\lists\\" + name + ".txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String temp;
            while((temp = reader.readLine()) != null) {
                //System.out.println(temp);

                //switch statement to create and add new items
                if(temp.contains("type:")) {    //first line of item
                    switch(temp) {
                        case "type:1":
                            String itemName1 = reader.readLine();
                            itemName1 = itemName1.substring(itemName1.indexOf(":") + 1);
                            String status1 = reader.readLine();
                            status1 = status1.substring(status1.indexOf(":") + 1);
                            addItemToList(new GenericItem(itemName1, Boolean.parseBoolean(status1)));
                            break;
                        case "type:2":
                            String itemName2 = reader.readLine();
                            itemName2 = itemName2.substring(itemName2.indexOf(":") + 1);
                            String status2 = reader.readLine();
                            status2 = status2.substring(status2.indexOf(":") + 1);
                            String desc2 = reader.readLine();
                            desc2 = desc2.substring(desc2.indexOf(":") + 1);
                            addItemToList(new WorkItem(itemName2, Boolean.parseBoolean(status2), desc2));
                            break;
                        case "type:3":
                            //System.out.println("Found type 3");
                            break;
                        case "type:4":
                            //System.out.println("Found type 4");
                            break;
                    }
                }
            }

        } catch (FileNotFoundException e){
            System.out.println("File not found!");
        } catch (IOException e){
            System.out.println("IO Exception!");
        }

        for (GenericItem i:
             items) {
            System.out.println(i.toString());
        }
    }

    //write given list of items to file "name"
    public void writeFile(String name, ArrayList<GenericItem> items) {

    }

    private void addItemToList(GenericItem newItem) {
        items.add(newItem);
    }
}
