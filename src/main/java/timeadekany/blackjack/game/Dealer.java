package timeadekany.blackjack.game;

import timeadekany.blackjack.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private final List<Card> dealerCards;

    public Dealer() {
        this.dealerCards = new ArrayList<Card>();
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void addCard(Card card) {
        dealerCards.add(card);
    }

    public void removeCards() {
        dealerCards.clear();
    }

    public void printDealerCards() {
        System.out.println(this.dealerCards);
    }
}
