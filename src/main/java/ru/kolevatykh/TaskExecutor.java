package ru.kolevatykh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskExecutor implements Runnable {

    private String input;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(input);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
