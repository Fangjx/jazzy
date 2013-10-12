package com.swabunga.spell.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;

public class SpellCheckExample3 {

	private static String dictFile = "dict/english.0";
	// private static String phonetFile = "dict/phonet.en";

	private SpellChecker spellCheck = null;

	public SpellCheckExample3() {
		try {
			SpellDictionary dictionary = new SpellDictionaryHashMap(new File(dictFile), null);

			spellCheck = new SpellChecker(dictionary);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Enter text to spell check: ");
				String line = in.readLine();

				if (line.length() <= 0){
					break;
				}
				List<Map<String,List<String>>> result = spellCheck.checkSpelling(line);
				System.out.println("MISSPELT WORD and suggestions: " + result);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SpellCheckExample3();
	}
}
