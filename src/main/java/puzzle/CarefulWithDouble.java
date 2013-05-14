package puzzle;

public class CarefulWithDouble {
	public static void main(String[] args) {
		double total = 2.0;
		double cost = 1.1; // 1.1 can't be represented
		double changeBack = (2.0 - 1.1);
		System.out.println(changeBack);

		System.out.printf("%.2f%n", changeBack);
		System.out.println((200 - 110) + " pence");
	}
}

