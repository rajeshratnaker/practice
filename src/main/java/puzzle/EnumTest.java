package puzzle;

public class EnumTest {
	private static enum State {
		UnSubscribed, Subscribed, Waiting, Error
	}

	public static void main(String[] args) {
		int i = State.UnSubscribed.ordinal();
		System.out.println(i);

		State state = State.values()[i];
		String stateStr = state.toString();
		System.out.println(stateStr);
	}

}
