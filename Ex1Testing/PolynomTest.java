package Ex1Testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Polynom_able;
import Ex1.function;

class PolynomTest {
	
	@Test
	void DerivativeTest() {
	Polynom p1 = new Polynom("2x+2x^2");
	Polynom expected = new Polynom("2+4x");
	assertEquals(expected, p1.derivative());
	}
	
	@Test 
	void testZero() {
		Polynom p1 = new Polynom("0");
		assertTrue("check if the polynom is zero",p1.isZero());

		Polynom p2 = new Polynom("5x");
		assertFalse("check if the polynom is not zero",p2.isZero());		
	}
	
	@Test
	void testAdd() {
		Polynom p1 = new Polynom();
		String monoms[] =	{"3","3x","2x","x^7"}; 
		for (int i = 0; i < monoms.length; i++) {
			Monom m = new Monom(monoms[i]);
			p1.add(m);
		}
		Polynom expected = new Polynom("3+3x+2x+x^7");
		assertEquals(expected, p1);
	}
	
	@Test
	void testMultiplyMonom() {
		Polynom p1 = new Polynom("2+3x+5x^3-x^2");
		Polynom expected = new Polynom("4x+6x^2+10x^4-2x^3");
		Monom m1 = new Monom("2x");
		p1.multiply(m1);
		assertEquals(expected,p1);
	}
	
	@Test 
	void testMuiltiplyPolynom() {
		Polynom p1 = new Polynom("2+x^2");
		Polynom p2 = new Polynom("x+3");
		Polynom expected = new Polynom("2x+6+x^3+3x^2");
		p1.multiply(p2);
		assertEquals(p1, expected);
	}
	
	@Test
	void testCopy() {
		Polynom p1 = new Polynom("2+3x+5x^3-x^2");
		function p2 = p1.copy();
		assertTrue(p1.equals(p2), "check the copy in the polynom class" );
		
	}
}