/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String clean1 = preProcess(str1);
		String clean2 = preProcess(str2);
		boolean found = false;

		if (clean1.length() != clean2.length()) {

			return false;
		}

		for (int i = 0; i < clean1.length(); i++) {
			found = false;
			clean1.charAt(i);

			for (int n = 0; n < clean2.length(); n++) {

				if (clean1.charAt(i) == clean2.charAt(n)) {
					found = true;
					clean2 = clean2.substring(0, n) + clean2.substring(n + 1);
					break;

				}

			}
			if (!found) {
				return false;

			}

		}
		return true;

	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {

		String word = str;
		int len = str.length();
		String Fword = "";

		for (int i = 0; i < len; i++) {

			if (Character.isLetter(str.charAt(i))) {
				char nchar = Character.toLowerCase(str.charAt(i));
				Fword = Fword + nchar;
			}
		}

		return Fword;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		String source = str;
		String result = "";

		while (source.length() > 0) {

			int randIndex = (int) (Math.random() * source.length());

			char c = source.charAt(randIndex);

			result += c;

			source = source.substring(0, randIndex) + source.substring(randIndex + 1);

		}

		return result;
	}

}
