package wendingMachine;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Scanner;

public class WendingMachineMain {
    public static Scanner scanner;
    public static double credit = 0.00;

    public static void main(String[] args) {

        makeList();
        buyItem(makeList());

    }

    public static HashMap makeList() {

        HashMap<wendingMachine.Items, Double> listOfItems = new HashMap<>();
        listOfItems.put(wendingMachine.Items.BAR, 2.40);
        listOfItems.put(wendingMachine.Items.WATER, 1.50);
        listOfItems.put(wendingMachine.Items.CRISPS, 3.20);
        listOfItems.put(wendingMachine.Items.CANDY, 3.40);
        listOfItems.put(wendingMachine.Items.COLA, 2.70);
        listOfItems.put(wendingMachine.Items.SPRITE, 2.80);
        listOfItems.put(wendingMachine.Items.FANTA, 2.60);
        listOfItems.put(wendingMachine.Items.PEPSI, 2.50);
        listOfItems.put(wendingMachine.Items.SEVEN_UP, 2.90);
        listOfItems.put(wendingMachine.Items.MIRINDA, 2.30);

        return listOfItems;
    }

    public static void buyItem(HashMap<wendingMachine.Items, Double> listOfItems) {

        System.out.println("Hello, items available:");
        System.out.println(listOfItems);
        System.out.println("Machine only accepts: 1$, 2$, 5$ coins.");
        putCoin();

    }

    public static void putCoin() {

        scanner = new Scanner(System.in);
        double coin;
        String decision;
        System.out.println("Put 1$, 2$ or 5$ coin.");
        coin = scanner.nextDouble();
        if (coin == 1.00 || coin == 2.00 || coin == 5.00) {
            credit += coin;
            System.out.println("You have " + credit + "$");
            System.out.println("Want to put another coin? Type yes or no.");
            decision = scanner.next().toLowerCase();
            if (decision.equals("yes")) {
                putCoin();
            } else {
                chooseItem(credit);
            }
        } else {
            System.out.println("Wrong coin.");
            putCoin();
        }

    }

    public static void chooseItem(double credit) {

        scanner = new Scanner(System.in);
        String answer;

        System.out.println("You have " + credit + "$");
        System.out.println("Choose product:");
        System.out.println(makeList());
        answer = scanner.nextLine().toUpperCase();

        if (
                answer.equals("BAR") ||
                        answer.equals("WATER") ||
                        answer.equals("CRISPS") ||
                        answer.equals("CANDY") ||
                        answer.equals("COLA") ||
                        answer.equals("FANTA") ||
                        answer.equals("SPRITE") ||
                        answer.equals("PEPSI") ||
                        answer.equals("MIRINDA") ||
                        answer.equals("SEVEN_UP")
        ) {
            System.out.println("You choose: " + printItem(answer));
            giveChange(printItem(answer));
        } else {
            System.out.println("Item not available.");
            chooseItem(credit);
        }
    }

    public static wendingMachine.Items printItem(String item) {
        switch (item) {
            case "BAR": {
                return Items.BAR;
            }
            case "WATER": {
                return Items.WATER;
            }
            case "CRISPS": {
                return Items.CRISPS;
            }
            case "CANDY": {
                return Items.CANDY;
            }
            case "COLA": {
                return Items.COLA;
            }
            case "FANTA": {
                return Items.FANTA;
            }
            case "SPRITE": {
                return Items.SPRITE;
            }
            case "PEPSI": {
                return Items.PEPSI;
            }
            case "MIRINDA": {
                return Items.MIRINDA;
            }
            default: {
                return Items.SEVEN_UP;
            }
        }

    }

    public static void giveChange(Items item) {
        double itemValue = (double) makeList().get(item);
        scanner = new Scanner(System.in);
        String decision;
        if (itemValue > credit) {
            System.out.println("You do not have enough credit, want to put more coins? Type: yes or no.");
            decision = scanner.nextLine().toLowerCase();
            if (decision.equals("yes")) {
                putCoin();
            } else {
                System.out.println("Thank you for visiting our wending machine. Get out.");
            }
        } else {
            double change = credit - itemValue;
            System.out.println("You purchased " + item);
            System.out.println("Please take your " + change + "$ change.");
            System.out.println("Thank you for visiting our wending machine. Have a nice day :)!");
        }
    }
}
