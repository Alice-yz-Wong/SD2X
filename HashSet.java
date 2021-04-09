
public class HashSet {
	private String[] values;
	public HashSet(int size) {
		values=new String[size];
	}
	private int hashCode(String value) {
		return value.length();
	}
	
	public boolean add(String value) {
		int index=hashCode(value)%values.length;
		if(values[index]==null) {
			values[index]=value;
			return true;
		}`
		return false;
	}
}
