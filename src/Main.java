
import java.util.Scanner;

import logic.Arena;
import logic.Mage;
import logic.Novice;
import logic.Summoner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static Arena arena = new Arena();

	public static void main(String[] args) {

		while (true) {
			System.out.println("a - add new novice to the list");
			System.out.println("f - let 2 novices fight in the arena");
			System.out.println("l - see all status of all novices in the list");
			System.out.println("q - terminate the program\n");
			System.out.print("Choose an option : ");

			// wait for input
			String option = in.nextLine();

			switch (option) {
			case "a":
				addNovice();
				System.out.println("");
				continue;
				
			case "f":
				if(arena.canFight()) {
					System.out.println("List of novices:");
					arena.listNovices();
					System.out.print("Choose two novices to fight: ");
					String fighter = in.nextLine();
					String[] fighters = fighter.split(" ");
					Novice first = arena.getNovice(Integer.parseInt(fighters[0]));
					Novice second = arena.getNovice(Integer.parseInt(fighters[1]));
					if (first != null && second != null) {
						System.out.println("");
						System.out.println(arena.fight(first, second).getName()+" wins");
						System.out.println("");
					} else {
						System.out.println("This novice isn't available.");
						System.out.println("");
					}
					continue;
				} else {
					arena.listNovices();
					System.out.println("There is not enough novices to fight.");
					System.out.println("");
					continue;
				}
				
			case "l":
				System.out.println("List of novices:");
				arena.listNovices();
				System.out.println("");
				continue;
				
			case "q":
				System.exit(0);
				
			default:
				System.out.println("Wrong input!!\n");
				System.out.println("");
			}
			System.out.println();
		}
	}
	private static void addNovice() {
		System.out.println("1 - Add Novice");
		System.out.println("2 - Add Mage");
		System.out.println("3 - Add Summoner");
		System.out.println("");
		System.out.print("Choose a class : ");
		String choice = in.nextLine();
		switch(choice) {
		case "1":
			System.out.print("Create name and status(name hp atk def): ");
			String ninput = in.nextLine();
			String[] ninputs = ninput.split(" ");
			Novice nneww = new Novice(ninputs[0],Integer.parseInt(ninputs[1]),Integer.parseInt(ninputs[2]),Integer.parseInt(ninputs[3]));
			arena.addNovice(nneww);
			System.out.println(ninputs[0]+" has been added to list");
			break;
		case "2":
			System.out.print("Create name and status(name hp atk def): ");
			String minput = in.nextLine();
			String[] minputs = minput.split(" ");
			Mage mneww = new Mage(minputs[0],Integer.parseInt(minputs[1]),Integer.parseInt(minputs[2]),Integer.parseInt(minputs[3]));
			arena.addNovice(mneww);
			System.out.println(minputs[0]+" has been added to list");
			break;
		case "3":
			System.out.print("Create name and status(name hp atk def): ");
			String input = in.nextLine();
			String[] inputs = input.split(" ");
			Summoner neww = new Summoner(inputs[0],Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]),Integer.parseInt(inputs[3]));
			arena.addNovice(neww);
			System.out.println(inputs[0]+" has been added to list");
			break;
		default:
			System.out.println("Wrong Input");
		}
	}
}

	