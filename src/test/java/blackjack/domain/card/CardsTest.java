package blackjack.domain.card;

import static blackjack.domain.CardsTestDataGenerator.generateCards;
import static blackjack.domain.card.Denomination.*;
import static blackjack.domain.card.Suit.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import blackjack.domain.CardsArgumentsProvider;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class CardsTest {

    @DisplayName("카드 리스트를 활용하여 Cards 를 생성한다.")
    @Test
    void 카드들_생성() {
        assertDoesNotThrow(() -> new Cards(generateCards()));
    }

    @DisplayName("Cards는 2개가 아닌 다른 갯수의 카드를 활용하여 생성할 경우 예외를 던진다.")
    @Test
    void 카드들_생성_실패() {
        assertThatThrownBy(() -> new Cards(List.of(new Card(ACE, CLOVER))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("카드의 개수는 2장이어야 합니다.");
    }

    @DisplayName("카드의 총점을 계산한다.")
    @Test
    void 카드_총점_계산() {
        List<Card> cardValues = List.of(new Card(JACK, CLOVER), new Card(ACE, DIAMOND));

        Cards cards = new Cards(cardValues);
        cards.append(new Card(FIVE, SPADE));

        assertThat(cards.calculateTotalScore()).isEqualTo(16);
    }

    @DisplayName("카드 List에 카드를 추가한다.")
    @Test
    void 카드_추가() {
        Cards cards = new Cards(generateCards());

        cards.append(new Card(KING, DIAMOND));

        assertThat(cards.getValue().size()).isEqualTo(3);
    }

    @DisplayName("Cards가 주어지면 점수를 계산하면 반환한다.")
    @ParameterizedTest
    @ArgumentsSource(CardsArgumentsProvider.class)
    void 카드_점수_계산(Cards cards, int totalScore) {
        assertThat(cards.calculateTotalScore()).isEqualTo(totalScore);
    }
}
