package org.example.models;

import java.sql.SQLOutput;

public class Jogador {
    private String magia;

    public Jogador(String magia) {
        this.magia = magia;
    }

    public String getMagia() {
        return magia;
    }

    public void realizarAlgo(){
    System.out.println("O jogador fez algo");
    }
}
