package program;

import java.io.IOException;
import java.util.Scanner;

//uses the command line to display the gui, processes commands
public class ProgramGUI {
    private LogicDriver driver;

    public ProgramGUI() {
        driver = new LogicDriver();
        startUpScreen();
        main();
    }

    private void main() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!input.contains("exit")) { // exit is the escape word
            if (input.contains("clear")) {
                clearScreen();
            } else if (input.contains("help") && input.indexOf("help") == 0) {
                availableCommands();
            } else if (input.contains("new list") && input.indexOf("new list") == 0) {
                driver.newList();
            } else if (input.contains("save") && input.indexOf("save") == 0) {
                driver.saveList(input.substring(input.indexOf("save") + 4));
            } else if (input.contains("load") && input.indexOf("load") == 0) {
                driver.loadList(input.substring(input.indexOf("load") + 4));
            } else if (input.contains("remove list") && input.indexOf("remove list") == 0) {
                driver.removeList(input.substring(input.indexOf("remove list") + 11));
            } else if (input.contains("new generic") && input.indexOf("new generic") == 0) {
                driver.newGenericItem(input.substring(input.indexOf("new generic") + 11));
            } else if (input.contains("new deadline") && input.indexOf("new deadline") == 0) {
                String desc, date;
                System.out.println("Please enter the deadline date (yyyy-mm-dd)");
                date = in.nextLine();
                System.out.println("Please enter a short description");
                desc = in.nextLine();
                driver.newDeadlineItem(input.substring(input.indexOf("new deadline") + 12), desc, date);
            } else if (input.contains("new habit") && input.indexOf("new habit") == 0) {
                String desc;
                int days;
                System.out.println("Please enter the space between days (0 = everyday, 1 = every other day)");
                days = Integer.parseInt(in.nextLine());
                System.out.println("Please enter a short description");
                desc = in.nextLine();
                driver.newHabitItem(input.substring(input.indexOf("new habit") + 9), desc, days);
            } else if (input.contains("new work") && input.indexOf("new work") == 0) {
                String desc;
                System.out.println("Please enter a short description");
                desc = in.nextLine();
                driver.newWorkItem(input.substring(input.indexOf("new work") + 8), desc);
            } else if (input.contains("edit") && input.indexOf("edit") == 0) {
                driver.editItem(input.substring(input.indexOf("edit") + 4));
            } else if (input.contains("remove") && input.indexOf("remove") == 0) {
                driver.removeItem(input.substring(input.indexOf("remove") + 6));
            } else if (input.contains("complete") && input.indexOf("complete") == 0) {
                driver.completeItem(input.substring(input.indexOf("complete") + 8));
            } else if (input.contains("uncomplete") && input.indexOf("uncomplete") == 0) {
                driver.revertItem(input.substring(input.indexOf("uncomplete") + 10));
            } else {
                System.out.println("\nYour command \"" + input + "\" is not a recognized command!");
            }

            input = in.nextLine();
        }
        in.close();
    }

    private void clearScreen() {
        System.out.println("Clearing Screen");
        // code taken from here:
        // https://stackoverflow.com/questions/2979383/java-clear-the-console

        // the uncommented code should work (famous last words), but this is here in
        // case it one day doesn't
        /*
         * try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); }
         * catch (IOException e) {
         * 
         * } catch (InterruptedException e) {
         * 
         * }
         */

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void startUpScreen() {
        clearScreen();
        System.out.println("Welcome to the Habit and To Do List Program!\n");
        System.out.println("To see a list of every available command, type help\n");
    }

    public void availableCommands() {
        System.out.println("Available Commands: (please keep one command per line!)");
        System.out.println("    exit: Closes the program");
        System.out.println("    new list: Creates a new to do list");
        System.out.println("    save listname: Saves the current to do list with the name listname");
        System.out.println("    load listname: Loads the list named listname");
        System.out.println("    remove list listname: Deletes the list named listname");
        System.out.println(
                "    new generic itemname: Creates a new generic item named itemname, and adds it to the current list");
        System.out.println(
                "    new deadline itemname: Creates a new deadline item named itemname, and adds it to the current list");
        System.out.println(
                "    new habit itemname: Creates a new habit item named itemname, and adds it to the current list");
        System.out.println(
                "    new work itemname: Creates a new work item named itemname, and adds it to the current list");
        System.out.println("    edit itemname: Edits the item named itemname from the current list");
        System.out.println("    remove itemname: Deletes the item named itemname from the current list");
        System.out.println("    complete itemname: Checks the item named itemname as complete from the current list");
        System.out.println(
                "    uncomplete itemname: Unchecks the item named itemname as uncomplete from the current list");
        System.out.println("    help: Lists the available commands\n");
        System.out
                .println("    ********PLEASE ENTER COMMANDS IN ALL LOWER CASE (file names can use capitals)********\n");
    }
}