package blackjack.domain;

import java.util.List;

public class Dealer {

    private final String name;
    private final Cards cards;

    public Dealer(List<Card> cards) {
        this.name = "딜러";
        this.cards = new Cards(cards);
    }

    public boolean isDrawable() {
        return cards.calculateTotalScore() <= 16;
    }

    public void combine(Card card) {
        cards.combine(card);
    }

    public Card getOneCard() {
        return cards.getValue().get(0);
    }
}
