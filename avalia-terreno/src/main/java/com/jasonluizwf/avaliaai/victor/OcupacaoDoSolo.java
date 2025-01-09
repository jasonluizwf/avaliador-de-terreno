package com.jasonluizwf.avaliaai.victor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OcupacaoDoSolo {
	private Map<Integer, Double> ocupacaoDoSoloMap;

	public OcupacaoDoSolo() {
		if (ocupacaoDoSoloMap == null) {
			ocupacaoDoSoloMap = new HashMap<>();
		}
		ocupacaoDoSoloMap.put(1, 130.0);
		ocupacaoDoSoloMap.put(2, 100.0);
		ocupacaoDoSoloMap.put(3, 115.0);
		ocupacaoDoSoloMap.put(4, 70.0);
		ocupacaoDoSoloMap.put(5, 130.0);
		ocupacaoDoSoloMap.put(6, 85.0);
	}

	private double valorOcupacaoDoSolo(int chave) {
		Double valor = ocupacaoDoSoloMap.get(chave);
		if (valor == null) {
	        throw new IllegalArgumentException("Chave não encontrada na ocupação do solo: " + chave);
	    }
		return valor;
	}

	public double getValorOcupacaoDoSolo(){
		Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		double valor = 0;
		int chave;
		// COLETAR VALOR DA OCUPAÇÃO DO SOLO
		do {
			System.out.println("Selecione uma das opções abaixo:");
			System.out.println("[1] Com edificação");
			System.out.println("[2] Baldio");
			System.out.println("[3] Em construção");
			System.out.println("[4] Edificação em ruinas");
			System.out.println("[5] Praça");
			System.out.println("[6] Edificação temporaria");
			System.out.print("Escolha: ");
			try {
				chave = scanner.nextInt();
				// Validação do número dentro do intervalo
				if (ocupacaoDoSoloMap.containsKey(chave)) {
					flag = true; // Valor válido, sai do loop
					valor = valorOcupacaoDoSolo(chave);
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
		return "OcupacaoDoSolo [ocupacaoDoSoloMap=" + ocupacaoDoSoloMap + "]";
	}

}
