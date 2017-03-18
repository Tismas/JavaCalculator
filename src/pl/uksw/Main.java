package pl.uksw;

/**
 * @author      Adam Golan
 * @version     1.0
 * @since       1.0
 */
public class Main {
	/**
	 * Printing menu.
	 * <p>
	 * Choose from menu:
	 * 1: Specify operations from keyboard
	 * 2: Load operations from file
	 * 3: Terminate
	 * <p>
	 *
	 * @return void
	 */
	public static void printMenu() {
		System.out.println("Choose from menu: ");
		System.out.println("1: Specify operations from keyboard");
		System.out.println("2: Load operations from file");
		System.out.println("3: Terminate");
	}
	
	public static void main(String[] args) {
		int userChoice = -1;
		ConsoleInputHandler keyboard = new ConsoleInputHandler();
		while(userChoice != 3) {
			printMenu();
			userChoice = keyboard.getIntChoice(1, 3);
			while(userChoice == -1) {
				userChoice = keyboard.getIntChoice(1, 3);
			}
			if(userChoice == 1) {
				System.out.println("Give me operations");
				String operations = keyboard.getOperations();
				while(!operations.equals("koniec")) {
					if(Calculator.validate(operations)) {
						System.out.println(operations + " = " + Calculator.process(operations));
					}
					else {
						System.out.println("These are not valid operations");
					}
					operations = keyboard.getOperations();
				}
			}
			else if(userChoice == 2) {
				System.out.println("Give me a filename");
				String filename = keyboard.getFileName();
				while(filename == "") {
					System.out.println("Only .txt files are supported");
  					filename = keyboard.getFileName();
				}
				FileInputHandler fileio = new FileInputHandler(filename);
				String operations = fileio.getOperations();
				while(!operations.equals("")) {
					operations = operations.replaceAll(" ", "");
					if(Calculator.validate(operations)) {
						System.out.println(operations + " = " + Calculator.process(operations));
					}
					else {
						System.out.println("These are not valid operations");
					}
					operations = fileio.getOperations();
				}
			}
		}
	}
}
