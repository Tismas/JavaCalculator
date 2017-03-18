package pl.uksw;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Calculator {

	/**
	 * Validating operations.
	 *
	 * @param operations String containing operations
	 * @return Returns true if operations were correct, false otherwise
	 */
	public static boolean validate(String operations) {
		String[] elements = StringUtils.splitByCharacterType(operations);
		for(int i = 0; i < elements.length; ++i) {
			if(i % 2 == 0) {
				if(!StringUtils.isNumeric(elements[i])) {
					System.out.println("Should be numeric");
					return false;
				}
				
			}
			else {
				if(!elements[i].equals("+") && !elements[i].equals("-") && !elements[i].equals("*") && !elements[i].equals("/")) {
					System.out.println("Should be symbol");
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Executing operations.
	 *
	 * @param operations String containing operations
	 * @return Returns the result of operations
	 */
	public static double process(String operations) {
		String[] elements = StringUtils.splitByCharacterType(operations);
		for(int i = elements.length-2; i > 0; i -= 2) {
			if(elements[i].equals("*")) {
				elements[i - 1] = String.valueOf(Double.parseDouble(elements[i-1]) * Double.parseDouble(elements[i+1]));
				ArrayUtils.remove(elements, i);
				ArrayUtils.remove(elements, i + 1);
			}
			else if(elements[i].equals("/")) {
				elements[i - 1] = String.valueOf(Double.parseDouble(elements[i-1]) / Double.parseDouble(elements[i+1]));
				ArrayUtils.remove(elements, i);
				ArrayUtils.remove(elements, i + 1);
			}
		}
		double result = Double.parseDouble(elements[0]);
		for(int i = 1; i < elements.length; i += 2) {
			if(elements[i].equals("+")) {
				result += Double.parseDouble(elements[i+1]);
			}
			else if(elements[i].equals("-")) {
				result -= Double.parseDouble(elements[i+1]);
			}
		}
		return result;
	}
}
