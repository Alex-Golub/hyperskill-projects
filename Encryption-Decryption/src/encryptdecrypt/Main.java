package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static final String UNICODE = "unicode";
	static final String SHIFT = "shift";
	private static final String MODE = "-mode";
	private static final String ENCRYPTION = "enc";
	private static final String DECRYPTION = "dec";
	private static final String CMD_DATA = "-data";
	private static final String EXTERNAL_INPUT = "-in";
	private static final String EXTERNAL_OUTPUT = "-out";
	private static final String KEY = "-key";
	private static final String ALGORITHM = "-alg";

	public static void main(String[] args) {

		// application default behaviors
		String mode = ENCRYPTION;
		String data = "";
		int key = 0;
		String inPath = "";
		String outPath = "";
		String algorithmType = SHIFT;

		// extract data from user
		// -mode, -data, -in, -out, -key, -alg
		// same order not guarantee
		for (int i = 0; i < args.length - 1; i += 2) {
			String argument = args[i];
			String value = args[i + 1];

			if (argument.equals(MODE)) {
				if (value.equalsIgnoreCase(ENCRYPTION) || value.equalsIgnoreCase(DECRYPTION)) {
					mode = value;
					continue;
				} else {
					System.out.println("Error: " + value + " is not supported");
					return;
				}
			}

			if (argument.equals(CMD_DATA)) {
				data = value;
				continue;
			}

			if (argument.equals(EXTERNAL_INPUT)) {
				if (new File(value).exists()) {
					inPath = value;
					continue;
				} else {
					System.out.println("Error: input file at " + value + " not exists");
				}
			}

			if (argument.equals(EXTERNAL_OUTPUT)) {
				if (new File(value).exists()) {
					outPath = value;
					continue;
				} else { // external file not exists, create new one
					try {
						new File(value).createNewFile();
						outPath = value;
					} catch (IOException | NullPointerException e) {
						System.out.println("Error: failed to create output file in " + value);
						return;
					}
				}
			}

			if (argument.equals(KEY)) {
				try {
					key = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					System.out.println("Error: " + value + " is not a number");
					return;
				}
				continue;
			}

			if (argument.equals(ALGORITHM)) {
				if (value.equalsIgnoreCase(UNICODE) || value.equalsIgnoreCase(SHIFT)) {
					algorithmType = value;
					continue;
				} else {
					System.out.println("Error: " + value + " algorithm is not supported");
					return;
				}
			}
		}

		// if there are both -data and -in arguments, program prefer -data over -in.
		if (data.isEmpty() && !inPath.isEmpty()) {
			// read from -in
			try (Scanner sc = new Scanner(new File(inPath))) {
				while (sc.hasNext()) {
					data = data.concat(sc.nextLine() + "\n");
				}
			} catch (NullPointerException | FileNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		AlgorithmStrategy as = AlgorithmFactory.chooseAlgorithm(algorithmType);
		switch (mode) {
		case ENCRYPTION:
			data = as.encrypt(data, key);
			break;
		case DECRYPTION:
			data = as.decrypt(data, key);
			break;
		}

		if (outPath.isEmpty()) { // print to std out
			System.out.println(data);
		} else { // write to out file
			try (FileWriter fw = new FileWriter(outPath)) {
				fw.write(data);
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
