package pl.uksw;

import java.io.FileReader;
import java.util.Scanner;

public class FileInputHandler implements InputHandler {
	
	private Scanner s = null;

	/**
	 * Initialize scanner with file.
	 */
	FileInputHandler(String filename) {
		try {
			s = new Scanner(new FileReader(filename));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Reads int from file and checks for correctness.
	 *
	 * @param min Min correct value
	 * @param max Max currect value
	 * @return Returns user choice if correct, -1 otherwise
	 */
	@Override
	public int getIntChoice(int min, int max) {		
		if(s == null) { 
			return -1;
		}
		int userChoice = s.nextInt();
		s.close();
		if(userChoice < min || userChoice > max) {
			System.out.println("Give ma number between " + min + " and " + max);
			userChoice = -1;
		}
		return userChoice;
	}

	/**
	 * Reads operations from file.
	 *
	 * @return Returns operations contained in next line or empty string otherwise
	 */
	@Override
	public String getOperations() {
		if(s == null) { 
			return "";
		}
		String line = "";
		if(s.hasNextLine())
			line = s.nextLine();
		return line;
	}
	
}
