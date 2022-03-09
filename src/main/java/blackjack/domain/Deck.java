package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Deck {

    private final Queue<Card> cards;

    public Deck(Set<Card> values) {
        List<Card> cards = new ArrayList<>(values);
        Collections.shuffle(cards);

        this.cards = new LinkedList<>(cards);
        validateSize();
    }

    private void validateSize() {
        if (cards.size() != 52) {
            throw new IllegalArgumentException("카드 뭉치의 갯수가 부족합니다.");
        }
    }
}
