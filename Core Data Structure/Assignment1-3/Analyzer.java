import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;


/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		
		List<Sentence> sentences= new ArrayList<>();
		List<String> lines=new ArrayList<>();
		
		//get files
		try {
			lines = Files.lines(Paths.get(filename)).collect(Collectors.toList());
		
		//return empty list if file is null
		} catch (Exception e) {
			return new ArrayList<Sentence>(); 
		}
		
		//parse through lines
		for(String line:lines) {
			int index=line.indexOf("");
			try {
				int score=Integer.parseInt(line.substring(0,index));
				String text = line.substring(index + 1); 
				if (score <= 2 && score >= -2 && !text.isEmpty()) { 
					sentences.add(new Sentence(score, text));
				}
			} catch(Exception e) {
				continue;
			}
		}
		return sentences;

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
        List<Word> wordList = new ArrayList<>(); 
		
		if (!(sentences == null || sentences.isEmpty())) { // sentences list not null or empty
			for (Sentence sentence : sentences) {
				if (sentence != null) {
					String[] tokens = sentence.getText().toLowerCase().split(" ");
					for (String token : tokens) {
						if (Character.isLetter(token.charAt(0))) { // token starts with a letter
							Word word = new Word(token);
							word.increaseTotal(sentence.getScore());
							
							if (wordList.contains(word)) {
								wordList.get(wordList.indexOf(word)).increaseTotal(word.getTotal()); // update word 
							} else {
								wordList.add(word);
							}
						}
					}
				}
			}
		}
		return new HashSet<Word>(wordList);
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> map = new HashMap<String, Double>();
		if (words != null && !words.isEmpty()) {
			for (Word word : words) {
				if (word != null) {
					map.put(word.text, word.calculateScore());
				}
			}
		}
		return map;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double score=0;
		int count=0;
		
		
		if (!(wordScores == null || wordScores.isEmpty() 
				|| sentence == null || sentence.isEmpty())) {
			String[] tokens = sentence.toLowerCase().split(" ");
			for (String token : tokens) {
				if (Character.isLetter(token.charAt(0))) { // token starts with a letter
					if (wordScores.containsKey(token)) {
						score += wordScores.get(token);
					}
					count++;
				}
			}
		}
		
		return count == 0 ? 0 : score / count; 
	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
