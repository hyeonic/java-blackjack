package blackjack.domain;

import static blackjack.domain.CardsTestDataGenerator.generateCards;
import static blackjack.domain.CardsTestDataGenerator.generateTotalScoreGraterThan21Cards;
import static blackjack.domain.CardsTestDataGenerator.generateTotalScoreNotMoreThan21Cards;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayerTest {

    @DisplayName("이름과 카드 리스트가 주어지면 정상적으로 생성된다.")
    @Test
    void 플레이어_생성_정상() {
        String name = "mat";
        List<Card> cards = List.of(Card.of(Denomination.ACE, Suit.CLOVER), Card.of(Denomination.KING, Suit.DIAMOND));

        assertDoesNotThrow(() -> new Player(name, cards));
    }

    @DisplayName("플레이어가 가진 카드의 총점을 구한다.")
    @ParameterizedTest
    @MethodSource("blackjack.domain.CardsTestDataGenerator#cardsAndTotalScoreMethodSource")
    void 플레이어_카드_총점_Cards(Cards cards, int totalScore) {
        String name = "mat";
        Player player = new Player(name, cards.getValue());

        assertThat(player.getTotalScore()).isEqualTo(totalScore);
    }

    @DisplayName("플레이어의 총 점수가 21점 이하인 경우 hit가 가능하다.")
    @Test
    void 플레이어_게임_지속_가능() {
        String name = "mat";
        List<Card> cards = generateTotalScoreNotMoreThan21Cards();
        Player player = new Player(name, cards);

        assertThat(player.isPlaying()).isTrue();
    }

    @DisplayName("플레이어의 총 점수가 21점을 초과하는 경우 hit가 불가능하다.")
    @Test
    void 플레이어_게임_지속_불가능() {
        String name = "mat";
        List<Card> cards = generateTotalScoreGraterThan21Cards();
        Player player = new Player(name, cards);

        assertThat(player.isPlaying()).isFalse();
    }

    @DisplayName("카드를 받아서 합칠 수 있다.")
    @Test
    void 카드_합침() {
        Player player = new Player("mat", generateCards());
        Card card = Card.of(Denomination.FIVE, Suit.SPADE);

        player.combine(card);

        assertThat(player.getCards().size()).isEqualTo(3);
    }
}
