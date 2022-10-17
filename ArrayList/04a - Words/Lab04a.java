import java.util.Arrays;
import static java.lang.System.*;

public class Lab04a
{
    public static void main(String[] args)
    {
        String[] tests = {
                "one two three four five six seven alligator",
                "fun fly four six times ten plus eight",
                "alligator chicken dog cat pig buffalo"
        };

        Arrays.stream(tests).forEach(Lab04a::test);
    }

    static void test(String t) {
        Words test = new Words(t);
        out.println(test);
        out.println("word with 2 vowels = "+test.countWordsWithXVowels(2));
        out.println("word with 3 vowels = "+test.countWordsWithXVowels(3));
        out.println("word with 4 vowels = "+test.countWordsWithXVowels(4));
        out.println("word with 2 chars = "+test.countWordsWithXChars(2));
        out.println("word with 4 chars = "+test.countWordsWithXChars(4));
        out.println("word with 5 chars = "+test.countWordsWithXChars(5));
        test.removeWordsWithXChars(3);
        out.println("\nafter removing words with 3 chars \n"+test);
        out.println("\n\n");
    }
}