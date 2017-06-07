package com.anlp.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrievelModel extends HttpServlet{

	private static final long serialVersionUID = 9051262063501142791L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>"
				+ "<head><title>CSE 610 Project</title>"
				+ "<style>p{margin-top:75px}"
				+ "input[type=text] { width: 130px; box-sizing: border-box; border: 2px solid #ccc;"
				+ "border-radius: 4px; font-size: 16px; background-color: white; background-image: url('searchicon.png');"
				+ "background-position: 10px 10px; background-repeat: no-repeat; padding: 12px 20px 12px 40px;"
				+ "-webkit-transition: width 0.4s ease-in-out; transition: width 0.4s ease-in-out;}"
				+ "input[type=text]:focus { width: 100%;}</style></head>"
				+ "<body>"
				+ "<p><h1 style='text-align:center;'>Web Search</h1>"
				+ "<h4 style='text-align:center;'>Advanced Natural Language Processing Project</h4>"
				+ "<form align='center'><input align='center' type='text' name='search' placeholder='Enter url..'>"
				+ "<input type='submit' name='crawling' value='Crawling'>"
				+ "<input type='submit' name='indexer' value='Indexer'>"
				+ "<input type='submit' name='ranker' value='Ranker'>"
				+ "<input type='submit' name='qprocessor' value='QueryProcessor'>"
				+ "<input type='submit' name='summarization' value='Summarization'>"
				+ "<input type='submit' name='tprocessing' value='TextProcessing'>"
				+ "</body>"
				+ "</html>");
		if (req.getParameter("search") != null){
			if (req.getParameter("crawling") != null){
				WebCrawler crawler = new WebCrawler();
				crawler.getPageLinks(req.getParameter("search"));
			} else if (req.getParameter("indexer") != null){ //to be done
				System.out.println("indexer");
			} else if (req.getParameter("ranker") != null){ //to be done
				WebRanker ranker = new WebRanker();
				System.out.println(ranker.getUrlRanking(req.getParameter("search")));
				System.out.println("mert");
			} else if (req.getParameter("qprocessor") != null){ //to be done
				System.out.println("qprocessor");
			} else if (req.getParameter("summarization") != null){
				WebSummarization summarization = new WebSummarization();
				summarization.getSummarization();
			} else if (req.getParameter("tprocessing") != null){
				TextProcessing processing = new TextProcessing();
				try {
					processing.getTProcessing();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
