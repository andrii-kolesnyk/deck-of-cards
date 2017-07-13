package ak.programming.task.model;

import static ak.programming.task.model.CardType.*;

public enum DeckType {
    Small(36, new CardType[]{Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}),
    Standard(52, new CardType[]{Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}),
    StandardWithJoker(54, new CardType[]{Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace, Joker});

    private final int size;
    private final CardType[] cardTypes;

    DeckType(int size, CardType[] cardTypes) {
        this.size = size;
        this.cardTypes = cardTypes;
    }

    public int getSize() {
        return size;
    }

    public CardType[] getCardTypes() {
        return this.cardTypes;
    }
}
