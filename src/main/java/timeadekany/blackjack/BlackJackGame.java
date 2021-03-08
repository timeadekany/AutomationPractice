package timeadekany.blackjack;

import timeadekany.blackjack.game.Menu;
import timeadekany.blackjack.game.UserInputReader;
import timeadekany.blackjack.game.logic.BlackJack;

public class BlackJackGame {

    private final Menu menu;
    private final UserInputReader userInputReader;
    private final BlackJack blackJack;

    public BlackJackGame(Menu menu, UserInputReader userInputReader, BlackJack blackJack) {
        this.menu = menu;
        this.userInputReader = userInputReader;
        this.blackJack = blackJack;
    }

    public void startGame() {
        menu.writeGameDescriptionToConsole();
        int playerWage = userInputReader.readUserInputInt();
        blackJack.play(playerWage);
    }

    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame(new Menu(), new UserInputReader(), new BlackJack(new UserInputReader()));
        blackJackGame.startGame();
    }
}
