package timeadekany.blackjack.game.logic;

import timeadekany.blackjack.card.CardDeck;
import timeadekany.blackjack.game.Dealer;
import timeadekany.blackjack.game.Player;

public class WinnerCalculator {

    private static final int BLACK_JACK_NUMBER = 21;

    public Winner checkTheWinner(Player player, Dealer dealer, CardDeck cardDeck) {
        int sumOfThePlayerCards = cardDeck.calculateCardValues(player.getPlayerCards());
        int sumOfTheDealerCards = cardDeck.calculateCardValues(dealer.getDealerCards());
        System.out.println("The Dealers cards sum is: " + sumOfTheDealerCards);
        System.out.println("The Players cards sum is: " + sumOfThePlayerCards);

        if (sumOfThePlayerCards > BLACK_JACK_NUMBER) {
            player.playerMoneyCalculator(Winner.DEALER.toString());
            return Winner.DEALER;
        } else if (sumOfTheDealerCards > BLACK_JACK_NUMBER) {
            player.playerMoneyCalculator(Winner.PLAYER.toString());
            return Winner.PLAYER;
        } else if (sumOfThePlayerCards > sumOfTheDealerCards) {
            player.playerMoneyCalculator(Winner.PLAYER.toString());
            return Winner.PLAYER;
        } else if (sumOfThePlayerCards < sumOfTheDealerCards) {
            player.playerMoneyCalculator(Winner.DEALER.toString());
            return Winner.DEALER;
        } else {
            return Winner.DRAW;
        }
    }

    public void printTheWinnerName(Winner winner) {
        switch (winner) {
            case DRAW:
                System.out.println("The Game is draw");
                break;
            case PLAYER:
                System.out.println("The Winner: Player");
                break;
            case DEALER:
                System.out.println("The Winner: Dealer");
                break;
        }
    }
}
