package W2;

import java.util.Map;
import java.util.TreeMap;

public class BookReport {
	protected String bookTitle;
	protected String studentName;
	protected int numPages;
	
	public BookReport(String bookTitle, String studnetName, int numPages) {
		this.bookTitle=bookTitle;
		this.studentName=studentName;
		this.numPages=numPages;
	}
	
	public String toString() {
		return(studentName +"wrote"+numPages +"pages on"+bookTitle+".");
	}
	
	public int compareTo(BookReport otherBookReport) {
		return numPages-otherBookReport.numPages;
	}
	
	public static void main(String[] args) {
		BookReport aa=new BookReport("aa","a",50);
		BookReport bb=new BookReport("bb","b",30);
		BookReport cc=new BookReport("cc","c",20);
		BookReport dd=new BookReport("dd","d",10);
		
		TreeMap<BookReport, Integer> reportScores=new TreeMap<BookReport,Integer>();
		reportScores,put(aa,51);
		reportScores,put(bb,31);
		reportScores,put(dd,21);
		reportScores,put(cc,11);
		
		for(Map.Entry<BookReport,Integer> entry:reportScores.entrySet()) {
			BookReport reportInfo=entry.getKey();
			int score=entry.getValue();
			System.out.println(reportInfo+" "+score+"pts.");
			
		}
	}

	
}
