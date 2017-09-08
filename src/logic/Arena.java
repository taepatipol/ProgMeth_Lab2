package logic;

import java.util.ArrayList;
import java.util.List;

public class Arena {
	private List<Novice> novices;
	public Arena() {
		this.novices = new ArrayList<Novice>();
	}
	public Novice fight(Novice first,Novice second) {
		Novice winner;
		int n;
		System.out.println("A fight begins between "+first.getName()+" and "+second.getName());
		while(true) {
			System.out.println(first.getName()+" deals damage to "+second.getName()+".");
			first.action(second);
			System.out.println(second.getName()+"'s current HP is "+second.getHp());
			System.out.println("");
			if (second.isDefeated()) {
				winner = first;
				n = novices.indexOf(second);
				break;
			}
			System.out.println(second.getName()+" deals damage to "+first.getName()+".");
			second.action(first);
			System.out.println(first.getName()+"'s current HP is "+first.getHp());
			System.out.println("");
			if (first.isDefeated()) {
				winner = second;
				n = novices.indexOf(first);
				break;
			}
		}
		novices.remove(n);
		winner.restoreHp();
		return winner;
	}
	public void listNovices() {
		int i = 0;
		for(Novice x : novices) {
			System.out.println(i + " - " +x.toString());
			i++;
		}
	}
	public void addNovice(Novice n) {
		novices.add(n);
	}
	public Novice getNovice(int number) {
		return novices.get(number);
	}
	public boolean canFight() {
		if (novices.size() >= 2) {
			return true;
		} else {
			return false;
		}
	}
}
