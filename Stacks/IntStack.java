import java.util.*;
import java.util.stream.*;
import java.io.*;

public class IntStack {
	private ArrayList<Integer> int_list;

	public IntStack() {
		int_list = new ArrayList<>();
	}

	public void push(int item) {
		int_list.add(item);
	}

	public int pop() {
		return int_list.size() > 0 ? int_list.remove(int_list.size()-1) : 0;
	}

	public boolean isEmpty() {
		return int_list.isEmpty();
	}

	public int peek() {
		return int_list.get(int_list.size()-1);
	}

	public String toString() {
		return int_list.toString();
	}
}