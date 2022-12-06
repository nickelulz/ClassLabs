public class Lab14c {
	public static void main (String[] args) {
		MonsterPQ test = new MonsterPQ();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.print("Enter the ht :: ");
			int height = in.nextInt();
			System.out.print("Enter the wt :: ");
			int weight = in.nextInt();
			System.out.println("Enter the age :: ");
			int age = in.nextInt();
			test.add(new Monster(height, weight, age));
		}
	}
}