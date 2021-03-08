package timeadekany.blackjack.card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    private CardDeck cardDeck;

    @Before
    public void init() {
        cardDeck = new CardDeck();
    }

    @Test
    public void testGenerateRandomCard() {
        Card generatedCard = cardDeck.generateRandomCard();
        assertTrue(generatedCard.toString().matches("Cardsuit='[♣♦♥♠]', value='[2345678910JQK]'"));
        assertEquals(51, cardDeck.getDeckSize());
        assertFalse(cardDeck.containsCard(generatedCard));
    }

    @Test
    public void testInitialDeckSize() {
        assertEquals(52, cardDeck.getDeckSize());
    }

    @Test
    public void testTooMuchCardGeneration() {
        for (int i = 0; i < 52; i++) {
            cardDeck.generateRandomCard();
        }

        try {
            cardDeck.generateRandomCard();
            fail("The 53th generation didn't thrown an exception");
        } catch (Exception e) {
            assertEquals(IllegalStateException.class, e.getClass());
            assertEquals("Cannot generate more card since the deck is empty", e.getMessage());
        }
    }
}
