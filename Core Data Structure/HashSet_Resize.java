import java.util.LinkedList;

public class HashSet_Resize {
	private LinkedList<String>[] buckets;
	private int currentsize=0;
	private double loadFactor;
	
	
	public void HashSet2(int size) {
		buckets=new LinkedList[size];
		for(int i=0;i<size;i++) {
			buckets[i]=new LinkedList<String>();
		}
	}
	
	
	private int hashCode(String value) {
		return value.length();	
	}
	
	
	public boolean addValue(String value) {
		if(!containValue(value)) {
			int index=hashCode(value)%buckets.length;
			LinkedList<String> bucket=buckets[index];
			bucket.addFirst(value);
			currentsize++;
			
			double averageLoad=currentsize/(double)buckets.length;
			if(averageLoad>loadFactor) {
				reinsertAll();
			}
			
			return true;
		}
		return false;
	}
	
	
	private void reinsertAll() {
		LinkedList<String> oldBuckets[]=buckets;
		buckets=new LinkedList[buckets.length*2];
		
		for(LinkedList<String> bucket:oldBuckets) {
			for(String element:bucket) {
				int index=hashCode(element)%buckets.length;
				LinkedList<String> newBucket=buckets[index];
				newBucket.addFirst(element);
			}
		}
	}

	
	public boolean containValue(String value) {
		int index=hashCode(value)%buckets.length;
		LinkedList<String> bucket=buckets[index];
		return bucket.contains(value);
	}
}
