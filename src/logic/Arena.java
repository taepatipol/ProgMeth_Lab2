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
		while(true) {
			first.action(second);
			if (second.isDefeated()) {
				winner = first;
				n = novices.indexOf(second);
				break;
			}
			second.action(first);
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
		for(Novice x : novices) {
			System.out.println(x.toString());
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
