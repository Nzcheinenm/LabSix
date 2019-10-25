package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс работы с файлом, записью и чтению строк.
 */

class ArrayReader {
        private String str;
        private ArrayList<String> list = new ArrayList<>();
        private ArrayList<String> name = new ArrayList<>();
        private ArrayList<String> phone = new ArrayList<>();

        void getReadToFile() { // Читаем файл и делим его на строки и сущности
                try (Scanner scan = new Scanner(new File("book.txt"), "UTF-8")) {
                        while (scan.hasNextLine()) {
                                list.add(scan.nextLine());
                        }
                        String[] array = list.toArray(new String[0]);
                        for (String str1 : array) {
                                String[] data = str1.split(" ");
                                if (data.length < 2) {
                                        continue;
                                }
                                name.add(data[0]);
                                phone.add(data[1]);
                        }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
        }

        void searchToName() {  // Проверка телефона у фамилии
                getReadToFile();
                String[] arrayName = name.toArray(new String[0]);
                String[] arrayPhone = phone.toArray(new String[0]);

                Scanner scanInName = new Scanner(System.in, "UTF-8");
                System.out.println("Введите Фамилию для проверки: ");
                str = scanInName.nextLine();
                boolean k = false;
                for (int i = 0; i < arrayName.length; i++) {
                        if (str.equals(arrayName[i])) {
                                System.out.println(arrayPhone[i]);
                                k = true;
                        }
                }
                if (!k) {
                        System.out.println("Такого номера/фамилии нет");
                }

        }

        void addString() throws NothingRepeat {  // Добавляем данные

                Scanner scanInName = new Scanner(System.in, "UTF-8");
                System.out.println("Введите Фамилию: ");
                str = scanInName.nextLine();

                Scanner scanInPhone = new Scanner(System.in, "UTF-8");
                System.out.println("Введите номер: ");
                String str1 = scanInPhone.nextLine();

                str = str + " " + str1;
                list.add(str);

                String[] array = list.toArray(new String[0]);

                for (int i = 0; i < array.length - 1; i++) {
                        if (str.equals(array[i])) {
                                String[] data = str.split(" ");
                                throw (new NothingRepeat(data[0], data[1]));
                        }
                }
        }

        void recordToFile() {  // Записываем в файл
                try {
                        Files.write(Paths.get("book.txt"), list, StandardOpenOption.CREATE);
                } catch (IOException e) {
                        e.printStackTrace();
                }

        }

}

