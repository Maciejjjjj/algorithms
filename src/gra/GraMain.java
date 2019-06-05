package gra;

import java.util.Random;
import java.util.Scanner;

public class GraMain {
    static Scanner scanner = new Scanner(System.in);
    static int x = 1;

    public static void main(String[] args) {

        graj(x);
    }

    private static void graj(int x) {
        Potwor potwor = new Potwor(x);
        System.out.println("Widzisz potwora o sile " + potwor.lvl);
        Bron bron = wybierzBron();
        int random = new Random().nextInt(3);
        Bohater bohater = losujBohatera(random);
        walcz(potwor,bron,bohater);
    }

    private static void walcz(Potwor potwor, Bron bron, Bohater bohater) {
        switch (bohater){
            case SEBIX: {
                if (bron==Bron.LUK) {
                    graj(potwor.lvl+1);
                } else {
                    System.out.println(bohater + " umiera na " + potwor.lvl + " poziomie");
                    graj(x);
                }
                break;
            }
            case JANUSZ: {
                if (bron==Bron.MIECZ) {
                    graj(potwor.lvl+1);
                } else {
                    System.out.println(bohater + " umiera na " + potwor.lvl + " poziomie");
                    graj(x);
                }
                break;
            }
            case ZENOBIA: {
                if (bron==Bron.KOSTUR) {
                    graj(potwor.lvl+1);
                } else {
                    System.out.println(bohater + " umiera na " + potwor.lvl + " poziomie");
                    graj(x);
                }
            }
        }
    }

    private static Bohater losujBohatera(int random) {
        switch (random){
            case 1: {
                return Bohater.JANUSZ;
            }
            case 2: {
                return Bohater.ZENOBIA;
            }
            default: {
                return Bohater.SEBIX;
            }
        }
    }

    private static Bron wybierzBron() {
        System.out.println("Sprawdź się! Wybierz broń!");
        System.out.println("[luk],[miecz],[kostur]");
        switch (scanner.nextLine()) {
            case "luk": {
                return Bron.LUK;
            }
            case "miecz": {
                return Bron.MIECZ;
            }
            default: {
                return Bron.KOSTUR;
            }
        }
    }
}
