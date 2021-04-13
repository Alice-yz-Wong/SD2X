import java.util.Scanner;
import java.io.IOException;
import java.util.List;
/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	private Scanner scanner = new Scanner(System.in);

	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		List<String> lines = null;
		
		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String line : lines) {
			String[] fields = line.split("\t");
			books.add(new Book(fields[0], fields[1], Integer.parseInt(fields[2])));
		}
		return books;
	}
}
