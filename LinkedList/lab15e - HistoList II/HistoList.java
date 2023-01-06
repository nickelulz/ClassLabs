public class HistoList
{
	private ListNode front;

	public HistoList() {}

	// Adds a new node to the front of the list if it does not exist
	// If it does exist, it increments the counter at that node
	public void add(Object obj) {
		for (ListNode current = front; current != null; current = current.getNext()) {
			ThingCount elem = (ThingCount) current.getValue(); 
			if (elem.getThing().equals(obj)) {
				elem.setCount(elem.getCount()+1);
				return;
			}
		}

		front = new ListNode(new ThingCount(obj, 1), front);
	}

	// Returns the index of an element
	public int indexOf(Object obj) {
		int index = 0;
		for (ListNode iter = front; iter != null; iter = iter.getNext(), index++)
			if (((ThingCount) iter.getValue()).getThing().equals(obj))
				return index;
		return -1;
	}

	// Returns a reference to the node at an index
	private ListNode nodeAt(int index) {
		int i = 0;
		for (ListNode iter = front; iter != null; iter = iter.getNext(), i++)
			if (i == index)
				return iter;
		return null;
	}

	// Returns the list as a big string
	public String toString() {
		StringBuilder out = new StringBuilder();
		for (ListNode iter = front; iter != null; iter = iter.getNext()) {
			if (!(iter.getValue() instanceof ThingCount))
				continue;
			ThingCount thingNode = (ThingCount) iter.getValue();
			out.append(String.format("%s - %d\t\t", thingNode.getThing(), thingNode.getCount()));
		}
		return out.toString();
	}
}