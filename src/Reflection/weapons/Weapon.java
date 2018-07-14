package Reflection.weapons;

public abstract class Weapon {
    protected int power;

    public Weapon(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if(power > 0) {
            this.power = power;
        } else {
            System.out.println("Wrong power!");
        }
    }

    public abstract void shout();
}
