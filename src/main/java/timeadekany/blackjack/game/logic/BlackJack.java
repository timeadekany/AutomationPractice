package timeadekany.blackjack.game.logic;

import timeadekany.blackjack.card.CardDeck;
import timeadekany.blackjack.game.Dealer;
import timeadekany.blackjack.game.Player;
import timeadekany.blackjack.game.UserInputReader;

public class BlackJack {

    UserInputReader userInputReader;
    Player player;
    Dealer dealer;
    CardDeck cardDeck;
    private int playerBet;
    private String gameActionSelector;
    private boolean nextGame = true;

    public BlackJack(UserInputReader userInputReader) {
        this.userInputReader = userInputReader;
    }

    public void firstHandForThePlayer(Player player, CardDeck cardDeck) {
        player.removeCards();
        player.addCard(cardDeck.generateRandomCard());
        player.addCard(cardDeck.generateRandomCard());
        System.out.println("The players cards:");
        player.printPlayerCards();
    }

    public void firstHandForTheDealer(Dealer dealer, CardDeck cardDeck) {
        int minCardValueLimit = 15;
        dealer.removeCards();
        dealer.addCard(cardDeck.generateRandomCard());
        dealer.addCard(cardDeck.generateRandomCard());
        while (cardDeck.calculateCardValues(dealer.getDealerCards()) <= minCardValueLimit) {
            dealer.addCard(cardDeck.generateRandomCard());
        }
        System.out.println("The Dealers cards:");
        dealer.printDealerCards();
    }

    public void hintANewCardForThePlayer() {
        int maxCardValueLimit = 21;
        if((cardDeck.calculateCardValues(player.getPlayerCards()) < maxCardValueLimit)){
            player.addCard(cardDeck.generateRandomCard());
            System.out.println("The players cards:");
            player.printPlayerCards();
        } else {
            System.out.println("Too much card. You need to finish the game, press (S) ");
        }
    }

    public void setGameType(String gameTypeSelector) {
        Winner winner;
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        switch (gameTypeSelector) {
            case "H":
            case "Hit":
                nextGame = false;
                System.out.println("Okay, I give you another card.");
                hintANewCardForThePlayer();
                playOneGame();
                break;
            case "S":
            case "Split":
                System.out.println("Your money amount is: " + player.getPlayerMoney());
                winner = winnerCalculator.checkTheWinner(player, dealer, cardDeck);
                winnerCalculator.printTheWinnerName(winner);
                System.out.println("Your money amount is: " + player.getPlayerMoney());
                break;
            case "Q":
            case "Quit":
                System.exit(1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gameTypeSelector);
        }
    }

    public void play(int playerWage) {
        initGame(playerWage);
        while (player.hasMoney() && playerWantsToPlay()) {
            playOneGame();
        }
    }

    private boolean playerWantsToPlay() {
        return nextGame;
    }

    private void playOneGame() {
        if (!nextGame && player.getPlayerMoney() > 0) {
            gameActionSelector = new UserInputReader().readMenuCharacter();
            setGameType(gameActionSelector);
        }
        if (player.getPlayerMoney() > 0) {
            playerBet = userInputReader.readUserInputInt();
            player.askPlayerBet(playerBet);
            System.out.println("Player betting with " + playerBet + " bet");
            firstHandForThePlayer(player, cardDeck);
            firstHandForTheDealer(dealer, cardDeck);
            gameActionSelector = new UserInputReader().readMenuCharacter();
            setGameType(gameActionSelector);
        }
    }

    private void initGame(int playerWage) {
        cardDeck = new CardDeck();
        dealer = new Dealer();
        player = new Player(playerWage);
        nextGame = true;
        System.out.println("Start playing with " + player.getPlayerMoney() + " wage");
    }
}
