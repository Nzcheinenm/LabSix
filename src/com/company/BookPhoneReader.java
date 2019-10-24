package com.company;

import java.util.Scanner;

class BookPhoneReader extends ArrayReader{
    void getMain() throws NothingRepeat {
        int value;
        Scanner scanInName = new Scanner(System.in);
        System.out.println("Хотите ввести данные или проверить на наличие? "
                +  "\nВведите для ввода данных 1 или для проверки 2");
        value = scanInName.nextInt();
        if (value == 1) {
            getReadToFile();
            addString();
            recordToFile();
        } else if (value == 2) {
            searchToName();
        } else {
            throw new NothingRepeat();
        }
    }

    void getNotRead() throws NothingRepeat {
        getReadToFile();
        addString();
        recordToFile();
    }
}
