package br.com.vicarisolutions;

import br.com.vicarisolutions.modelo.Tabuleiro;
import br.com.vicarisolutions.visao.TabuleiroConsole;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        new TabuleiroConsole(tabuleiro);

    }
}
