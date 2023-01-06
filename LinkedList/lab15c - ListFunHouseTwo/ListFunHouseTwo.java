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

		ListNode[] list = (ListNode[]) stream().toArray(ListNode[]::new);
		list[list.length-1].setNext(new ListNode(data, null));
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
		ListNode[] list = stream().toArray(ListNode[]::new);
		list[list.length-1].setNext(new ListNode(list[list.length-1].getValue(), null));
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
		ListNode[] list = (ListNode[]) stream().toArray(ListNode[]::new);
		for (int i = 1; i < list.length; i++)
			if (i % x == 1)
				list[i-1].setNext(i < list.length-1 ? list[i+1] : null);
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

	public Stream<ListNode> stream() {
		Stream.Builder<ListNode> nodeStream = Stream.builder();
		for (ListNode node = theList; node != null; node = node.getNext())
			nodeStream.add(node);
		return nodeStream.build();
	}
}