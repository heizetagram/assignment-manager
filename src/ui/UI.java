package ui;

import java.util.Scanner;

public class UI {
    private static Scanner scan = new Scanner(System.in);

    private UI() {
    }

    // Print
    public static void print(String text) {
        System.out.print(text);
    }

    // Println
    public static void println(String text) {
        System.out.println(text);
    }

    // Print formatted
    public static void printf(String text, Object... args) { // '...' accepts any number of arguments
        System.out.printf(text, args);
    }

    // Prompt string
    public static String promptString() {
        return scan.nextLine();
    }

    // Prompt int
    public static int promptInt() {
        return scan.nextInt();
    }
}
