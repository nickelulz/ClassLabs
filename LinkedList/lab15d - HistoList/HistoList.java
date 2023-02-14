import java.util.*;
import static java.lang.System.*;
import java.util.function.*;

public class HistoList
{
   private HistoNode front;

	// add a new node to the front for let if let does not exist
	// bump up the count if let already exists
	public void addLetter(char let) {
		if (front == null) {
			front = new HistoNode(let, 1, null);
			return;
		}

		for (HistoNode current = front; current != null; current = current.getNext()) {
			if (current.getLetter() == let) {
				current.setLetterCount(current.getLetterCount()+1);
				return;
			}
		}

		front = new HistoNode(let, 1, front);
	}

	// returns the index pos of let in the list if let exists
	public int indexOf(char let) {
		int index = 0;
		for (HistoNode node = front; node != null; node = node.getNext(), index++)
			if (node.getLetter() == let)
				return index;
		return -1;
	}

	// returns a reference to the node at spot
	private HistoNode nodeAt(int spot) {
		HistoNode node = front; 
		int index = 0;
		while (index < spot) {
			node = node.getNext();
			index++;
		}
		return node;
	}

	// returns a string will all values from list
	public String toString() {
		String out = "";
		for (HistoNode node = front; node != null; node = node.getNext())
			out += node.getLetter() + " - " + node.getLetterCount() + "\t";
		return out;
	}
}