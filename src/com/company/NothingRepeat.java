package com.company;

 class NothingRepeat extends Exception {
     public NothingRepeat(String str1, String str2) {
         super("Данный пользователь " + str1 + ",c номером " + str2 + " уже имеется в книге.");
     }
     public NothingRepeat() {
         super("Вы ввели неккоректное значение");
     }
}
