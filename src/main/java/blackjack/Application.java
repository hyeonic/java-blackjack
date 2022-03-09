package blackjack;

import static java.util.stream.Collectors.*;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Deck deck = new Deck(Card.VALUES);
        Dealer dealer = new Dealer(initCards(deck));

        List<String> names = inputView.getNames();
        List<Player> players = names.stream()
                .map(name -> new Player(name, initCards(deck)))
                .collect(toList());
    }

    public static List<Card> initCards(Deck deck) {
        return List.of(deck.draw(), deck.draw());
    }
}
