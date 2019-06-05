package samoloty;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainSamoloty {

    public static void main(String[] args) {

        dzialaj();
    }

    private static void dzialaj() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile jest lotnisk?");
        int x = scanner.nextInt();
        ileLotnisk(x);
    }

    private static void ileLotnisk(int x) {
        ArrayList<Lotnisko> listaLotnisk = new ArrayList<>();

        for (int i = 0; i <= x; i++) {
            listaLotnisk.add(new Lotnisko());
        }

        System.out.println("Każde zaczyna z jednym samolotem");
        System.out.println("Następuje losowanie lotu");

        Random randomizer = new Random();
        int random = 0;
        int random2 = 0;
        for (int i = 0; i <= x+1; i++) {
            random = randomizer.nextInt(x);
            random2 = randomizer.nextInt(x)+1;
        }
        if (random==0) {
            System.out.println("Lotnisko " + x + " nie wysyła samolotu");
        } else {
            listaLotnisk.get(random2).samolotyTeraz =
                    listaLotnisk.get(random2).samolotyTeraz-1;

            System.out.println("Z lotniska "
                    + random2
                    + " wyleciał samolot do lotniska "
                    + random);

            listaLotnisk.get(random).samolotyTeraz =
                    listaLotnisk.get(random).samolotyTeraz+1;

            System.out.println(random
                    + " lotnisko ma samolotyNaLotnisku "
                    + listaLotnisk.get(random).samolotyTeraz
                    + " samolotów");

            System.out.println(random2
                    + " lotnisko ma samolotyNaLotnisku "
                    + listaLotnisk.get(random2).samolotyTeraz
                    + " samolotów");

            if (listaLotnisk.get(random).samolotyTeraz>4){
                System.out.println("Przekierowuję samoloty");
            }
        }
    }
}
