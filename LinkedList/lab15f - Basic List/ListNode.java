public class ListNode implements Linkable
{
	private Comparable listNodeValue;
	private ListNode nextListNode;

	public ListNode() {
		listNodeValue = null;
		nextListNode = null;
	}

	public ListNode(Comparable value, ListNode next) {
		listNodeValue = value;
		nextListNode = next;
	}

	public Comparable getValue() {
		return listNodeValue;
	}

	public ListNode getNext() {
	   return nextListNode;
	}

	public void setValue(Comparable value) {
		listNodeValue = value;
	}

	public void setNext(Linkable next) {
		nextListNode = (ListNode) next;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ListNode))
			return false;
		ListNode other = (ListNode) obj;
		return this.listNodeValue.equals(other.listNodeValue) && 
			((this.nextListNode == null) ? this.nextListNode == other.nextListNode : this.nextListNode.equals(other.nextListNode)); 
	}
}