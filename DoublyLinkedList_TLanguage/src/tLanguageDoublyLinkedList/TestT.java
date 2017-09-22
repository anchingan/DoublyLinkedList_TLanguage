package tLanguageDoublyLinkedList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TestT {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		TLanguage doT = new TLanguage();
		System.out.println("Command:");
		String str;
		while ((str = scanner.nextLine()).equals(""));
		if (doT.readCommand(str)) {
			System.out.println("File read successed!");
			doT.exactTFile();
		}
		else
			System.out.println("Input error!");
		int input;
		do {
			System.out.print("1. Next Step, 2. Last Step, 3. Compile, -1. Quit: ");
			input = scanner.nextInt();
			if (input == -1)
				break;
			switch (input) {
			case 1:
				doT.nextStep();
				break;
			case 2:
				doT.lastStep();
				break;
			case 3:
				System.out.println("Command:");
				while ((str = scanner.nextLine()).equals(""));
				if (doT.readCommand(str)) {
					doT.exactTFile();
					System.out.println("Done");
				}
				else
					System.out.println("Input error!");
				break;
			}
		} while (true);
		scanner.close();
		System.out.println("Bye!");
		
	}

}
