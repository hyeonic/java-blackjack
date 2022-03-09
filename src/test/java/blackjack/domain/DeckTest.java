package blackjack.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    @DisplayName("Deck을 정상 생성한다.")
    @Test
    void Deck_정상_생성() {
        assertDoesNotThrow(() -> new Deck(Card.VALUES));
    }

    @DisplayName("카드 뭉치의 갯수가 부족하여 생성에 실패한다.")
    @Test
    void Deck_카드_뭉치_갯수_부족() {
        assertThatThrownBy(() -> new Deck(Set.of(Card.of(Denomination.ACE, Suit.DIAMOND))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("카드 뭉치의 갯수가 부족합니다.");
    }
}