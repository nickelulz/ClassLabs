import static java.lang.System.*;
import java.util.function.ObjIntConsumer;
import java.util.stream.*;

public class ListFunHouse 
{
	// this method will print the entire list on the screen
	public static void print(ListNode list) {
		stream(list).map(ListNode::getValue).forEach(e -> System.out.print(e + " "));
		System.out.println();
	}
	
	// this method will return the number of nodes present in list
	public static int nodeCount(ListNode list) {
		return (int) stream(list).count();
	}
		
	// this method will create a new node with the same value as the first node and add this
	// new node to the list. Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list) {
		list.setNext(new ListNode(list.getValue(), list.getNext()));
	}

	// this method will create a new node with the same value as the last node and add this
	// new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode start) {
		ListNode[] list = stream(start).toArray(ListNode[]::new);
		list[list.length-1].setNext(new ListNode(list[list.length-1].getValue(), null));
	}
		
	// method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list) {
		removeEveryXthNode(list, 2);
	}

	//t his method will set the value of every xth node in the list
	public static void setEveryXthNode(ListNode list, int x, Comparable value) {
		forEach(list, (node, index) -> {
			if (index % x == 1)
				node.setValue(value);
		});
	}

	// this method will remove every xth node in the list
	// Assume x > 1
	public static void removeEveryXthNode(ListNode start, int x) {
		ListNode[] list = (ListNode[]) stream(start).toArray(ListNode[]::new);
		for (int i = 1; i < list.length; i++)
			if (i % x == 1)
				list[i-1].setNext(i < list.length-1 ? list[i+1] : null);
	}

	public static void forEach(ListNode node, ObjIntConsumer<ListNode> action) {
		for (int index = 0; node != null; node = node.getNext(), index++)
			action.accept(node, index);
	}

	public static Stream<ListNode> stream(ListNode start) {
		Stream.Builder<ListNode> nodeStream = Stream.builder();
		for (ListNode node = start; node != null; node = node.getNext())
			nodeStream.add(node);
		return nodeStream.build();
	}
}