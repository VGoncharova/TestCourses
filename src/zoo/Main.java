package cources.zoo;

import cources.zoo.animals.HasNotTicketException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        System.out.println("Do you want to buy a ticket? y/n");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().toLowerCase().equals("y")){
            zoo.buyTicket();
        }
        try {
            for (int i = 0; i < zoo.getCagesCount(); i++) {
                System.out.println(zoo.getCageReport(i) + "\n");
            }

            String[] animalNames = {"Aby", "Brown", "Zorkii"};
            for (String animal : animalNames) {
                System.out.println(animal + " - cage " + zoo.getCageNumberByAnimalName(animal));
            }
        }catch (HasNotTicketException e){
            System.out.println("Buy ticket, please");
        }
    }
}
