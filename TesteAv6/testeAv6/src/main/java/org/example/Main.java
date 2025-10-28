package org.example;

import models.ClasseA;
import models.ClasseB;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ClasseB classeB = new ClasseB();
        ClasseA classeA = new ClasseA(classeB);
        System.out.println("");
    }
}