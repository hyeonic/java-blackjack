package blackjack.domain;

import static blackjack.domain.Denomination.*;
import static blackjack.domain.Suit.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class CardsTestDataGenerator {

    public static Stream<Arguments> cardsAndTotalScoreMethodSource() {
        return Stream.of(
                arguments(new Cards(List.of(Card.of(NINE, CLOVER), Card.of(EIGHT, DIAMOND))), 17),
                arguments(new Cards(List.of(Card.of(TWO, HEART), Card.of(EIGHT, SPADE), Card.of(ACE, CLOVER))), 21),
                arguments(new Cards(List.of(Card.of(SEVEN, CLOVER), Card.of(KING, SPADE))), 17),
                arguments(new Cards(List.of(Card.of(ACE, CLOVER), Card.of(ACE, SPADE))), 12),
                arguments(new Cards(List.of(Card.of(ACE, CLOVER), Card.of(KING, SPADE))), 21),
                arguments(new Cards(List.of(Card.of(ACE, CLOVER), Card.of(ACE, SPADE), Card.of(THREE, HEART))), 15)
        );
    }

    public static List<Card> generateCards() {
        return List.of(Card.of(ACE, Suit.CLOVER), Card.of(KING, Suit.DIAMOND));
    }

    public static List<Card> generateTotalScoreGraterThan21Cards() {
        return List.of(Card.of(JACK, Suit.CLOVER), Card.of(QUEEN, Suit.CLOVER), Card.of(KING, Suit.DIAMOND));
    }

    public static List<Card> generateTotalScoreNotMoreThan21Cards() {
        return List.of(Card.of(JACK, Suit.CLOVER), Card.of(QUEEN, Suit.CLOVER));
    }

    public static List<Card> generateTotalScoreNotMoreThan16Cards() {
        return List.of(Card.of(JACK, Suit.CLOVER), Card.of(TWO, Suit.CLOVER));
    }
}
