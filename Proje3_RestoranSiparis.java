

/**
 * Ad Soyad: [HALİD hacbekkur]
 * Öğrenci No: [250541608]
 * Proje: [restoran siparişi]
 * Tarih: []
 */







import java.util.Scanner;

public class RestoranSiparis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ana Yemek (0=Yok, 1-4): ");
        int anaSecim = sc.nextInt();

        System.out.print("Başlangıç (0=Yok, 1-3): ");
        int baslangicSecim = sc.nextInt();

        System.out.print("İçecek (0=Yok, 1-4): ");
        int icecekSecim = sc.nextInt();

        System.out.print("Tatlı (0=Yok, 1-3): ");
        int tatliSecim = sc.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Öğrenci misiniz? (E/H): ");
        char ogrenci = sc.next().toUpperCase().charAt(0);

        System.out.print("Gün (1=Pzt ... 7=Paz): ");
        int gun = sc.nextInt();

        double ana = getMainDishPrice(anaSecim);
        double bas = getAppetizerPrice(baslangicSecim);
        double ice = getDrinkPrice(icecekSecim);
        double tat = getDessertPrice(tatliSecim);

        double araToplam = ana + bas + ice + tat;

        boolean combo = isComboOrder(anaSecim, icecekSecim, tatliSecim);
        boolean hh = isHappyHour(saat);
        boolean ogrenciMi = (ogrenci == 'E');

        double indirimli = calculateDiscount(araToplam, combo, ogrenciMi, saat, gun, icecekSecim);

        double bahsis = calculateServiceTip(indirimli);

        System.out.println("\n===== SİPARİŞ ÖZETİ =====");
        System.out.println("Ara Toplam: " + araToplam + " TL");
        System.out.println("İndirimli Toplam: " + indirimli + " TL");
        System.out.println("Bahşiş Önerisi (%10): " + bahsis + " TL");
    }

    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }

    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }

    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            default: return 0;
        }
    }

    public static boolean isComboOrder(int anaVar, int icecekVar, int tatliVar) {
        return anaVar != 0 && icecekVar != 0 && tatliVar != 0;
    }

    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat, int gun, int icecekSecim) {
        double indirimli = tutar;

        if (combo) indirimli -= indirimli * 0.15;

        if (isHappyHour(saat) && icecekSecim != 0) indirimli -= getDrinkPrice(icecekSecim) * 0.20;

        if (ogrenci && gun >= 1 && gun <= 5) indirimli -= indirimli * 0.10;

        if (indirimli > 200) indirimli -= indirimli * 0.10;

        return indirimli;
    }

    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }
}
