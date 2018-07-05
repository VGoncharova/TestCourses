package zoo.cages;

import zoo.animals.Animal;

public class Volier extends Cage {
    private int radius;

    public Volier(Animal[] animals, int radius) {
        super(animals);
        this.radius = radius;
    }

    @Override
    public String getCageDescription() {
        StringBuilder descriptionBuilder = new StringBuilder();

        descriptionBuilder.append(super.getCageDescription());
        descriptionBuilder.append("volier radius=");
        descriptionBuilder.append(this.radius);

        return descriptionBuilder.toString();
    }
}
