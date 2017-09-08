package logic;

public class Novice {
	protected String name;
	protected int hp;
	protected int maxHp;
	protected int attack;
	protected int defense;
	public Novice(String name,int maxHp,int attack,int defense) {
		this.name = name;
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		if (maxHp < 1) {
			this.maxHp = 1;
		}
		if (attack < 1) {
			this.attack = 1;
		}
		if (defense < 1) {
			this.defense = 1;
		}
		this.hp = this.maxHp;
	}
	public String toString() {
		return this.name + " | HP : " + this.maxHp + " | Atk : " +this.attack+" | Def : " +this.defense;
	}
	public void action(Novice opponent) {
		opponent.takeDamage(this.attack-opponent.getDefense());
	}
	public void takeDamage(int damage) {
		if (damage < 1) {
			this.hp -= 1;
		} else {
			this.hp -= damage;
		}
		if (this.hp < 0) {
			this.hp = 0;
		}
	}
	public boolean isDefeated() {
		if (this.hp <= 0) {
			return true;
		} else {
			return false;
		}
	}
	public void restoreHp() {
		this.hp = this.maxHp;
	}
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getDefense() {
		return this.defense;
	}
	
}
