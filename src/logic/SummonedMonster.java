package logic;

public class SummonedMonster {
	private int attackBuff;
	private int defenseBuff;
	private int lifeTime;
	public SummonedMonster() {
		this.attackBuff = 8;
		this.defenseBuff = 8;
		this.lifeTime = 3;
	}
	public void decreaseLifeTime() {
		this.lifeTime -= 1;
	}
	public int getLifeTime() {
		return this.lifeTime;
	}
	public int getAttackBuff() {
		return this.attackBuff;
	}
	public int getDefenseBuff() {
		return this.defenseBuff;
	}
	
}
