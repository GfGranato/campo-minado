package br.com.cod3r.cm.visao;

import br.com.cod3r.cm.excecao.ExplosaoException;
import br.com.cod3r.cm.excecao.SairException;
import br.com.cod3r.cm.modelo.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo() {
        try{
            boolean continuar = true;
            while (continuar){
                cicloJogo();
                System.out.println("Outra Partida?(S/n) ");
                String resposta = entrada.nextLine();
                if("n".equalsIgnoreCase(resposta)){
                    continuar = false;
                }else {
                    tabuleiro.reiniciar();
                }
            }
        }catch (SairException e){
            System.out.println("tchau!");
        }finally {
            entrada.close();
        }
    }

    private void cicloJogo() {
        try{
            while (!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);
                String digitado = capturarValorDigitado("Digite (x,y): ");
                Iterator<Integer> xy = Arrays.stream(digitado.split(","))
                    .map(e -> Integer.parseInt(e.trim())).iterator();

                digitado = capturarValorDigitado("1 - Abrir ou 2 - (des)marcar");
                if("1".equalsIgnoreCase(digitado)){
                    tabuleiro.abrir(xy.next(), xy.next());
                }else if("2".equalsIgnoreCase(digitado)){
                    tabuleiro.marcar(xy.next(), xy.next());
                }
            }
            System.out.println(tabuleiro);
            System.out.println("Victory!");
        }catch (ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("Wasted!");
        }catch (NoSuchElementException e) {
            System.out.println("Digite um valor valido!");
            cicloJogo();
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = entrada.nextLine();
        if("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }
        return digitado;
    }
}
