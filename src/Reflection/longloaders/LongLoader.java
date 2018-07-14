package Reflection.longloaders;

import java.util.Random;

public class LongLoader implements ILoader{
    @Override
    public void load(String data) {
        Random random = new Random();

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(data + " loaded");
    }
}
