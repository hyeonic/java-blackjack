package blackjack.view;

import static java.util.stream.Collectors.joining;

import blackjack.domain.Card;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printStartInfo(Dealer dealer, List<Player> players) {
        String names = players.stream()
                .map(Player::getName)
                .collect(joining(", "));
        System.out.println("\n딜러와 " + names + "에게 2장씩 나누었습니다.");

        System.out.println("딜러: " + cardInfo(dealer.getCards().get(0)));
        players.forEach(OutputView::printPlayerCardInfo);
        System.out.println();
    }

    public static void printPlayerCardInfo(Player player) {
        String cardsInfo = player.getCards().stream()
                .map(card -> cardInfo(card))
                .collect(joining(", "));

        System.out.println(player.getName() + ": " + cardsInfo);
    }

    private static String cardInfo(Card card) {
        return card.getDenomination().getName() + card.getSuit().getName();
    }

    public static void printDealerDrawableInfo() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printResultInfo(Dealer dealer, List<Player> players) {
        createDealerResultInfo(dealer);
        players.forEach(OutputView::createPlayerResultInfo);
    }

    private static void createPlayerResultInfo(Player player) {
        String cardsInfo = player.getCards().stream()
                .map(card -> cardInfo(card))
                .collect(joining(", "));

        System.out.println(player.getName() + ": " + cardsInfo + " - 결과: " + player.getTotalScore());
    }

    private static void createDealerResultInfo(Dealer dealer) {
        String cardsInfo = dealer.getCards().stream()
                .map(card -> cardInfo(card))
                .collect(joining(", "));

        System.out.println("\n딜러: " + cardsInfo + " - 결과: " + dealer.getTotalScore());
    }
}

