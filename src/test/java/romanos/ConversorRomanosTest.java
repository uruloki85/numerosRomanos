package romanos;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConversorRomanosTest {

	@Test
	public void test1() {
		// given
		int entrada = 1;
				
		// when
		String numeroRomano = ConversorRomanos.aNumeroRomano(entrada);
		
		// then
		assertEquals("I", numeroRomano);
		
	}
	
	@Test
	public void test2() {
		assertEquals("II", ConversorRomanos.aNumeroRomano(2));
	}
	
	@Test
	public void test3() {
		assertEquals("III", ConversorRomanos.aNumeroRomano(3));
	}
	
	@Test
	public void test4() {
		assertEquals("IV", ConversorRomanos.aNumeroRomano(4));
	}
	
	@Test
	public void test5() {
		assertEquals("V", ConversorRomanos.aNumeroRomano(5));
	}
	
	@Test
	public void test6() {
		assertEquals("VI", ConversorRomanos.aNumeroRomano(6));
	}
	
	@Test
	public void test7() {
		assertEquals("VII", ConversorRomanos.aNumeroRomano(7));
	}
	
	@Test
	public void test8() {
		assertEquals("VIII", ConversorRomanos.aNumeroRomano(8));
	}
	
	@Test
	public void test9() {
		assertEquals("IX", ConversorRomanos.aNumeroRomano(9));
	}
	
	@Test
	public void test10() {
		assertEquals("X", ConversorRomanos.aNumeroRomano(10));
	}
	
	@Test
	public void test11() {
		assertEquals("XI", ConversorRomanos.aNumeroRomano(11));
	}
	
	@Test
	public void test14() {
		assertEquals("XIV", ConversorRomanos.aNumeroRomano(14));
	}
	
	@Test
	public void test17() {
		assertEquals("XVII", ConversorRomanos.aNumeroRomano(17));
	}
	
	@Test
	public void test19() {
		assertEquals("XIX", ConversorRomanos.aNumeroRomano(19));
	}
	
	@Test
	public void test20() {
		assertEquals("XX", ConversorRomanos.aNumeroRomano(20));
	}
	
	@Test
	public void test23() {
		assertEquals("XXIII", ConversorRomanos.aNumeroRomano(23));
	}
	
	@Test
	public void test25() {
		assertEquals("XXV", ConversorRomanos.aNumeroRomano(25));
	}
	@Test
	public void test26() {
		assertEquals("XXVI", ConversorRomanos.aNumeroRomano(26));
	}
	
	@Test
	public void test29() {
		assertEquals("XXIX", ConversorRomanos.aNumeroRomano(29));
	}
	
	@Test
	public void test54() {
		assertEquals("LIV", ConversorRomanos.aNumeroRomano(54));
	}
	
	@Test
	public void test112() {
		assertEquals("CXII", ConversorRomanos.aNumeroRomano(112));
	}
	
	@Test
	public void test155() {
		assertEquals("CLV", ConversorRomanos.aNumeroRomano(155));
	}
	
	@Test
	public void test179() {
		assertEquals("CLXXIX", ConversorRomanos.aNumeroRomano(179));
	}
	
	@Test
	public void test249() {
		assertEquals("CCXLIX", ConversorRomanos.aNumeroRomano(249));
	}
	
	@Test
	public void test423() {
		assertEquals("CDXXIII", ConversorRomanos.aNumeroRomano(423));
	}
	
	@Test
	public void test467() {
		assertEquals("CDLXVII", ConversorRomanos.aNumeroRomano(467));
	}
	
	@Test
	public void test500() {
		assertEquals("D", ConversorRomanos.aNumeroRomano(500));
	}
	
	@Test
	public void test599() {
		assertEquals("DXCIX", ConversorRomanos.aNumeroRomano(599));
	}
	
	@Test
	public void test669() {
		assertEquals("DCLXIX", ConversorRomanos.aNumeroRomano(669));
	}
	
	@Test
	public void test791() {
		assertEquals("DCCXCI", ConversorRomanos.aNumeroRomano(791));
	}
	
	@Test
	public void test820() {
		assertEquals("DCCCXX", ConversorRomanos.aNumeroRomano(820));
	}
	
	@Test
	public void test1000() {
		assertEquals("M", ConversorRomanos.aNumeroRomano(1000));
	}
	
	@Test
	public void test1999() {
		assertEquals("MCMXCIX", ConversorRomanos.aNumeroRomano(1999));
	}
	
	@Test
	public void test2013() {
		assertEquals("MMXIII", ConversorRomanos.aNumeroRomano(2013));
	}
	
	@Test
	public void test2999() {
		assertEquals("MMCMXCIX", ConversorRomanos.aNumeroRomano(2999));
	}
	
	@Test
	public void test3000() {
		assertEquals("MMM", ConversorRomanos.aNumeroRomano(3000));
	}
	
}
