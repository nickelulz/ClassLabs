//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.ArrayList;
import static java.lang.System.*;

public class Heap<T extends Comparable<T>>
{
	private ArrayList<T> list;

	public Heap()
	{
		list = new ArrayList<T>();
	}

	public void add(T value)
	{
		list.add(value);
		swapUp(list.size()-1);
	}

   public void swapUp(int bot)
   {
	}

	public T remove( )
	{
		T ret = list.get(0);
		list.set(0,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(list.size());
		return ret;
	}

	public void swapDown(int top)
	{
	}
	
	private void swap(int start, int finish)
	{
	}
	
	public T peek()
	{
		return list.get(0);
	}
	
	public boolean isEmpty()
	{
		return false;
	}

	public void print()
	{
		out.println("\n\nPRINTING THE HEAP!\n\n");
      int x=0;
		for(int i=1; i<list.size();i*=2)
		{
			for(int s=1;s<list.size()-i;s++)
			{
		      out.print(" ");
			}
		   for(int j=0;j<=i-1&&x<list.size(); j++)
		   {
		   	out.print(list.get(x++)+"  ");
		   }
		   out.println();
		   if(x==list.size()-1)
		   {
		   	out.print(list.get(x++)+"  ");
		   }
		}
		out.println();
	}

	public String toString()
	{
		return list.toString();
	}
}