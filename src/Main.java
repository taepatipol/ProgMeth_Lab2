
import java.util.Scanner;

import logic.Arena;
import logic.Mage;
import logic.Novice;
import logic.Summonner;

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
				//fill code
				
			case "f":
				//fill code
				
			case "l":
				//fill code
				
			case "q":
				//fill code
				
			default:
				System.out.println("Wrong input!!\n");
			}
			System.out.println();
		}
	}
}

	