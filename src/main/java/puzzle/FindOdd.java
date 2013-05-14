package puzzle;

public class FindOdd {

	/*
	 * It doesn't work in case of -ve integer
	 */
	static boolean isOddWrong(int i) {
		return (i % 2) == 1;
	}

	static boolean isOddRight(int i) {
		return (i % 2) != 0;
	}

	static boolean isOddEfficient(int i) {
		return (i & 1) == 1;
	}

	public static void main(String[] args) {
		System.out.println(isOddWrong(-21));
		System.out.println(isOddRight(-21));
		System.out.println(isOddRight(-21));
	}
}
