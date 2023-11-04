public class Card {

    private String suit; //Clubs, Hearts, Spades, Diamonds
    private String rank;


    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String toString() {
        return String.format("%s-%s", rank, suit, getValue());
    }
    public int getValue() {
        if ((rank == "A") || (rank == "K") || (rank == "J") || (rank == "Q")) {
            if (rank == "A") {
                return 11;
            } else return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }
}
