package timeadekany.blackjack.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {

    private static final Random RANDOM = new Random();
    private static final int DECK_SIZE = 52;
    int sumOfTheCards;

    private String[] suits = {"♣", "♦", "♥", "♠"};
    private String[] faceCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private List<Card> cardDeck = new ArrayList<>(DECK_SIZE);

    public CardDeck() {
        generateCardDeck();
    }

    private List<Card> generateCardDeck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < faceCards.length; j++) {
                cardDeck.add(new Card(suits[i], faceCards[j]));
            }
        }

        return cardDeck;
    }

    public Card generateRandomCard() {
        if (cardDeck.size() > 0) {
            return cardDeck.remove(RANDOM.nextInt(cardDeck.size()));
        }

        throw new IllegalStateException("Cannot generate more card since the deck is empty");
    }

    public int getDeckSize() {
        return cardDeck.size();
    }

    public boolean containsCard(Card card) {
        return cardDeck.contains(card);
    }

    public int calculateCardValues(List<Card> cards) {
        sumOfTheCards = 0;
        for (int i = 0; i < cards.size(); i++) {
            switch (cards.get(i).getValue()) {
                case "2":
                    sumOfTheCards += 2;
                    break;
                case "3":
                    sumOfTheCards += 3;
                    break;
                case "4":
                    sumOfTheCards += 4;
                    break;
                case "5":
                    sumOfTheCards += 5;
                    break;
                case "6":
                    sumOfTheCards += 6;
                    break;
                case "7":
                    sumOfTheCards += 7;
                    break;
                case "8":
                    sumOfTheCards += 8;
                    break;
                case "9":
                    sumOfTheCards += 9;
                    break;
                case "10":
                case "J":
                case "Q":
                case "K":
                    sumOfTheCards += 10;
                    break;
                case "A":
                    sumOfTheCards += 1;
                    break;
            }

        }
        return sumOfTheCards;
    }
}
