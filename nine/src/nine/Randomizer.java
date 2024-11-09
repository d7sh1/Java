package nine;

public class Randomizer {
	public static int getInt(int min, int max) {
		int n = (int)(Math.random() * ((max - min) + 1)) + min;
		return n;
	}
}
