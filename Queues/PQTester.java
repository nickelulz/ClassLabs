import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.List;

public class PQTester {
	private Queue<String> priorityQueue;
	private List<String> originalOrder;

	public PQTester() {
		priorityQueue = new PriorityQueue<>();
	}

	public PQTester(String list) {
		setPQ(list);
	}

	public void setPQ(String list) {
		originalOrder = Arrays.asList(list.split(" "));
		priorityQueue = new PriorityQueue<>(originalOrder);
	}
	
	public Object getMin() {
		return priorityQueue.peek();	
	}
	
	public String getNaturalOrder() {
		return priorityQueue.toString().replaceAll("[\\[\\],]","");
	}

	@Override
	public String toString() {
		return priorityQueue.toString();
	}
}