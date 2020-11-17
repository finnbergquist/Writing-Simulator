import java.util.*;

class MapTest {
	public static void main(String args[]) {

		Map<String, Character> hm1 = new HashMap<String, Character>();

		hm1.put("th", new Character('e'));
		hm1.put("ca", new Character('t'));

		for (Map.Entry<String, Character> entry : hm1.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
}