package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.SummonedMonster;

public class TestSummonedMonster {
	
	@Test
	public void testConstructor() {
		SummonedMonster monster = new SummonedMonster();
		assertEquals(3, monster.getLifeTime());
		assertEquals(8, monster.getAttackBuff());
		assertEquals(8, monster.getDefenseBuff());
	}
	
	@Test
	public void testDecreaseLifeTime() {
		SummonedMonster monster = new SummonedMonster();
		int lifeTime = monster.getLifeTime();
		int attackBuff = monster.getAttackBuff();
		int defenseBuff = monster.getDefenseBuff();
		while (monster.getLifeTime() > 0) {
			lifeTime--;
			monster.decreaseLifeTime();
			assertEquals(lifeTime, monster.getLifeTime());
			assertEquals(attackBuff, monster.getAttackBuff());
			assertEquals(defenseBuff, monster.getDefenseBuff());
		}
	}

}
