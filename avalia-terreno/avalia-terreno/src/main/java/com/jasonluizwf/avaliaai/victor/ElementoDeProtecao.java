package com.jasonluizwf.avaliaai.victor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElementoDeProtecao {
		
	private final Map<Integer, Double> elementoDeProtecaoMap = new HashMap<>();

	public ElementoDeProtecao() {
		elementoDeProtecaoMap.put(1, 140.0);
		elementoDeProtecaoMap.put(2, 130.0);
		elementoDeProtecaoMap.put(3, 120.0);
		elementoDeProtecaoMap.put(4, 110.0);
		elementoDeProtecaoMap.put(5, 100.0);
	}

	private double valorElementoDeProtecao(int chave) {
		Double valor = elementoDeProtecaoMap.get(chave);
		if (valor == null) {
	        throw new IllegalArgumentException("Chave não encontrada na topografia: " + chave);
		}
		return valor;
	}

	public double getValorElementoDeProtecao() {
				Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		double valor = 0;
		int chave;
		// COLETAR VALOR DO ELEMENTO DEPROTEÇÃO
		do {
			System.out.println("Selecione uma das opções abaixo:");
			System.out.println("[1] Muro");
			System.out.println("[2] Gradil");
			System.out.println("[3] Cerca de madeira");
			System.out.println("[4] Cerca de arame");
			System.out.println("[5] Aberto");
			System.out.print("Escolha: ");
			try {
				chave = scanner.nextInt();
				// Validação do número dentro do intervalo
				if (elementoDeProtecaoMap.containsKey(chave)) {
					flag = true; // Valor válido, sai do loop
					valor = valorElementoDeProtecao(chave);
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
		return "ElementoDeProtecao [elementoDeProtecaoMap=" + elementoDeProtecaoMap + "]";
	}

}
