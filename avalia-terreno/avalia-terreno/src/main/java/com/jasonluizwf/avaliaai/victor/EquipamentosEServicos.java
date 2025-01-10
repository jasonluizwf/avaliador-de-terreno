package com.jasonluizwf.avaliaai.victor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EquipamentosEServicos {
	private Map<Integer, Double> redeDeAguaMap;
	private Map<Integer, Double> redeDeEsgotoMap;
	private Map<Integer, Double> redeEletricaMap;
	private Map<Integer, Double> redeTelefonicaMap;
	private Map<Integer, Double> galeriasPluviaisMap;
	private Map<Integer, Double> passeioCalcadaMap;
	private Map<Integer, Double> conservacaoDeViasPublicasMap;
	private Map<Integer, Double> limpezaPublicaMap;
	private Map<Integer, Double> situacaoDoLogradouroMap;
	private Map<Integer, Double> iluminacaoPublicaMap;

	public EquipamentosEServicos() {
		if (redeDeAguaMap == null) {
			redeDeAguaMap = new HashMap<>();
		}
		if (redeDeEsgotoMap == null) {
			redeDeEsgotoMap = new HashMap<>();
		}
		if (redeEletricaMap == null) {
			redeEletricaMap = new HashMap<>();
		}
		if (redeTelefonicaMap == null) {
			redeTelefonicaMap = new HashMap<>();
		}
		if (galeriasPluviaisMap == null) {
			galeriasPluviaisMap = new HashMap<>();
		}
		if (passeioCalcadaMap == null) {
			passeioCalcadaMap = new HashMap<>();
		}
		if (conservacaoDeViasPublicasMap == null) {
			conservacaoDeViasPublicasMap = new HashMap<>();
		}
		if (limpezaPublicaMap == null) {
			limpezaPublicaMap = new HashMap<>();
		}
		if (situacaoDoLogradouroMap == null) {
			situacaoDoLogradouroMap = new HashMap<>();
		}
		if (iluminacaoPublicaMap == null) {
			iluminacaoPublicaMap = new HashMap<>();
		}

		redeDeAguaMap.put(1, 120.0);
		redeDeAguaMap.put(2, 100.0);

		redeDeEsgotoMap.put(1, 130.0);
		redeDeEsgotoMap.put(2, 100.0);

		redeEletricaMap.put(1, 120.0);
		redeEletricaMap.put(2, 100.0);

		redeTelefonicaMap.put(1, 110.0);
		redeTelefonicaMap.put(2, 100.0);

		galeriasPluviaisMap.put(1, 130.0);
		galeriasPluviaisMap.put(2, 100.0);

		passeioCalcadaMap.put(1, 120.0);
		passeioCalcadaMap.put(2, 100.0);

		conservacaoDeViasPublicasMap.put(1, 110.0);
		conservacaoDeViasPublicasMap.put(2, 100.0);

		limpezaPublicaMap.put(1, 115.0);
		limpezaPublicaMap.put(2, 100.0);

		situacaoDoLogradouroMap.put(0, 100.0);
		situacaoDoLogradouroMap.put(1, 115.0);
		situacaoDoLogradouroMap.put(2, 130.0);

		iluminacaoPublicaMap.put(0, 100.0);
		iluminacaoPublicaMap.put(1, 115.0);
		iluminacaoPublicaMap.put(2, 130.0);

	}

	private double valorRedeDeAgua(int chave) {
		if (redeDeAguaMap.get(chave) == null) {
	        throw new IllegalArgumentException("Chave não encontrada em equipamentos e serviços: " + chave);
	    }
		return redeDeAguaMap.get(chave);
	}
	public double getValorRedeDeAgua() {
		Scanner scanner = ScannerManager.getScanner();
		boolean flag = false;
		double valor = 0;
		int chave;
		// COLETAR VALOR DA REDE DE ÁGUA
		do {
			System.out.println("Selecione uma das opções abaixo:");
			System.out.println("Tem rede de água?");
			System.out.println("[1] Sim");
			System.out.println("[2] Não");
			System.out.print("Escolha: ");
			try {
				chave = scanner.nextInt();
				// Validação do número dentro do intervalo
				if (redeDeAguaMap.containsKey(chave)) {
					flag = true; // Valor válido, sai do loop
					valor = valorRedeDeAgua(chave);
				} else {
					System.out.println("Erro: O número deve ser entre 1 e 2. Tente novamente.");
				}
			} catch (Exception e) {
				System.out.println("Erro: Entrada inválida. Digite um número válido. Tente novamente.");
				scanner.nextLine(); // Limpa a entrada inválida
			}
		} while (!flag);
		return valor;

	}

	public double getRedeDeEsgotoMap(int chave) {
		return redeDeEsgotoMap.get(chave);
	}

	public double getRedeEletricaMap(int chave) {
		return redeEletricaMap.get(chave);
	}

	public double getRedeTelefonicaMap(int chave) {
		return redeTelefonicaMap.get(chave);
	}

	public double getGaleriasPluviaisMap(int chave) {
		return galeriasPluviaisMap.get(chave);
	}

	public double getPasseioCalcadaMap(int chave) {
		return passeioCalcadaMap.get(chave);
	}

	public double getConservacaoDeViasPublicasMap(int chave) {
		return conservacaoDeViasPublicasMap.get(chave);
	}

	public double getLimpezaPublicaMap(int chave) {
		return limpezaPublicaMap.get(chave);
	}

	public double getSituacaoDoLogradouroMap(int chave) {
		return situacaoDoLogradouroMap.get(chave);
	}

	public double getIluminacaoPublicaMap(int chave) {
		return iluminacaoPublicaMap.get(chave);
	}

	@Override
	public String toString() {
		return "EquipamentosEServicos [redeDeAguaMap=" + redeDeAguaMap + ", redeDeEsgotoMap=" + redeDeEsgotoMap
				+ ", redeEletricaMap=" + redeEletricaMap + ", redeTelefonicaMap=" + redeTelefonicaMap
				+ ", galeriasPluviaisMap=" + galeriasPluviaisMap + ", passeioCalcadaMap=" + passeioCalcadaMap
				+ ", conservacaoDeViasPublicasMap=" + conservacaoDeViasPublicasMap + ", limpezaPublicaMap="
				+ limpezaPublicaMap + ", situacaoDoLogradouroMap=" + situacaoDoLogradouroMap + ", iluminacaoPublicaMap="
				+ iluminacaoPublicaMap + "]";
	}

}
