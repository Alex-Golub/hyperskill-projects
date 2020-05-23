package encryptdecrypt;

/**
 * Encode/Decode algorithm strategy
 */
interface AlgorithmStrategy {
	String encrypt(String data, int key);
	String decrypt(String data, int key);
}

/**
 * Unicode shift algorithm uses 2 bytes of data to encrypt/decrypt input data
 */
class Unicode implements AlgorithmStrategy {
	private final int CHAR_MAX_VALUE = Character.MAX_VALUE + 1;

	@Override
	public String encrypt(String data, int key) {
		StringBuilder res = new StringBuilder(data.length());
		for (char c : data.toCharArray()) {
			res.append((char) ((c + key % CHAR_MAX_VALUE) % CHAR_MAX_VALUE));
		}
		return res.toString();
	}

	@Override
	public String decrypt(String data, int key) {
		StringBuilder res = new StringBuilder(data.length());
		for (char c : data.toCharArray()) {
			res.append((char) ((CHAR_MAX_VALUE + c - key % CHAR_MAX_VALUE) % CHAR_MAX_VALUE));
		}
		return res.toString();
	}
}

/**
 * Shift algorithm moves each letter by key value in the english alphabetical
 * circle 1st circle 'a' -> 'z' 2nd circle 'A' -> 'Z'
 */
class Shift implements AlgorithmStrategy {

	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	@Override
	public String encrypt(String data, int key) {
		StringBuilder res = new StringBuilder(data.length());
		for (char c : data.toCharArray()) {
			if (ALPHABET.contains((c + "").toLowerCase())) { // offset according to character case
				char charCase = Character.isUpperCase(c) ? 'A' : 'a';
				res.append((char) (charCase + (c - charCase + key % 26) % 26));
			} else { // character is not a letter
				res.append(c);
			}
		}
		return res.toString();
	}

	@Override
	public String decrypt(String data, int key) {
		StringBuilder res = new StringBuilder(data.length());
		for (char c : data.toCharArray()) {
			if (ALPHABET.contains((c + "").toLowerCase())) { // offset according to character case
				char charCase = Character.isUpperCase(c) ? 'A' : 'a';
				res.append((char) (charCase + (c + 26 - charCase - key % 26) % 26));
			} else { // character is not a letter
				res.append(c);
			}
		}
		return res.toString();
	}
}
