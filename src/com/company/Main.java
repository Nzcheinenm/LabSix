package com.company;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NothingRepeat {
	// write your code here

            ArrayReader reader = new ArrayReader();
            reader.getReadToFile(); // Читаем из файла
            reader.addString(); // Добавляем строку
            reader.validationString(); // Проверяем строку на аналогичную
            reader.recordToFile(); // Записываем в файл
    }
}

