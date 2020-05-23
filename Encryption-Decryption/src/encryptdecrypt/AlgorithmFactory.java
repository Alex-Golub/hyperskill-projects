package encryptdecrypt;

/**
 * Algorithm factory
 */
class AlgorithmFactory {

	static AlgorithmStrategy chooseAlgorithm(String type) {
		switch (type.toLowerCase()) {
		case Main.UNICODE: return new Unicode();
		case Main.SHIFT: return new Shift();
		default:
			System.out.println("Error: invalid algorithm");
			return null;
		}
	}

}