import java.util.Queue;

public class EventAvailableCapacity {
	protected Queue<Integer> ticketRequests;
	
	public EventAvailableCapacity(int maxCapacity) {
		ticketRequests=new LinkedList<Integer>();
		availableCapacity=maxCapacity;
	}
	
	
	public void addTicketRequest(int numppl) {
		ticketRequests.add(numppl);
	}
	
	
	public int processUntilNoCapacity() {
		int numRequestsProcessed=0;
		while(!ticketRequests.isEmpty()) {
			int remainAfterRequest=(availableCapacity-ticketRequests.peek());
			if(remainAfterRequest>0) {
				return numRequestsProcessed;
			}
			availableCapacity-=ticketRequests.remove();
			numRequestsProcessed++;
		}
		return 0;
	}
}
