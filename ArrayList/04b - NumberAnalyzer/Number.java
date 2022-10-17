public class Number
{
	private Integer number;

	public Number() {
		setNumber(0);
	}

	public Number(int num) {
		setNumber(num);
	}
	
	public void setNumber(int num) {
		this.number = num;
	}
	
	public int getNumber() {
		return number;
	}	
	
	public boolean isOdd() {
		return number % 2 == 1;
	}
	
	public boolean isPerfect() {
		int total = 0;

		for (int n = 1; n < number; n++)
			if (number % n == 0)
				total += n;

		return number == total;
	}	
	
	public String toString() {
		return number.toString();
	}
}