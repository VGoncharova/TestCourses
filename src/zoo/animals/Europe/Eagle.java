package zoo.animals.Europe;

import zoo.animals.Birds;

public class Eagle extends Birds {
    private int eyeStrenght;

    public int getEyeStrenght() {
        return eyeStrenght;
    }

    public void setEyeStrenght(int eyeStrenght) {
        this.eyeStrenght = eyeStrenght;
    }

    public Eagle(String name, String colorDescription, short wingSize, int eyeStrenght) {
        super(name, colorDescription, wingSize);
        this.eyeStrenght = eyeStrenght;
    }

    @Override
    public String toString() {
        return "Eagle{" +
                "eyeStrenght=" + eyeStrenght +
                ", name='" + name + '\'' +
                ", colorDescription='" + colorDescription + '\'' +
                "}\n";
    }
}
