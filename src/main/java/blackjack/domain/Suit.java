package blackjack.domain;

public enum Suit {

    SPADE("스페이드"),
    DIAMOND("다이아몬드"),
    HEART("하트"),
    CLOVER("클로버"),
    ;

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public boolean isSame(Card card) {
        return this == card.getSuit();
    }

    public String getName() {
        return name;
    }
}
