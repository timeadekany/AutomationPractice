package timeadekany.blackjack.card;

import org.junit.Before;
import org.junit.Test;
import timeadekany.blackjack.game.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player player;

    @Before
    public void init() {
        player = new Player(500);
    }

    @Test
    public void testPlayerCardsBeforeTheGameIsStarted() {
        assertTrue(player.getPlayerCards().isEmpty());
    }

    @Test
    public void testAddCardToThePlayer() {
        player.addCard(new Card("♣", "10"));
        assertEquals(1, player.getPlayerCards().size());
        assertEquals("♣",player.getPlayerCards().get(0).getSuit());
        assertEquals("10",player.getPlayerCards().get(0).getValue());
    }

    @Test
    public void testRemoveAllThePlayersCards() {
        player.removeCards();
        assertTrue(player.getPlayerCards().isEmpty());
    }

    @Test
    public void testPlayerMoneyWhenTheWinnerIsThePlayer(){
        player.askPlayerBet(300);
        int bet = player.getPlayerBet();
        int playerMoney = player.getPlayerMoney();
        int sum = playerMoney + bet;
        player.playerMoneyCalculator("PLAYER");
        assertEquals(sum,player.getPlayerMoney());
    }

    @Test
    public void testPlayerMoneyWhenTheWinnerIsTheDealer(){
        player.askPlayerBet(300);
        int bet = player.getPlayerBet();
        int playerMoney = player.getPlayerMoney();
        int sum = playerMoney - bet;
        player.playerMoneyCalculator("DEALER");
        assertEquals(sum,player.getPlayerMoney());
    }
}
