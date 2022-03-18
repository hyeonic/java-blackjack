package blackjack.domain.participant;

public class Name {

    private final String value;

    public Name(String value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (value.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 아니어야합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
