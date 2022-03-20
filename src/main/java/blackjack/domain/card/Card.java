package blackjack.domain.card;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Denomination denomination;
    private final Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public int calculateScore(int score) {
        return denomination.addScore(score);
    }

    public boolean isAce() {
        return denomination.isAce();
    }

    public String getDenomination() {
        return denomination.getName();
    }

    public String getSuit() {
        return suit.getName();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(o.denomination.getScore(), denomination.getScore());
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
}
