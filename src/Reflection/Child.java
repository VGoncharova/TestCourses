package Reflection;

public class Child extends Parent implements IPlayer{
    public String name;
    protected int totalCash;
    private boolean isVirgin = true;

    public void saySome(){
        System.out.println("Bla bla");
    }

    protected int getTotalCash(){
        return totalCash;
    }

    private void changeVirgin(){
        isVirgin = false;
    }

    @Override
    public void play(String gameName) {
        System.out.println("i play " + gameName);
    }

    @Override
    public int getPlayEnjoy() {
        return 10;
    }
}
