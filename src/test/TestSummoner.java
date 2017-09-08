package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Summoner;

public class TestSummoner {
	
	@Test
	public void testAction() {
		String testName = "A";
		int testHp = 300;
		int testAttack = 10;
		int testDefense = 5;
		Summoner test = new Summoner(testName, testHp, testAttack, testDefense);
		
		// Summon
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack + test.getSummonedMonster().getAttackBuff(), test.getAttack());
		assertEquals(testDefense + test.getSummonedMonster().getDefenseBuff(), test.getDefense());
		
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack + test.getSummonedMonster().getAttackBuff(), test.getAttack());
		assertEquals(testDefense + test.getSummonedMonster().getDefenseBuff(), test.getDefense());
		
		// Desummon
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack + test.getSummonedMonster().getAttackBuff(), test.getAttack());
		assertEquals(testDefense + test.getSummonedMonster().getDefenseBuff(), test.getDefense());
		
		// Desummon
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack, test.getAttack());
		assertEquals(testDefense, test.getDefense());
		
		// Cooldown ends
		
		// Summon again
		test.action(null);
		assertEquals(testName, test.getName());
		assertEquals(testHp, test.getHp());
		assertEquals(testAttack + test.getSummonedMonster().getAttackBuff(), test.getAttack());
		assertEquals(testDefense + test.getSummonedMonster().getDefenseBuff(), test.getDefense());
		
	}

}
