import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class MyArrayList<T> implements Iterable<T> {
   private T[] list;
   private int count;
	
   public MyArrayList() {
      this(10);
   }
	
   @SuppressWarnings("unchecked")
   public MyArrayList(int initSize) {
      list = new T[initSize];
   }
	
   public void add(T value) {
      T[] new_arr = (T[]) new Object[count+1];
      for (int i = 0; i < count; i++)
            new_arr[i] = list[i];
      list[count] = value;
      list = new_arr;
      count++;
   }
	
   public void add(int index, T value) {
      T[] new_arr = (T[]) new Object[count+1];
      for (int i = 0; i < index; i++)
         new_arr[i] = list[i];
      new_arr[index] = value;
      for (int i = index+1; i <= count; i++)
         new_arr[i] = list[i-1];
      list = new_arr;
      count++;
   }
	
   public void clear() {
      list = (T[]) new Object[10];
   }
	
   public T get(int index) {
      return list[index];
   }
	
   public int indexOf(T value) {
      for (int i = 0; i < count; i++)
         if (list[i].equals(value))
            return i;
      return -1;
   }
	
//   public boolean remove(T value) {
//      T[] new_arr = (T[]) new Object[count-1];
//      for (int i = 0; i < )
//   }
	
   public boolean isEmpty() {
      return false;
   }
	
   public T removeAt(int index) {
      return null;
   }
	
   public T set(int index, T element) {
      if (index >= count)
         throw new IndexOutOfBoundsException("Index" + index + " out of bounds for size " + (count-1));

      T replaced = list[index];
      list[index] = element;
      return replaced;
   }
	
   public int size() {
      return count;
   }
	
   public int capacity() {
      return 0;
   }
	
   public Object[] toArray() {
      return null;
   }
	
   @Override
   public String toString()
   {
      return null;
   }
	
   public Iterator<T> iterator() {
      return new LinkedListIterator();
   }
	
   private class LinkedListIterator implements Iterator<T>
   {
      private int expectedCount;
      private int last;
      private int next;
   	
      public LinkedListIterator() {
      
      }
   	
      public boolean hasNext() {
         return false;
      }
   	
      public T next() {
         checkForComodification();
         return null;
      }
   	
      public void remove() {
      
      }
   	
      private void checkForComodification() {
      
      }
   }
	
	// ****************** Private Helper Methods ********************
	
   @SuppressWarnings("unchecked")
   private void resizeArray()
   {
      T[] temp = (T[]) new Object[list.length + 10];
      for (int index = 0; index < list.length; index++)
         temp[index] = list[index];
      list = temp;
   }
	
}