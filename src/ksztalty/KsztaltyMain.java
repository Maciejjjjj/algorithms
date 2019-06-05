package ksztalty;

import java.util.Scanner;

public class KsztaltyMain {

    public static void main(String[] args) {
        System.out.println("Narysujmy coś!");
        dzialaj();
    }


    private static Shape jakiKsztalt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jaki ksztalt narysować?");
        System.out.println("[romb],[kwadrat],[choinka]");
        String odpowiedz = scanner.nextLine();
        switch (odpowiedz) {
            case "romb": {
                return Shape.ROMB;
            }
            case "kwadrat": {
                return Shape.KWADRAT;
            }
            case "choinka": {
                return Shape.CHOINKA;
            }
            default: {
                return Shape.ZLY;
            }
        }
    }

    private static void generujKsztalt(Shape shape) {
        String line1 = null;
        String line2 = null;
        String line3 = null;
        String line4 = null;
        String line5 = null;

        switch (shape) {
            case ROMB: {
                line1 = "     *   ";
                line2 = "   *   *  ";
                line3 = " *       *";
                line4 = "   *   *  ";
                line5 = "     *   ";
                break;
            }
            case KWADRAT: {
                line1 = "***********";
                line2 = "*         *";
                line3 = "*         *";
                line4 = "*         *";
                line5 = "***********";
                break;
            }
            case CHOINKA: {
                line1 = "   *   ";
                line2 = "  ***  ";
                line3 = " ***** ";
                line4 = "*******";
                line5 = "   *   ";
                break;
            }
            case ZLY: {
                line1 = "*     *";
                line2 = " *   * ";
                line3 = "  * *  ";
                line4 = " *   * ";
                line5 = "*     *";
                break;
            }

        }
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println();
        System.out.println("Rysujemy dalej [tak]/[nie]?");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("tak")) {
            dzialaj();
        }
    }

    private static void dzialaj() {
            Shape shape = jakiKsztalt();
            generujKsztalt(shape);
    }
}
