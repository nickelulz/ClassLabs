import java.util.*;
import static java.lang.System.*;

public class Permutation {
	private String orig;
	private String list;

	public Permutation(String word) {
		orig=word;
		list="";
	}

   public void permutation() {
	   out.println("\nPERMUTATION OF WORD :: "+orig);
	   permutation(orig,"");
   }

	private void permutation(String orig, String sent) {
		if (orig.isEmpty()) {
			list += sent + "\n";
			return;
		}

		for (int i = 0; i < orig.length(); i++)
			permutation(orig.substring(0, i) + orig.substring(i+1), sent + orig.charAt(i));
	}

   public String toString() {
	   return list;
   }
}