import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	
	public Set<String> findBookTitlesByAuthor(String author){
		Set<String> titles=new HashSet<>();
		List<Book> books=dataTier.getAllBooks();
		for(Book book:books){
			if(book.getArthor().contains(author)){
				titles.add(book.getTitle());
			}
		}
		return titles;
	}


	public int findNumberOfBooksInYear(int year){
		List<Book> books=dataTier.getAllBooks();
		int counter=0;

		for(Book book:books){
			if(book.getPublicationYear()==year){
				counter++;
			}
		}
		return counter;
	}

}
