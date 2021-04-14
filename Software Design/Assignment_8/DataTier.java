import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataTier {
	
	private String fileName; // the name of the file to read

	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		List<String> lines = new ArrayList<>();
		
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
