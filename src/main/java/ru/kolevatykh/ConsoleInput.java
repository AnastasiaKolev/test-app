package ru.kolevatykh;

import lombok.Data;

import java.util.Scanner;

@Data
public class ConsoleInput {

    private static Scanner consoleInput = new Scanner(System.in);

    public static String getConsoleInput() {
        return consoleInput.nextLine();
    }

    public static void close() {
        consoleInput.close();
    }
}
