package timeadekany.blackjack.game;

import timeadekany.blackjack.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int playerMoney;
    private int playerBet;
    private final List<Card> playerCards;

    public Player(int playerMoney) {
        this.playerCards = new ArrayList<Card>();
        this.playerMoney = playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public void askPlayerBet(int bet) {
        playerBet = bet;
    }

    public void addCard(Card card) {
        playerCards.add(card);
    }

    public void removeCards() {
        playerCards.clear();
    }

    public void printPlayerCards() {
        System.out.println(this.playerCards);
    }

    public boolean hasMoney() {
        return getPlayerMoney() > 0;
    }

    public void playerMoneyCalculator(String winner) {
        int money = getPlayerMoney();
        int bet = getPlayerBet();
        switch (winner) {
            case "PLAYER":
                money+=bet;
                break;
            case "DEALER":
                money-=bet;
                break;
        }
        setPlayerMoney(money);
    }
}

