import static java.lang.System.*;

class SiteName implements Comparable<SiteName> {
    private String name, domain;

    public SiteName(String full) {
        String[] tokens = full.split(".");
        name = tokens[0];
        domain = tokens[1];
    }
    public int compareTo(SiteName other) {
        if (!this.domain.equals(other.domain))
            return other.domain.compareTo(this.domain);
        return this.name.compareTo(other.name);
    }

    public String toString() {
        return name + "." + domain;
    }
}