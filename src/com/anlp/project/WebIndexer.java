package com.anlp.project;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WebIndexer {
	Map<String, Set<Integer>> index;

	WebIndexer() {
		index = new TreeMap<String, Set<Integer>>();
	}

	public void addItem(String keyword, int page) {
		if (index.get(keyword) != null) {
			(index.get(keyword)).add(page);
		} else {
			index.put(keyword, new HashSet<Integer>());
			(index.get(keyword)).add(page);
		}
	}

	public void removeItem(String keyword, int page) { 
		if (index.get(keyword) != null) {
			index.get(keyword).remove(page);

			if (index.get(keyword).isEmpty()) {
				index.remove(keyword);
			}
		}
	}

	public String getEntry(String keyword) {
		String result = keyword;

		for(int elem : index.get(keyword)){
			result = result + "," + " " + elem;
		}

		return result;
	}

	public void printIndex() {
		System.out.println("----------------------------------");
		System.out.println("INDEX");
		System.out.println("----------------------------------");

		for (String keyword : index.keySet()) {
			System.out.println(" " +  getEntry(keyword));   
		}
	}

	public static void main(String[] args) {
		WebIndexer test = new WebIndexer();

		test.addItem("test", 1);
		test.addItem("bleh", 2);
		test.addItem("blar", 1);

		test.printIndex();
	}
}