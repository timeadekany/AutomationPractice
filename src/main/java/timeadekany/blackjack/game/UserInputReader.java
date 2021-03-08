package timeadekany.blackjack.game;

import timeadekany.blackjack.wrappings.MyScanner;

public class UserInputReader {

    private int userInputInt;
    private MyScanner scanner;
    private OutPutWriter outPutWriter;

    public UserInputReader() {
        scanner = new MyScanner(System.in);
        outPutWriter = new OutPutWriter();
    }

    public UserInputReader(MyScanner scanner, OutPutWriter outPutWriter) {
        this.scanner = scanner;
        this.outPutWriter = outPutWriter;
    }

    public int readUserInputInt() {
        Integer userInputInt = null;
        do {
            outPutWriter.writeAmountAskingMessage();
            try {
                userInputInt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException  numberFormatException) {
                outPutWriter.writeIncorrectNumberErrorMessage();
            }
        } while (userInputInt == null);

        return userInputInt;
    }

    public boolean userChoiceAcceptable(String userChoice) {
        return "H".equalsIgnoreCase(userChoice)
                || "S".equalsIgnoreCase(userChoice)
                || "Q".equalsIgnoreCase(userChoice);
    }

    public String readMenuCharacter() {
        String userChoice;
        do {
            outPutWriter.writerUserChoice();
            userChoice = scanner.nextLine().toUpperCase();
        } while (!userChoiceAcceptable(userChoice));
        return userChoice;
    }
}