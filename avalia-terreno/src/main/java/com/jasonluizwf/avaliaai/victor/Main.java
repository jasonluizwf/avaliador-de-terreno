package com.jasonluizwf.avaliaai.victor;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeSetores gerenciadorDeSetores = new GerenciadorDeSetores();
        Terreno terreno = new Terreno(gerenciadorDeSetores);
        terreno.coletarDadosTerreno();
        terreno.getValorVenalDoTerreno();
    }
}