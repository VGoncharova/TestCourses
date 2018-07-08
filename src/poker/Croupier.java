package poker;

import java.util.Random;

public class Croupier {
    private Deck deck = new Deck();
    private int playersQuantity;
    private String[] currentDeck = deck.getDeck();

    private void reSortDeck() {

        Random random = new Random();
        for (int i = currentDeck.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            //swap
            String newIndex = currentDeck[index];
            currentDeck[index] = currentDeck[i];
            currentDeck[i] = newIndex;
        }
    }

    public void setPlayersQuantity(int playersQuantity) {
        this.playersQuantity = playersQuantity;
    }

    public String[][] getPlayersCardSets() {
        reSortDeck();

        String[][] playerCardSet = new String[playersQuantity][5];
        for (int playerNumber = 0; playerNumber < playersQuantity; playerNumber++) {
            for (int cards = 0; cards < 5; cards++) {
                playerCardSet[playerNumber][cards] = currentDeck[playerNumber * 5 + cards];
            }
        }
        return playerCardSet;
    }
}
