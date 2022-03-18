package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public interface State {

    State draw(Card card);

    State stay();

    boolean isReady();

    boolean isFinished();

    Cards cards();
}
