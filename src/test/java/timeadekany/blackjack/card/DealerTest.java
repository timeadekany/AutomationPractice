package timeadekany.blackjack.card;

import org.junit.Before;
import org.junit.Test;
import timeadekany.blackjack.game.Dealer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DealerTest {

    private Dealer dealer;

    @Before
    public void init() {
        dealer = new Dealer();
    }

    @Test
    public void testAddCardToTheDealer(){
        dealer.addCard(new Card("♥", "9"));;
        assertEquals(1,dealer.getDealerCards().size());
        assertEquals("♥",dealer.getDealerCards().get(0).getSuit());
        assertEquals("9",dealer.getDealerCards().get(0).getValue());
    }

    @Test
    public void testDealerCardsBeforeTheGameIsStarted(){
        assertTrue(dealer.getDealerCards().isEmpty());
    }


    @Test
    public void testRemoveAllTheDealersCards(){
        dealer.removeCards();
        assertTrue(dealer.getDealerCards().isEmpty());
    }
}
