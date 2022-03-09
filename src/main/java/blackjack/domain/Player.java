package blackjack.domain;

import java.util.List;

public class Player {

    private final String name;
    private final Cards cards;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = new Cards(cards);
    }

    public void combine(Card card) {
        cards.combine(card);
    }

    public boolean isBust() {
        return cards.calculateTotalScore() > 21;
    }

    public boolean isBlackjack() {
        return cards.calculateTotalScore() == 21;
    }

    public List<Card> getCards() {
        return cards.getValue();
    }
}
