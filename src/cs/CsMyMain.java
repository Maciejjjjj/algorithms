package cs;

import java.util.Random;
import java.util.Scanner;

public class CsMyMain {

    static final int KULE_PISTOLETU = 7;
    static final int KULE_STRZELBY = 2;
    static final int KULE_KARABINU = 15;
    static int kasa;
    static int runda;
    static Scanner scanner;

    public static void main(String[] args) {
        kasa = 0;
        runda = 1;
        scanner = new Scanner(System.in);
        System.out.println("Lets play!");

        nowaRunda(kasa, runda);

    }

    private static void nowaRunda(double kasa, int runda) {
        final int ŻYCIE_PRZECIWNIKA = 100;
        final int MNOŻNIK_KASA_ZA_ŻYCIE = 10;

        System.out.println("Runda " + runda);
        System.out.println("Masz " + kasa + "$");

        Bron bron = wybierzBron(kasa);
        double nowaKasa = odejmijKase(kasa, bron);
        Dystans dystans = losujDystans();
        int pudla = losujPudla(bron);
        double obrazenia = strzelajDoPrzeciwnika(bron, dystans, pudla);

        System.out.println("Zadajesz przeciwnikowi " + (int) obrazenia + " pkt obrażeń");
        System.out.println("Zarabiasz " + obrazenia * MNOŻNIK_KASA_ZA_ŻYCIE + "$");

        if (ŻYCIE_PRZECIWNIKA <= obrazenia){
            System.out.println("Zabijasz przeciwnika w rundzie " + runda + "!");
            System.exit(0);
        }

        System.out.println("Przeciwnik żyje, grasz dalej? [tak]/[nie]");
        String odpowiedz = scanner.nextLine();

        if (odpowiedz.equals("tak")){
            nowaRunda(nowaKasa + obrazenia * MNOŻNIK_KASA_ZA_ŻYCIE, runda +1);
        } else {
            System.out.println("Kończysz grę na rundzie " + runda + ".");
        }


    }

    private static double strzelajDoPrzeciwnika(Bron bron, Dystans dystans, int pudla) {
        final int WARTOSC_POCISKU_ZWYKLEGO = 10;
        final int WARTOSC_POCISKU_STRZELBY = 45;
        double damageInDouble = 0.0;

        switch (bron) {
            case PISTOLET: {
                for (int i = 0; i < KULE_PISTOLETU - pudla; i++) {
                    damageInDouble += WARTOSC_POCISKU_ZWYKLEGO;
                }
                break;
            }

            case STRZELBA: {
                for (int i = 0; i < KULE_STRZELBY - pudla; i++) {
                    damageInDouble += WARTOSC_POCISKU_STRZELBY;

                    if (dystans.equals(Dystans.CLOSE)) damageInDouble = damageInDouble * 1.5;
                    if (dystans.equals(Dystans.RANGED)) damageInDouble = damageInDouble * 0.5;
                }
                break;
            }


            case KARABIN: {
                for (int i = 0; i < KULE_KARABINU - pudla; i++) {
                    damageInDouble += WARTOSC_POCISKU_ZWYKLEGO;

                    if (dystans.equals(Dystans.CLOSE)) damageInDouble = damageInDouble * 0.5;
                    if (dystans.equals(Dystans.RANGED)) damageInDouble = damageInDouble * 1.5;
                }
                break;
            }

        }
        return damageInDouble;
    }

    private static int losujPudla(Bron bron) {
        int ilePudel = 0;
        switch (bron) {
            case PISTOLET: {
                for (int i = 0; i < KULE_PISTOLETU; i++) {
                    if (Math.random() > 0.5) {
                        ilePudel += 1;
                    }
                }
                break;
            }
            case STRZELBA: {
                for (int i = 0; i < KULE_STRZELBY; i++) {
                    if (Math.random() > 0.5) {
                        ilePudel += 1;
                    }
                }
                break;
            }
            case KARABIN: {
                for (int i = 0; i < KULE_KARABINU; i++) {
                    if (Math.random() > 0.5) {
                        ilePudel += 1;
                    }
                }
                break;
            }
        }
        System.out.println("Pudłujesz " + ilePudel + " raz(y).");
        return ilePudel;
    }

    private static Dystans losujDystans() {
        Random random = new Random();
        int randomizer = random.nextInt(3);

        switch (randomizer) {
            case 2: {
                return Dystans.RANGED;
            }
            case 1: {
                return Dystans.CLOSE;
            }
            default: {
                return Dystans.ALL;
            }
        }

    }

    private static double odejmijKase(double kasa, Bron bron) {
        double nowaKasa = kasa;
        switch (bron) {
            case KARABIN: {
                nowaKasa -= 3000;
                return nowaKasa;
            }

            case STRZELBA: {
                nowaKasa -= 1000;
                return nowaKasa;
            }

            default: {
                return nowaKasa;
            }
        }
    }

    private static Bron wybierzBron(double kasa) {
        String odpowiedz;

        if (kasa >= 3000) {
            System.out.println("Możesz wziąć" +
                    "\n[pistolet] 0$ - 7 strzałów po 10hp na każdy dystans, " +
                    "\n[strzelba] 1000$ - 2 strzały po 45hp na bliski dystans, " +
                    "\n[karabin] 3000$ - 15 strzałów po 10hp na daleki dystans.");

        } else if (kasa >= 1000) {
            System.out.println("Możesz wziąć" +
                    "\n[pistolet] 0$ - 7 strzałów po 10hp na każdy dystans, " +
                    "\n[strzelba] 1000$ - 2 strzały po 45hp na bliski dystans.");

        } else {
            System.out.println("Możesz wziąć" +
                    "\n[pistolet] 0$ - 7 strzałów po 10hp na każdy dystans.");
        }

        System.out.println("Co wybierasz?");

        odpowiedz = scanner.nextLine();

        switch (odpowiedz) {
            case "karabin": {
                if (kasa >= 3000) {
                    System.out.println("Kupujesz karabin.");
                    return Bron.KARABIN;
                } else {
                    System.out.println("Słabo liczysz, łap pistolet");
//                    System.exit(0);
                    return Bron.PISTOLET;
                }
            }

            case "strzelba": {
                if (kasa >= 1000) {
                    System.out.println("Kupujesz strzelbę.");
                    return Bron.STRZELBA;
                } else {
                    System.out.println("Słabo liczysz, łap pistolet");
                    return Bron.PISTOLET;
                }
            }

            default: {
                System.out.println("Wybierasz pistolet.");
                return Bron.PISTOLET;

            }
        }
    }

}
