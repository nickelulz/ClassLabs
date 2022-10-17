public class GCF {
	public static int gcf(int n1, int n2) {
		int rem = n1 % n2;
		if(rem == 0)
			return n2;
		return gcf(n2,rem);
	}
}