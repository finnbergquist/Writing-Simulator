import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 02/19/19
 * 
 * @author Finn Bergquist
 *
 */

public class WordGen {
	/**
	 * The is is the driver. It reads the text file into a sequence table and then
	 * outputs characters, given the probabilities that any character will follow a
	 * certain sequence. This method is known as the Infinite Monkey Theorem.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// First, using a scanner, the user will be prompted for a filename and k-value
		Scanner sc = new Scanner(System.in);
		System.out.println("Which file would you like to simulate? ");
		String scannerName = sc.next();

		System.out.println("What would you like the k-value to be? ");
		int k = sc.nextInt();

		String stringSample = readFileAsString(scannerName);

		SequenceTable smap = new SequenceTable();
		// Now the sequence table will acquire increments of k-size from the string by
		// iterating through whole text file
		int counter = stringSample.length() - k - 1;
		for (int i = 0; i <= counter; i++) {
			smap.add(stringSample.substring(i, i + k), stringSample.charAt(i + k));
		}

		// Creating string to be filled with output text
		String outputString;
		// this random integer will make sure the first sequence is randomly selected
		// from the first 50 characters of the text.
		int startInt = (int) (Math.random() * 50);
		outputString = stringSample.substring(startInt, startInt + k);

		// Sequence Table's method, nextChar() is used if there are instances of
		// the k-sequence. Otherwise it uses random character method
		for (int i = 0; i < 500; i++) {
			if (smap.contains(outputString.substring(i, i + k))) {
				outputString += smap.get(outputString.substring(i, i + k)).nextChar();
			} else {
				outputString += randomChar();
			}
		}

		// Finally, the output string is printed!!!!!
		System.out.println(outputString);

	}

	/**
	 * this method of random letter generation is taken verbatim from Lab 2 packet
	 * 
	 * @return random character
	 */
	private static final Random rand = new Random();

	private static char randomChar() {
		return (char) (rand.nextInt(26) + 'a');
	}

	/**
	 * Read the contents of a file into a string. If the file does not exist or
	 * cannot not be read for any reason, returns null. Also taken from lab.
	 * 
	 * @param filename The name of the file to read.
	 * @return The contents of the file as a string, or null.
	 */
	private static String readFileAsString(String filename) {
		try {
			return new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			return null;
		}
	}

}
