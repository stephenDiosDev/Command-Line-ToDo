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
            } else if (input.contains("help")) {
                availableCommands();
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
        clearScreen();
        System.out.println("Welcome to S^3 Habit and To Do List Program!");
        availableCommands();
    }

    public void availableCommands() {
        System.out.println("Available Commands: (please keep one command per line!)");
        System.out.println("    Exit: Closes the program");
        System.out.println("    New List: Creates a new to do list");
        System.out.println("    Save listname: Saves the current to do list under with the name listname");
        System.out.println("    Help: Lists the available commands");
    }
}
