package Reflection.weapons;

import java.util.Scanner;

public class WeaponExecutor {
    public static void main(String[] args) {
        Weapon[] weapons = {
                                new Gun(10),
                                new ShortGun(5),
                                new Gun(15),
                                new BFG(100),
                                new Gun(4),
                                new BFG(200)
                            };
        Scanner scanner = new Scanner(System.in);
        System.out.println("What weapon do you want to ban?");
        String bannedWeaponName = scanner.next();

        for (Weapon weapon:
             weapons) {
//            System.out.println(weapon.getClass().getName());
            if(weapon.getClass().getName().equals(bannedWeaponName)){
                System.out.println("Sorry " + bannedWeaponName
                                            + " is banned!");
                continue;
            }
            weapon.shout();
        }
    }
}
