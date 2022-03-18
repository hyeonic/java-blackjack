package blackjack.domain.card;

import blackjack.domain.card.generator.CardsGenerator;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {

    private final Queue<Card> values;

    public Deck(CardsGenerator cardsGenerator) {
        this.values = new LinkedList<>(cardsGenerator.generate());
    }

    public Card pick() {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("카드가 모두 소진되었습니다.");
        }
        return values.poll();
    }
}
