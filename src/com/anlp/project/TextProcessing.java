package com.anlp.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessing {
	
	public void getTProcessing() throws Exception {
		
		int sumChars = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		File input = new File("/home/myilmaz/Desktop/deneme.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

		Elements divs = doc.select("div, p, b");
		for (Element div : divs) {
			if (div.ownText() != "") {
				sumChars += div.ownText().length();
				String[] word = div.ownText().split(" ");
				for (String t : word){
					
					if (map.containsKey(t)){
						map.put(t, map.get(t)+1);
					} else {
						map.put(t, 1);
					}
					
				}
			}
		}
		System.out.println("Sum of all words: " + sumChars);
		System.out.print("Number of singular words: ");

		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String,Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for(int i = 0; i < map.size(); i++){
			System.out.println(entries.get(entries.size() - i - 1).getKey()+" "+entries.get(entries.size() - i - 1).getValue());
		}
		
	}

	public static void main(String[] args) throws Exception{

		TextProcessing processing = new TextProcessing();
		processing.getTProcessing();

	}
}
