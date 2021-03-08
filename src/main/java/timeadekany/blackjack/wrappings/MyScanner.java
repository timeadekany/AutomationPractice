package timeadekany.blackjack.wrappings;

import java.io.InputStream;
import java.util.Scanner;

public class MyScanner {
	
	private Scanner scanner;
	
	public MyScanner(InputStream in) {
		scanner = new Scanner(in);
	}

	public String nextLine() {
		return scanner.nextLine();
	}

	public String next() {
		return scanner.next();
	}
}
