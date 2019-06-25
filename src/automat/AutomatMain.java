package automat;

import java.util.HashMap;
import java.util.Scanner;

public class AutomatMain {
    private static HashMap<Items, Double> listaProduktow;
    private static Scanner scanner;

    public static void main(String[] args) {

        init();
        dzialaj(listaProduktow);
    }

    private static void init() {
        listaProduktow = new HashMap<>();
        scanner = new Scanner(System.in);
        listaProduktow.put(Items.BATON, 2.20);
        listaProduktow.put(Items.CHIPSY, 3.00);
        listaProduktow.put(Items.PALUSZKI, 1.80);
        listaProduktow.put(Items.WODA, 1.75);
        listaProduktow.put(Items.COLA, 3.50);
        listaProduktow.put(Items.SPRITE, 3.50);
        listaProduktow.put(Items.FANTA, 3.50);
        listaProduktow.put(Items.PEPSI, 3.20);
        listaProduktow.put(Items.SEVEN_UP, 3.20);
        listaProduktow.put(Items.MIRINDA, 3.20);
    }

    private static void dzialaj(HashMap<Items, Double> produkty) {
        Double kasa = 0.0;
        System.out.println("Witaj w automacie vendingowym!");
        System.out.println("Dostępne w ofercie są:");
        System.out.println(produkty);
        wrzucMonete(kasa, produkty);
    }

    private static void wrzucMonete(Double kasa, HashMap<Items, Double> produkty) {
        double nowaKasa;
        boolean dalej;
        System.out.println("Monety 1, 2 i 5 PLN, co wrzucasz?");
        nowaKasa = scanner.nextDouble() + kasa;
        System.out.println("Masz " + nowaKasa + " PLN");
        System.out.println("Wrzucamy dalej? [true/false]");
        dalej = scanner.nextBoolean();
        if (dalej) {
            wrzucMonete(nowaKasa, produkty);
        } else {
            wybierzProdukt(nowaKasa, produkty);
        }
    }

    private static void wybierzProdukt(double nowaKasa, HashMap<Items, Double> produkty) {
        String odpowiedz;
        Double kasaPoSprzedazy;
        Double wartoscProduktu;
        Items produkt;
        System.out.println("Masz " + nowaKasa + " PLN");
        System.out.println("To na co się zdecydujesz?");
        System.out.println(produkty);
        odpowiedz = scanner.next().toUpperCase();
        produkt = odzyskajProduktZListy(odpowiedz);
        wartoscProduktu = produkty.get(produkt);
        kasaPoSprzedazy = nowaKasa - wartoscProduktu;
        System.out.println("Kupujesz " + odpowiedz);
        System.out.println("Wydaję reszty " + kasaPoSprzedazy + " PLN");
        System.out.println();
        dzialaj(produkty);
    }

    private static Items odzyskajProduktZListy(String odpowiedz) {
        switch (odpowiedz) {
            case "BATON": {
                return Items.BATON;
            }
            case "WODA": {
                return Items.WODA;
            }
            case "CHIPSY": {
                return Items.CHIPSY;
            }
            case "PALUSZKI": {
                return Items.PALUSZKI;
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
}

