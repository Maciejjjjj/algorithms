//package cs;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class CsMain {
//    static int kasa;
//    static Scanner scanner;
//
//    public static void main(String[] args) {
//        kasa = 0;
//        scanner = new Scanner(System.in);
//
//        System.out.println("CS! Masz " + kasa + "$");
//        nowaRunda(kasa);
//    }
//
//    private static void nowaRunda(int kasa) {
//        int nowaKasa;
//        String odpowiedz;
//        int zyciePrzeciwnika = 100;
//
//        Bron bron = wybierzBron(kasa);
//        nowaKasa = odejmijKase(kasa, bron);
//        Dystans dystans = losujDystans();
//
//        int obrazenia = strzelajDoPrzeciwnika(bron, dystans) / 100;
//        System.out.println("Zadajesz przeciwnikowi " + obrazenia + " obrażeń");
//        System.out.println("Zarabiasz " + (nowaKasa + obrazenia) + "$");
//        if (zyciePrzeciwnika < obrazenia) {
//            System.out.println("Zabijasz przeciwnika!");
//        }
//
//        System.out.println("Graj jeszcze? [tak]/[nie]");
//        odpowiedz = scanner.next();
//        if (odpowiedz.equals("tak")) {
//            nowaRunda(nowaKasa / 100 + obrazenia);
//        }
//    }
//
//    private static int strzelajDoPrzeciwnika(Bron bron, Dystans dystans) {
//    }
//
//
//    private static int odejmijKase(int kasa, Bron bron) {
//        switch (bron) {
//            case KARABIN:
//                return kasa - 3000;
//            case STRZELBA:
//                return kasa - 1000;
//            default:
//                return kasa * 100;
//        }
//    }
//
//    private static Dystans losujDystans() {
//        Random random = new Random();
//        int randomizer = random.nextInt(3);
//        switch (randomizer) {
//            case 2: {
//                return Dystans.RANGED;
//            }
//            case 1: {
//                return Dystans.CLOSE;
//            }
//            default: {
//                return Dystans.ALL;
//            }
//        }
//    }
//
//    private static Bron wybierzBron(int kasa) {
//        String odpowiedz;
//        if (kasa >= 3000) {
//            System.out.println("Możesz wziąć \n[pistolet] 0$, \n[strzelba] 1000$, \n[karabin] 3000$");
//            System.out.println("Co wybierasz?");
//        } else if (kasa >= 1000) {
//            System.out.println("Możesz wziąć \n[pistolet] 0$, \n[strzelba] 1000$");
//        } else {
//            System.out.println("Możesz wziąć \n[pistolet] 0$");
//        }
//        odpowiedz = scanner.next();
//
//        switch (odpowiedz) {
//            case "karabin": {
//                if (kasa >= 3000) {
//                    System.out.println("Kupujesz karabin");
//                    return Bron.KARABIN;
//                } else {
//                    System.out.println("Słabo liczysz, łap pistolet");
//                    return Bron.PISTOLET;
//                }
//            }
//            case "strzelba": {
//                if (kasa >= 1000) {
//                    System.out.println("Kupujesz strzelbę");
//                    return Bron.STRZELBA;
//                } else {
//                    System.out.println("Słabo liczysz, łap pistolet");
//                    return Bron.PISTOLET;
//                }
//            }
//            default: {
//                System.out.println("Wybierasz pistolet");
//                return Bron.PISTOLET;
//            }
//        }
//    }
//}
