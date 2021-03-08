package timeadekany.blackjack.game;

public class OutPutWriter {

	public void writeMenu() {
	}

	public void writerUserChoice() {
		System.out.println("---------------------------------------------------");
		System.out.println("Hit (H) /  Stand (S) / Quit from the Game (Q)");
	}

	public void writeAmountAskingMessage() {
		System.out.println("Please enter the amount: ");
	}

	public void writeIncorrectNumberErrorMessage() {
		System.out.println("That's not a number, Please enter a valid number: ");
	}
}
