package ru.kolevatykh;

public class App {

    public static void main(String[] args) {

        FileService.readFile(args[0]);

        CommandLineService.readCommandLine();
    }
}
