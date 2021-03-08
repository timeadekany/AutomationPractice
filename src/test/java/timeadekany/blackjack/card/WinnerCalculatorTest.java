package timeadekany.blackjack.card;

import org.junit.Test;
import timeadekany.blackjack.game.Dealer;
import timeadekany.blackjack.game.Player;
import timeadekany.blackjack.game.logic.WinnerCalculator;

import static org.junit.Assert.assertEquals;
import static timeadekany.blackjack.game.logic.Winner.*;

public class WinnerCalculatorTest {

    private WinnerCalculator winnerCalculator;
    private Player player;
    private Dealer dealer;
    private CardDeck cardDeck;

    @Test
    public void testTheDrawGame() {
        winnerCalculator = new WinnerCalculator();
        player = new Player(500);
        dealer = new Dealer();
        cardDeck = new CardDeck();
        player.addCard(new Card("♣","10"));
        player.addCard(new Card("♣","J"));
        dealer.addCard(new Card("♦","10"));
        dealer.addCard(new Card("♦","J"));
        assertEquals(DRAW, winnerCalculator.checkTheWinner(player,dealer, cardDeck));

    }

    @Test
    public void testThePlayerGetBetterCards() {
        winnerCalculator = new WinnerCalculator();
        player = new Player(500);
        dealer = new Dealer();
        cardDeck = new CardDeck();
        player.addCard(new Card("♣","10"));
        player.addCard(new Card("♣","J"));
        dealer.addCard(new Card("♦","10"));
        dealer.addCard(new Card("♦","6"));
        assertEquals(PLAYER, winnerCalculator.checkTheWinner(player,dealer, cardDeck));

    }

    @Test
    public void testTheDealerGetMoreCardsThan21() {
        winnerCalculator = new WinnerCalculator();
        player = new Player(500);
        dealer = new Dealer();
        cardDeck = new CardDeck();
        player.addCard(new Card("♣","10"));
        player.addCard(new Card("♣","J"));
        dealer.addCard(new Card("♦","10"));
        dealer.addCard(new Card("♦","3"));
        dealer.addCard(new Card("♥","10"));
        assertEquals(PLAYER, winnerCalculator.checkTheWinner(player,dealer, cardDeck));

    }

    @Test
    public void testTheDealerGetBetterCards() {
        winnerCalculator = new WinnerCalculator();
        player = new Player(500);
        dealer = new Dealer();
        cardDeck = new CardDeck();
        player.addCard(new Card("♣","2"));
        player.addCard(new Card("♣","J"));
        dealer.addCard(new Card("♦","10"));
        dealer.addCard(new Card("♦","6"));
        assertEquals(DEALER, winnerCalculator.checkTheWinner(player,dealer, cardDeck));

    }

    @Test
    public void testThePlayerGetMoreCardsThan21() {
        winnerCalculator = new WinnerCalculator();
        player = new Player(500);
        dealer = new Dealer();
        cardDeck = new CardDeck();
        player.addCard(new Card("♣","8"));
        player.addCard(new Card("♣","J"));
        player.addCard(new Card("♥","5"));
        dealer.addCard(new Card("♦","10"));
        dealer.addCard(new Card("♥","10"));
        assertEquals(DEALER, winnerCalculator.checkTheWinner(player,dealer, cardDeck));

    }

}
