package dokumentacja;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDokumentacja {

    public static void main(String[] args) {

        ArrayList<Dane> dane = new ArrayList<Dane>();
        ArrayList<Dane> korespondencja = new ArrayList<Dane>();

        System.out.println("Witaj w kreatorze konta!");

        dane.add(uzupelnijDane());
        korespondencja.add(uzupelnijKorespondencje(dane));
        wyplujWyniki(dane, korespondencja);
    }

    private static Dane uzupelnijDane() {
        Scanner scanner = new Scanner(System.in);
        Dane noweDane = new Dane();
        System.out.println("Podaj imie klienta:");
        noweDane.imie = scanner.nextLine();
        System.out.println("Świetnie, samolotyNaLotnisku nazwisko:");
        noweDane.nazwisko = scanner.nextLine();
        System.out.println("Teraz ulica:");
        noweDane.ulica = scanner.nextLine();
        System.out.println("I ostatni krok, miasto:");
        noweDane.miasto = scanner.nextLine();
        System.out.println("Zapisuję dane: "
                + noweDane.imie
                + ","
                + noweDane.nazwisko
                + " z "
                + noweDane.ulica
                + " w "
                + noweDane.miasto);
        return noweDane;
    }

    private static Dane uzupelnijKorespondencje(ArrayList<Dane> stareDane) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adres korespondencyjny inny niż meldunku [tak]/[nie]");
        String odpowiedz = scanner.nextLine();
        Dane noweDane = new Dane();
        if (odpowiedz.equals("tak")) {
            noweDane.imie = stareDane.get(0).imie;
            noweDane.nazwisko = stareDane.get(0).nazwisko;
            System.out.println("Podaj ulicę korespondencji:");
            noweDane.ulica = scanner.nextLine();
            System.out.println("Podaj miasto korespondencji:");
            noweDane.miasto = scanner.nextLine();
        } else {
            System.out.println("Zapisuję takie same dane");
            noweDane = stareDane.get(0);
        }
        return noweDane;
    }

    private static void wyplujWyniki(ArrayList<Dane> dane, ArrayList<Dane> korespondencja) {
        Dane meldunek = dane.get(0);
        Dane listy = korespondencja.get(0);
        System.out.println("Meldunek: "
                + meldunek.imie
                + " "
                + meldunek.nazwisko
                + " "
                + meldunek.ulica
                + " "
                + meldunek.miasto);
        System.out.println("Listy: "
                + listy.imie
                + " "
                + listy.nazwisko
                + " "
                + listy.ulica
                + " "
                + listy.miasto);
    }
}
