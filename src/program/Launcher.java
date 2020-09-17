package program;

import storage.Storage;

public class Launcher {

    public static void main(String[] args) {
        FileIO fl = new FileIO();

        fl.readFile("list");

        fl.writeFile("newList", Storage.items);
    }
}
