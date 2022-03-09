package blackjack.view;

import java.util.Arrays;

public enum HitCommand {

    YES("y"),
    NO("n"),
    ;

    private final String command;

    HitCommand(String command) {
        this.command = command;
    }

    public static HitCommand of(String inputCommand) {
        return Arrays.stream(values())
                .filter(hitCommand -> hitCommand.command.equals(inputCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 명령어 입니다."));
    }
}
