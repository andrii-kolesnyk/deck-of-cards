package ak.programming.task;

import ak.programming.task.exception.DeckIsEmptyError;
import ak.programming.task.model.Card;
import ak.programming.task.model.CardType;
import ak.programming.task.model.DeckType;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DeckTest extends BaseTest {

    @Test
    public void testDeckStandardWithJokerShouldHave4CardTypesAnd2Jokers() {
        Deck deck = new Deck(DeckType.StandardWithJoker);

        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Two);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Three);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Four);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Five);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Six);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Seven);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Eight);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Nine);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Ten);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Jack);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Queen);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.King);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Ace);

        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 2, CardType.Joker);
    }

    @Test
    public void testDeckStandardShouldHave4CardTypes() {
        Deck deck = new Deck(DeckType.Standard);

        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Two);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Three);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Four);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Five);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Six);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Seven);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Eight);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Nine);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Ten);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Jack);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Queen);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.King);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Ace);

        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 0, CardType.Joker);
    }

    @Test
    public void testDeckSmallShouldHave4CardTypes() {
        Deck deck = new Deck(DeckType.Small);

        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 0, CardType.Two);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 0, CardType.Three);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 0, CardType.Four);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 0, CardType.Five);

        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Six);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Seven);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Eight);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Nine);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Ten);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Jack);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Queen);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.King);
        checkDecksShouldHaveAmountOfTypesPerSuite(deck, 4, CardType.Ace);
    }

    private void checkDecksShouldHaveAmountOfTypesPerSuite(Deck deck, int expectedAmount, CardType cardType) {
        int cardTypeCount = 0;
        for (Card card : deck.getDeck()) {
            if (card.getCardType().equals(cardType)) {
                cardTypeCount++;
            }
        }

        assertEquals(expectedAmount, cardTypeCount);
    }

    @Test
    public void testSmallDeckShouldHave36Cards() {
        Deck deck = new Deck(DeckType.Small);
        assertEquals(SMALL_DECK_SIZE, deck.getDeck().size());
    }

    @Test
    public void testStandardDeckShouldHave52Cards() {
        Deck deck = new Deck(DeckType.Standard);
        assertEquals(STANDARD_DECK_SIZE, deck.getDeck().size());
    }

    @Test
    public void testStandardWithJokerDeckShouldHave54Cards() {
        Deck deck = new Deck(DeckType.StandardWithJoker);
        assertEquals(STANDARD_WITH_JOKER_DECK_SIZE, deck.getDeck().size());
    }

    @Test
    public void testPickACardShouldReturnFirstCard() {
        Deck deck = new Deck(DeckType.Small);
        Card first = deck.getDeck().get(0);
        Card firstPicked = deck.pickACard();

        assertSame(first, firstPicked);
    }

    @Test
    public void testPickACardShouldRemoveACardFormTheDeck() {
        Deck deck = new Deck(DeckType.Small);
        Card first = deck.pickACard();

        assertFalse(deck.getDeck().contains(first));
    }

    @Test(expected = DeckIsEmptyError.class)
    public void testPickACardShouldThrowErrorWhenDeckIsEmpty() {
        Deck deck = new Deck(DeckType.Small);
        int exceededDeckAmount = deck.getSize() + 1;
        for (int i = 0; i < exceededDeckAmount + 1; i++) {
            deck.pickACard();
        }
    }
}
