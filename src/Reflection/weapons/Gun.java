package Reflection.weapons;

public class Gun extends Weapon {
    public Gun(int power) {
        super(power);
    }

    @Override
    public void shout() {
        System.out.println("Bang!");
    }
}
