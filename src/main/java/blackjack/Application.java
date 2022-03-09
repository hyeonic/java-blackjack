package blackjack;

import static java.util.stream.Collectors.*;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Player;
import blackjack.view.HitCommand;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Deck deck = new Deck(Card.VALUES);
        Dealer dealer = new Dealer(initCards(deck));

        List<String> names = InputView.getNames();
        List<Player> players = names.stream()
                .map(name -> new Player(name, initCards(deck)))
                .collect(toList());

        OutputView.printStartInfo(dealer, players);
        System.out.println();

        for (Player player : players) {
            playing(deck, player);
        }
    }

    public static List<Card> initCards(Deck deck) {
        return List.of(deck.draw(), deck.draw());
    }

    public static void playing(Deck deck, Player player) {
        while (!player.isBust()) {
            HitCommand hitCommand = InputView.getHitCommand(player);

            if (hitCommand == HitCommand.YES) {
                player.combine(deck.draw());
                OutputView.printPlayerCardInfo(player);
            }

            if (hitCommand == HitCommand.NO) {
                OutputView.printPlayerCardInfo(player);
                break;
            }
        }
    }
}
