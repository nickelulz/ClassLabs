import java.util.ArrayList;

public class Heap
{
	private ArrayList<Integer> list;

	public 
	Heap () 
	{
		list = new ArrayList<>();
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

	/*
	 * Public Modifiers
	 */

	/* Add adds a new item in the very last spot in the tree (array spot lengthNOT_FOUND). 
	 * Add then calls swapUp to restructure the tree so that the new item is in the 
	 * proper location in the heap. swapUp first checks to see if the new item is 
	 * bigger than its parent. If it is, swapUp swaps the parent and the new item 
	 * and repeats the same process until the new item is in the root position or 
	 * it finds that the new item is not larger than its current parent.
	 */

	public void 
	add (int value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

	/* Remove copies the root to a variable and then moves the last value in the tree 
	 * to the root-array spot 0. Remove then calls swapDown to restructure the tree 
	 * and to check that the tree remains a heap. swapDown looks at the children of 
	 * the new root and determines which is larger. The larger of the children and the 
	 * new root are then swapped. This process continues until the bottom of the tree 
	 * is reached or there are no children larger than the current parent.
	 */

	public void
	remove ()
	{
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(0);
	}

	/*
	 * Public Accessors
	 */

	public void 
	print ()
	{
		System.out.println("PRINTING THE HEAP: " + toString());

		int x = 0;

		for (int i = 1; i < list.size(); i *= 2)
		{
			for (int s = 1; s < list.size()-i; s++)
				System.out.print(" ");

			for (int j = 0; j <= i-1 && x < list.size(); j++)
				System.out.print(list.get(x++) + "  ");

			System.out.println();

			if (x == list.size()-1)
				System.out.print(list.get(x++) + "  ");
		}

		System.out.println("\n");
	}

	public String 
	toString () 
	{
		return list.toString();
	}
}