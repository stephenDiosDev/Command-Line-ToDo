package program;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

import items.GenericItem;
import storage.Storage;

//contains the actual program logic, takes inputs from ProgramGUI and sends strings as outputs
public class LogicDriver {
    private FileIO fileIO;

    public LogicDriver() {
        fileIO = new FileIO();
    }

    public ArrayList<String> lists() {
        // taken from:
        // https://stackoverflow.com/questions/1384947/java-find-txt-files-in-specified-folder
        ArrayList<String> filenameList = new ArrayList<String>();
        File directory = new File("lists");
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                // add filename without .txt
                filenameList.add(file.getName().substring(0, file.getName().indexOf(".txt")));
            }
        }
        return filenameList;
    }

    // new file gets created in saveList, this function is basically user assurance
    // fluff
    public void newList() {
        System.out.println("\nNew list created! Start adding items\n");
        Storage.items.clear(); // empty previous items
    }

    // save whats in storage into file given a file name
    public void saveList(String filename) {
        System.out.println("\nSaving file named: " + filename + "\n");

        // use the file IO class
        fileIO.writeFile("lists\\" + filename, Storage.items);
        System.out.println("[List saved successfully]");
        Storage.items.clear();
    }

    // load items from filename into storage
    public void loadList(String filename) {
        System.out.println("\nLoading list named: " + filename + "\n");
        fileIO.readFile(filename);
        System.out.println("[List loaded successfully]");
    }

    public void removeList(String filename) {
        System.out.println("\nRemoving list named: " + filename + "\n");
        // taken from: https://www.geeksforgeeks.org/delete-file-using-java/
        File file = new File("src\\lists\\" + filename + ".txt");
        if (file.delete()) {
            System.out.println("[List deleted successfully]");
        } else {
            System.out.println("[Unable to delete list]");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void newGenericItem(String name) {
        System.out.println("Creating new basic item with name: " + name + "\n");
        GenericItem temp = new GenericItem(name, false);
        Storage.items.add(temp);
        System.out.println("[Successfully created basic item and added to current list]");
    }

    public void newDeadlineItem(String name, String desc, String date) {
        System.out.println(
                "CREATING NEW DEADLINE ITEM WITH NAME: " + name + "\nAND DESC: " + desc + "\nAND DATE: " + date + "\n");
    }

    public void newHabitItem(String name, String desc, int recurring) {
        System.out.println("CREATING NEW HABIT ITEM WITH NAME: " + name + "\nAND DESC: " + desc + "\nAND RECURRING: "
                + recurring + "\n");
    }

    public void newWorkItem(String name, String desc) {
        System.out.println("CREATING NEW WORK ITEM WITH NAME: " + name + "\nAND DESC: " + desc + "\n");
    }

    // given an item name, load from storage, edit changes and store new version in
    // storage
    public void editItem(String name) {
        System.out.println("EDITING ITEM WITH NAME: " + name + "\n");
    }

    // given item name, remove it from storage
    public void removeItem(String name) {
        System.out.println("REMOVING ITEM WITH NAME: " + name + "\n");
    }

    // given item name, check the status to true
    public void completeItem(String name) {
        System.out.println("COMPLETING ITEM WITH NAME: " + name + "\n");
    }

    // given item name, uncheck the status to false
    public void revertItem(String name) {
        System.out.println("REVERTING ITEM WITH NAME: " + name + "\n");
    }

    public void infoItem(String name) {
        System.out.println("GIVING INFO ON ITEM WITH NAME: " + name + "\n");
    }

    // given item name, check storage to ensure there is no other item with the same
    // name
    private void duplicateNameCheck(String name) {

    }
}
