import java.util.*;
import static java.lang.System.*;

public class Lab09e {
   public static void main(String args[]) {
      String[] test_cases = {
              "ABC",
              "abc",
              "boat",
              "it"
      };

      for (String s: test_cases)
         test(s);
   }

   static void test(String test) {
      Permutation p = new Permutation(test);
      p.permutation();
      System.out.println(p);
   }
}