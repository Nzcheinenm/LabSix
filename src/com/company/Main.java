package com.company;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Класс содержит запуск программы и обработку исключения try-catch.
 */

final class Main {
        private Main() {
        }

        public static void main(final String[] args) throws NothingRepeat {

                try {
                        BookPhoneReader bookReader = new BookPhoneReader();
                        bookReader.getMain();
                } catch (NothingRepeat e) {
                        System.out.println("\u001B[31m" + "Данный пользователь"
                            + " имеется" + "\u001B[0m");
                        Scanner scanInNum = new Scanner(System.in, "UTF-8");
                        System.out.println("Хотите повторить ввод или закончить? "
                            + "\nВведите для повтора 1 или для закрытия 2");
                        double value = scanInNum.nextInt();
                        if (value == 1) {
                                BookPhoneReader bookPhone = new BookPhoneReader();
                                bookPhone.getNotRead();
                        } else if (value == 2) {
                                exit(1);
                        } else {
                                throw new NothingRepeat();
                        }

                }

        }
}

