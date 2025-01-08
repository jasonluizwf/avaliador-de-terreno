package com.jasonluizwf.avaliaai.victor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pedologia {
	private Map<Integer, Double> pedologiaMap;

	public Pedologia() {
		if (pedologiaMap == null) {
	        pedologiaMap = new HashMap<>();
	    }

		pedologiaMap.put(1, 130.0);
		pedologiaMap.put(2, 115.0);
		pedologiaMap.put(3, 100.0);
		pedologiaMap.put(4, 70.0);
		pedologiaMap.put(5, 85.0);
	}

	private double valorPedologia(int chave) {
		Double valor = pedologiaMap.get(chave);
	    if (valor == null) {
	        throw new IllegalArgumentException("Chave não encontrada na pedologia: " + chave);
	    }
	    return valor;
	}

	public double getValorPedologia() {
		Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		double valor = 0;
		int chave;
		// COLETAR VALOR DA TOPOLOGIA
		do {
			System.out.println("Selecione uma das opções abaixo:");
			System.out.println("[1] Normal");
			System.out.println("[2] Rochoso");
			System.out.println("[3] Arenoso");
			System.out.println("[4] Alagadiço");
			System.out.println("[5] Inundavel");
			System.out.print("Escolha: ");
			try {
				chave = scanner.nextInt();
				// Validação do número dentro do intervalo
				if (pedologiaMap.containsKey(chave)) {
					flag = true; // Valor válido, sai do loop
					valor = valorPedologia(chave);
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
		return "Pedologia [pedologiaMap=" + pedologiaMap + "]";
	}
	
}
