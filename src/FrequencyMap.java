import java.util.HashMap;
import java.util.Map;

/**
 * 02/19/19
 * @author Finn Bergquist
 *
 */
public class FrequencyMap {
	private Map<Character, Integer> hmap1;

	/**
	 * This is the constructor method. it assigns the hash map as an attribute of
	 * the FrequencyMap class
	 */
	public FrequencyMap() {
		this.hmap1 = new HashMap<Character, Integer>();
	}

	/**
	 * This method assigns keys and values to the hash map. If the character is
	 * already in the map, then it adds 1 to that characters corresponding count.
	 * 
	 * @param afterK this is the preceding sequence that the hash map is linked to
	 *               in the Sequence Table
	 */
	public void add(Character afterK) {
		if (!hmap1.containsKey(afterK)) {
			hmap1.put(afterK, 1);
		} else {
			hmap1.put(afterK, 1 + hmap1.get(afterK));
		}
	}

	/**
	 * This method generates the next character, using the probabilities accumulated
	 * in the frequency map.
	 * 
	 * @return a Character that is selected based on how often it occurs after the
	 *         given sequence in the file.
	 */
	public Character nextChar() {

		int valuesSum = 0;
		for (Integer value : hmap1.values()) {// getting max number that can be used for max of random numbers
			valuesSum += value;
		}

		int randomSum = (int) (Math.random() * valuesSum);
		Character chosenChar = 'a';// just a placeholder

		for (Character key : hmap1.keySet()) {
			if (hmap1.get(key) <= randomSum) {
				randomSum = randomSum - hmap1.get(key);
			} else {
				chosenChar = key;// placeholder is replaced
				break;
			}
		}
		return chosenChar;
	}

	/**
	 * This method is not actually used in the WordGen class; however, it was used
	 * while testing out the Frequency Map class
	 * 
	 * @return String representation of Frequency Map
	 */
	public String toString() {
		String stringRepresentation = "";
		for (Map.Entry<Character, Integer> entry : hmap1.entrySet()) {
			stringRepresentation = stringRepresentation + entry.getKey() + "/" + entry.getValue() + "\n";
		}
		return stringRepresentation;
	}
}
