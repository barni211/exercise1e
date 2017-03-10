package wdsr.exercise1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testModuloByZero() {
		doThrow(new IllegalArgumentException()).when(calculator).modulo(anyInt(), eq(0));
		
		calculator.modulo(3, 0);
		
		// when
		//
	}

	@Test
	public void testModulo16By4() {
		doReturn(0).when(calculator).modulo(anyInt(), anyInt());

		// when
		String result = calcUtil.getModuloText(16, 4);

		// then
		assertEquals("16 % 4 = 0", result);
		verify(calculator).modulo(anyInt(), anyInt()); // check if our calculator mock was really invoked.
	}
}
