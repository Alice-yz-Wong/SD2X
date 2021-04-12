//event request tracking system, add to the rear, remove from the front
import java.util.LinkedList;

public class Queue {
	protected LinkedList list=new LinkedList();
	
	public void add(Object value) {
		list.add(value);
	}
	
	public void remove() {
		if(list.isEmpty()) {
			return null;
		}
		return list.removeFirst();
	}

}
