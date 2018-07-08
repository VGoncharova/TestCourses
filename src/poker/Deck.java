package poker;

public class Deck {

    private String[] deck = new String[52];
    private String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
    private String[] prioritySet = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    public String[] getDeck() {
        int k = 0;
        for (String suit : suits) {
            for (String aPrioritySet : prioritySet) {
                deck[k] = suit + " " + aPrioritySet;
                k++;
            }
        }

        return deck;
    }

}
