package com.company;

/**
 * Класс содержит реализацию Исключения NothingRepeat.
 */

class NothingRepeat extends Exception {
        NothingRepeat(final String str1, final String str2) {
                super("Данный пользователь " + str1 + ",c номером"
                    + " " + str2 + " уже имеется в книге.");
        }

        NothingRepeat() {
                super("Вы ввели неккоректное значение");
        }
}
