package Reflection.privates;

public class ClosedClass {
    private int privateState;

    private void privateMethod(){
        privateState++;
    }

    public void publicMethod(){
        privateState = 10;
    }
}
