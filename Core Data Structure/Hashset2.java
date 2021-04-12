import java.util.LinkedList;

public class Hashset_LinkedList{
	private LinkedList<String>[] buckets;
	
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
			return true;
		}
		return false;
	}
	
	public boolean containValue(String value) {
		int index=hashCode(value)%buckets.length;
		LinkedList<String> bucket=buckets[index];
		return bucket.contains(value);
	}
}
