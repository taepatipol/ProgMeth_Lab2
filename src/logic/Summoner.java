package logic;

public class Summoner extends Novice {
	private int coolDown;
	private static final int MAX_COOL_DOWN = 8;
	private SummonedMonster summonedMonster;
	public Summoner(String name,int maxHp,int attack,int defense) {
		super(name,maxHp,attack,defense);
		this.coolDown = 0;
	}
	public void action(Novice opponent) {
		if(this.summonedMonster != null) {
			this.summonedMonster.decreaseLifeTime();
			if(this.summonedMonster.getLifeTime() <= 0) {
				this.desummon();
			}
		}
		if(this.summonedMonster == null && this.coolDown == 0) {
			this.summon();
		}
		if(opponent != null) {
			super.action(opponent);
		}
		if(this.coolDown > 0) {
			this.coolDown -= 1;
		}
	}
	public SummonedMonster getSummonedMonster() {
		return this.summonedMonster;
	}
	private void summon() {
		SummonedMonster monster = new SummonedMonster();
		this.summonedMonster = monster;
		this.attack += monster.getAttackBuff();
		this.defense += monster.getDefenseBuff();
		this.coolDown = Summoner.MAX_COOL_DOWN;
	}
	private void desummon() {
		this.attack -= this.summonedMonster.getAttackBuff();
		this.defense -= this.summonedMonster.getDefenseBuff();
		this.summonedMonster = null;
	}
	
}
