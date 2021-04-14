import java.util.Scanner;
import java.util.Set;

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	private Scanner scanner=new Scanner(System.in);

	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	

	public void start() {
		System.out.println("Would you want to find book titles by author or find number of books in year? Please type in 1 for finding book titles by author and type in 2 for find number of books in year.");
		String input=scanner.nextLine();
		if(input.equals("1")){
			showBookTitlesByAuthor();
		}else if(input.equals("2")){
			showNumberOfBooksInYear();
		}else{
			System.out.println("out of bound error");
		}

	}
	
	public void showBookTitlesByAuthor(){
		System.out.println("which author");
		String author=scanner.nextLine();
		Set<String> books=logicTier.findBookTitlesByAuthor(author);
		System.out.println("Books by"+author+" : ");
		for(String book:books){
			System.out.println(book);
		}
	}


	public void showNumberOfBooksInYear(){
		System.out.println("which year");
		String year=scanner.nextLine();
		int booknum=logicTier.findNumberOfBooksInYear(Integer.parseInt(year));
		System.out.println("There are "+booknum+" in "+year);
	}
	

}
