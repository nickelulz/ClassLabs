public class Number
{
	private int theValue;
	
	public Number(int value) {
	}	
	
	public int getValue() {
		return theValue;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Number))
			return false;
		return theValue == ((Number) obj).theValue;
	} 
	
	public int hashCode() {
		return 0;
	}

	public String toString() {
		return String.valueOf(theValue);
	}	
}