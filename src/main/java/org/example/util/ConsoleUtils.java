package org.example.util;

public class ConsoleUtils {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void showLoadingSpinner(String message, int durationMillis) {
        String[] spinner = {"|", "/", "-", "\\"};
        long startTime = System.currentTimeMillis();
        int i = 0;

        System.out.print(message + " ");

        while (System.currentTimeMillis() - startTime < durationMillis) {
            System.out.print("\r" + message + " " + spinner[i++ % spinner.length]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("\r" + message + " Done!");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBanner(String message, int delayMillisPerChar) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delayMillisPerChar);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // Move to next line
    }
}
