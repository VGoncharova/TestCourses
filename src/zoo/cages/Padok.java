package cources.zoo.cages;

import cources.zoo.animals.Animal;

public class Padok extends Cage {
    private int square;

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public Padok(Animal[] animals, int square) {
        super(animals);
        this.square = square;
    }

    @Override
    public String getCageDescription() {
        StringBuilder descriptionBuilder = new StringBuilder();

        descriptionBuilder.append(super.getCageDescription());
        descriptionBuilder.append("square=");
        descriptionBuilder.append(this.square);

        return descriptionBuilder.toString();
    }
}
