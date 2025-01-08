package com.jasonluizwf.avaliaai.victor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Topografia {
	private Map<Integer, Double> topografiaMap;

	public Topografia() {
	    if (topografiaMap == null) {
	        topografiaMap = new HashMap<>();
	    }
	    // Inicializa o mapa com os valores padrões
	    topografiaMap.put(1, 115.0);
	    topografiaMap.put(2, 100.0);
	    topografiaMap.put(3, 130.0);
	    topografiaMap.put(4, 85.0);
	    topografiaMap.put(5, 115.0);
	}

	private double valorTopografiaDoTerreno(int chave) {
	    Double valor = topografiaMap.get(chave);
	    if (valor == null) {
	        throw new IllegalArgumentException("Chave não encontrada na topografia: " + chave);
	    }
	    return valor;
	}

	public double getValorTopografia() {
		Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		double valor = 0;
		int chave;
		// COLETAR VALOR DA TOPOLOGIA
		do {
			System.out.println("Selecione uma das opções abaixo:");
			System.out.println("[1] Ao nível");
			System.out.println("[2] Abaixo do nível");
			System.out.println("[3] Acima do nível");
			System.out.println("[4] Irregular");
			System.out.println("[5] Divisa com manacial insalubre");
			System.out.print("Escolha: ");
			try {
				chave = scanner.nextInt();
				// Validação do número dentro do intervalo
				if (topografiaMap.containsKey(chave)) {
					flag = true; // Valor válido, sai do loop
					valor = valorTopografiaDoTerreno(chave);
				} else {
					System.out.println("Erro: O número deve ser entre 1 e 5. Tente novamente.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número válido. Tente novamente.");
				scanner.nextLine(); // Limpa a entrada inválida
			}
		} while (!flag);
		return valor;
	}
	@Override
	public String toString() {
		return "Topografia [topografiaMap=" + topografiaMap + "]";
	}
}