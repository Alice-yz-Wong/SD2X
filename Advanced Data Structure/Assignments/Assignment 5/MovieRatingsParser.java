/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	@SuppressWarnings("null")
	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String,PriorityQueue<Integer>> tmap=new TreeMap<>();
		
		if(allUsersRatings==null||allUsersRatings.isEmpty()) return tmap;
		
		for(UserMovieRating rating: allUsersRatings) {
			//parseMovieRatings should ignore that UserMovieRatings object:
			//1.If the input List is null or empty, parseMovieRatings should return an empty TreeMap
			//2.If the input List contains any null UserMovieRatings object, 
			//3.or a UserMovieRatings object whose movie title is null or an empty string, 
			//4.or a UserMovieRatings object whose rating is negative, 
			if(rating!=null||rating.getMovie()!=null||!rating.getMovie().isEmpty()||rating.getUserRating()<0) {
				//The movie titles should be considered case-insensitive----all lower case
				String mtitle = rating.getMovie().toLowerCase();
				
				if(!tmap.containsKey(mtitle)) {
					//add new
					PriorityQueue<Integer> ratings=new PriorityQueue<>();
					ratings.add(rating.getUserRating());
					tmap.put(mtitle,ratings);
				}else {
					//exist, add ratings only
					tmap.get(mtitle).add(rating.getUserRating());
				}
			}
		}
		
		return tmap;
	}

}
