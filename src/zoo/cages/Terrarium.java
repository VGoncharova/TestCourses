package zoo.cages;

import zoo.animals.Animal;

public class Terrarium extends Cage{
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Terrarium(Animal[] animals, int volume) {
        super(animals);
        this.volume = volume;
    }

    @Override
    public String getCageDescription() {
        StringBuilder descriptionBuilder = new StringBuilder();

        descriptionBuilder.append(super.getCageDescription());
        descriptionBuilder.append("volume=");
        descriptionBuilder.append(this.volume);

        return descriptionBuilder.toString();
    }
}
