package com.hamburg.springtests.logintest.kafkatest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class LottoService {

	private static Random r = new Random();

	// private static List<ArrayList<String>> lotteryListListe = new
	// ArrayList<ArrayList<String>>();

	public String getLottoZahlen() {
		return generateLottery(1, 49); // "34 39 25 30 14 47 14 25 30 34 39 47";
	}

	public String generateLottery(int min, int max) {

		List<ArrayList<String>> lotteryListListe = new ArrayList<ArrayList<String>>();

		for (int j = 1; j < 13; j++) {
			lotteryListListe.add(generateOneLottery(min, max));
		}

		String result = "";

		for (int j = 0; j < lotteryListListe.size(); j++) {
			ArrayList<String> oneListe = lotteryListListe.get(j);
			String oneLine = "";
			for (int i = 0; i < oneListe.size(); i++) {
				oneLine += oneListe.get(i);
			}
			result += "\n" + oneLine;
		}

		StringBuffer sb = new StringBuffer().append(result).append("\n");
		// System.out.println(result);
		return sb.toString();
	}

	public ArrayList<String> generateOneLottery(int min, int max) {

		ArrayList<String> resultList = new ArrayList<String>();
		HashSet<String> lotterySet = new HashSet<String>();

		while (lotterySet.size() < 6) {
			lotterySet.add(Integer.toString((r.nextInt(max - min + 1) + min)));
		}

		ArrayList<String> lotteryUnsortedList = new ArrayList<String>(lotterySet);

		List<String> lotterySortedList = new ArrayList<String>(lotterySet);
		// Collections.sort(lotterySortedList);

		lotterySortedList = lotterySortedList.stream().mapToInt(Integer::parseInt).sorted().mapToObj(Integer::toString)
				.collect(Collectors.toList());

//		lotterySortedList = lotterySortedList.stream()
//					.filter(Objects::nonNull)
//					.map(Objects::toString)
//					.map(String::trim)
//					.filter(s -> isInteger(s))
//					//.map(Integer::parseInt)
//					.map(s -> Integer.getInteger(s))
//					//.map(s -> Integer.toString(s))
//					.sorted((s1, s2) -> s1.compareTo(s2))				
//					.map(s-> s.toString())
//					.filter(Objects::nonNull)
//					.collect(Collectors.toList());

		// .sort((a, b) -> a.);

		for (int i = 0; i < lotteryUnsortedList.size(); i++) {
			resultList.add("\t" + lotteryUnsortedList.get(i));
		}

		resultList.add("\t\t\t");
		for (int j = 0; j < lotterySortedList.size(); j++) {
			resultList.add("\t" + lotterySortedList.get(j).toString());
		}
		resultList.add("\t");

		return resultList;
	}

	public static boolean isInteger(String string) {

		if (string == null || string.equals("")) {
			System.out.println("String cannot be parsed, it is null or empty.");
			return false;
		}

		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
