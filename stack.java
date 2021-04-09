import java.uil.LinkedList;

public class stack {
	protected LinkedList list=new LinkedList();
	
	public void push(Object value) {
		list.addFirst(value);
	}
	
	public void pop() {
		if(list.isEmpty()) {
			return null
		}
		return list.removeFirst();
	}
	
	public Object peek() {
		return list.getFirst();
	}
}
