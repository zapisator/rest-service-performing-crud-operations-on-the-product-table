package service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Id
    private Integer id;

    private String name;
    private Integer amount;

    @Override
    public String toString() {
        final String ANSI_BRIGHT_BLACK  = "\u001B[90m";
        final String ANSI_BRIGHT_RED    = "\u001B[91m";
        final String ANSI_BRIGHT_GREEN  = "\u001B[92m";
        final String ANSI_RESET  = "\u001B[0m";

        return String.format(
                "\n\tProduct: {\n\t\tid: %s%d%s,\n\t\tname: %s%s%s,\n\t\tamount: %s%d%s\n\t}\n",
                id == null ? ANSI_BRIGHT_BLACK : ANSI_BRIGHT_RED, id, ANSI_RESET,
                name == null ? ANSI_BRIGHT_BLACK : ANSI_BRIGHT_GREEN, name, ANSI_RESET,
                amount == null ? ANSI_BRIGHT_BLACK : ANSI_BRIGHT_RED, amount, ANSI_RESET
        );
    }

}
