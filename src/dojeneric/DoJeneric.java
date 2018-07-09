package dojeneric;

public class DoJeneric<Param> {
    Param objectGen;

    public DoJeneric(Param o) {
        objectGen = o;
    }

    public Param getObjectGen() {
        return objectGen;
    }

    public void setObjectGen(Param objectGen) {
        this.objectGen = objectGen;
    }
}
