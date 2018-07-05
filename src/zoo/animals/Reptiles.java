package zoo.animals;

public abstract class Reptiles extends Animal{
    private short tailLenght;

    public short getTailLenght() {
        return tailLenght;
    }

    public Reptiles(String name, String colorDescription, short tailLenght) {
        super(name, colorDescription);
        this.tailLenght = tailLenght;
    }

    @Override
    public String toString() {
        return "Reptiles{" +
                "tailLenght=" + tailLenght +
                ", name='" + name + '\'' +
                ", colorDescription='" + colorDescription + '\'' +
                '}';
    }
}
