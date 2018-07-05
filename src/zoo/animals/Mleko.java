package zoo.animals;

public abstract class Mleko extends Animal {
    private boolean isWool;

    public boolean isWool() {
        return isWool;
    }

    public Mleko(String name, String colorDescription, boolean isWool) {
        super(name, colorDescription);
        this.isWool = isWool;
    }

    @Override
    public String toString() {
        return "Mleko{" +
                "isWool=" + isWool +
                ", name='" + name + '\'' +
                ", colorDescription='" + colorDescription + '\'' +
                '}';
    }
}
