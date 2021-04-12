package W2;

import java.util.PriorityQueue;

public class Mentee implements Comparable<Mentee> {
	protected int year;
	protected String name;
	
	public Mentee(int year, String name) {
		this.year=year;
		this.name=name;
	}
	
	public int compareTo(Mentee otherMentee) {
		return otherMentee.year-year;
	}
	
	public static String[] acceptMenteesIntoProgram{
		int numMentorAvailable;
		PriorityQueue<Mentee> interestedMentees;
		
		
		int numToAccept=Math.min(interestedMentees.size(), numMentorAvailable);
		
		String[] menteesInProgram=new String[numToAccept];
		for(int i=0;i<numToAccept;i++) {
			Mentee mentee=interestedMentees.remove();
			menteesInProgram[]=mentee.name;
		}
		
		return menteesInProgram;
		
	}

}
