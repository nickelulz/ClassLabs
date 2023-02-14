import static java.lang.System.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class ListFunHouseTwo
{
	private ListNode theList;
	
	public void add(Comparable data) {
		if (theList == null) {
			theList = new ListNode(data, null);
			return;
		}

		getEnd().setNext(new ListNode(data, null));
	}

	public ListNode getEnd() {
		ListNode node = theList;
		while (node.getNext() != null)
			node = node.getNext();
		return node;
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount() {
		return (int) stream().count();
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst() {
		theList.setNext(new ListNode(theList.getValue(), theList.getNext()));
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast() {
		ListNode end = getEnd();
		end.setNext(new ListNode(end.getValue(), null));
	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther() {
		removeXthNode(2);
	}

	//this method will set the value of every xth node in the list
		public void setXthNode(int x, Comparable value) {
		forEach((node, index) -> {
			if (index % x == 1)
				node.setValue(value);
		});
	}

	//this method will remove every xth node in the list
	public void removeXthNode(int x) {
		ListNode node = theList;
		int i = 0;
		while (node != null) {
			if (i % x == 1)
				removeAfter(node);
			node = node.getNext();
		}
	}

	private void removeAfter(ListNode before) {
		if (before.getNext() == null)
			return;

		before.setNext(before.getNext().getNext());
	}

	//this method will return a String containing the entire list
	public String toString() {
		StringBuilder string = new StringBuilder("[");
		forEach((e, i) -> string.append(e.getValue() + ", "));
		return string.toString().substring(0, string.toString().length()-2) + "]";
	}

	public void forEach(ObjIntConsumer<ListNode> action) {
		int index = 0;
		for (ListNode node = theList; node != null; node = node.getNext(), index++)
			action.accept(node, index);
	}
}