package programtv;

import java.util.Random;
import java.util.Scanner;

public class ProgramTvMain {

    public static void main(String[] args) {

        int wiek = wpiszWiek();
        Program program = czyPelnoletni(wiek);
        wypiszWybor(program);
    }

    private static void wypiszWybor(Program wybor) {
        System.out.println("Twój program to:");
        System.out.println(wybor.toString());
    }

    private static Program czyPelnoletni(int wiek) {
        if (wiek >= 18) {
            Plec plec = okreslPlec();
            int randomizer = new Random().nextInt(2);
            return wybierzProgram(plec, randomizer);
        } else {
            return Program.BAJKI;
        }
    }

    private static Program wybierzProgram(Plec plec, int randomizer) {
        Program program = null;
        switch (plec) {
            case KOBIETA: {
                switch (randomizer) {
                    case 0: {
                        program = Program.PROJECT_LADY;
                    }
                    case 1: {
                        program = Program.KUCHENNE_REWOLUCJE;
                    }
                    case 2: {
                        program = Program.TANIEC_Z_GWIAZDAMI;
                    }
                }
                break;
            }
            case MEZCZYZNA: {
                switch (randomizer) {
                    case 0: {
                        program = Program.MECZ;
                    }
                    case 1: {
                        program = Program.AKCJA;
                    }
                    case 2: {
                        program = Program.PRZYRODNICZY;
                    }
                }
                break;
            }
        } return program;
    }

    private static Plec okreslPlec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jestes [k]obietą czy [m]ężczyzną?");
        if (scanner.nextLine().equals("k")) {
            return Plec.KOBIETA;
        } else {
            return Plec.MEZCZYZNA;
        }
    }

    private static int wpiszWiek() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz wiek");
        return scanner.nextInt();
    }
}
