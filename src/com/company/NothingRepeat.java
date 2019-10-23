package com.company;

 class NothingRepeat extends Exception {
     public NothingRepeat() {
         super("Данные уже имеются");
     }
}
