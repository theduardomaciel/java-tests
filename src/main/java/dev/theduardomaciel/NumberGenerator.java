package dev.theduardomaciel;

import java.util.List;
import java.util.SplittableRandom;

/*
* Para realizar Mocks com métodos estáticos, é necessário substituir a dependência "mockito-core" pela "mockito-inline".
* */

public class NumberGenerator {
	private static final SplittableRandom random = new SplittableRandom();
	
	private NumberGenerator() {
		throw new IllegalStateException("Utility class");
	}
	
	// O argumento "bound" é exclusivo, ou seja, o número gerado será menor que "bound"
	public static List<Integer> generateRandomNumbers(int size, int bound) {
		return random.ints(size, 0, bound).boxed().toList();
	}
	
	public static List<Integer> generateRandomNumbers(int size) {
		return random.ints(size).boxed().toList();
	}
	
	public static List<Integer> generateRandomNumbers() {
		return random.ints().boxed().toList();
	}
}
