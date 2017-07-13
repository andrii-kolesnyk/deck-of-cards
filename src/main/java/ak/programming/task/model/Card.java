package ak.programming.task.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Card {
    private CardType cardType;
    private Suit suit;
}
