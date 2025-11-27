/**
 * Ad Soyad: [HALİD hacbekkur]
 * Öğrenci No: [250541608]
 * Proje: [sinema bileti ]
 * Tarih: []
 */
import java.util.Scanner;

public class SinemaBilet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Gün (1=Pzt ... 7=Paz): ");
        int gun = sc.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Yaş: ");
        int yas = sc.nextInt();

        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
        int meslek = sc.nextInt();

        System.out.print("Film Türü (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int filmTuru = sc.nextInt();

        double finalPrice = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);

        generateTicketInfo(gun, saat, yas, meslek, filmTuru, finalPrice);
    }

    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7;
    }

    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!weekend && matinee) return 45;
        if (!weekend) return 65;
        if (weekend && matinee) return 55;
        return 85;
    }

    public static double calculateDiscount(int yas, int meslek, int gun) {
        double indirimOrani = 0;

        if (yas >= 65) indirimOrani = 0.30;
        else if (yas < 12) indirimOrani = 0.25;
        else {
            switch (meslek) {
                case 1:
                    if (gun >= 1 && gun <= 4) indirimOrani = 0.20;
                    else indirimOrani = 0.15;
                    break;
                case 2:
                    if (gun == 3) indirimOrani = 0.35;
                    break;
                case 3:
                    indirimOrani = 0;
                    break;
            }
        }

        return indirimOrani;
    }

    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 1: return 0;
            case 2: return 25;
            case 3: return 35;
            case 4: return 50;
            default: return 0;
        }
    }

    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);
        double discountedPrice = base - (base * discountRate);
        double extra = getFormatExtra(filmTuru);

        return discountedPrice + extra;
    }

    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru, double finalPrice) {
        System.out.println("\n===== BİLET BİLGİLERİ =====");
        System.out.println("Gün: " + gun);
        System.out.println("Saat: " + saat);
        System.out.println("Yaş: " + yas);
        System.out.println("Meslek: " + meslek);
        System.out.println("Film Türü: " + filmTuru);
        System.out.println("-----------------------------");
        System.out.println("Toplam Fiyat: " + finalPrice + " TL");
    }
}
