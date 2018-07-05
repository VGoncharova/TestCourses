package cources.zoo.animals.Australia;

import cources.zoo.animals.Reptiles;

public class Varan extends Reptiles {
    private boolean poisonous;

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    public Varan(String name, String colorDescription, short tailLenght, boolean poisonous) {
        super(name, colorDescription, tailLenght);
        this.poisonous = poisonous;
    }

    @Override
    public String toString() {
        return "Varan{" +
                "poisonous=" + poisonous +
                ", name='" + name + '\'' +
                ", colorDescription='" + colorDescription + '\'' +
                "}\n";
    }
}
