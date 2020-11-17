import java.util.HashMap;
import java.util.Map;
/**
 * 02/19/19
 * @author Finn Bergquist
 *
 */
public class SequenceTable {
	private Map<String, FrequencyMap> hmap2;

	public SequenceTable() {
		this.hmap2 = new HashMap<String, FrequencyMap>();
	}
	
	/**
	 * Checks to see if sequence of k characters has already been seen in text.
	 * If not, it instantiates a new frequency map and uses frequency map's add method
	 * to add the character that follows to the frequency map. If the sequence has been
	 * seen before, then the frequency map that corresponds to the sequence will be edited.
	 * @param kSequence: the sequence that is being added to Sequence table
	 * @param afterK: the character that follows the sequence that is being added to the 
	 * frequency map
	 */
	public void add(String kSequence, Character afterK) {
		if (!hmap2.containsKey(kSequence)) {
			FrequencyMap fMap = new FrequencyMap();
			fMap.add(afterK);
			hmap2.put(kSequence, fMap);
		} else {
			hmap2.get(kSequence).add(afterK);
		}
	}
	
	/**
	 * This was a method used to create string representation of a Sequence table. 
	 * It also includes the elements of the frequency map stored in the sequence table
	 * @return String of frequency table
	 */
	public String toString() {
		String stringRepresentation = "";
		for (Map.Entry<String, FrequencyMap> entry : hmap2.entrySet()) {
			stringRepresentation = stringRepresentation + entry.getKey() + ":\n" + entry.getValue();
		}
		return stringRepresentation;
	}

	/**
	 * This method will return the frequency map that corresponds to a given
	 * k-sequence
	 * 
	 * @param String that is length of k
	 * @return the Frequency Map holding the character's that follow the sequence
	 */
	public FrequencyMap get(String kSequence) {// returns frequency map
		return hmap2.get(kSequence);
	}

	/**
	 * Returns true if the Sequence Table has encountered the given sequence
	 * 
	 * @param kSequence
	 * @return boolean
	 */
	public boolean contains(String kSequence) {
		if (hmap2.containsKey(kSequence)) {
			return true;
		} else {
			return false;
		}

	}
}
