package program;

import items.*;
import storage.Storage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileIO {
    private ArrayList<GenericItem> items;

    public FileIO() {
        items = new ArrayList<GenericItem>();
    }

    // read in file "name" and parse its contents into this.items
    public void readFile(String name) {
        // using code taken from: https://www.tutorialspoint.com/java/java_files_io.htm
        File file = new File("lists\\" + name + ".txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String temp;
            while ((temp = reader.readLine()) != null) {
                // System.out.println(temp);

                // switch statement to create and add new items
                if (temp.contains("type:")) { // first line of item
                    switch (temp) {
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
                            String itemName3 = reader.readLine();
                            itemName3 = itemName3.substring(itemName3.indexOf(":") + 1);
                            String status3 = reader.readLine();
                            status3 = status3.substring(status3.indexOf(":") + 1);
                            String desc3 = reader.readLine();
                            desc3 = desc3.substring(desc3.indexOf(":") + 1);
                            String date3 = reader.readLine();
                            date3 = date3.substring(date3.indexOf(":") + 1);
                            LocalDate due3 = LocalDate.parse(date3);
                            addItemToList(new DeadlineItem(itemName3, Boolean.parseBoolean(status3), desc3, due3));
                            break;
                        case "type:4":
                            String itemName4 = reader.readLine();
                            itemName4 = itemName4.substring(itemName4.indexOf(":") + 1);
                            String status4 = reader.readLine();
                            status4 = status4.substring(status4.indexOf(":") + 1);
                            String desc4 = reader.readLine();
                            desc4 = desc4.substring(desc4.indexOf(":") + 1);
                            String recurring = reader.readLine();
                            recurring = recurring.substring(recurring.indexOf(":") + 1);
                            int recurInt = Integer.parseInt(recurring);
                            addItemToList(new HabitItem(itemName4, Boolean.parseBoolean(status4), desc4, recurInt));
                            break;
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("IO Exception!");
        }

        // add items from fileIO to storage class
        for (GenericItem i : items) {
            // System.out.println(i.toString());
            Storage.items.add(i);
        }

        // debug
        /*
         * for (GenericItem e: Storage.items) { System.out.println(e.toString()); }
         */
    }

    // write given list of items to file "name"
    public void writeFile(String name, ArrayList<GenericItem> items) {
        // following: https://www.w3schools.com/java/java_files_create.asp
        try {
            FileWriter writer = new FileWriter(name + ".txt");

            for (GenericItem i : items) {
                if (i instanceof WorkItem) {
                    WorkItem j = (WorkItem) i;
                    writer.write("type:" + j.type + "\n");
                    writer.write("name:" + j.getName() + "\n");
                    writer.write("status:" + j.isCompleted() + "\n");
                    writer.write("desc:" + j.getDescription() + "\n");
                    writer.write("\n");
                } else if (i instanceof DeadlineItem) {
                    DeadlineItem j = (DeadlineItem) i;
                    writer.write("type:" + j.type + "\n");
                    writer.write("name:" + j.getName() + "\n");
                    writer.write("status:" + j.isCompleted() + "\n");
                    writer.write("desc:" + j.getDescription() + "\n");
                    writer.write("due:" + j.getDeadline().toString() + "\n");
                    writer.write("\n");
                } else if (i instanceof HabitItem) {
                    HabitItem j = (HabitItem) i;
                    writer.write("type:" + j.type + "\n");
                    writer.write("name:" + j.getName() + "\n");
                    writer.write("status:" + j.isCompleted() + "\n");
                    writer.write("desc:" + j.getDescription() + "\n");
                    writer.write("repeat:" + j.getSpaceBetweenDays() + "\n");
                    writer.write("\n");
                } else {
                    writer.write("type:" + i.type + "\n");
                    writer.write("name:" + i.getName() + "\n");
                    writer.write("status:" + i.isCompleted() + "\n");
                    writer.write("\n");
                }

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addItemToList(GenericItem newItem) {
        items.add(newItem);
    }
}
