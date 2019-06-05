package odleglosc;

import java.util.ArrayList;
import java.util.Scanner;

public class MainOdległość {

    public static void main(String[] args) {

        ArrayList<Punkt> lista = podajWspolrzedne();
        zmierzOdleglosc(lista);
    }

    private static void zmierzOdleglosc(ArrayList<Punkt> lista) {
        int odlegloscX = lista.get(0).x - lista.get(1).x;
        int odlegloscY = lista.get(0).y - lista.get(1).y;
        int daneWeWzorze = (odlegloscX*odlegloscX)+(odlegloscY*odlegloscY);
        double odleglosc = Math.sqrt(daneWeWzorze);
        System.out.println(odleglosc);
    }

    private static ArrayList<Punkt> podajWspolrzedne() {

        Scanner scanner = new Scanner(System.in);
        Punkt pierwszy = new Punkt();
        Punkt drugi = new Punkt();
        ArrayList<Punkt> lista = new ArrayList<>();

        System.out.println("Podaj X punktu pierwszego");
        pierwszy.x = scanner.nextInt();
        System.out.println("Podaj Y punktu pierwszego");
        pierwszy.y = scanner.nextInt();

        System.out.println("Podaj X punktu drugiego");
        drugi.x = scanner.nextInt();
        System.out.println("Podaj Y punktu drugiego");
        drugi.y = scanner.nextInt();

        lista.add(pierwszy);
        lista.add(drugi);
        return lista;
    }
}
