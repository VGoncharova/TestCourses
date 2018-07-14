package Reflection.boxes;

public class Main {
    public static void main(String[] args) {
        RestrictedBox restrictedBox =
                new RestrictedBox();

        restrictedBox.addToBox(new Cat());
        restrictedBox.addToBox(new Ball());
        restrictedBox.addToBox(new Poison());

        BigBox bigBox = new BigBox();
        SmallBox smallBox = new SmallBox();
        for (int i = 0; i < 15; i++) {
            System.out.println("Adding to big box number " + i );
            bigBox.addToBox(new Cat());
            System.out.println("Adding to small box number " + i );
            smallBox.addToBox(new Cat());
        }
    }
}
