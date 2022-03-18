package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cards {

    private static final int INIT_CARDS_SIZE = 2;

    private final List<Card> value;

    public Cards(List<Card> cards) {
        this.value = new ArrayList<>(cards);
        validateSize();
    }

    public Cards() {
        this.value = new ArrayList<>();
    }

    private void validateSize() {
        if (value.size() != INIT_CARDS_SIZE) {
            throw new IllegalArgumentException("카드의 개수는 " + INIT_CARDS_SIZE + "장이어야 합니다.");
        }
    }

    public boolean isBlackjack() {
        return isReady() && hasAce() && totalScore() == 11;
    }

    public boolean isReady() {
        return value.size() == 2;
    }

    private boolean hasAce() {
        return value.stream()
                .anyMatch(Card::isAce);
    }

    public boolean isBust() {
        return totalScore() > 21;
    }

    public int totalScore() {
        return value.stream()
                .map(Card::getDenomination)
                .mapToInt(Denomination::getScore)
                .sum();
    }

    public int calculateTotalScore() {
        value.sort(Comparator.naturalOrder());

        int totalScore = 0;
        for (Card card : value) {
            totalScore = card.calculateScore(totalScore);
        }

        return totalScore;
    }

    public void append(Card card) {
        value.add(card);
    }

    public List<Card> getValue() {
        return Collections.unmodifiableList(value);
    }
}
