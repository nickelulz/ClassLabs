import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class BasicList
{
   private ListNode front;
   private ListNode back;
   private int size;

	public BasicList() {
		front = null;
		back = null;
	}

   /* 
    * MODIFIER METHODS - methods that can change the list
    */
	public void add(Comparable insertItem) {
		// set front to new item
		if (front == null) {
			back = new ListNode(insertItem, back);
			front = back;
		} 

		// add to back
		else {
			ListNode temp = back;
			back = new ListNode(insertItem, null);
			temp.setNext(back);
		}

		size++;
	}

	public void addFirst(Comparable insertItem) {
		front = new ListNode(insertItem, front);
		if (back == null)
			back = front;

		size++;
	}

	public void addLast(Comparable insertItem) {
		back.setNext(new ListNode(insertItem, null));
	}

	public Comparable remove(int index) {
		ListNode toRemove = getElement(index-1); 
		removeAfter(toRemove);
		size--;
		return toRemove.getValue();
	}

	public boolean remove(Comparable o) {
		try {
			if (front.getValue().equals(o)) {
				front = front.getNext();
				return true;
			}

			ListNode found = null;
			for (ListNode node = front; node != null; node = node.getNext())
				if (node.getNext().getValue().equals(o))
					found = node.getNext();
			removeAfter(found);
			size--;

			return true;
		} 

		catch (IndexOutOfBoundsException ie) {
			return false;
		}
	}

	// This removes the node AFTER the one specified
	private Comparable removeAfter(ListNode before) throws IllegalStateException {
		if (before.getNext() == back) {
			before.setNext(null);
			back = before;
		}

		try {
			Comparable removed = before.getNext().getValue(); 
			before.setNext(before.getNext().getNext());
			return removed;
		} 

		catch (NullPointerException e) {
			throw new IllegalStateException();
		}
	}

	public Comparable removeFirst() {
		Comparable removed = front.getValue();
		front = front.getNext();
		size--;
		return removed;
	}

	public Comparable removeLast() {
		ListNode[] array = (ListNode[]) stream().toArray(ListNode[]::new);
		Comparable old = array[array.length-1].getValue();
		array[array.length-2].setNext(null);
		back = array[array.length-2];
		size--;
		return old;
	}

	public Comparable removeLast2() {
		ListNode beforeLast = front;
		for (; front.getNext() != last; front = front.getNext());
		try {
			Comparable old = removeAfter(beforeLast);
			size--;
			return old;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public Comparable set(int index, Comparable element) {
		boundsCheck(index);
		ListNode node = getElement(index);
		Comparable old = node.getValue();
		node.setValue(element);
		return old;
	}

	public void clear() {
		size = 0;
	}


   /*
    * ACCESSOR METHODS - methods that do not change the list
    */
   public boolean isEmpty() {
      return front == null;
   }

	public boolean equals(Object someList) {
		if (this == someList)
			return true;
		if (!(someList instanceof BasicList))
			return false;
		BasicList other = (BasicList) someList;
		if (this.size != other.size)
			return false;
		return this.front.equals(other.front); // recursive equals method
	}

	public boolean contains(Comparable o) {
		for (ListNode node = front; node != null; node = node.getNext())
			if (node.getValue().equals(o))
				return true;
		return false;
	}

	public Comparable get(int index) {
		boundsCheck(index);
		ListNode node = front;
		for (int _index = 0; _index < index && node != null; node = node.getNext(), _index++);
		return node.getValue();
	}

	public ListNode getElement(int index) {
		boundsCheck(index);
		ListNode node = front;
		for (int _index = 0; _index < index && node != null; node = node.getNext(), _index++);
		return node;
	}

	@SuppressWarnings("unchecked")
	public void boundsCheck(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size);
	}

	public Comparable getFirst() {
		return front.getValue();
	}

	public Comparable getLast() {
		return back.getValue();
	}

	public int size() {
		return size;
	}

	public void forEach(ObjIntConsumer consumer) {
		int index = 0;
		for (ListNode node = front; node != null; node = node.getNext(), index++)
			consumer.accept(node, index);
	}

	public Stream<ListNode> stream() {
		Stream.Builder<ListNode> stream = Stream.builder();
		for (ListNode node = front; node != null; node = node.getNext())
			stream.add(node);
		return stream.build();
	}
}