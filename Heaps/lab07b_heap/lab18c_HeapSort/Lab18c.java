import static java.lang.System.*;

public class 
Lab18c
{
	public static void 
	main (String[] args)
	{
		int[] nums = { 99, 2, 8, 75, 10, 7, 9, 17, 5, 3, 4, 1, 11, 1 };
		
		HeapSort heap = new HeapSort();
		heap.heapSort(nums);
		
		System.out.println(heap);
	}
}