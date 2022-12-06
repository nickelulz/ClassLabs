import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class MonsterPQ {
	private Queue<Monster> pqueue;

	{
		pqueue = new PriorityQueue();
	}

	public void add(Monster obj) {
		pqueue.add(obj);
	}
	
	public Object getMin() {
		return pqueue.element();
	}
	
	public Object removeMin() {
		return pqueue.remove();
	}
	
	public String getNaturalOrder() {
		return pqueue.toString().replaceAll("[\\[\\],]", "");	
	}

	public String toString() {
		return pqueue.toString();
	}
}