package com.jasonluizwf.avaliaai.victor;

import java.util.Scanner;

/*
 * Ao usar a classe terreno, deve instanciar um gerenciador de setores e iniciar o metodo coletarDadosTerreno.
 * 
 */
public class Terreno {

	private double area;
	private double valorDoMetroQuadrado;
	private double linhaDeDivisaFrente;
	private double linhaDeDivisaFundo;
	private final Topografia topografia;
	private final Pedologia pedologia;
	private final ElementoDeProtecao elementoDeProtecao;
	private final SituacaoDoTerreno situacao;
	private final OcupacaoDoSolo ocupacaoDoSolo;
	private final EquipamentosEServicos equipamentosEServicos;
	private GerenciadorDeSetores gerenciadorDeSetores;

	// Construtor para iniciar as instancias
	public Terreno(GerenciadorDeSetores gerenciadorDeSetores) {
        this.gerenciadorDeSetores = gerenciadorDeSetores;
		this.topografia = new Topografia();
		this.pedologia = new Pedologia();
		this.elementoDeProtecao = new ElementoDeProtecao();
		this.situacao = new SituacaoDoTerreno();
		this.ocupacaoDoSolo = new OcupacaoDoSolo();
		this.equipamentosEServicos = new EquipamentosEServicos();
    }

	public double getValorVenalDoTerreno() {

		// Fatores Corretivos
		double fc14 = topografia.getValorTopografia();
		double fc15 = pedologia.getValorPedologia();
		double fc16 = elementoDeProtecao.getValorElementoDeProtecao();
		double fc17 = situacao.getValorSituacao();
		double fc18 = ocupacaoDoSolo.getValorOcupacaoDoSolo();
		double fc50 = equipamentosEServicos.getValorRedeDeAgua();
		double fc51 = equipamentosEServicos.getValorRedeDeEsgoto();

		/* 
		 
		//
		double fc52 = equipamentosEServicos.getRedeEletricaMap(redeEletricaChave);
		double fc53 = equipamentosEServicos.getRedeTelefonicaMap(redeTelefonicaChave);
		double fc54 = equipamentosEServicos.getGaleriasPluviaisMap(galeriaPluviaisChave);
		double fc55 = equipamentosEServicos.getPasseioCalcadaMap(passeioCalcadaChave);
		double fc56 = equipamentosEServicos.getConservacaoDeViasPublicasMap(conservacaoDeViasPublicasChave);
		double fc57 = equipamentosEServicos.getLimpezaPublicaMap(limpezaPublicaChave);
		double fc58 = equipamentosEServicos.getSituacaoDoLogradouroMap(situacaoDoLogradouroChave);
		double fc59 = equipamentosEServicos.getIluminacaoPublicaMap(iluminacaoPublicaChave);
		

		// Fator Corretivo Médio (FCM)
		double fatorCorretivoMedio = ((fc14 + fc15 + fc16 + fc17 + fc18 + fc50 + fc51 + fc52 + fc53 + fc54 + fc55 + fc56
				+ fc57 + fc58 + fc59) / 15) + coeficienteDeAproveitamentoTecnicoDoTerreno();

		// Valor por Localização
		Double valorPorLocalizacao = gerenciadorDeSetores.obterValorPorLocalizacao(setor, rua, quadra);
		if (valorPorLocalizacao == null) {
			throw new IllegalArgumentException("Valor por localização não encontrado para os parâmetros fornecidos.");
		}

		// Valor Venal do Terreno (VTT)
		double vtt = area * valorPorLocalizacao * fatorCorretivoMedio;
		return vtt;
		*/
		
		return 0;
	}
	public double getValorDoMetroQuadradp(double area, double valorVenalDoTerreno) {
		return area / valorVenalDoTerreno;
	}

	// Método para coletar os dados do terreno
    public void coletarDadosTerreno() {
		Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		// COLETAR METROS QUADRADOS DO TERRENO
		do {
			System.out.println("QUANTOS M² TEM O TERRENO?");
			try {
				this.area = scanner.nextDouble();
				scanner.nextLine();
				if (this.area > 0) {
					flag = true; // Valor válido, sai do loop
				} else {
					System.out.println("Erro: O número deve ser maior que 0. Tente novamente.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número válido. Tente novamente.");
				scanner.nextLine(); // Limpa a entrada inválida
			}
		} while (!flag);
		
		flag = false;

		// COLETAR LINHA DE DIVISÃO DE FRENTE
		do {
			System.out.println("QUANTOS METROS DE LINHA DE DIVISÃO DE FRENTE?");
			try {
				this.linhaDeDivisaFrente = scanner.nextDouble();
				scanner.nextLine();
				if (this.linhaDeDivisaFrente > 0) {
					flag = true;
				} else {
					System.out.println("Erro: O número deve ser maior que 0. Tente novamente.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número válido. Tente novamente.");
				scanner.nextLine(); // Limpa a entrada inválida
			}
		} while (!flag);

		flag = false;

		// COLETAR LINHA DE DIVISÃO DE FUNDO
		
		do {
			System.out.println("QUANTOS METROS DE LINHA DE DIVISÃO DE FUNDO?");
			try {
				this.linhaDeDivisaFundo = scanner.nextDouble();
				scanner.nextLine();
				if (this.linhaDeDivisaFundo > 0) {
					flag = true;
				} else {
					System.out.println("Erro: O número deve ser maior que 0. Tente novamente.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número válido. Tente novamente.");
				scanner.nextLine(); // Limpa a entrada inválida
			}
		} while (!flag);
		
    }
	// Cálculo do Coeficiente de Aproveitamento Técnico do Terreno
	private double coeficienteDeAproveitamentoTecnicoDoTerreno() {
		return (this.area / ((this.linhaDeDivisaFrente + this.linhaDeDivisaFundo) / 2) / 100);
	}
}
