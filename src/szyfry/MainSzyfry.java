package szyfry;

import java.util.Scanner;

public class MainSzyfry {

    public static void main(String[] args) {

        dzialaj();
    }

    private static void dzialaj() {
        String wiadomosc = wpiszWiadomosc();
        Szyfr szyfr = wybierzSzyfr();
        szyfruj(wiadomosc, szyfr);
    }

    private static void szyfruj(String wiadomosc, Szyfr szyfr) {
        switch (szyfr) {
            case CEZARA: {
                StringBuffer result = new StringBuffer();
                System.out.println("Jakie przesunięcie 1-25?");
                Scanner scanner = new Scanner(System.in);
                int shift = scanner.nextInt();
                if (shift > 25) {
                    System.out.println("Za dużo przesuwasz!");
                } else {
                    for (int i = 0; i < wiadomosc.length(); i++) {
                        if (Character.isUpperCase(wiadomosc.charAt(i))) {
                            char ch = (char) (((int) wiadomosc.charAt(i) +
                                    shift - 65) % 26 + 65);
                            result.append(ch);
                        } else {
                            char ch = (char) (((int) wiadomosc.charAt(i) +
                                    shift - 97) % 26 + 97);
                            result.append(ch);
                        }
                    }
                    System.out.println(result.toString());
                }
            }
            break;
            case WLASNY: {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Jaki fragment zmieniamy? Najlepiej pojedynczy znak");
                String coZmieniamy = scanner.nextLine();
                System.out.println("Na co zmieniamy?");
                String naCoZmieniamy = scanner.nextLine();
                String zaszyfrowana;
                zaszyfrowana = wiadomosc.replace(coZmieniamy, naCoZmieniamy);
                System.out.println(zaszyfrowana);
            }
            break;
            case BRAK: {
                System.out.println(wiadomosc);
            }
            break;
        }
    }

    private static Szyfr wybierzSzyfr() {
        System.out.println("Wybierz szyfr:");
        System.out.println("[1] Szyfr Cezara");
        System.out.println("[2] Własny");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "1": {
                return Szyfr.CEZARA;
            }
            case "2": {
                return Szyfr.WLASNY;
            }
            default: {
                return Szyfr.BRAK;
            }
        }
    }

    private static String wpiszWiadomosc() {
        System.out.println("Wpisz wiadomość:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
