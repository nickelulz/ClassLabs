import java.util.ArrayList;
import static java.lang.System.*;

public class HeapSort
{
	private ArrayList<Integer> list;

	public 
	HeapSort (int[] input_array)
	{
		for (int input: input_array) {
			list.add(input);
			swapUp(input.size()-1);
		}
	}

	/*
	 * Private Modifiers
	 */

	private static int NOT_FOUND = -1;

	private int
	getLeftChild (int index) 
	{
		if (index < 0)
			return NOT_FOUND;
		return index * 2 + 1;
	}

	private int
	getRightChild (int index)
	{
		if (index < 0)
			return NOT_FOUND;
		return index * 2 + 2;
	}

	private int
	getLargestChild (int index)
	{
		int right = getRightChild(index);
		int left = getLeftChild(index);

		if (right == NOT_FOUND && left == NOT_FOUND)
			return NOT_FOUND;

		if (right == NOT_FOUND && !inBounds(left) || 
			left == NOT_FOUND && !inBounds(right) || 
			!inBounds(left) && !inBounds(right))
			return NOT_FOUND;

		if (right == NOT_FOUND)
			return left;

		if (left == NOT_FOUND)
			return right;

		if (list.get(right) > list.get(left))
			return right;

		return left;
	}

	private int
	getParent (int index) 
	{
		if (index <= 0)
			return NOT_FOUND;
		return index + 1 / 2; 
	}

	private boolean
	inBounds (int index)
	{
		return index >= 0 && index < list.size();
	}

	private void 
	swap (int indexA, int indexB)
	{
		if (inBounds(indexA) && inBounds(indexB))
		{
			int temp = list.get(indexA);
			list.set(indexA, list.get(indexB));
			list.set(indexB, temp);
		}
	}

	/* Swaps a heap member upwards using indices
	 * beginning at the bottom of the heap.
	 */

	private void 
	swapUp (int index)
	{
		int parent = getParent(index);

		if (inBounds(parent) && inBounds(index))
			System.out.println("swap: " + index + " " + list.get(index) + ", " + parent + " " + list.get(parent));

		while (parent != NOT_FOUND && 
			inBounds(parent) &&
			inBounds(index) &&
			list.get(index) > list.get(parent)) 
		{
			// Debug
			System.out.println("SWAPPING (c) " + list.get(index) + " and (p) " + list.get(parent));

			// Swap the indices
			swap(index, parent);

			// Set the current index to the parent index
			index = parent;

			// Advance to the next parent
			parent = getParent(index);
		}
	}

	private void 
	swapDown (int index)
	{
		int largestChild = getLargestChild(index);

		// Loops until it no longer has a largest child
		while (largestChild != NOT_FOUND &&
			inBounds(largestChild) && 
			inBounds(index) &&
			list.get(largestChild) > index)
		{
			// Swap the indices
			swap(index, largestChild);

			// Set the current index to the largest child index
			index = largestChild;

			// Advance to the next largest child
			largestChild = getLargestChild(index);
		}
	}

	public String 
	toString ()
	{
		return list.toString();
	}
}