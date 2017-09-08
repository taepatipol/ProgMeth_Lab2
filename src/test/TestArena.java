package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Arena;
import logic.Novice;
import logic.Mage;
import logic.Summoner;

public class TestArena {

	private Novice a = new Novice("A", 100, 100, 100);
	private Novice b = new Mage("B", 100, 100, 100);
	private Novice c = new Summoner("C", 100, 100, 100);
	private Novice d = new Novice("D", 1, 1, 1);
	private Novice e = new Mage("E", 1, 1, 1);
	private Novice f = new Summoner("F", 1, 1, 1);

	@Test
	public void testFightFirstWins() {
		Arena testArena = new Arena();
		testArena.addNovice(a);
		testArena.addNovice(b);
		testArena.addNovice(c);

		testArena.addNovice(d);
		assertEquals(a, testArena.fight(a, d));
		assertEquals(100, a.getHp());

		testArena.addNovice(e);
		assertEquals(a, testArena.fight(a, e));
		assertEquals(100, a.getHp());

		testArena.addNovice(f);
		assertEquals(a, testArena.fight(a, f));
		assertEquals(100, a.getHp());

		testArena.addNovice(d);
		assertEquals(b, testArena.fight(b, d));
		assertEquals(100, b.getHp());

		testArena.addNovice(e);
		assertEquals(b, testArena.fight(b, e));
		assertEquals(100, b.getHp());

		testArena.addNovice(f);
		assertEquals(b, testArena.fight(b, f));
		assertEquals(100, b.getHp());

		testArena.addNovice(d);
		assertEquals(c, testArena.fight(c, d));
		assertEquals(100, c.getHp());

		testArena.addNovice(e);
		assertEquals(c, testArena.fight(c, e));
		assertEquals(100, c.getHp());
		
		testArena.addNovice(f);
		assertEquals(c, testArena.fight(c, f));
		assertEquals(100, c.getHp());
	}

	public void testFightSecondWins() {
		Arena testArena = new Arena();
		testArena.addNovice(a);
		testArena.addNovice(b);
		testArena.addNovice(c);

		testArena.addNovice(d);
		assertEquals(a, testArena.fight(d, a));
		assertEquals(100, a.getHp());

		testArena.addNovice(e);
		assertEquals(a, testArena.fight(e, a));
		assertEquals(100, a.getHp());

		testArena.addNovice(f);
		assertEquals(a, testArena.fight(f, a));
		assertEquals(100, a.getHp());

		testArena.addNovice(d);
		assertEquals(b, testArena.fight(d, b));
		assertEquals(100, b.getHp());

		testArena.addNovice(e);
		assertEquals(b, testArena.fight(e, b));
		assertEquals(100, b.getHp());

		testArena.addNovice(f);
		assertEquals(b, testArena.fight(f, b));
		assertEquals(100, b.getHp());

		testArena.addNovice(d);
		assertEquals(c, testArena.fight(d, c));
		assertEquals(100, c.getHp());

		testArena.addNovice(e);
		assertEquals(c, testArena.fight(e, c));
		assertEquals(100, c.getHp());
		
		testArena.addNovice(f);
		assertEquals(c, testArena.fight(f, c));
		assertEquals(100, c.getHp());
	}

	@Test
	public void testCanFightIncreasing() {
		Arena testArena = new Arena();
		assertFalse(testArena.canFight());
		testArena.addNovice(new Novice("A", 1, 1, 1));
		assertFalse(testArena.canFight());
		for (int i = 0; i < 100; i++) {
			testArena.addNovice(new Novice("A", 1, 1, 1));
			assertTrue(testArena.canFight());
		}
	}

	@Test
	public void testCanFightDecreasing() {
		Arena testArena = new Arena();
		for (int i = 0; i < 100; i++)
			testArena.addNovice(new Novice("A", 1, 1, 1));
		for (int i = 0; i < 98; i++) {
			testArena.fight(testArena.getNovice(0), testArena.getNovice(1));
			assertTrue(testArena.canFight());
		}
		testArena.fight(testArena.getNovice(0), testArena.getNovice(1));
		assertFalse(testArena.canFight());
	}

}
