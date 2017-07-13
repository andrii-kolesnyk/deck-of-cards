package ak.programming.task;

import ak.programming.task.model.DeckType;

public class App {
    public static void main(String[] args) {
        for (DeckType deckType : DeckType.values()) {
            System.out.println(deckType);

            Deck deck = new Deck(deckType);
            System.out.println("Deck size: " + deck.getSize());
            deck.getDeck().forEach(System.out::println);
            deck.shuffle();
            System.out.println();
            System.out.println("Shuffled card deck");
            System.out.println();
            deck.getDeck().forEach(System.out::println);
            System.out.println();
        }
    }
}
