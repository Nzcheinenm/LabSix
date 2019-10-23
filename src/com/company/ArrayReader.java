package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayReader {
    public ArrayList<String> list = new ArrayList<>();
    public String str;

    public void getReadToFile() {
        try (Scanner scan = new Scanner(new File("book.txt"))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addString () throws NothingRepeat {

        Scanner scanIn = new Scanner(System.in);
        System.out.println("Введите Фамилию и номер через пробел: ");
        str = scanIn.nextLine();
        list.add(str);

    }

    public void validationString () throws NothingRepeat {

        String[] array = list.toArray(new String[0]);

        for (int i = 0; i < array.length - 1; i++) {
            if (str.equals(array[i])) {
                throw (new NothingRepeat());
            }
        }
    }

    public void recordToFile() {
        try {
            Files.write(Paths.get("book.txt"),list, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
