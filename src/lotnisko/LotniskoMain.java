package lotnisko;

import java.util.ArrayList;
import java.util.Scanner;

public class LotniskoMain {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Ile lotnisk symulujemy?");
        ArrayList<Lotnisko> lista = tworzLotniska(ileLotnisk());
        tworzSamoloty(lista);
        Integer portMacierzysty = 1;
        Integer portDestynacji = 2;
        nowaTuraLotow(portMacierzysty, portDestynacji, lista);
    }

    private static void tworzSamoloty(ArrayList<Lotnisko> lista) {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).samolotyNaLotnisku.add(new Samolot());
        }
    }

    private static ArrayList<Lotnisko> nowaTuraLotow(
            Integer portMacierzysty,
            Integer portDestynacji,
            ArrayList<Lotnisko> lista
    ) {
        Integer macierzystyNowaIlosc;
        Integer destynacjiNowaIlosc;
        if (lista.get(portDestynacji).samolotyNaLotnisku.size()>4) {
            System.out.println("Na lotnisku jest za dużo samolotów");
            System.out.println("Przekierowuję do" + (portDestynacji+1));
            macierzystyNowaIlosc = lista.get(portMacierzysty).samolotyNaLotnisku.size()-1;
            System.out.println("Macierzysty port ma " +macierzystyNowaIlosc + " samolotów");
            destynacjiNowaIlosc = lista.get(portDestynacji+1).samolotyNaLotnisku.size()+1;
            System.out.println("Port destynacji ma " +destynacjiNowaIlosc + " samolotów");
        } else {
            System.out.println("Ruszamy z portu " + portMacierzysty);
            System.out.println("Ruszamy do " + portDestynacji);
            macierzystyNowaIlosc = lista.get(portMacierzysty).samolotyNaLotnisku.size()-1;
            System.out.println("Macierzysty port ma " +macierzystyNowaIlosc + " samolotów");
            destynacjiNowaIlosc = lista.get(portDestynacji).samolotyNaLotnisku.size()+1;
            System.out.println("Port destynacji ma " +destynacjiNowaIlosc + " samolotów");
        }
        return null;
    }

    private static ArrayList<Lotnisko> tworzLotniska(int ileLotnisk) {
        ArrayList<Lotnisko> listaLotnisk = new ArrayList<>();
        for (int i = 0; i < ileLotnisk; i++) {
            listaLotnisk.add(new Lotnisko());
        }
        return listaLotnisk;
    }

    private static int ileLotnisk() {
        return scanner.nextInt();
    }
}
