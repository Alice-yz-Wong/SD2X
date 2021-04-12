import java.util.LinkedList;
import java.util.Scanner;

public class numGame {
	
	LinkedList<Integer> numbers=new LinkedList<Integer>();
	Scanner in=new Scanner(System.in);
	int input=0;
	
	while (true) {
		System.out.print("pls enter a number: ");
		input=in.nextInt();
		if(input==0) {
			break;
		}
		numbers.add(input);
	}
	
	System.out.print("pls enter another num");
	input=in.nextInt();
	
	//check if numbers have been enters before
	if(numbers.countains(input)) {
		System.out.print(input+"is in the list");
	}else {
		System.out.print(input+"is not in the list");
	}
}