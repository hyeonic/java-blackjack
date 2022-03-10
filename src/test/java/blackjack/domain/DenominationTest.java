package blackjack.domain;

import static blackjack.domain.Denomination.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DenominationTest {

    @DisplayName("끗수는 가중치를 조회할 수 있다.")
    @Test
    void 가중치_조회() {
        int score = ACE.getScore();

        assertThat(score).isEqualTo(1);
    }

    @DisplayName("끗수 갯수는 13개 이어야한다.")
    @Test
    void 끗수_갯수_확인() {
        int size = values().length;

        assertThat(size).isEqualTo(13);
    }

    @DisplayName("끗수 이름을 조회한다.")
    @Test
    void 끗수_이름_조회() {
        String name = KING.getName();

        assertThat(name).isEqualTo("K");
    }

    @DisplayName("현재 점수를 기반으로 현재 끗수의 숫자를 더해 반환한다.")
    @Test
    void 점수_더하기() {
        Denomination three = THREE;

        int result = addScore(three, 10);

        assertThat(result).isEqualTo(13);
    }

    @DisplayName("현재 점수가 20점인 경우 ACE는 1점으로 계산된다.")
    @Test
    void 점수_ACE_20() {
        Denomination ace = ACE;

        int result = addScore(ace, 20);

        assertThat(result).isEqualTo(21);
    }

    @DisplayName("현재 점수가 10점인 경우 ACE는 11점으로 계산된다.")
    @Test
    void 점수_ACE_10() {
        Denomination ace = ACE;

        int result = addScore(ace, 10);

        assertThat(result).isEqualTo(21);
    }

    @DisplayName("현재 점수가 11점인 경우 ACE는 1점으로 계산된다.")
    @Test
    void 점수_ACE_11() {
        Denomination ace = ACE;

        int result = addScore(ace, 11);

        assertThat(result).isEqualTo(12);
    }
}
