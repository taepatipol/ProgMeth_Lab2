package logic;

public class Mage extends Novice {
	public Mage(String name,int maxHp,int attack,int defense) {
		super(name,maxHp,attack,defense);
	}
	public void action(Novice opponent) {
		super.action(opponent);
		super.action(opponent);
	}
	
}
