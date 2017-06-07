package com.anlp.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class WebSummarization {
	
	public void getSummarization() throws IOException {
		
		File input = new File("/home/myilmaz/Desktop/deneme.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

	    Elements divs = doc.select("div, p, b");
	    for (Element div : divs) {
	    	if (div.ownText() != "")
	    		System.out.println(div.ownText());
	    }
		
	}

	public static void main(String[] args) throws Exception{

		WebSummarization summarization = new WebSummarization();
		summarization.getSummarization();

	}
}
