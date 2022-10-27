import static java.lang.System.*;

public class Word implements Comparable<Word>
{
    private String str;

    public Word(String str) {
        this.str = str;
    }

    public int compareTo(Word other) {
        this.str.compareTo(other.str);
    }

    public String toString() {
        return str;
    }
}