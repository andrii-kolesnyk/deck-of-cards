package ak.programming.task.model;

public enum Suit {
    Club(Color.Green, 1),
    Diamond(Color.Blue, 1),
    Heart(Color.Red, 1),
    Spade(Color.Black, 1),
    Joker(Color.None, 2);

    private Color color;
    private int amountPerColor;

    Suit(Color color, int amountPerColor) {
        this.color = color;
        this.amountPerColor = amountPerColor;
    }

    public Color getColor() {
        return color;
    }

    public int getAmountPerColor() {
        return amountPerColor;
    }
}
