package br.com.cod3r.cm;

import br.com.cod3r.cm.modelo.Tabuleiro;

import java.util.Random;

public class Aplicacao {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);

        tabuleiro.marcar(4,4);
        tabuleiro.marcar(5,5);
        tabuleiro.abrir(3,3);
        tabuleiro.abrir(1,1);
        System.out.println(tabuleiro);
    }
}
