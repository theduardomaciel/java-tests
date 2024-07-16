package dev.theduardomaciel.integration;

import dev.theduardomaciel.NumberGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class NumberGeneratorTest {
	@Test
	void testNumberGenerationWithSize() {
		MockedStatic<NumberGenerator> numberGeneratorMock = mockStatic(NumberGenerator.class);
		
		numberGeneratorMock.when(() -> NumberGenerator.generateRandomNumbers(10)).thenReturn(null);
		
		Assertions.assertNull(NumberGenerator.generateRandomNumbers(10));
	}
}
