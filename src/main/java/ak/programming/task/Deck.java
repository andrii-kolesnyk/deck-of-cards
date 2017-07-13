package ak.programming.task;

import ak.programming.task.exception.DeckIsEmptyError;
import ak.programming.task.model.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Deck {
    private final List<Card> deck;
    private final DeckType deckType;

    public Deck(DeckType deckType) {
        this.deckType = deckType;
        this.deck = initDeck(deckType);
    }

    //Visible for testing
    List<Card> initDeck(DeckType deckType) {
        List<Card> deck = new ArrayList<>(deckType.getSize());

        for (CardType cardType : deckType.getCardTypes()) {

            for (Suit suit : cardType.getSuits()) {
                for (int i = 0; i < suit.getAmountPerColor(); i++) {
                    Card card = new Card(cardType, suit);
                    deck.add(card);
                }
            }
        }
        return deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int getSize() {
        return deck.size();
    }

    public Card pickACard() {
        try {
            return this.deck.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new DeckIsEmptyError(e.getMessage(), e.getCause());
        }
    }
}
