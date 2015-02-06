package yoshikihigo.cosinesimilarity;

import java.util.Random;

public class CosineSimilarity {

	public static void main(final String[] args) {

		final int dimension = 80;
		final int times = 100;
		final Random random = new Random();

		for (int i = 0; i < times; i++) {
			final int[] vector1 = new int[dimension];
			final int[] vector2 = new int[dimension];
			for (int j = 0; j < dimension; j++) {
				vector1[j] = random.nextInt(100);
				vector2[j] = random.nextInt(100);
			}
			final double similarity = calculate(vector1, vector2);
			System.out.println("vector1: " + toString(vector1));
			System.out.println("vector2: " + toString(vector2));
			System.out.println(Double.toString(similarity));
			System.out.println();
		}
	}

	private static String toString(int[] vector) {
		final StringBuilder text = new StringBuilder();
		for (final int element : vector) {
			text.append(element);
			text.append(",");
		}
		return text.toString();
	}

	public static double calculate(final int[] vector1, final int[] vector2) {

		if (null == vector1 || null == vector2) {
			return 0f;
		}

		if (vector1.length != vector2.length) {
			return 0f;
		}

		double dominator1 = 0d;
		for (final int element : vector1) {
			dominator1 += (double) (element * element);
		}
		if (0 == dominator1) {
			return 0d;
		}
		dominator1 = Math.sqrt(dominator1);

		double dominator2 = 0d;
		for (final int element : vector2) {
			dominator2 += (double) (element * element);
		}
		if (0 == dominator2) {
			return 0d;
		}
		dominator2 = Math.sqrt(dominator2);

		double numerator = 0d;
		for (int i = 0; (i < vector1.length) && (i < vector2.length); i++) {
			numerator += vector1[i] * vector2[i];
		}
		if (0 == numerator) {
			return 0d;
		}

		return numerator / (dominator1 * dominator2);
	}
}
