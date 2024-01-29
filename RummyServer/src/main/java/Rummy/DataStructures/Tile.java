package Rummy.DataStructures;

enum Color {
    SPADES, HEARTS, CLUBS, DIAMONDS
}

public class Tile {

    public Color color;
    public int value;

    public Tile(Color color, int value) {
        this.color = color;
        this.value = value;
    }

}
