package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Mage;
import logic.Novice;

public class TestMage {

	@Test
	public void testAction() {
		String testName = "A";
		int testHp = 300;
		int testAttack = 10;
		int testDefense = 5;
		Mage first = new Mage(testName, testHp, testAttack, testDefense);
		Novice second = new Novice(testName, testHp, testAttack, testDefense);
		Novice third = new Novice(testName, testHp, testAttack, testDefense);
		first.action(second);

		third.takeDamage(first.getAttack() - second.getDefense());
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
}
