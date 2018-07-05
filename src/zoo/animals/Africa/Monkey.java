package zoo.animals.Africa;

import zoo.animals.Mleko;

public class Monkey extends Mleko {
    private int wordKnown;

    public int getWordKnown() {
        return wordKnown;
    }

    public void setWordKnown(int wordKnown) {
        this.wordKnown = wordKnown;
    }

    public Monkey(String name, String colorDescription, boolean isWool, int wordKnown) {
        super(name, colorDescription, isWool);
        this.wordKnown = wordKnown;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "wordKnown=" + wordKnown +
                ", name='" + name + '\'' +
                ", colorDescription='" + colorDescription + '\'' +
                "}\n";
    }
}
