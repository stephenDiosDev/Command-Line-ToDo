package program;
import items.GenericItem;

import java.io.*;
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

    //write given list of items to file "name"
    private void writeFile(String name, ArrayList<GenericItem> items) {

    }

    //read in file "name" and parse its contents into this.items
    private void readFile(String name) {

    }
}
