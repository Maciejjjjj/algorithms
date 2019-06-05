package automat;

import java.util.HashMap;
import java.util.Scanner;

public class AutomatMain {
    private static HashMap<Produkty, Double> listaProduktow;
    private static Scanner scanner;

    public static void main(String[] args) {

        init();
        dzialaj(listaProduktow);
    }

    private static void init() {
        listaProduktow = new HashMap<>();
        scanner = new Scanner(System.in);
        listaProduktow.put(Produkty.BATON, 2.20);
        listaProduktow.put(Produkty.CHIPSY, 3.00);
        listaProduktow.put(Produkty.PALUSZKI, 1.80);
        listaProduktow.put(Produkty.WODA, 1.75);
        listaProduktow.put(Produkty.COLA, 3.50);
        listaProduktow.put(Produkty.SPRITE, 3.50);
        listaProduktow.put(Produkty.FANTA, 3.50);
        listaProduktow.put(Produkty.PEPSI, 3.20);
        listaProduktow.put(Produkty.SEVEN_UP, 3.20);
        listaProduktow.put(Produkty.MIRINDA, 3.20);
    }

    private static void dzialaj(HashMap<Produkty, Double> produkty) {
        Double kasa = 0.0;
        System.out.println("Witaj w automacie vendingowym!");
        System.out.println("Dostępne w ofercie są:");
        System.out.println(produkty);
        wrzucMonete(kasa, produkty);
    }

    private static void wrzucMonete(Double kasa, HashMap<Produkty, Double> produkty) {
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

    private static void wybierzProdukt(double nowaKasa, HashMap<Produkty, Double> produkty) {
        String odpowiedz;
        Double kasaPoSprzedazy;
        Double wartoscProduktu;
        Produkty produkt;
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

    private static Produkty odzyskajProduktZListy(String odpowiedz) {
        switch (odpowiedz) {
            case "BATON": {
                return Produkty.BATON;
            }
            case "WODA": {
                return Produkty.WODA;
            }
            case "CHIPSY": {
                return Produkty.CHIPSY;
            }
            case "PALUSZKI": {
                return Produkty.PALUSZKI;
            }
            case "COLA": {
                return Produkty.COLA;
            }
            case "FANTA": {
                return Produkty.FANTA;
            }
            case "SPRITE": {
                return Produkty.SPRITE;
            }
            case "PEPSI": {
                return Produkty.PEPSI;
            }
            case "MIRINDA": {
                return Produkty.MIRINDA;
            }
            default: {
                return Produkty.SEVEN_UP;
            }
        }
    }
}

