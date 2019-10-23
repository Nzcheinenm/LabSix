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
    public ArrayList<String> name = new ArrayList<>();
    public ArrayList<String> phone = new ArrayList<>();
    public String str;
    public String str1;


    public void getReadToFile() { // Читаем файл и делим его на строки и сущности
        try (Scanner scan = new Scanner(new File("book.txt"))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
            String[] array = list.toArray(new String[0]);
            for (String str: array ) {
                String[] data = str.split(" ");
                if (data.length < 2)
                    continue;
                name.add(data[0]);
                phone.add(data[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchToName() {  // Проверка телефона у фамилии
        getReadToFile();
        String[] arrayName = name.toArray(new String[0]);
        String[] arrayPhone = phone.toArray(new String[0]);

        Scanner scanInName = new Scanner(System.in);
        System.out.println("Введите Фамилию для проверки: ");
        str = scanInName.nextLine();
        boolean k = false;
        for (int i = 0; i < arrayName.length ; i++) {   // Проверяем на имеющуюся строку
            if (str.equals(arrayName[i])) {
                System.out.println(arrayPhone[i]);
                k = true;
            }
        }
        if (k == false) {
            System.out.println("Такого номера/фамилии нет");
        }

    }

    public void addString () throws NothingRepeat {  // Добавляем данные

        Scanner scanInName = new Scanner(System.in);
        System.out.println("Введите Фамилию: ");
        str = scanInName.nextLine();

        Scanner scanInPhone = new Scanner(System.in);
        System.out.println("Введите номер: ");
        str1 = scanInPhone.nextLine();

        str = str + " " + str1;
        list.add(str);

        String[] array = list.toArray(new String[0]);

        for (int i = 0; i < array.length - 1; i++) {   // Проверяем на имеющуюся строку
            if (str.equals(array[i])) {
                String[] data = str.split(" ");
                throw (new NothingRepeat(data[0],data[1]));
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

