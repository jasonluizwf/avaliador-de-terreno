package com.jasonluizwf.avaliaai.victor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SituacaoDoTerreno {
	private Map<Integer, Double> situacaoMap = new HashMap<>();

	public SituacaoDoTerreno() {
		if (situacaoMap == null) {
			situacaoMap = new HashMap<>();
		}
		situacaoMap.put(1, 115.0);
		situacaoMap.put(2, 130.0);
		situacaoMap.put(3, 100.0);
		situacaoMap.put(4, 85.0);
		situacaoMap.put(5, 70.0);
	}

	private double valorSituacao(int chave) {
		Double valor = situacaoMap.get(chave);
		if (valor == null) {
			throw new IllegalArgumentException("Chave não encontrada na situação do terreno: " + chave);
		}
		return valor;
	}

	public double getValorSituacao(){
		Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		double valor = 0;
		int chave;
		// COLETAR VALOR DA SITUAÇÃO DO TERRENO
		do {
			System.out.println("Selecione uma das opções abaixo:");
			System.out.println("[1] Meio de quadra");
			System.out.println("[2] Esquina");
			System.out.println("[3] Vila");
			System.out.println("[4] Encravao");
			System.out.println("[5] Rua sem saida");
			System.out.print("Escolha: ");
			try {
				chave = scanner.nextInt();
				// Validação do número dentro do intervalo
				if (situacaoMap.containsKey(chave)) {
					flag = true; // Valor válido, sai do loop
					valor = valorSituacao(chave);
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
		return "SituacaoDoTerreno [situacaoMap=" + situacaoMap + "]";
	}

}
