package ru.kolevatykh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CommandLineService {

    private static ExecutorService executorService;

    static void readCommandLine() {
        System.out.println("*** Welcome to console input ECHO emulator ***"
                + "\nType \"exit\" to close the application.");
        String command = "";

        while (!"exit".equals(command)) {
            executorService = Executors.newSingleThreadExecutor();
            command = ConsoleInput.getConsoleInput();
            try {
                TaskExecutor taskExecutor = new TaskExecutor(command);
                Future future = executorService.submit(taskExecutor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }

        ConsoleInput.close();
        System.exit(1);
    }
}
