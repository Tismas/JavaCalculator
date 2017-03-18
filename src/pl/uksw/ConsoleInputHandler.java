package pl.uksw;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class ConsoleInputHandler implements InputHandler {

	/**
	 * Reads int from keyboard and checks for correctness.
	 *
	 * @param min Min correct value
	 * @param max Max currect value
	 * @return Returns user choice if correct, -1 otherwise
	 */
	@Override
	public int getIntChoice(int min, int max) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int userChoice = -1;
		try {
			userChoice = scanner.nextInt();
		}
		catch(Exception e) {
			System.out.println("Give ma number between " + min + " and " + max);
		}
		if(userChoice < min || userChoice > max) {
			System.out.println("Give ma number between " + min + " and " + max);
			userChoice = -1;
		}
		return userChoice;
	}

	/**
	 * Reads operations from keyboard.
	 *
	 * @return Returns operations contained in next line
	 */
	@Override
	public String getOperations() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String operations = "";
		operations = scanner.nextLine();
		return operations;
	}

	/**
	 * Reads filename from keyboard and checks if it is correct .txt file.
	 *
	 * @return Returns correct .txt filename or empty string otherwise.
	 */
	public String getFileName() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String filename = "";
		filename = scanner.nextLine();
		String splitted[] = StringUtils.split(filename, '.');
		if(splitted.length > 0 && splitted[splitted.length-1].equals("txt"))
			return filename;
		return "";
	}

}
