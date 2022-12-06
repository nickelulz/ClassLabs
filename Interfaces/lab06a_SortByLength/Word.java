import static java.lang.System.*;

public class Word implements Comparable<Word>
{
    private String str;

    public Word(String str) {
        this.str = str;
    }

    public int compareTo(Word other) {
        return this.str.length()- other.str.length();
    }

    public String toString() {
        return str;
    }
}