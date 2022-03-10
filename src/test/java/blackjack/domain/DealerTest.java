package blackjack.domain;

import static blackjack.domain.CardsTestDataGenerator.generateCards;
import static blackjack.domain.CardsTestDataGenerator.generateTotalScoreNotMoreThan16Cards;
import static blackjack.domain.Denomination.*;
import static blackjack.domain.Suit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @DisplayName("카드 리스트가 주어지면 정상적으로 생성된다.")
    @Test
    void 딜러_생성_정상() {
        List<Card> cards = generateCards();

        assertDoesNotThrow(() -> new Dealer(cards));
    }

    @DisplayName("딜러 가진 카드의 총점을 구한다.")
    @Test
    void 딜러_카드_총점_11() {
        List<Card> cards = List.of(Card.of(ACE, CLOVER), Card.of(KING, DIAMOND));
        Dealer dealer = new Dealer(cards);

        assertThat(dealer.getTotalScore()).isEqualTo(21);
    }

    @DisplayName("딜러의 점수가 16점 이하인 경우 카드를 받을 수 있다.")
    @Test
    void 카드_발급_유무_확인() {
        Dealer dealer = new Dealer(generateTotalScoreNotMoreThan16Cards());

        assertThat(dealer.isDrawable()).isTrue();
    }

    @DisplayName("카드를 받아서 합칠 수 있다.")
    @Test
    void 카드_합침() {
        Dealer dealer = new Dealer(generateCards());
        Card card = Card.of(FIVE, SPADE);

        dealer.combine(card);

        assertThat(dealer.getCards().size()).isEqualTo(3);
    }
}
