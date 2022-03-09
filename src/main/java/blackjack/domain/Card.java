package blackjack.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Card {

    public static final Set<Card> VALUES;

    private final Denomination denomination;
    private final Suit suit;

    static {
        Set<Card> cards = Arrays.stream(Denomination.values())
                .flatMap(denomination -> createCards(denomination).stream())
                .collect(toSet());

        VALUES = Collections.unmodifiableSet(cards);
    }

    private static Set<Card> createCards(Denomination denomination) {
        return Arrays.stream(Suit.values())
                .map(suit -> new Card(denomination, suit))
                .collect(toSet());
    }

    private Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public static Card of(Denomination denomination, Suit suit) {
        return VALUES.stream()
                .filter(denomination::isSame)
                .filter(suit::isSame)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카드입니다."));
    }

    public int getScore() {
        return denomination.getScore();
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "denomination=" + denomination +
                ", suit=" + suit +
                '}';
    }
}
