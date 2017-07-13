package ak.programming.task.model;

public enum CardType {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14),
    Joker(15, new Suit[]{Suit.Joker});

    private int rank;
    private Suit[] suits;

    CardType(int rank, Suit[] suits) {
        this.rank = rank;
        this.suits = suits;
    }

    CardType(int rank) {
        this(rank, new Suit[]{Suit.Club, Suit.Diamond, Suit.Heart, Suit.Spade});
    }

    public int getRank() {
        return this.rank;
    }

    public Suit[] getSuits() {
        return suits;
    }
}
