package cources.zoo.cages;

import cources.zoo.animals.Animal;

public abstract class Cage implements ICageDescriptor {
    protected Animal[] animals;

    public Cage(Animal[] animals) {
        this.animals = animals;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    @Override
    public String getCageDescription() {
        StringBuilder descriptionBuilder = new StringBuilder();

        for (Animal animal:
                    animals) {
            descriptionBuilder.append(animal.toString());
        }

        return descriptionBuilder.toString();
    }
}
