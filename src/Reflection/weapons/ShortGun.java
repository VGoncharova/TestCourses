package Reflection.weapons;

public class ShortGun extends Weapon {
    public ShortGun(int power) {
        super(power);
    }

    @Override
    public void shout() {
        System.out.println("Boom!");
    }
}
