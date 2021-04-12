package W2;

public class Heap {
	int[] values;
	int size=0;
	
	public Heap(int maxHeight) {
		values=new int[(int) (Math.pow(2, maxHeight)-1)];
	}
	
	public void swapValue(int index1, int index2) {
		int temp=values[index1];
		values[index1]=values[index2];
		values[index2]=temp;
	}
	
	public void addValue(int val) {
		if(size==values.length) {
			throw new HeapException();
		}
		values[size]=val;
		bubbleUp(size);
		size++;
	}
	
	public void bubbleUp(int index) {
		if(index==0) return;
		int parentIndex=(index-1)/2;
		if(values[parentIndex]<values[index]) {
			swapValue(index,parentIndex);
			bubbleUp(parentIndex);
		}
	}
	
	public void removemaxValue() {
		if(size==0) {
			throw new HeapException();
		}
		int extractMax=value[0];
		values[0]=values[size-1];
		bubbleDown(0);
		size-=1;
		return extractMax;
	}
	
	public void bubbleDown(int index) {
		int greaterChild;
		int leftIndex=(index*2)+1;
		int rightIndex=(index*2)+2;
		
		//check right index within bound
		if(rightIndex<size&&values[rightIndex]>values[leftIndex]) {
			greaterChild=rightIndex;
			
		//left child is greater
		}else if(leftIndex==size) {
			greaterChild=leftIndex;
		}else return;
		
		if(values[index]<values[greaterChild]) {
			swapValue(index,greaterChild);
			bubbleDown(greaterChild);
		}
		
	}
	

}
