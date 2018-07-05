package zoo;

import zoo.animals.Africa.Monkey;
import zoo.animals.Animal;
import zoo.animals.Australia.Varan;
import zoo.animals.Europe.Eagle;
import zoo.animals.HasNotTicketException;
import zoo.cages.Cage;
import zoo.cages.Padok;
import zoo.cages.Terrarium;
import zoo.cages.Volier;

public class Zoo {
    public static final int ANIMAL_NOT_FOUND = -1;
    private Cage[] cages;
    private boolean hasTicket;

    public Zoo() {
        cages = new Cage[3];

        Animal[] animalsFirst = new Animal[2];
        animalsFirst[0] = new Monkey("Aby", "Brown", true, 4);
        animalsFirst[1] = new Monkey("Mister", "Black", true, 3);
        Cage first = new Volier(animalsFirst, 10);
        cages[0] = first;

        Animal[] animalsSecond = new Animal[2];
        animalsSecond[0] = new Eagle("Zorkii", "black", (short) 10, 6);
        animalsSecond[1] = new Eagle("Metkii", "gray", (short) 5, 4);
        Cage second = new Padok(animalsSecond, 10);
        cages[1] = second;

        Animal[] animalsThird = new Animal[1];
        animalsThird[0] = new Varan("Odinokii", "Duochrome", (short) 7, true);
        Cage third = new Terrarium(animalsThird, 1000);
        cages[2] = third;
    }

    public int getCagesCount() throws HasNotTicketException {
        if (!hasTicket) {
            throw new HasNotTicketException();
        }
        return cages.length;
    }

    public String getCageReport(int cageNumber) throws HasNotTicketException {
        if (!hasTicket) {
            throw new HasNotTicketException();
        }
        return cages[cageNumber].getCageDescription();
    }

    public void buyTicket() {
        hasTicket = true;
    }

    public int getCageNumberByAnimalName(String animalName) throws HasNotTicketException {
        if (!hasTicket) {
            throw new HasNotTicketException();
        }
        for (int i = 0; i < cages.length; i++) {
            Animal[] animalsInCage = cages[i].getAnimals();
            for (Animal anAnimalsInCage : animalsInCage) {
                if (anAnimalsInCage.getName().equals(animalName)) {
                    return i + 1;
                }
            }
        }
        return ANIMAL_NOT_FOUND;
    }


}
