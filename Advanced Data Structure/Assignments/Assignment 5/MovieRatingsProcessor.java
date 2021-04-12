/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.*;

public class MovieRatingsProcessor {

	
	
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		if(movieRatings==null||movieRatings.isEmpty()) {
			ArrayList<String> alist=new ArrayList<>();
			return alist;
		}else {
			ArrayList<String> alist=new ArrayList<>(movieRatings.keySet());
			return alist;
		}
	}

	
	
	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		if(movieRatings==null||movieRatings.isEmpty()) {
			ArrayList<String> alist=new ArrayList<>();
			return alist;
		}
		ArrayList<String> movies = new ArrayList<>();
		for (String title : movieRatings.keySet()) {
			if (movieRatings.get(title).peek() > rating) {
				movies.add(title);
			}
		}
		return movies;
	}
	
	
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		if(movieRatings==null||movieRatings.isEmpty()) {
			TreeMap<String,Integer> emptymap=new TreeMap<>();
			return emptymap;
		}
		
		TreeMap<String,Integer> nmap=new TreeMap<>();
		
		
		Iterator<Map.Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, PriorityQueue<Integer>> entry = entries.next();
			
			Iterator<Integer> ratingsIT = entry.getValue().iterator();
			while (ratingsIT.hasNext()) {
				if (ratingsIT.next() < rating) {
		    		ratingsIT.remove();
		    		if (!nmap.containsKey(entry.getKey())) { 
		    			nmap.put(entry.getKey(), 1);
		    		} else {
		    			nmap.put(entry.getKey(), nmap.get(entry.getKey()) + 1);
		    		}
		    	}
			}
		    if (entry.getValue().isEmpty()) {
		    	entries.remove();
		    }
		}
		return nmap;
	}
}
