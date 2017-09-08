package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Novice;

public class TestNovice {
	
	private String testName = "A";
	private int testHp = 300;
	private int testAttack = 10;
	private int testDefense = 10;
	
	@Test
	public void testConstructorNormal() {
		for (int i = 1; i <= 10000; i++) {
			Novice test = new Novice("A", i, i, i);
			assertEquals("A", test.getName());
			assertEquals(i, test.getHp());
			assertEquals(i, test.getAttack());
			assertEquals(i, test.getDefense());
		}
	}
	
	@Test
	public void testConstructorException() {
		for (int i = 0; i >= -10000; i--) {
			Novice test = new Novice("A", i, i, i);
			assertEquals("A", test.getName());
			assertEquals(1, test.getHp());
			assertEquals(1, test.getAttack());
			assertEquals(1, test.getDefense());
		}
	}

	@Test
	public void testAction() {
		Novice first = new Novice(testName, testHp, testAttack, testDefense);
		Novice second = new Novice(testName, testHp, testAttack, testDefense);
		Novice third = new Novice(testName, testHp, testAttack, testDefense);
		first.action(second);
		third.takeDamage(first.getAttack() - second.getDefense());
		assertEquals(third.getHp(), second.getHp());
		
		assertEquals(testName, first.getName());
		assertEquals(testHp, first.getHp());
		assertEquals(testAttack, first.getAttack());
		assertEquals(testDefense, first.getDefense());
		
		assertEquals(testName, second.getName());
		assertEquals(testAttack, second.getAttack());
		assertEquals(testDefense, second.getDefense());
	}

	@Test
	public void testIsDefeated() {
		Novice test = new Novice(testName, testHp, testAttack, testDefense);
		while (test.getHp() > 0) {
			assertFalse(test.isDefeated());
			test.takeDamage(1);

			assertEquals(testName, test.getName());
			assertEquals(testAttack, test.getAttack());
			assertEquals(testDefense, test.getDefense());
		}
		assertTrue(test.isDefeated());
		assertEquals(testName, test.getName());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
	}
	
	@Test
	public void testRestoreHp() {
		Novice test = new Novice(testName, testHp, testAttack, testDefense);
		
		test.restoreHp();
		assertEquals(testHp, test.getHp());
		assertEquals(testName, test.getName());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		test.takeDamage(50);
		test.restoreHp();
		assertEquals(testHp, test.getHp());
		assertEquals(testName, test.getName());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		test.takeDamage(300);
		test.restoreHp();
		assertEquals(testHp, test.getHp());
		assertEquals(testName, test.getName());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
	}

	@Test
	public void testTakeDamageNormal() {
		Novice test = new Novice(testName, testHp, testAttack, testDefense);
		for (int i = 1; i <= 200; i++) {
			test.takeDamage(i);
			assertEquals(testHp - i, test.getHp());
			
			assertEquals(testName, test.getName());
			assertEquals(testAttack, test.getAttack());
			assertEquals(testDefense, test.getDefense());
			test.restoreHp();
		}
	}
	
	@Test
	public void testTakeDamageLessThanOne() {
		Novice test = new Novice(testName, testHp, testAttack, testDefense);
		for (int i = 0; i >= -200; i--) {
			test.takeDamage(i);
			assertEquals(testHp - 1, test.getHp());
			
			assertEquals(testName, test.getName());
			assertEquals(testAttack, test.getAttack());
			assertEquals(testDefense, test.getDefense());
			test.restoreHp();
		}
	}
	
	@Test
	public void testTakeDamageMoreThanHp() {
		Novice test = new Novice(testName, testHp, testAttack, testDefense);
		for (int i = testHp; i <= testHp + 1000; i++) {
			test.takeDamage(i);
			assertEquals(0, test.getHp());
			
			assertEquals(testName, test.getName());
			assertEquals(testAttack, test.getAttack());
			assertEquals(testDefense, test.getDefense());
			test.restoreHp();
		}
	}

}
