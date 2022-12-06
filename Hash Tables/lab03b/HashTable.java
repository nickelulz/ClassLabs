import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class HashTable {
   private LinkedList[] table;

   // If we were using Open Addressing, we'd start with a table size 1.3 x N and find the next prime.
   public HashTable(int size) {
      // size /= 4;
      // while (!isPrime(++size));
      table = new LinkedList[size];
   }

   public void add(Object obj) {
      // System.out.println("add");
      // Calculate the index of the bucket where it would be stored
      int index = obj.hashCode() % table.length;
      // If there isnt already a list there add one
      if (table[index] == null)
         table[index] = new LinkedList();
      // If the list at index doesnt already contains obj, add it to the list
      if (!table[index].contains(obj))
         table[index].add(obj);
   }

   public String toString() {
      String output = "HASHTABLE\n";
      for (int i = 0; i < table.length; i++) {
         output += "Bucket " + i + ": ";
         if (table[i] != null) {
            for (int a = 0; a < table[i].size(); a++)
               output += table[i].get(a) + " ";
         }
         output += "\n";
      }
      return output;
   }


   /*
    * Sieve of Eratosthenes is not the best solution when only one prime number should be found. 
    * Here is the solution which is useful for that purpose. It is based on the idea that all 
    * prime numbers are in form of 6k+-1, so I'm only testing 2, 3 and numbers in form 6+-1. 
    * Of course, the loop quits when divisor breaches sqrt(a) because all such numbers have already been tested.
   */
   boolean isPrime(int number) {
      if (number < 2)
         return false;
      if (number == 2 || number == 3)
         return true;
   
      if (number % 2 == 0 || number % 3 == 0)
         return false;
   
      int divisor = 6;
      // divisor * divisor - 2 * divisor + 1 is the same as Math.pow(divisor - 1, 2)
      // We could also have said:  divisor <= Math.sqrt(number) + 1
      // It's much cheaper computationally to simply write the d^2 - 2d + 1 like we did.
      while (divisor * divisor - 2 * divisor + 1 <= number) { 
         if (number % (divisor - 1) == 0)
            return false;
         if (number % (divisor + 1) == 0)
            return false;
         divisor += 6;
      }
      return true;
   }
}