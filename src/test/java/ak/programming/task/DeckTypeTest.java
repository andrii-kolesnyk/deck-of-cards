package ak.programming.task;

import ak.programming.task.model.DeckType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTypeTest extends BaseTest {

    @Test
    public void testSmallDeckShouldHave36Cards() {
        assertEquals(SMALL_DECK_SIZE, DeckType.Small.getSize());
    }

    @Test
    public void testStandardDeckShouldHave52Cards() {
        assertEquals(STANDARD_DECK_SIZE, DeckType.Standard.getSize());
    }

    @Test
    public void testStandardWithJokerDeckShouldHave54Cards() {
        Deck deck = new Deck(DeckType.StandardWithJoker);
        assertEquals(STANDARD_WITH_JOKER_DECK_SIZE, DeckType.StandardWithJoker.getSize());
    }
}
