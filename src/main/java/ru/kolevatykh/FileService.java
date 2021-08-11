package ru.kolevatykh;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {

    public static void readFile(String fileName) {
        List<Object> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String str;
            while ((str = br.readLine()) != null && !str.isEmpty()) {
                String[] strArr = str.split(" ");

                Arrays.stream(strArr)
                        .filter(NumberUtils::isCreatable)
                        .forEach(s -> {
                            if (s.contains(".") || s.contains(",")) {
                                Double d = Double.parseDouble(s);
                                list.add(d);
                                System.out.println(d);
                            } else {
                                Integer i = Integer.parseInt(s);
                                list.add(i);
                                System.out.println(i);
                            }
                        });
            }
        } catch (FileNotFoundException e) {
            System.out.println("test.txt does not exist.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
