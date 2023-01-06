import java.util.stream.ObjIntConsumer;

public class BasicList
{
   private ListNode front;
   private ListNode back;

	public BasicList() {
		front = null;
		back = null;
	}

   /* 
    * MODIFIER METHODS - methods that can change the list
    */
	public void add(Comparable insertItem) {
		if (front == null) {
			back = new ListNode(insertItem, back);
			front = back;
		} 

		else {
			ListNode temp = back;
			back = new ListNode(insertItem, null);
			temp.setNext(back);
		}
	}

	public void addFirst(Comparable insertItem) {
		front = new ListNode(insertItem, front);
		if (back == null)
			back=front;
	}

	public void addLast(Comparable insertItem) {}

	public Comparable remove(int index) {}

	public boolean remove(Comparable o) {}

	public Comparable removeFirst() {}

	public Comparable removeLast() {}

	public Comparable set(int index, Comparable element) {}

	public void clear() {}


   /*
    * ACCESSOR METHODS - methods that do not change the list
    */
   public boolean isEmpty() {
      return front == null;
   }

	public boolean equals(Comparable someList) {}

	public boolean contains(Comparable o) {}

	public Comparable get(int index) {}

	public Comparable getFirst() {}

	public Comparable getLast() {}

	public int size() {}

	public Stream<ListNode> stream() {

	}

	public void forEach(ObjIntConsumer consumer) {
		for (ListNode node = front;)
	}

	public String toString() {}
}